package org.example;

public class Passenger extends Person {
    public Passenger(String name, int age, String startLocation, String destination) {
        super(name, age, startLocation, destination);
    }

    /**
     *
     * @return the passenger type
     */
    @Override
    public TypeOfPerson getTypeOfPerson() {
        return TypeOfPerson.PASSENGER;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", startLocation='" + startLocation + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
