import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalObserverTest {

    @Test
    public void testRemoveObserver() {
        Hospital hospital = new Hospital("Test Hospital");

        // Flag to track if observer was called
        final boolean[] wasCalled = { false };

        // Anonymous test observer with flag
        AdmissionObserver testObserver = new AdmissionObserver() {
            @Override
            public void onPatientAdmitted(String patientName, int riskScore) {
                wasCalled[0] = true;
            }
        };

        // Add, then remove the observer
        hospital.addObserver(testObserver);
        hospital.removeObserver(testObserver);

        // Reset flag and admit patient
        wasCalled[0] = false;
        hospital.admitPatient("Test Patient", 50);

        // Verify observer was NOT called after removal
        assertFalse(wasCalled[0], "Removed observer should not be called");
    }
}