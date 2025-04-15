import java.util.LinkedList;

public class Drone {
    private String name;
    private int number;
    private LinkedList<Mission> missions;
    private static int nextID = 1; // shared by all drones starts at 1


    public Drone(String nome, int number) {
        this.name = nome;
        this.number = number;
        this.missions = new LinkedList<>();
    }

    public Drone(String name) {
        this.name = name;
        this.number = nextID++; // default number or ID
        this.missions = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public void addMission(Mission mission) {
        missions.add(mission);
    }

    public void removeMission(Mission mission) {
        if (mission == null || !missions.contains(mission)) {
            return;
        }
        missions.remove(mission);
    }

    public LinkedList<Mission> getMissions() {
        return new LinkedList<>(missions);
    }

    public void signReport (Mission mission) {
        if (mission == null || !mission.getDrones().contains(this)) {
            return;
        }
        mission.addReportLine("Drone signed: " + this.name + " (ID: " + this.number + ")");
    }
}
