public interface AdmissionSubject {
    void addObserver(AdmissionObserver observer);
    void removeObserver(AdmissionObserver observer);
    void notifyObservers(String patientName, int riskScore);

}
