import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Trip {
    private String cityName;
    private String timePeriod;
    private List<Attractions> attractionsList;

    public Trip(String cityName, String timePeriod, List<Attractions> attractionsList) {
        this.cityName = cityName;
        this.timePeriod = timePeriod;
        this.attractionsList = attractionsList;
    }

    public String getCityName() {
        return cityName;
    }

    public String getTimePeriod() {
        return timePeriod;
    }


    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }


    public List<Attractions> getAttractionsList() {
        return attractionsList;
    }

    public void setAttractionsList(List<Attractions> attractionsList) {
        this.attractionsList = attractionsList;
    }

    /**
     * we sort the attractions
     */
    public void sortAttractions() {
        Collections.sort(attractionsList);
    }

    /**
     *
     * @param attractions the attraction to check
     * @return true if the attraction is visitable and not payable
     */
    public boolean isVisitableNotPayable(Attractions attractions) {
        if (!(attractions instanceof Payable)) {
            return true;
        }
        return false;
    }

    /**
     * we check if an attraction is only visitable and add it to a new List, then we print it
     */
    public void printVisitable() {
        List<Attractions> visitableAttractions = new ArrayList<>();

        for (Attractions a : attractionsList) {
            if (isVisitableNotPayable(a)) {
                visitableAttractions.add(a);
            }
        }

        visitableAttractions.sort(Attractions::compareTo2);
        for (Attractions a : visitableAttractions) {
            System.out.println(a + "\n");
        }
    }


    @Override
    public String toString() {
        return "Trip{" +
                "cityName='" + cityName + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                ", attractionsList=" + this.getAttractionsList() + '\n' +
                '}';
    }
}
