package vehicleroutingproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class for the vehicleroutingproblem.Depot part
 */
public class Depot {

    private String depotName;
    private String location;
    private int vehiclesNumber;
    private int maxSpace;
    private List<Vehicle> vehicleList;

    public Depot(String depotName, String location, int maxSpace) {
        this.depotName = depotName;
        this.location = location;
        this.vehiclesNumber = 0;
        this.maxSpace = maxSpace;
        this.vehicleList = new ArrayList<>();
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVehiclesNumber() {
        return vehiclesNumber;
    }

    public void setVehiclesNumber(int vehiclesNumber) {
        this.vehiclesNumber = vehiclesNumber;
    }

    public int getMaxSpace() {
        return maxSpace;
    }

    public void setMaxSpace(int maxSpace) {
        this.maxSpace = maxSpace;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    /**
     * @param vehicle We add a new vehicle to a depot
     */
    public void addVehicle(Vehicle vehicle) {
        if (vehiclesNumber < maxSpace) {
            vehicleList.add(vehicle);
            vehiclesNumber++;
        } else {
            System.out.println("Cannot add vehicle. Depot is full.");
        }
    }

    /**
     * @return a list with all vehicle from the depot
     */
    public List<Vehicle> getVehicles() {
        return vehicleList;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "depotName='" + depotName + '\'' +
                ", location='" + location + '\'' +
                ", vehiclesNumber=" + vehiclesNumber +
                ", maxSpace=" + maxSpace +
                ", vehicleList=" + vehicleList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Depot depot)) return false;
        return vehiclesNumber == depot.vehiclesNumber && maxSpace == depot.maxSpace && Objects.equals(depotName, depot.depotName) && Objects.equals(location, depot.location) && Objects.equals(vehicleList, depot.vehicleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depotName, location, vehiclesNumber, maxSpace, vehicleList);
    }
}
