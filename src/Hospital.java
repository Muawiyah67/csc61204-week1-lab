import java.util.ArrayList;
import java.util.List;

public class Hospital implements AdmissionSubject{
    private List<AdmissionObserver> observers = new ArrayList<>();
    private String hospitalName;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;

    }
    @Override
    public void addObserver(AdmissionObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(AdmissionObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String patientName, int riskScore) {
        for (AdmissionObserver observer : observers) {
            observer.onPatientAdmitted(patientName, riskScore);
        }
    }

    // Called when a new patient is admitted
    public void admitPatient(String patientName, int riskScore) {
        System.out.println("[" + hospitalName + "] Admitting: " + patientName);
        notifyObservers(patientName, riskScore);
    }

    public String getHospitalName() {
        return hospitalName;
    }

}
