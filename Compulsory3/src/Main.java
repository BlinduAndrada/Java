import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Map<LocalDate, TimeInterval> statueTime = new HashMap<>();
        statueTime.put(LocalDate.of(2024, 8, 10), new TimeInterval(LocalTime.of(10, 0), LocalTime.of(20, 0)));

        Map<LocalDate, TimeInterval> churchTime = new HashMap<>();
        churchTime.put(LocalDate.of(2024, 8, 11), new TimeInterval(LocalTime.of(7, 0), LocalTime.of(14, 0)));

        Map<LocalDate, TimeInterval> concertTime = new HashMap<>();
        concertTime.put(LocalDate.of(2024, 8, 12), new TimeInterval(LocalTime.of(15, 0), LocalTime.of(23, 0)));

        LocalDate date1 = LocalDate.of(2024, 8, 12);
        LocalDate date2 = LocalDate.of(2024, 8, 11);
        LocalDate date3 = LocalDate.of(2024, 8, 10);

        Statue statue1 = new Statue("Michelangelo", "very big and beautiful", "somewhere", date3, statueTime);
        Church church1 = new Church("Mont St. Michel Abbey", "very beautiful", "somewhere far", date2, churchTime);
        Concert concert1 = new Concert("concert Evanescence", "cel mai smecher concert", "UK", date1, concertTime, "Evanescence", 500);

        List<Attractions> attractionsList = new ArrayList<>();

        attractionsList.add(statue1);
        attractionsList.add(church1);
        attractionsList.add(concert1);

        Trip trip = new Trip("in Lume", "August 2024",  attractionsList);
        System.out.println(trip);

        TravelPlan travelPlan = new TravelPlan(attractionsList);
        travelPlan.addAttraction(statue1, date3);
        travelPlan.addAttraction(church1, date2);
        travelPlan.addAttraction(concert1, date1);

        trip.printVisitable();

        System.out.println(travelPlan);

    }

}