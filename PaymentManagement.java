interface PaymentMethod {
    void pay();
}

class CardPayment implements PaymentMethod {
    String holderName;
    int last4Digits;
    double totalAmount;
    double billAmount;

    CardPayment(String holderName, int last4Digits, double totalAmount, double billAmount) {
        this.holderName = holderName;
        this.last4Digits = last4Digits;
        this.totalAmount = totalAmount;
        this.billAmount = billAmount;
    }

    public void pay() {
        if (totalAmount <= 0 || billAmount <= 0) {
            throw new IllegalArgumentException("Invalid Amount or Bill Amount");
        } else if (billAmount <= totalAmount) {
            System.out.println("Payment Successfull");
            System.out.println("Card Balance");
            totalAmount = totalAmount - billAmount;
            System.out.println(totalAmount);
        } else {
            System.out.println("Amount Insufficent");
        }

    }
}

class CashPayment implements PaymentMethod {
    double amountReceived;
    double billAmount;

    CashPayment(double amountReceived, double billAmount) {
        this.amountReceived = amountReceived;
        this.billAmount = billAmount;
    }

    public void pay() {
        if (amountReceived <= 0) {
            throw new IllegalArgumentException("Invalid Amount");
        } else if (amountReceived >= billAmount) {
            System.out.println("Payment successfull");
            System.out.println("Balance");
            System.out.println(amountReceived - billAmount);
        } else {
            System.out.println("Cash Amount Insufficient");
        }
    }
}

public class PaymentManagement {
    public static void main(String args[]) {
        PaymentMethod payment1 = new CardPayment("Archana", 9090, 90000, 2000);
        PaymentMethod payment2 = new CashPayment(7000, 8000);
        payment1.pay();
        payment2.pay();
        payment1.pay();

    }
}