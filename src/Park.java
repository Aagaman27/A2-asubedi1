import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Park {

    private final Map<Integer, Attraction> attractions;

    public Park() {
        attractions = new HashMap<>();
    }

    public void registerAttraction(Attraction attraction) {
        if (attraction == null) {
            throw new IllegalArgumentException("Attraction cannot be null.");
        }

        if (attractions.containsKey(attraction.getId())) {
            throw new IllegalArgumentException(
                    "An attraction with ID " + attraction.getId()
                            + " is already registered."
            );
        }

        attractions.put(attraction.getId(), attraction);

        System.out.println("Registered attraction: "
                + attraction.getName()
                + " (ID " + attraction.getId() + ")");
    }

    public Attraction getAttraction(int id) {
        Attraction attraction = attractions.get(id);

        if (attraction == null) {
            System.out.println("No attraction found with ID " + id + ".");
        } else {
            System.out.println("Found attraction with ID "
                    + id + ": " + attraction.getName());
        }

        return attraction;
    }

    public void displayVisitorCounts() {
        System.out.println("Visitor counts for all attractions:");

        for (Attraction attraction : attractions.values()) {
            System.out.println("  - " + attraction.getName()
                    + ": " + attraction.getVisitCount() + " seats served");
        }
    }

    public int getDistinctVisitorCount() {
        Set<Visitor> distinctVisitors = new HashSet<>();

        for (Attraction attraction : attractions.values()) {
            distinctVisitors.addAll(attraction.getVisitHistory());
        }

        return distinctVisitors.size();
    }

    public void displayDistinctVisitorCount() {
        System.out.println("Distinct visitors served across the park: "
                + getDistinctVisitorCount());
    }
}