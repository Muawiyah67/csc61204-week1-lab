public class PatientReportDemo {
    public static void main(String[] args) {
        PatientReportFormatter formatter = new PatientReportFormatter();
        ReportFileSaver saver  = new ReportFileSaver();
        Notifier notifier = new EmailNotifier();   // or: new SmsNotifier();
        AuditLogger logger     = new AuditLogger();

        String report = formatter.format("Maria Santos", 80);
        saver.save(report, "report_001.txt");
        notifier.send(report, "doctor@meditrack.com");
        logger.log("Report generated for Maria Santos");
    }

}
