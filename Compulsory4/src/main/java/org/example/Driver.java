package org.example;

import java.util.ArrayList;
import java.util.List;

public class Driver extends Person {
    private List<String> intermediaryDestinations;

    public Driver(String name, int age, String startLocation, String destination, List<String> intermediaryDestinations) {
        super(name, age, startLocation, destination);
        this.intermediaryDestinations = intermediaryDestinations;
    }

    public List<String> getIntermediaryDestinations() {
        return intermediaryDestinations;
    }


    /**
     * @return the Driver type
     */
    @Override
    public TypeOfPerson getTypeOfPerson() {
        return TypeOfPerson.DRIVER;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "intermediaryDestinations=" + intermediaryDestinations +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", startLocation='" + startLocation + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
