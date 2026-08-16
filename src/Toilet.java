public class Toilet implements Inspectable {

    private int id;
    private String name;
    private String inspectionResult;
    private boolean closedForInspection;

    public Toilet(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Toilet ID must be a positive number.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Toilet name cannot be empty.");
        }

        this.id = id;
        this.name = name.trim();
        this.inspectionResult = "Not yet inspected";
        this.closedForInspection = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void recordInspectionResult(String result) {
        if (result == null || result.trim().isEmpty()) {
            throw new IllegalArgumentException("Inspection result cannot be empty.");
        }

        this.inspectionResult = result.trim();
    }

    @Override
    public String getInspectionResult() {
        return inspectionResult;
    }

    @Override
    public boolean isClosedForInspection() {
        return closedForInspection;
    }

    @Override
    public void setClosedForInspection(boolean closed) {
        this.closedForInspection = closed;
    }

    @Override
    public String toString() {
        return "Toilet[ID=" + id
                + ", Name=" + name
                + ", InspectionResult=" + inspectionResult
                + ", ClosedForInspection=" + closedForInspection + "]";
    }
}