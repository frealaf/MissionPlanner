import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        // create the objects
        Operator operator1 = new Operator("Alice", 1001);
        Drone drone1 = new Drone("DJI Phantom", 201);
        Drone drone2 = new Drone("Parrot Anafi", 202);

        // create a mission and assign drones
        Mission mission1 = new Mission("Reconnaissance of Leiria", 301, operator1);
        mission1.addDrone(drone1);
        mission1.addDrone(drone2);

        // assign operator and drone to mission
        operator1.addMission(mission1);
        drone1.addMission(mission1);
        drone2.addMission(mission1);

        // operator writes the report (and drones sign it)
        operator1.writeReport(mission1);
        System.out.println("--- Mission Report ---");
        System.out.println(mission1.getReport());

        mission1.removeDrone(drone2);

        operator1.writeReport(mission1);

        // print the full mission report
        System.out.println("--- Mission Report ---");
        System.out.println(mission1.getReport());
    }
}