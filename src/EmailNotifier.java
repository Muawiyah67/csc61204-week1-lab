public class EmailNotifier implements Notifier {
    public void send(String report, String recipient) {
        System.out.println("Emailing '" + report + "' to " + recipient);
    }

}
