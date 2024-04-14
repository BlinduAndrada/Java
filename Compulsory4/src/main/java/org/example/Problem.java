package org.example;


import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    private List<Person> allPeople;
    private List<Driver> drivers;
    private List<Passenger> passengers;
    private Map<String, List<Person>> allDestination;
    private List<String> keys;

    /**
     * @param allPeople the list of all drivers and all passengers
     */
    public Problem(List<Person> allPeople) {
        this.allPeople = allPeople;
        this.drivers = allPeople.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
        this.passengers = allPeople.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
        this.allDestination = new HashMap<>();
        this.keys = getAllDriversLocations();
    }

    /**
     * @return a list with all the driver's locations that they go to
     */
    public List<String> getAllDriversLocations() {
        List<String> allLocations = new ArrayList<>();
        for (Driver driver : drivers) {
            allLocations.add(driver.getStartLocation());
            allLocations.addAll(driver.getIntermediaryDestinations());
            allLocations.add(driver.getDestination());
        }
        return allLocations;
    }

    /**
     * @return a map of all destinations and the passengers that goes there with the format location and person
     */
    public Map<String, List<Person>> allDestination() {
        this.allDestination = keys.stream()
                .collect(Collectors.toMap(
                        location -> location,
                        location -> allPeople.stream()
                                .filter(x -> x.getDestination().equals(location) || (x instanceof Driver && ((Driver) x).getIntermediaryDestinations().contains(location)))
                                .collect(Collectors.toList())));
        this.keys
                .forEach(d -> {
                    System.out.println(d);
                    this.allDestination.get(d).forEach(x -> System.out.println(x.getName()));
                    System.out.println();
                });
        return allDestination;
    }

    /**
     * @param driver    the driver and his locations
     * @param passenger the passenger and his location
     * @return if at any point they are matching their locations so that the driver can pick them
     */
    private boolean isMatching(Driver driver, Passenger passenger) {
        boolean startMatch = driver.getStartLocation().equals(passenger.getStartLocation());
        boolean endMatch = driver.getDestination().equals(passenger.getDestination());
        boolean intermediateMatch = driver.getIntermediaryDestinations().contains(passenger.getStartLocation()) &&
                driver.getIntermediaryDestinations().contains(passenger.getDestination());
        return startMatch || endMatch || intermediateMatch;
    }

    /**
     * checks if a passengers start location and destination matches with the driver locations so
     * that means that he can pick him
     * after we do that, it breaks, and it goes to the next driver
     */
    public void matchDriversWithPassengers() {
        for (Driver driver : drivers) {
            for (Passenger passenger : passengers) {
                if (isMatching(driver, passenger)) {
                    System.out.println(passenger.getName() + " matched with the driver " + driver.getName());
                    break;
                }
            }
        }
    }

    /**
     * @return all the details we need to print about the problem
     */
    @Override
    public String toString() {
        return "Problem{" +
                "allPeople=" + allPeople +
                ", drivers=" + drivers +
                ", passengers=" + passengers +
                '}';
    }
}
