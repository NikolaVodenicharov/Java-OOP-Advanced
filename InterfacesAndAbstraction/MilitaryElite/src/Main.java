import Classes.*;
import Interfaces.Mission;
import Interfaces.Private;
import Interfaces.Repair;
import Interfaces.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        List<Soldier> soldiers = new ArrayList<>();

        while(true){
            String inputLine = reader.readLine();

            boolean isBreak = inputLine.equals("End");
            if (isBreak){
                break;
            }

            String[] splitInput = inputLine.split("\\s+");
            String soldierType = splitInput[0];
            String[] parameters =
                    Arrays.stream(splitInput)
                    .skip(1)
                    .limit(splitInput.length - 1)
                    .toArray(String[]::new);

            switch (soldierType){
                case "Private":
                    Soldier privat = createPrivate(parameters);
                    soldiers.add(privat);
                    break;
                case "Commando":
                    Soldier commando = createCommando(parameters);
                    soldiers.add(commando);
                    break;
                case "Engineer":
                    Soldier engineer = createEngineer(parameters);
                    soldiers.add(engineer);
                    break;
                case "LeutenantGeneral":
                    Soldier leutenantGeneral = createLeutenantGeneral(parameters, soldiers);
                    soldiers.add(leutenantGeneral);
                    break;
                case "Spy":
                    Soldier spy = createSpy(parameters);
                    soldiers.add(spy);
                    break;
                default:
                    break;
            }
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier);
        }
    }

    public static Soldier createPrivate (String[] parameters){
        String id = parameters[0];
        String firstName = parameters[1];
        String lastName = parameters[2];
        double salary = Double.parseDouble(parameters[3]);

        Soldier privat = new PrivateImpl(id, firstName, lastName, salary);

        return privat;
    }

    public static Soldier createSpy(String[] parameters){
        String id = parameters[0];
        String firstName = parameters[1];
        String lastName = parameters[2];
        String codeNumber = parameters[3];

        Soldier spy = new SpyImpl(id, firstName, lastName, codeNumber);

        return spy;
    }

    public static Soldier createLeutenantGeneral(String[] parameters, Collection<Soldier> soldiers){
        String id = parameters[0];
        String firstName = parameters[1];
        String lastName = parameters[2];
        double salary = Double.parseDouble(parameters[3]);

        String[] soldiersId =
                Arrays.stream(parameters)
                .skip(4)
                .limit(parameters.length - 4)
                .toArray(String[]::new);
        Collection<Private> foundSoldiers = getSoldiersById(soldiersId, soldiers);

        Soldier leutenantGeneral = new LeutenantGeneralImpl(id, firstName, lastName, salary, foundSoldiers);

        return leutenantGeneral;
    }
    private static Collection<Private> getSoldiersById(String[] soldiersId, Collection<Soldier> soldiers){
        List<Private> foundSoldiers = new ArrayList<>();

        for (String id : soldiersId) {
            try {
                Soldier soldier = getSoldierById(id, soldiers);
                foundSoldiers.add((Private)soldier); // is this bad ?
            }
            catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        return foundSoldiers;
    }
    private static Soldier getSoldierById(String id, Collection<Soldier> soldiers){
        for (Soldier soldier : soldiers) {
            if (soldier.getId().equals(id)){
                return soldier;
            }
        }

        throw new IllegalArgumentException("Soldier id does not exist.");
    }

    public static Soldier createEngineer(String[] parameters){
        String id = parameters[0];
        String firstName = parameters[1];
        String lastName = parameters[2];
        double salary = Double.parseDouble(parameters[3]);
        String corp = parameters[4];

        int len = parameters.length;
        String[] repairsParameters =
                Arrays.stream(parameters)
                        .skip(5)
                        .limit(len - 5)
                        .toArray(String[]::new);
        Collection<Repair> repairs = createRepairs(repairsParameters);

        Soldier engineer = new EngineerImpl(id, firstName, lastName, salary, corp, repairs);

        return engineer;
    }
    public static Collection<Repair> createRepairs(String[] parameters){
        List<Repair> repairs = new ArrayList<>(parameters.length / 2);

        List<String[]> groupedParameters = groupParameters(parameters, 2);
        for (String[] group : groupedParameters) {
            Repair repair = createRepair(group);
            repairs.add(repair);
        }

        return repairs;
    }
    public static Repair createRepair(String[] parameters){
        String name = parameters[0];
        int hours = Integer.parseInt(parameters[1]);

        Repair repair = new RepairImpl(name, hours);

        return repair;
    }

    public static Soldier createCommando (String[] parameters){
        String id = parameters[0];
        String firstName = parameters[1];
        String lastName = parameters[2];
        double salary = Double.parseDouble(parameters[3]);
        String corp = parameters[4];

        String[] missionsParameters =
                Arrays.stream(parameters)
                        .skip(5)
                        .limit(parameters.length - 5)
                        .toArray(String[]::new);
        Collection<Mission> missions = createMissions(missionsParameters);

        Soldier engineer = new CommandoImpl(id, firstName, lastName, salary, corp, missions);

        return engineer;
    }
    public static Collection<Mission> createMissions(String[] parameters){
        List<Mission> missions = new ArrayList<>(parameters.length / 2);

        List<String[]> groupedParameters = groupParameters(parameters, 2);
        for (String[] group : groupedParameters) {
            Mission mission = createMission(group);
            missions.add(mission);
        }

        return missions;
    }
    public static Mission createMission(String[] parameters){
        String name = parameters[0];
        String state = parameters[1];

        Mission mission = new MissionImpl(name, state);

        return mission;
    }

    public static List<String[]> groupParameters(String[] parameters, int groupLength){
        if (parameters.length % groupLength != 0){
            throw new IllegalArgumentException("Parameters can not be divide to groupLength");
        }

        List<String[]> groups = new ArrayList<>();

        for (int groupNumber = 0; groupNumber < parameters.length / groupLength; groupNumber++) {
            String[] group = new String[groupLength];

            for (int groupIndex = 0; groupIndex < groupLength; groupIndex++) {
                int parameterIndex = groupIndex + groupNumber * groupLength;
                group[groupIndex] = parameters[parameterIndex];
            }

            groups.add(group);
        }

        return groups;
    }
}
