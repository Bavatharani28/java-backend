import java.util.Scanner;

class Bank {
    private int accountNumber;
    String holderName;
    private double balance;

    public Bank(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        if (holderName != "")
            this.holderName = holderName;
        else
            System.out.println("Invalid User Name");
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Success");
        } else
            System.out.println("Reject deposit");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("withdraw success");
        } else {
            System.out.println("Reject Withdraw");
        }
    }

    public void transfer(Bank obj, double amt) {
        obj.deposit(amt);
        balance = balance - amt;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return holderName;
    }

}

public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // String name = sc.next();
        // double balance = sc.nextDouble();
        Bank obj = new Bank(123, "bava", 40000);
        Bank obj1 = new Bank(456, "thara", 3000);
        obj.deposit(40000);
        obj.withdraw(4000);
        System.out.println(obj.getBalance());
        System.out.println(obj.getAccountHolderName());
        obj.transfer(obj1, 2000);
        System.out.println(obj1.getAccountHolderName());
        System.out.println(obj1.getBalance());

    }
}
