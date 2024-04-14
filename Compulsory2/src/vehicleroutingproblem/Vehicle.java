package vehicleroutingproblem;

import java.util.Objects;

/**
 * Class for the vehicleroutingproblem.Vehicle part
 */
public abstract class Vehicle {
    private String carName;
    private String carModel;
    private String itsDepot;

    public Vehicle(String carName, String carModel, String itsDepot) {
        this.carName = carName;
        this.carModel = carModel;
        this.itsDepot = itsDepot;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getItsDepot() {
        return itsDepot;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setItsDepot(String itsDepot) {
        this.itsDepot = itsDepot;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "carName='" + carName + '\'' +
                ", carModel='" + carModel + '\'' +
                ", itsDepot='" + itsDepot + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return Objects.equals(carName, vehicle.carName) && Objects.equals(carModel, vehicle.carModel) && Objects.equals(itsDepot, vehicle.itsDepot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carModel, itsDepot);
    }
}
