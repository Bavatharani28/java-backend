class Employee {
    int id;
    String Name;
    int experience;
    private double Salary;

    Employee(int id, String Name, int experience) {
        this.id = id;
        this.Name = Name;
        this.experience = experience;
        if (experience < 0) {
            throw new IllegalArgumentException("Invalid experience");
        } else if (experience < 1) {
            this.Salary = 10000;
        } else if (experience < 2) {
            this.Salary = 20000;
        } else if (experience < 5) {
            this.Salary = 30000;
        } else {
            this.Salary = 50000;
        }
    }

    public void DisplayEmployee() {
        System.out.println("Id : " + id + "Name : " + Name);
        System.out.println("Salary : " + Salary);
    }

    public double getSalary() {
        return Salary;
    }
}

class Manager extends Employee {
    String Department;

    Manager(int id, String Name, int experience, String Department) {
        super(id, Name, experience);
        this.Department = Department;

    }

    @Override
    public void DisplayEmployee() {
        super.DisplayEmployee();
        System.out.println("Department : " + Department);
    }
}

public class EmployeeManagement {
    public static void main(String args[]) {
        Employee emp1 = new Employee(1001, "Alex", 2);
        Manager manag1 = new Manager(1002, "Bob", 7, "Finance");
        emp1.DisplayEmployee();
        manag1.DisplayEmployee();
        System.out.println("Manager's Salary : " + manag1.getSalary());
    }
}
