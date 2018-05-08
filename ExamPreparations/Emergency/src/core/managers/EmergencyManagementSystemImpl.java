package core.managers;

import data.Register;
import data.RegisterImpl;
import models.emergencies.Emergency;
import models.emergencyCenters.EmergencyCenter;

import java.util.HashMap;
import java.util.Map;

public class  EmergencyManagementSystemImpl implements EmergencyManagementSystem {
    private static final String REGISTER_EMERGENCY = "Registered Public %s Emergency of level %s at %s.";
    private static final String REGISTER_EMERGENCY_CENTER = "Registered %s Service Emergency center – %s.";

    private Map<String, Register<Emergency>> emergencyRegisters;
    private Map<String, Register<EmergencyCenter>> emergencyCenterRegisters;

    private Map<String, String> emergencyCorrespondingCenterType;

    private int totalProcessedEmergencies;
    private int totalPropertyDamageFixed;
    private int totalHealthCasualtiesSaved;
    private int totalSpecialCasesProcessed;

    public EmergencyManagementSystemImpl(
            Map<String, Register<Emergency>> emergencyRegisters,
            Map<String, Register<EmergencyCenter>> emergencyCenterRegisters,
            Map<String, String> emergencyCorrespondingCenterType){
        this.emergencyRegisters = emergencyRegisters;
        this.emergencyCenterRegisters = emergencyCenterRegisters;
        this.setEmergencyCorrespondingCenterType(emergencyCorrespondingCenterType);
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
        if (!this.emergencyRegisters.containsKey(simpleName)){
            this.emergencyRegisters.put(simpleName, new RegisterImpl<>());
        }

        this.emergencyRegisters.get(simpleName).enqueue(emergency);

        String message =
                String.format(
                        REGISTER_EMERGENCY,
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

        if (!this.emergencyCenterRegisters.containsKey(simpleName)){
            this.emergencyCenterRegisters.put(simpleName, new RegisterImpl<>());
        }

        this.emergencyCenterRegisters.get(simpleName).enqueue(center);

        String output =
                String.format(
                        REGISTER_EMERGENCY_CENTER,
                        simpleName.replace("Emergency", ""),
                        center.getName());

        return output;
    }

    @Override
    public String processEmergencies(String emergencyType) {
        Register<Emergency> emergencies = this.emergencyRegisters.get(emergencyType);

        String centerType = this.emergencyCorrespondingCenterType.get(emergencyType);
        Register<EmergencyCenter> availableCenters = this.emergencyCenterRegisters.get(centerType);

        Register<EmergencyCenter> busyCenters = new RegisterImpl<>(availableCenters.size());

        while(true){
            if (emergencies.isEmpty()){
                break;
            }
            if (availableCenters.isEmpty()){
                break;
            }

            this.centerProcessEmergency(availableCenters, busyCenters);
            this.removeEmergency(emergencyType, emergencies);
        }

        this.restartBusyCenters(availableCenters, busyCenters);

        return this.messageProcessResult(emergencies, emergencyType);
    }
    private void centerProcessEmergency(Register<EmergencyCenter> availableCenters, Register<EmergencyCenter> busyCenters){
        EmergencyCenter center = availableCenters.dequeue();
        center.processEmergency();

        if (!center.isForRetirement()){
            busyCenters.enqueue(center);
        }
    }
    private void removeEmergency(String emergencyType, Register<Emergency> emergencies) {
        Emergency emergency = emergencies.dequeue();
        this.totalProcessedEmergencies++;
        this.gatherStatisticInfo(emergencyType, emergency.specificInfo());
    }
    private void gatherStatisticInfo(String emergencyType, int emergencySpecificInfo){
        switch (emergencyType) {
            case "Property":
                this.totalPropertyDamageFixed += emergencySpecificInfo;
                break;
            case "Health":
                this.totalHealthCasualtiesSaved += emergencySpecificInfo;
            case "Order":
                this.totalSpecialCasesProcessed += emergencySpecificInfo;
            default:
                break;
        }
    }
    private void restartBusyCenters(Register<EmergencyCenter> availableCenters, Register<EmergencyCenter> busyCenters){
        while(true){
            if (busyCenters.isEmpty()){
                break;
            }

            EmergencyCenter center = busyCenters.dequeue();
            availableCenters.enqueue(center);
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
                        this.emergencyCenterRegisters.get("FireServiceCenter").size()))
                .append(System.lineSeparator())
                .append(String.format(
                        "Medical Service Centers: %s",
                        this.emergencyCenterRegisters.get("MedicalServiceCenter").size()))
                .append(System.lineSeparator())
                .append(String.format(
                        "Police Service Centers: %s",
                        this.emergencyCenterRegisters.get("PoliceServiceCenter").size()))
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


    private void setEmergencyCorrespondingCenterType(Map<String, String> emergencyCorrespondingCenterType){
        this.emergencyCorrespondingCenterType = emergencyCorrespondingCenterType;

        if (this.emergencyCorrespondingCenterType.isEmpty()){
            seedEmergencyCorrespondingCenterType();
        }
    }
    private void seedEmergencyCorrespondingCenterType(){
        if (emergencyCenterRegisters == null){
            emergencyCorrespondingCenterType = new HashMap<>();
        }

        emergencyCorrespondingCenterType.put("Health", "MedicalServiceCenter");
        emergencyCorrespondingCenterType.put("Property", "FireServiceCenter");
        emergencyCorrespondingCenterType.put("Order", "PoliceServiceCenter");
    }
}
