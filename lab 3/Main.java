import java.util.Scanner;

class Books {
    String name;
    String author;
    int price;
    int numPages;

    Books(String name, String author, int price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    public String toString() {
        String name = "Book name: " + this.name + "\n";
        String author = "Author name: " + this.author + "\n";
        String price = "Price: " + this.price + "\n";
        String numPages = "Number of pages: " + this.numPages + "\n";
        return name + author + price + numPages;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = s.nextInt();
        s.nextLine();

        Books[] b = new Books[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = s.nextLine();
            System.out.print("Author: ");
            String author = s.nextLine();
            System.out.print("Price: ");
            int price = s.nextInt();
            System.out.print("Number of pages: ");
            int numPages = s.nextInt();
            s.nextLine();
            b[i] = new Books(name, author, price, numPages);
        }

        System.out.println("\nBook details:");
        for (int i = 0; i < n; i++) {
            System.out.println(b[i]);
        }

        s.close();
    }}
