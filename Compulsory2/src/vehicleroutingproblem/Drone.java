package vehicleroutingproblem;

public class Drone extends Vehicle {
    private int maxFlightDuration;

    public Drone(String carName, String carModel, String itsDepot, int maxFlightDuration) {
        super(carName, carModel, itsDepot);
        this.maxFlightDuration = maxFlightDuration;
    }

    public int getMaxFlightDuration() {
        return maxFlightDuration;
    }

    public void setMaxFlightDuration(int maxFlightDuration) {
        this.maxFlightDuration = maxFlightDuration;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "carName='" + getCarName() + '\'' +
                ", carModel='" + getCarModel() + '\'' +
                ", itsDepot='" + getItsDepot() + '\'' +
                "maxFlightDuration=" + maxFlightDuration +
                '}';
    }
}
