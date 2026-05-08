public class ObserverDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("MediTrack Central");

        // Register observers
        hospital.addObserver(new DoctorNotifier("Dr. Lim"));
        hospital.addObserver(new BillingNotifier());
        hospital.addObserver(new AuditNotifier());
        // Step 5 & 6: Create and add WardNurseNotifier
        WardNurseNotifier nurse = new WardNurseNotifier("Nurse Sarah");
        hospital.addObserver(nurse);
        // Add the urgent-only doctor notifier
        hospital.addObserver(new UrgentOnlyDoctorNotifier("Dr. Lim"));
        System.out.println("=== URGENT patient (score 80) ===");
        hospital.admitPatient("Maria Santos", 80);

        System.out.println();

        System.out.println("=== ROUTINE patient (score 25) ===");
        hospital.admitPatient("Ahmad Razali", 25);

        /*System.out.println("=== First admission (WITH nurse) ===");
        hospital.admitPatient("Maria Santos", 80);
        System.out.println();*/

        // Remove the nurse observer
       // hospital.removeObserver(nurse);

        //System.out.println("=== Second admission (WITHOUT nurse) ===");
        //hospital.admitPatient("Ahmad Razali", 25);

        // Admit two patients — all observers are notified automatically
        /*hospital.admitPatient("Maria Santos", 80);
        System.out.println();
        hospital.admitPatient("Ahmad Razali", 25);*/
    }

}
