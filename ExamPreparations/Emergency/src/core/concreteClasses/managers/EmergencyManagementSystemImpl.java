package core.concreteClasses.managers;

import core.abstractions.EmergencyManagementSystem;
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
        Register<EmergencyCenter> centers = this.emergencyCenterRegisters.get(centerType);

        Register<EmergencyCenter> busyCenters = new RegisterImpl<>(centers.size());

        int emergencySpecificInfo = 0;

        // Process emergencies and not write retired centers in busyCenters.
        while(true){

            if (emergencies.isEmpty()){
                break;
            }

            if (centers.isEmpty()){
                break;
            }


            Emergency emergency = emergencies.dequeue();
            emergencySpecificInfo += emergency.specificInfo();

            EmergencyCenter center = centers.dequeue();
            center.processEmergency();

            // Skip to add id back.
            if (center.isForRetirement()){
                continue;
            }

            busyCenters.enqueue(center);
        }

        switch(emergencyType){
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



        // Return not retired centers that were processing emergencies back to the main register.
        while(true){
            if (busyCenters.isEmpty()){
                break;
            }

            EmergencyCenter center = busyCenters.dequeue();
            centers.enqueue(center);
        }


        // Return message depend of success of processing emergencies.
        if (!emergencies.isEmpty()){
            return String.format("%s Emergencies left to process: %s.", emergencyType, emergencies.size());
        }

        return String.format("Successfully responded to all %s emergencies.", emergencyType);
    }
    @Override
    public String emergencyReport() {






        return null;
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
