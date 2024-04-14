package vehicleroutingproblem;

import java.time.LocalTime;

/*
Blindu Andrada Mihaela
The main class
 */
public class Main {
    public static void main(String[] args) {

        Problem problem1 = new Problem(10);

        Depot depot1 = new Depot("happyCars", "Iasi", 25);
        Depot depot2 = new Depot("Depot2", "Bucuresti", 10);
        Client c = new Client("Vlad", LocalTime.of(6, 0), LocalTime.of(10, 0), TypeClient.PREMIUM);

        c.print();
        Truck truck1 = new Truck("Truck1", "Model1", "depot1", 10);
        Drone drone1 = new Drone("Drone1", "Model1", "depot1", 60);


        Truck truck2 = new Truck("Truck2", "Model2", "depot2", 7);
        Drone drone2 = new Drone("Drone2", "Model2", "depot2", 40);

        depot1.addVehicle(truck1);
        depot1.addVehicle(drone1);

        depot2.addVehicle(truck2);
        depot2.addVehicle(drone2);

        System.out.println(depot1);
        System.out.println(depot2);

        Vehicle[] allVehiclesDepot = depot1.getVehicles().toArray(new Vehicle[0]);
        System.out.println("All Vehicles from depot :" + depot1.getDepotName());

        for (Vehicle vehicle : allVehiclesDepot) {
            System.out.println(vehicle);
        }

        problem1.addDepot(depot1);
        problem1.addDepot(depot2);

        Vehicle[] allVehicles = problem1.getVehicles();
        System.out.println("All Vehicles:");
        for (Vehicle vehicle : allVehicles) {
            System.out.println(vehicle);
        }


        /*
        System.out.println(d.getNameOfDepot());
        d.print();
        System.out.println(v.getCarModel());
        v.print();
        System.out.println(c.getClientName());
        System.out.println(c.getTypeOfClient());
        c.print();

         */

    }
}