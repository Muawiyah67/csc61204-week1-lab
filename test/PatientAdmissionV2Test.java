import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientAdmissionV2Test {

    @Test
    public void testStandardVsConservativeDifferentScores() {
        double temp = 38.7;
        int age = 62;

        PatientAdmissionV2 standard = new PatientAdmissionV2(new StandardRiskStrategy());
        PatientAdmissionV2 conservative = new PatientAdmissionV2(new ConservativeRiskStrategy());

        int standardScore = standard.calculateRiskScore(temp, age);
        int conservativeScore = conservative.calculateRiskScore(temp, age);

        assertEquals(25, standardScore);
        assertEquals(80, conservativeScore);  // was 75
        assertTrue(conservativeScore > standardScore, "Conservative should be higher");
    }

    @Test
    public void testStrategySwapAtRuntime() {
        PatientAdmissionV2 admission = new PatientAdmissionV2(new StandardRiskStrategy());

        double temp = 38.7;
        int age = 62;

        assertEquals(25, admission.calculateRiskScore(temp, age));

        // Swap to conservative
        admission.setStrategy(new ConservativeRiskStrategy());
        assertEquals(80, admission.calculateRiskScore(temp, age));
    }
    @Test
    public void testPediatricStrategyWithoutModifyingPatientAdmissionV2() {
        PatientAdmissionV2 pediatric = new PatientAdmissionV2(new PediatricRiskStrategy());

        // Child with fever: age 8, temp 38.5
        int score = pediatric.calculateRiskScore(38.5, 8);

        assertEquals(60, score);  // 20 (pediatric) + 40 (fever) = 60
    }

}