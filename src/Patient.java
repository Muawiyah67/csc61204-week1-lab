public class Patient {
    String  name;
    int     age;
    double  temperatureC;
    String  bloodType;
    boolean isAdmitted;

    public Patient(String name, int age, double temperatureC, String bloodType, boolean isAdmitted) {
        this.name         = name;
        this.age          = age;
        this.temperatureC = temperatureC;
        this.bloodType    = bloodType;
        this.isAdmitted   = isAdmitted;
    }

    public String assessRisk() {
        return PatientUtils.assessRisk(this.temperatureC);
    }

    public void printSummary() {
        System.out.println("--- Patient Summary ---");
        System.out.println("Name:     " + name);
        System.out.println("Age:      " + age);
        System.out.println("Temp:     " + temperatureC + "°C");
        System.out.println("Blood:    " + bloodType);
        System.out.println("Risk:     " + assessRisk());
        System.out.println("Admitted: " + isAdmitted);
    }
}