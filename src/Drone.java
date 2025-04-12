import java.util.LinkedList;

public class Drone {
    private String name;
    private int number;
    private LinkedList<Mission> missions;


    public Drone(String nome, int number) {
        this.name = nome;
        this.number = number;
        this.missions = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int numero) {
        this.number = numero;
    }

    public void addMission(Mission mission) {
        missions.add(mission);
    }

    public void removeMission(Mission mission) {
        missions.remove(mission);
    }

    public LinkedList<Mission> getMissions() {
        return new LinkedList<>(missions);
    }

    public void signReport (Mission mission) {
        mission.addReportLine("Drone signed: " + this.name + " (ID: " + this.number + ")");
    }
}
