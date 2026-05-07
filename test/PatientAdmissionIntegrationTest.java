import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientAdmissionIntegrationTest {

    private PatientAdmission admission;

    @BeforeEach
    void setUp() {
        admission = new PatientAdmission();
    }

    @Test
    void fullAdmissionFlow_elderlyHighFever_urgentPriority() {
        int score = admission.calculateRiskScore(40.0, 72);
        assertAll(
                () -> assertEquals(80, score),
                () -> assertEquals("URGENT", admission.getAdmissionPriority(score))
        );
    }

    @Test
    void fullAdmissionFlow_middleAgeModerateTemp_moderatePriority() {
        int score = admission.calculateRiskScore(38.0, 55);
        assertAll(
                () -> assertEquals(40, score),
                () -> assertEquals("MODERATE", admission.getAdmissionPriority(score))
        );
    }

    @Test
    void fullAdmissionFlow_youngNormalTemp_routinePriority() {
        int score = admission.calculateRiskScore(36.5, 25);
        assertAll(
                () -> assertEquals(0, score),
                () -> assertEquals("ROUTINE", admission.getAdmissionPriority(score))
        );
    }

    @Test
    void fullAdmissionFlow_elderlyNormalTemp_moderatePriority() {
        int score = admission.calculateRiskScore(36.5, 70);
        assertAll(
                () -> assertEquals(30, score),
                () -> assertEquals("MODERATE", admission.getAdmissionPriority(score))
        );
    }

    @Test
    void fullAdmissionFlow_highTempYoung_urgentPriority() {
        int score = admission.calculateRiskScore(40.0, 25);
        assertAll(
                () -> assertEquals(50, score),
                () -> assertEquals("MODERATE", admission.getAdmissionPriority(score))
        );
    }
}