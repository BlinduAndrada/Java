import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Attractions implements Visitable, Comparable<Attractions> {
    protected String name;
    protected String description;
    protected String location;
    protected LocalDate dataKey;
    protected Map<LocalDate, TimeInterval> timeTable;

    public Attractions(String name, String description, String location, LocalDate dataKey, Map<LocalDate, TimeInterval> timeTable) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.dataKey = dataKey;
        this.timeTable = timeTable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDataKey() {
        return dataKey;
    }

    public void setDataKey(LocalDate dataKey) {
        this.dataKey = dataKey;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Map<LocalDate, TimeInterval> timeTable) {
        this.timeTable = timeTable;
    }

    @Override
    public String toString() {
        return "Attractions{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", dataKey=" + dataKey +
                ", timeTable=" + timeTable +
                '}';
    }

    /**
     *
     * @param o the object to be compared.
     * @return compared by name
     */
    @Override
    public int compareTo(Attractions o) {
        return this.name.compareTo(o.getName());
    }

    /**
     *
     * @param o the object to be compared.
     * @return return compared hours
     */
    public int compareTo2(Attractions o) {
        return this.getOpeningTime(this.dataKey).compareTo(o.getOpeningTime(o.getDataKey()));

    }

    /**
     *
     * @param o the object to be compared.
     * @return compared dates
     */
    public int compareTo3(Attractions o){
        return this.getDataKey().compareTo(o.getDataKey());
    }

}
