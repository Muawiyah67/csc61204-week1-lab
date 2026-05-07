public class PatientRoster {

    Patient[] roster = {
            new Patient("Maria Santos", 45, 38.9, "O+",  true),
            new Patient("Ahmad Razali", 72, 37.1, "A-",  false),
            new Patient("Siti Aminah",  30, 39.8, "B+",  true),
            new Patient("James Lim",    55, 40.1, "AB+", true),
            new Patient("Nur Farhana",  28, 36.8, "O-",  false)
    };

    public void printAllSummaries() {
        for (Patient p : roster) {
            p.printSummary();
            System.out.println();
        }
    }

    public Patient findHottestPatient() {
        Patient hottest = roster[0];
        for (Patient p : roster) {
            if (p.temperatureC > hottest.temperatureC) {
                hottest = p;
            }
        }
        return hottest;
    }

    public int countHighRisk() {
        int count = 0;
        for (Patient p : roster) {
            if (p.assessRisk().equals("HIGH")) {
                count++;
            }
        }
        return count;
    }
}