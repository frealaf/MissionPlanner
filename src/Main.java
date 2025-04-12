import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        // create the objects
        Operator operator1 = new Operator("Alice", 101);
        Drone drone1 = new Drone("DJI Phantom", 501);
        Drone drone2 = new Drone("Parrot Anafi", 502);

        // create a mission and assign drones
        Mission mission1 = new Mission("Reconnaissance of Area A", 301, operator1);
        mission1.addDrone(drone1);
        mission1.addDrone(drone2);

        // associate the mission with operator and drones
        operator1.addMission(mission1);
        drone1.addMission(mission1);
        drone2.addMission(mission1);

        // operator writes the report (and drones sign it)
        operator1.writeReport(mission1);

        // print the full mission report
        System.out.println("--- Mission Report ---");
        System.out.println(mission1.getReport());
    }
}