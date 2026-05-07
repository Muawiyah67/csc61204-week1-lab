import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PatientAdmissionTest {

    private PatientAdmission admission;

    @BeforeEach
    void setUp() {
        admission = new PatientAdmission();
    }

    // --- calculateRiskScore tests ---

    @Test
    void calculateRiskScore_highTempElderlyPatient_returnsHighScore() {
        int score = admission.calculateRiskScore(40.0, 70);
        assertEquals(80, score);  // 50 + 30 = 80
    }

    @Test
    void calculateRiskScore_normalTempYoungPatient_returnsZero() {
        int score = admission.calculateRiskScore(36.5, 25);
        assertEquals(0, score);   // 0 + 0 = 0
    }

    @Test
    void calculateRiskScore_elevatedTempMiddleAge_returnsMediumScore() {
        int score = admission.calculateRiskScore(38.0, 55);
        assertEquals(40, score);  // 25 + 15 = 40
    }

    // --- getAdmissionPriority tests ---

    @Test
    void getAdmissionPriority_scoreAbove70_returnsUrgent() {
        assertEquals("URGENT", admission.getAdmissionPriority(80));
    }

    @Test
    void getAdmissionPriority_scoreBetween30And70_returnsModerate() {
        assertEquals("MODERATE", admission.getAdmissionPriority(40));
    }

    @Test
    void getAdmissionPriority_scoreBelow30_returnsRoutine() {
        assertEquals("ROUTINE", admission.getAdmissionPriority(10));
    }

    // --- isValidPatientName tests ---

    @Test
    void isValidPatientName_validName_returnsTrue() {
        assertTrue(admission.isValidPatientName("Maria Santos"));
    }

    @Test
    void isValidPatientName_nullName_returnsFalse() {
        assertFalse(admission.isValidPatientName(null));
    }

    @Test
    void isValidPatientName_emptyString_returnsFalse() {
        assertFalse(admission.isValidPatientName(""));
    }
    @Test
    void calculateRiskScore_temperatureExactlyAt39_5_returns50() {
        int score = admission.calculateRiskScore(39.5, 30);
        assertEquals(50, score);  // boundary: exactly 39.5 = high temp
    }

    @Test
    void calculateRiskScore_ageExactly65_returnsPlus30() {
        int score = admission.calculateRiskScore(36.5, 65);
        assertEquals(30, score);  // boundary: exactly 65 = elderly
    }

    @Test
    void isValidPatientName_exactly100Characters_returnsTrue() {
        String name = "A".repeat(100);
        assertTrue(admission.isValidPatientName(name));
    }

    @Test
    void isValidPatientName_101Characters_returnsFalse() {
        String name = "A".repeat(101);
        assertFalse(admission.isValidPatientName(name));
    }
    @Test
    void calculateRiskScore_temperatureBelow30_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.calculateRiskScore(20.0, 40);
        });
    }

    @Test
    void calculateRiskScore_temperatureAbove45_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.calculateRiskScore(46.0, 40);
        });
    }
    @ParameterizedTest
    @CsvSource({
            "40.0, 70, 80",    // high temp + elderly = 50 + 30
            "38.0, 55, 40",    // moderate temp + middle age = 25 + 15
            "36.5, 25, 0",     // normal temp + young = 0 + 0
            "39.5, 30, 50",    // boundary high temp + young = 50 + 0
            "37.5, 50, 40"     // boundary moderate temp + boundary age = 25 + 15
    })
    void calculateRiskScore_variousInputs_returnsCorrectScore(
            double temp, int age, int expectedScore) {
        assertEquals(expectedScore, admission.calculateRiskScore(temp, age));
    }
}