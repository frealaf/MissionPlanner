import java.util.LinkedList;

public class Operator {
    private String name;
    private int number;
    private LinkedList<Mission> missions;

    public Operator(String name, int number) {
        this.name = name; // Sets the name of the operator
        this.number = number; // Sets the operator ID
        this.missions = new LinkedList<>(); // Initializes an empty list of missions.
    }

    public Operator (String name, int number, LinkedList<Mission>missions){
        this.name = name;
        this.number = number;
        this.missions = new LinkedList<>(missions); // create a copy
        for (Mission mission : missions) {
            this.missions.add(mission);
            mission.setOperator(this); // Link operator to mission
        }
    }

    // Getter for the operators name
    public String getName() { return name; }

    // Getter for the operators number
    public int getNumber() { return number; }

    // Adds a mission to the operators mission list
    public void addMission(Mission mission) {
        if (mission == null || missions.contains(mission)) return;

        missions.add(mission);
        mission.setOperator(this); // ensures operator is assigned in the mission to
    }

    // Removes a mission from the operators mission list
    public void removeMission(Mission mission) {
        if (mission == null || !missions.contains(mission)) {
            return;
        }
        missions.remove(mission); // remove from operator side
        mission.removeOperator(); // remove from mission side
    }

    // Returns a copy of the missions list to avoid external modification.
    public LinkedList<Mission> getMissions() { return new LinkedList<>(missions); }

    public void writeReport(Mission mission) {
        if (mission == null || !missions.contains(mission)) {
            return; // The mission is either null or not assigned to this operator
        }
        // add header info line by line
        mission.addReportLine("Mission: "+ mission.getName());
        mission.addReportLine("ID: " + mission.getNumber());
        mission.addReportLine("Operator: " + this.name);

        // ask each drone to sign
        for (Drone drone : mission.getDrones()) {
            drone.signReport(mission); // each drone adds its own signature
        }
        }
}
