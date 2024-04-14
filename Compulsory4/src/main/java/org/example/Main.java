package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        Faker generator = new Faker();

        String city1= generator.address().cityName();

        Person p1 = new Driver(newName(generator), 21, city1, "Bucuresti", new ArrayList<>(List.of("Bacau", "Buzau")));
        Person p2 = new Driver(newName(generator), 34, "Cluj", "Suceava", new ArrayList<>(List.of("Timisoara", "Ilfov")));

        Person p3 = new Passenger(newName(generator), 43, city1, "Buzau");
        Person p4 = new Passenger(newName(generator), 23, "Timisoara", "Ilfov");

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        Problem p = new Problem(personList);

        System.out.println("All locations of the drivers are: " + p.getAllDriversLocations());
        //System.out.println("All destinations are: " + p.allDestination());
        p.matchDriversWithPassengers();


    }

    /**
     *
     * @param f the faker
     * @return a new generated fake name
     */
    private static String newName(Faker f) {
        return f.name().fullName();
    }

    /**
     *
     * @param f the faker
     * @return a new generated fake location
     */
    private static String newLocation(Faker f) {
        return f.address().cityName();
    }
}