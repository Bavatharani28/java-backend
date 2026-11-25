class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class ATM {
    double balance;
    int accountNumber;
    String accountHolderName;

    public ATM(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdrawMoney(double amount) {
        try {
            if (amount <= 0)
                throw new InvalidAmountException("This is Invalid Amount ");
            else if (amount > balance)
                throw new InsufficientBalanceException("Insufficient balance");
            else
                balance = balance - amount;
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    public void depositMoney(double amount) {
        try {
            if (amount <= 0)
                throw new InvalidAmountException("This is Invalid Amount ");
            else
                balance = balance + amount;
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }
}

public class ATMException {
    public static void main(String args[]) {
        ATM atm1Atm = new ATM(1234, "Bava", 1000.0);
        atm1Atm.depositMoney(9000);
        atm1Atm.withdrawMoney(12000);
        System.out.println("Balance: " + atm1Atm.getBalance());

    }

}
