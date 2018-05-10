package core;

import collection.Register;
import collection.EmergencyRegister;
import models.emergencies.Emergency;
import models.centers.EmergencyCenter;

import java.util.HashMap;
import java.util.Map;

public class EmergencyManagementSystem implements ManagementSystem {
    private static final String MESSAGE_REGISTER_EMERGENCY = "Registered Public %s Emergency of level %s at %s.";
    private static final String MESSAGE_REGISTER_CENTER = "Registered %s Service Emergency Center - %s.";

    private static final String HEALTH_EMERGENCY = "HealthEmergency";
    private static final String ORDER_EMERGENCY = "OrderEmergency";
    private static final String PROPERTY_EMERGENCY = "PropertyEmergency";

    private static final String MEDICAL_CENTER = "MedicalServiceCenter";
    private static final String FIRE_CENTER = "FireServiceCenter";
    private static final String POLICE_CENTER = "PoliceServiceCenter";

    private Map<String, Register<Emergency>> emergencyRegisters;
    private Map<String, Register<EmergencyCenter>> emergencyCenterRegisters;

    private Map<String, String> emergencyCorrespondingCenterType;

    private long totalProcessedEmergencies;
    private long totalPropertyDamageFixed;
    private long totalHealthCasualtiesSaved;
    private long totalSpecialCasesProcessed;

