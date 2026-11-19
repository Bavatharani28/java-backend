class Receipt {
    public void printReceipt(String customerName) {
        System.out.println("Name : " + customerName);
    }

    public void printReceipt(String customerName, double amount) {
        System.out.println("Name : " + customerName);
        System.out.println("Bill Amount : " + amount);
    }

    public void printReceipt(String customerName, double amount, String paymentMethod) {
        System.out.println("Name : " + customerName);
        System.out.println("Bill Amount : " + amount);
        System.out.println("Payment Method : " + paymentMethod);
    }
}

public class PaymentReceipt {
    static void main(String args[]) {
        Receipt bill1 = new Receipt();
        bill1.printReceipt("Bavatharani");
        System.out.println();
        bill1.printReceipt("Bavatharani", 50000.90);
        System.out.println();
        bill1.printReceipt("Bavatharani", 80000.98, "Card");
    }
}
