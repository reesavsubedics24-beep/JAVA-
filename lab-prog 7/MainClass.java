import java.util.Scanner;

class WrongAge extends Exception {
    WrongAge() {
        super("Age Error!");
    }

    WrongAge(String msg) {
        super(msg);
    }
}

class InputScanner {
    Scanner s = new Scanner(System.in);
}

class Father extends InputScanner {
    int fatherAge;

    Father() throws WrongAge {
        System.out.print("Enter Father Age: ");
        fatherAge = s.nextInt();

        if (fatherAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
    }

    void display() {
        System.out.println("Father's Age = " + fatherAge);
    }
}

class Son extends Father {
    int sonAge;

    Son() throws WrongAge {
        super();
        System.out.print("Enter Son Age: ");
        sonAge = s.nextInt();

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to Father's age");
        } else if (sonAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
    }

    void display() {
        super.display();
        System.out.println("Son's Age = " + sonAge);
    }
}

public class MainClass {
    public static void main(String[] args) {
        try {
            Son obj = new Son();
            obj.display();
        } catch (WrongAge e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }
    }
}
