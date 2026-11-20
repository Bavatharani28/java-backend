import java.util.*;

class Book {
    int id;
    String name;
    String authorName;
    boolean isAvailable;

    Book(int id, String name, String authorName, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.isAvailable = isAvailable;
    }
}

public class LibraryManager {
    static ArrayList<Book> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int id;
    static String name;
    static String authorName;
    static boolean isAvailable;

    static void addBook() {
        System.out.println("Enter Book Id");
        id = sc.nextInt();
        System.out.println("Enter Book Name");
        name = sc.next();
        System.out.println("Enter Author Name");
        authorName = sc.next();
        System.out.println("Enter Available");
        isAvailable = sc.nextBoolean();
        Book b = new Book(id, name, authorName, isAvailable);
        list.add(b);
        System.out.println("Book Added Successfully");
    }

    static void listBooks() {
        for (Book b : list) {
            System.out.println("Id : " + b.id + " Name : " + b.name + " Author : " + b.authorName + " Available : "
                    + b.isAvailable);
        }
    }

    static void searchBook() {
        System.out.println("Enter Book Name for search");
        name = sc.next();
        boolean found = false;
        for (Book b : list) {
            if (b.name.equals(name)) {
                System.out.println("Id : " + b.id + " Name : " + b.name + " Author : " + b.authorName + " Available : "
                        + b.isAvailable);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }
    }

    static void borrowBook() {
        System.out.println("Enter name of Book");
        name = sc.next();
        boolean found = false;
        for (Book b : list) {
            if (b.name.equals(name)) {
                if (b.isAvailable) {
                    System.out.println("Borrowed successfully");
                    b.isAvailable = false;
                } else {
                    System.out.println("Book is not available");
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }
    }

    static void returnBook() {
        System.out.println("Enter Book Name: ");
        name = sc.next();
        boolean found = false;
        for (Book b : list) {
            if (b.name.equals(name)) {
                if (!b.isAvailable) {
                    System.out.println("Return successfully");
                    b.isAvailable = true;
                } else {
                    System.out.println("Already available");
                }
                found = true;

            }
        }
        if (!found) {
            System.out.println("Book not found");
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 for add book");
        System.out.println("2 for list books");
        System.out.println("3 for search book");
        System.out.println("4 for check availability");
        System.out.println("5 for return book ");
        System.out.println("6 for exit");

        while (true) {
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }

}
