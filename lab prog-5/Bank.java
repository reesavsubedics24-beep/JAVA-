import java.util.Scanner;

class Account {
    String customerName;
    int accountNumber;
    String type;
    double balance;

    static Scanner sc = new Scanner(System.in);

    Account(String name, int accNo, String type) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.type = type;
        this.balance = 0.0;
    }

    void deposit() {
        System.out.print("Enter the deposit amount: ");
        double amount = sc.nextDouble();
        balance += amount;
    }

    void display() {
        System.out.println("Customer name: " + customerName);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Type of Account: " + type);
        System.out.println("balance = " + balance);
    }

    void withdraw() {
        System.out.print("Enter the withdrawal amount: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class SavAcct extends Account {

    SavAcct(String name, int accNo) {
        super(name, accNo, "Savings Account");
    }

    void computeInterest() {
        double rate = 0.05;  // 5%
        double interest = balance * rate;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
}

class CurAcct extends Account {
    final double MIN_BAL = 500;
    final double PENALTY = 50;

    CurAcct(String name, int accNo) {
        super(name, accNo, "Current Account");
    }

    void checkMinimum() {
        if (balance < MIN_BAL) {
            System.out.println("Balance below minimum. Penalty imposed: 50");
            balance -= PENALTY;
        }
    }

    @Override
    void withdraw() {
        System.out.print("Enter the withdrawal amount: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            checkMinimum();
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class Bank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the type of account (saving/current): ");
        String type = sc.nextLine().toLowerCase();

        Account acc;

        if (type.equals("saving"))
            acc = new SavAcct(name, accNo);
        else
            acc = new CurAcct(name, accNo);

        int choice;

        do {
            System.out.println("-----MENU-----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Compute interest for SavingsAccount");
            System.out.println("4. Display account details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    acc.deposit();
                    break;
                case 2:
                    acc.withdraw();
                    break;
                case 3:
                    if (acc instanceof SavAcct) {
                        ((SavAcct) acc).computeInterest();
                    } else {
                        System.out.println("Current Account has no interest.");
                    }
                    break;
                case 4:
                    acc.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}
