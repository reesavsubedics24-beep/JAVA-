import java.util.Scanner;

class Account {
    protected String customerName;
    protected int accountNumber;
    protected String accountType;
    protected double balance;

    Scanner sc = new Scanner(System.in);

    public void openAccount() {
        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();
        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Account Type (Savings/Current): ");
        accountType = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        balance += amt;
        System.out.println("Amount deposited successfully. Updated balance: " + balance);
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
    }

    public void withdraw() {}
}

class SavAcct extends Account {
    private double interestRate = 5.0;

    public void computeInterest() {
        System.out.print("Enter time period in years: ");
        double time = sc.nextDouble();
        double compoundInterest = balance * Math.pow((1 + interestRate / 100), time) - balance;
        balance += compoundInterest;
        System.out.println("Interest of Rs. " + compoundInterest + " added. New Balance: " + balance);
    }

    @Override
    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        if (amt > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amt;
            System.out.println("Amount withdrawn successfully. Updated Balance: " + balance);
        }
    }
}

class CurAcct extends Account {
    private final double minBalance = 5000.0;
    private final double serviceCharge = 500.0;

    @Override
    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        if (amt > balance) {
            System.out.println("Insufficient funds!");
            return;
        }
        balance -= amt;
        checkMinimumBalance();
        System.out.println("Amount withdrawn successfully. Updated Balance: " + balance);
    }

    public void checkMinimumBalance() {
        if (balance < minBalance) {
            System.out.println("Balance below minimum. Service charge of Rs. " + serviceCharge + " imposed.");
            balance -= serviceCharge;
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavAcct savAcc = null;
        CurAcct curAcc = null;

        System.out.println("Welcome to the Bank System!");
        System.out.println("1. Open Savings Account");
        System.out.println("2. Open Current Account");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            savAcc = new SavAcct();
            savAcc.openAccount();
        } else if (choice == 2) {
            curAcc = new CurAcct();
            curAcc.openAccount();
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        int opt;
        do {
            System.out.println("\n***** MENU *****");
            System.out.println("1. Deposit");
            System.out.println("2. Display Balance");
            System.out.println("3. Compute Interest (Savings Only)");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    if (savAcc != null) savAcc.deposit();
                    else curAcc.deposit();
                    break;
                case 2:
                    if (savAcc != null) savAcc.displayBalance();
                    else curAcc.displayBalance();
                    break;
                case 3:
                    if (savAcc != null) savAcc.computeInterest();
                    else System.out.println("Interest not available for Current Account.");
                    break;
                case 4:
                    if (savAcc != null) savAcc.withdraw();
                    else curAcc.withdraw();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (opt != 5);

        sc.close();
    }
}
