import java.util.Scanner;

class Bank {
    private int accountNumber;
    private String holderName;
    private double balance;

    public Bank(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        if (holderName != null && !holderName.trim().isEmpty())
            this.holderName = holderName;
        else
            throw new IllegalArgumentException("Invalid User Name");
        if (balance >= 0)
            this.balance = balance;
        else {
            throw new IllegalArgumentException("Invalid initial balance");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Success");
        } else
            System.out.println("Reject deposit");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("withdraw success");
        } else {
            System.out.println("Reject Withdraw");
        }
    }

    public void transfer(Bank obj, double amt) {
        if (obj == null || obj == this) {
            System.out.println("Invalid target account");
            return;
        }
        if (amt > 0 && amt <= balance) {
            balance = balance - amt;
            obj.deposit(amt);
            System.out.println("Tranfer successful");
        } else {
            System.out.println("Transfer rejected");
        }
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