    public EmergencyManagementSystem(){
        this.initializeEmergencyRegisters();
        this.initializeEmergencyCenterRegisters();
        this.initializeEmergencyCorrespondingCenterType();
    }

    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        String message = this.registerEmergency(emergency);
        return message;
    }
    @Override
    public String registerHealthEmergency(Emergency emergency) {
        String message = this.registerEmergency(emergency);
        return message;
    }
    @Override
    public String registerOrderEmergency(Emergency emergency) {
        String message = this.registerEmergency(emergency);
        return message;
    }
    private String registerEmergency(Emergency emergency){
        String simpleName = emergency.getClass().getSimpleName();
        this.emergencyRegisters.get(simpleName).enqueue(emergency);

        String message =
                String.format(
                        MESSAGE_REGISTER_EMERGENCY,
                        simpleName.replace("Emergency", ""),
                        emergency.getEmergencyLevel(),
                        emergency.getRegistrationTime());

        return message;
    }

    @Override
    public String registerFireServiceCenter(EmergencyCenter center) {
        String message = this.registerEmergencyCenter(center);
        return message;
    }
    @Override
    public String registerMedicalServiceCenter(EmergencyCenter center) {
        String message = this.registerEmergencyCenter(center);
        return message;
    }
    @Override
    public String registerPoliceServiceCenter(EmergencyCenter center) {
        String message = this.registerEmergencyCenter(center);
        return message;
    }
    private String registerEmergencyCenter(EmergencyCenter center){
        String simpleName = center.getClass().getSimpleName();
        this.emergencyCenterRegisters.get(simpleName).enqueue(center);

        String output =
                String.format(
                        MESSAGE_REGISTER_CENTER,
                        simpleName.replace("ServiceCenter", ""),
                        center.getName());

        return output;
    }

    @Override
    public String processEmergencies(String emergencyType) {
        String simpleName = emergencyType + "Emergency";

        Register<Emergency> emergencies = this.emergencyRegisters.get(simpleName);

        String centerType = this.emergencyCorrespondingCenterType.get(emergencyType);
        Register<EmergencyCenter> centers = this.emergencyCenterRegisters.get(centerType);

        while(true){
            if (emergencies.isEmpty()){
                break;
            }
            if (centers.isEmpty()){
                break;
            }

            EmergencyCenter center = centers.dequeue();
            if (center.isForRetirement()){
                continue;
            }

            center.processEmergency();
            if (!center.isForRetirement()){
                centers.enqueue(center);
            }

            this.removeEmergency(emergencyType, emergencies);
        }

        return this.messageProcessResult(emergencies, emergencyType);
    }
    private void removeEmergency(String emergencyType, Register<Emergency> emergencies) {
        Emergency emergency = emergencies.dequeue();
        this.gatherStatisticInfo(emergencyType, emergency.specificInfo());
    }
    private void gatherStatisticInfo(String emergencyType, int emergencySpecificInfo){
        this.totalProcessedEmergencies++;

        switch (emergencyType) {
            case "Property":
                this.totalPropertyDamageFixed += emergencySpecificInfo;
                break;
            case "Health":
                this.totalHealthCasualtiesSaved += emergencySpecificInfo;
                break;
            case "Order":
                this.totalSpecialCasesProcessed += emergencySpecificInfo;
            default:
                break;
        }
    }
    private String messageProcessResult(Register<Emergency> emergencies, String emergencyType){
        if (!emergencies.isEmpty()){
            return String.format("%s Emergencies left to process: %s.", emergencyType, emergencies.size());
        }

        return String.format("Successfully responded to all %s emergencies.", emergencyType);
    }

    @Override
    public String emergencyReport() {
        StringBuilder message = new StringBuilder();

        message.append("PRRM Services Live Statistics")
                .append(System.lineSeparator());

        message.append(String.format(
                        "Fire Service Centers: %s",
                        this.emergencyCenterRegisters.get(FIRE_CENTER).size()))
                .append(System.lineSeparator())
                .append(String.format(
                        "Medical Service Centers: %s",
                        this.emergencyCenterRegisters.get(MEDICAL_CENTER).size()))
                .append(System.lineSeparator())
                .append(String.format(
                        "Police Service Centers: %s",
                        this.emergencyCenterRegisters.get(POLICE_CENTER).size()))
                .append(System.lineSeparator());

        message.append(String.format("Total Processed Emergencies: %s", this.totalProcessedEmergencies))
                .append(System.lineSeparator())
                .append(String.format("Currently Registered Emergencies: %s", this.getCurrentlyRegisteredEmergenciesCount()))
                .append(System.lineSeparator());

        message.append(String.format("Total Property Damage Fixed: %s", this.totalPropertyDamageFixed))
                .append(System.lineSeparator())
                .append(String.format("Total Health Casualties Saved: %s", this.totalHealthCasualtiesSaved))
                .append(System.lineSeparator())
                .append(String.format("Total Special Cases Processed: %s", this.totalSpecialCasesProcessed));


        return message.toString();
    }
    private int getCurrentlyRegisteredEmergenciesCount(){
        int counter = 0;

        for (Map.Entry<String, Register<Emergency>> entry : emergencyRegisters.entrySet()) {
            counter += entry.getValue().size();
        }

        return counter;
    }

    private void initializeEmergencyCorrespondingCenterType(){
        emergencyCorrespondingCenterType = new HashMap<>();

        emergencyCorrespondingCenterType.put("Health", "MedicalServiceCenter");
        emergencyCorrespondingCenterType.put("Property", "FireServiceCenter");
        emergencyCorrespondingCenterType.put("Order", "PoliceServiceCenter");
    }
    private void initializeEmergencyRegisters(){
        this.emergencyRegisters = new HashMap<>();

        this.emergencyRegisters.put(HEALTH_EMERGENCY, new EmergencyRegister<>());
        this.emergencyRegisters.put(ORDER_EMERGENCY, new EmergencyRegister<>());
        this.emergencyRegisters.put(PROPERTY_EMERGENCY, new EmergencyRegister<>());
    }
    private void initializeEmergencyCenterRegisters(){
        this.emergencyCenterRegisters = new HashMap<>();

        this.emergencyCenterRegisters.put(MEDICAL_CENTER, new EmergencyRegister<>());
        this.emergencyCenterRegisters.put(POLICE_CENTER, new EmergencyRegister<>());
        this.emergencyCenterRegisters.put(FIRE_CENTER, new EmergencyRegister<>());
    }
}
