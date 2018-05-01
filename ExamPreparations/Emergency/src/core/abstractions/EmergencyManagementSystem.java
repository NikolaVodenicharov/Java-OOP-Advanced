package core.abstractions;

public interface EmergencyManagementSystem {

    String registerPropertyEmergency();
    String registerHealthEmergency();
    String registerOrderEmergency();

    String registerFireServiceCenter();
    String registerMedicalServiceCenter();
    String registerPoliceServiceCenter();

    String processEmergencies();
    String emergencyReport();
}
