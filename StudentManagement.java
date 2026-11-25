import java.util.*;

class Student {
    int id;
    String name;
    float cgpa;

    public Student(int id, String name, float cgpa) {
        if (id <= 0) {
            throw new InputMismatchException("Invalid ID");
        }
        this.id = id;
        if (name == null || name.trim().isEmpty()) {
            throw new InputMismatchException("Invalid Name");
        }
        this.name = name;
        if (cgpa < 0.0 || cgpa > 10.0) {
            throw new InputMismatchException("Invalid CGPA");
        }
        this.cgpa = cgpa;
    }
}

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> list = new ArrayList<>();
    static int id;
    static String name;
    static float cgpa;

    static void addStudent() {
        System.out.println("Enter id to add student");
        id = sc.nextInt();
        sc.nextLine(); // consume the newline character after reading the integer
        int f = 0;
        if (!list.isEmpty()) {
            for (Student sm : list) {
                if (sm.id == id) {
                    System.out.println("Duplicate ID");
                    f = 1;
                    break;
                }
            }
        }
        if (f == 0) {
            System.out.println("Enter the name");
            name = sc.nextLine();
            System.out.println("Enter the cgpa");
            cgpa = sc.nextFloat();
            sc.nextLine(); // consume the newline character after reading the integer
        } else {
            System.out.println("Enter the correct Id");
            return;
        }
        Student sm = new Student(id, name, cgpa);
        list.add(sm);
        System.out.println("Student Addedd Successfully");
    }

    static void displayStudent() {
        System.out.println("All Students");
        for (Student sm : list) {
            System.out.println("Id " + sm.id);
            System.out.println("Name " + sm.name);
            System.out.println("CGPA " + sm.cgpa);
        }
    }

    static void searchStudent() {
        System.out.println("Enter student id to search");
        id = sc.nextInt();
        int f = 0;
        for (Student sm : list) {
            if (sm.id == id) {
                System.out.println("Id " + sm.id);
                System.out.println("Name " + sm.name);
                System.out.println("CGPA " + sm.cgpa);
                f = 1;
                break;
            }
        }
        if (f == 0) {
            System.out.println("Student not found");
        }
    }

    static void updateStudent() {
        System.out.println("Enter the id for update details");
        id = sc.nextInt();
        sc.nextLine(); // consume the newline character after reading the integer
        int f = 0;
        for (Student sm : list) {
            if (sm.id == id) {
                f = 1;
                break;
            }
        }
        if (f == 0) {
            System.out.println("StudentID not found for update");
            return;
        }
        System.out.println("Press 1 to update name or Press 2 to update cgpa");
        int choice = sc.nextInt();
        sc.nextLine(); // consume the newline character after reading the integer
        if (choice == 1) {
            name = sc.nextLine();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Invalid Name");
                return;
            }
            for (Student sm : list) {
                if (sm.id == id) {
                    sm.name = name;
                    System.out.println("Name updated successfully");
                    break;
                }
            }
        } else if (choice == 2) {
            cgpa = sc.nextFloat();
            sc.nextLine(); // consume the newline character after reading the float
            if (cgpa < 0.0 || cgpa > 10.0) {
                System.out.println("Invalid CGPA");
                return;
            }
            for (Student sm : list) {
                if (sm.id == id) {
                    sm.cgpa = cgpa;
                    System.out.println("CGPA updated successfully");
                    break;
                }
            }
        } else {
            System.out.println("Invalid choice");
            return;
        }
    }

    static void deleteStudent() {
        System.out.println("Enter the studentid for delete");
        id = sc.nextInt();
        int f = 0;
        Iterator<Student> iterator = list.iterator();
        // Here why we are using iterator because we cannot remove an element from the
        // list while iterating through it using a for-each loop. Using an iterator
        // allows us to safely remove elements from the list while iterating.
        // it shows error if we use for-each loop because it will throw
        // ConcurrentModificationException. So we are using iterator to avoid that
        // error.
        while (iterator.hasNext()) {
            Student sm = iterator.next();
            if (sm.id == id) {
                iterator.remove();
                System.out.println("Student deleted successfully");
                f = 1;
                break;
            }
        }
        if (f == 0) {
            System.out.println("StudentID not found for deletion");
            return;
        }
    }

    static void countStudent() {
        if (list.isEmpty()) {
            System.out.println("No students Available");
            return;
        }
        System.out.println("Total number of students: " + list.size());
    }

    public static void main(String args[]) {
        int choice;
        while (true) {
            System.out.println("Press 1 to add student");
            System.out.println("Press 2 to display student");
            System.out.println("Press 3 to search student");
            System.out.println("Press 4 to update student");
            System.out.println("Press 5 to delete student");
            System.out.println("Press 6 to count students");
            System.out.println("Press 7 to exit");
            choice = sc.nextInt();
            if (choice == 7) {
                System.out.println("Exiting the program");
                break;
            }
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    countStudent();
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }
}
