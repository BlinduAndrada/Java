import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

public class Church extends Attractions implements Visitable {
    public Church(String name, String description, String location, LocalDate dataKey, Map<LocalDate, TimeInterval> timeTable) {
        super(name, description, location, dataKey, timeTable);
    }

    @Override
    public String toString() {
        return "Church{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", dataKey=" + dataKey +
                ", timeTable=" + timeTable +
                '}';
    }
}
