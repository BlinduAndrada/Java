import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

public class Statue extends Attractions implements Visitable {

    public Statue(String name, String description, String location, LocalDate dataKey, Map<LocalDate, TimeInterval> timeTable) {
        super(name, description, location, dataKey, timeTable);
    }

    @Override
    public String toString() {
        return "Statue{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", dataKey=" + dataKey +
                ", timeTable=" + timeTable +
                '}';
    }
}
