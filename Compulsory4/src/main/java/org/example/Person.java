package org.example;

public abstract class Person {
    protected String name;
    protected int age;
    protected String startLocation;
    protected String destination;


    public Person(String name, int age, String startLocation, String destination) {
        this.name = name;
        this.age = age;
        this.startLocation = startLocation;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public abstract TypeOfPerson getTypeOfPerson();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", startLocation='" + startLocation + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
