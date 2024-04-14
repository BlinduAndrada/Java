import java.time.LocalTime;

public class TimeInterval extends Pair<LocalTime, LocalTime> implements Comparable<TimeInterval> {

    public TimeInterval(LocalTime startTime, LocalTime endTime) {
        super(startTime, endTime);
    }

    public LocalTime getStartTime() {
        return super.getFirst();
    }

    public LocalTime getEndTime() {
        return super.getSecond();
    }

    @Override
    public int compareTo(TimeInterval o) {
        return this.getStartTime().compareTo(o.getStartTime());
    }

    @Override
    public String toString() {
        return " " + this.getStartTime() + "-" + this.getEndTime();
    }

}
