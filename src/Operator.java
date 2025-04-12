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

    // Getter for the operators name
    public String getName() { return name; }

    // Getter for the operators number
    public int getNumber() { return number; }

    // Adds a mission to the operators mission list
    public void addMission(Mission mission) { missions.add(mission); } // Corrected: add to the missions list, not to the mission itself. }

    // Removes a mission from the operators mission list
        public void removeMission(Mission mission) { missions.remove(mission);}

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
