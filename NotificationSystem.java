interface Notifier {
    void sendNotification();

    default void showServiceInfo() {
        System.out.println("Notification Service Processing");
    }
}

abstract class BaseNotification implements Notifier {
    protected String recipient;

    BaseNotification(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public abstract void sendNotification();
}

class EmailNotifier extends BaseNotification {

    EmailNotifier(String email) {
        super(email);
    }

    public void sendNotification() {
        System.out.println("Email send successfully");
        System.out.println("Email sent to " + getRecipient());

    }
}

class SMSNotifier extends BaseNotification {

    SMSNotifier(String phoneNumber) {
        super(phoneNumber);
    }

    public void sendNotification() {
        System.out.println("SMS send successfully");
        System.out.println("SMS sent to " + getRecipient());
    }

}

public class NotificationSystem {
    public static void main(String args[]) {
        Notifier notification1 = new EmailNotifier("bava@gmail.com");
        Notifier notification2 = new SMSNotifier("9876543210");
        notification1.showServiceInfo();
        notification1.sendNotification();
        notification2.showServiceInfo();
        notification2.sendNotification();
    }
}
