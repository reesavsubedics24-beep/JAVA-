import java.util.Scanner;

class Pharmacy {
    String name;
    int number;
    Scanner sc = new Scanner(System.in);

    Pharmacy() {
        System.out.println("Enter patient name");
        name = sc.nextLine();
        System.out.println("Enter the number");
        number = Integer.parseInt(sc.nextLine());
    }
}

class Doctor1 extends Pharmacy {
    double bill = 0;

    void pay(int amt) {
        System.out.println("the amount is " + amt);
        bill += amt;
    }

    double commision() {
        System.out.println("the commison is");
        if (bill > 50000) {
            return bill * 0.5;
        } else if (bill >= 10000 && bill<=50000) {
            return bill * 0.1;
        } else {
            return bill * 0.2;
        }
    }
}

class Doctor2 extends Pharmacy {
    double bill2 = 0;

    void pay(int amt) {
        System.out.println("the amount is " + amt);
        bill2 += amt;
    }
    double commision() {
        System.out.println("the commison is");
        if (bill2 > 50000) {
            return bill2 * 0.5;
        } else if (bill2 > 10000) {
            return bill2 * 0.1;
        } else {
            return bill2 * 0.2;
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Doctor1 D1 = new Doctor1();
        D1.pay(2000);
        System.out.println("D1 commission: " + D1.commision());
        

        Doctor2 D2 = new Doctor2();
        D2.pay(30000);
        System.out.println("D2 commission: " + D2.commision());
        
        Doctor2 D3 = new Doctor2();
        D3.pay(60000);
        System.out.println("D3 commission: " + D3.commision());
        
    }
}
