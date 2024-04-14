import java.time.LocalDate;
import java.util.*;

public class TravelPlan {
    private final Map<Attractions, LocalDate> plan;
    private final List<Attractions> keys;

    /**
     *
     * @param attractions the attraction
     *  we go through all the attractions and put them the data key in the plan and the attractions in the keys
     *  we sort them by their date
     */
    public TravelPlan(List<Attractions> attractions) {
        this.plan = new HashMap<>(attractions.size());
        this.keys = new ArrayList<>(attractions.size());

        for (Attractions a : attractions) {
            this.plan.put(a, a.getDataKey());
            keys.add(a);
        }
        this.keys.sort(Attractions::compareTo3);
    }

    public void addAttraction(Attractions attractions, LocalDate date) {
        plan.put(attractions, date);
    }

    public LocalDate getAttractionDate(Attractions attractions) {
        return plan.get(attractions);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int cont = 0;
        for (int i = 0; i < plan.size(); i++) {
            ++cont;
            s.append("Attraction ").append(cont).append(": ").append(this.keys.get(i).getName()).append(" ").append(plan.get(this.keys.get(i))).append(", ");
        }


        return "TravelPlan{" +
                "plan=" + s +
                '}';
    }
}
