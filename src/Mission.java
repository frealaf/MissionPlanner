import java.util.LinkedList;

public class Mission {
    private String name;
    private int number;
    private StringBuilder report;
    private Operator operator;
    private LinkedList<Drone> drones;

    public Mission(String name, int number, Operator operator) {
        this.name = name;
        this.number = number;
        this.operator = operator;
        this.drones = new LinkedList<>(); // empty list
        this.report = new StringBuilder();
    }

    public Mission(String nome, int numero, Operator operator, LinkedList<Drone> drones) {
        this.name = nome;
        this.number = numero;
        this.operator = operator;
        this.drones = new LinkedList<>();
        this.report = new StringBuilder();
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

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void removeOperator() { this.operator = null; }

    public LinkedList<Drone> getDrones() {
        return new LinkedList<>(drones);
    }

    public void addDrone(Drone drone) {
        drones.add(drone);
    }

    public void removeDrone(Drone drone) {
        if (drone == null || !drones.contains(drone)) {
            return;
        }
        drones.remove(drone);
        drone.removeMission(this);
    }

    public String getReport() {
        return  report.toString(); // converts the StringBuilder to a plain String
    }

    public void addReportLine(String line) {
        this.report.append(line).append("\n");
    }

}


