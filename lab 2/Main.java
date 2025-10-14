import java.util.Scanner;

class Subject {
    int subjectMarks;
    int credits;
    int grade;
}

class Student {
    String name;
    String usn;
    double SGPA;
    Scanner s;
    Subject subject[];

    Student() {
        s = new Scanner(System.in);
        subject = new Subject[8];
        for(int i=0; i<8; i++) {
            subject[i] = new Subject();
        }
    }

    void getStudentDetails() {
        System.out.print("Enter name: ");
        name = s.nextLine();
        System.out.print("Enter USN: ");
        usn = s.nextLine();
    }

    void getMarks() {
        for(int i=0; i<8; i++) {
            System.out.print("Enter marks for subject " + (i+1) + ": ");
            subject[i].subjectMarks = s.nextInt();
            System.out.print("Enter credits for subject " + (i+1) + ": ");
            subject[i].credits = s.nextInt();

            subject[i].grade = (subject[i].subjectMarks / 10) + 1;
            if(subject[i].grade == 11) {
                subject[i].grade = 10;
            }
            if(subject[i].grade <= 4) {
                subject[i].grade = 0;
            }
        }
        s.nextLine();
    }

    void computeSGPA() {
        int effectiveScore = 0;
        int totalCredits = 0;
        for(int i=0; i<8; i++) {
            effectiveScore += subject[i].grade * subject[i].credits;
            totalCredits += subject[i].credits;
        }
        SGPA = (double)effectiveScore / (double)totalCredits;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        System.out.printf("SGPA: %.2f\n", SGPA);
    }
}

public class Main{
    public static void main(String[] args) {
        Student[] students = new Student[2];
        for(int i=0; i<2; i++) {
            students[i] = new Student();
            students[i].getStudentDetails();
            students[i].getMarks();
            students[i].computeSGPA();
        }
        for(int i=0; i<2; i++) {
            students[i].display();
        }
    }
}
