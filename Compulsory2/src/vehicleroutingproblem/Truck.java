package vehicleroutingproblem;

public class Truck extends Vehicle {
    private int capacity;

    public Truck(String carName, String carModel, String itsDepot, int capacity) {
        super(carName, carModel, itsDepot);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Trucks{" +
                "carName='" + getCarName() + '\'' +
                ", carModel='" + getCarModel() + '\'' +
                ", itsDepot='" + getItsDepot() + '\'' +
                "capacity=" + capacity +
                '}';
    }

}
