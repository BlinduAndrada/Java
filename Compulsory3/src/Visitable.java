import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {

    Map<LocalDate, TimeInterval> getTimeTable();

    /**
     *
     * @param date the date
     * @return the opening time of the attraction
     */
    default LocalTime getOpeningTime(LocalDate date) {
        Map<LocalDate, TimeInterval> timeTable = getTimeTable();
        if (timeTable.containsKey(date)) {
            return (LocalTime) timeTable.get(date).getStartTime();
        }
        return null;
    }

    /**
     *
     * @param date the date
     * @return the closing time of the attraction
     */
    default LocalTime getClosingTime(LocalDate date) {
        Map<LocalDate, TimeInterval> timeTable = getTimeTable();
        if (timeTable.containsKey(date)) {
            return (LocalTime) timeTable.get(date).getEndTime();

        }
        return null;
    }

}
