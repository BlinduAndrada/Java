import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

public class Concert extends Attractions implements Payable, Visitable {

    private String singers;
    private int ticketPrice;

    public Concert(String name, String description, String location, LocalDate dataKey, Map<LocalDate, TimeInterval> timeTable, String singers, int ticketPrice) {
        super(name, description, location, dataKey, timeTable);
        this.singers = singers;
        this.ticketPrice = ticketPrice;
    }

    public String getSingers() {
        return singers;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    @Override
    public int getPrice() {
        return ticketPrice;
    }

    @Override
    public void setPrice(int price) {
        this.ticketPrice = price;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "singers='" + singers + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", dataKey=" + dataKey +
                ", timeTable=" + timeTable +
                '}';
    }
}
