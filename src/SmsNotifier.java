public class SmsNotifier implements Notifier {
    public void send(String report, String recipient){
        System.out.println("Sending sms'" + report + "' to " + recipient);
    };
}
