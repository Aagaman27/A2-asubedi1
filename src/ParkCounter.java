public class ParkCounter {

    private int totalVisitorsServed;

    public ParkCounter() {
        totalVisitorsServed = 0;
    }

    public synchronized void addVisitors(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Visitor count cannot be negative.");
        }

        totalVisitorsServed += count;
    }

    public synchronized int getTotalVisitorsServed() {
        return totalVisitorsServed;
    }
}