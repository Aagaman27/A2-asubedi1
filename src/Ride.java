public class Ride extends Attraction implements Inspectable {

    private String inspectionResult;
    private boolean closedForInspection;

    public Ride(int id, String name, int maxVisitorsPerCycle) {
        super(id, name, maxVisitorsPerCycle);

        this.inspectionResult = "Not yet inspected";
        this.closedForInspection = false;
    }

    @Override
    public void recordInspectionResult(String result) {
        if (result == null || result.trim().isEmpty()) {
            throw new IllegalArgumentException("Inspection result cannot be empty.");
        }

        this.inspectionResult = result.trim();

        if (result.equalsIgnoreCase("Failed")) {
            closedForInspection = true;
        } else if (result.equalsIgnoreCase("Passed")) {
            closedForInspection = false;
        }
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
    protected boolean canRun() {

        if (getOperator() == null) {
            System.out.println(getName() + " cannot run: no operator assigned.");
            return false;
        }

        if (closedForInspection) {
            System.out.println(getName() + " cannot run: ride is closed for inspection.");
            return false;
        }

        if (!hasWaitingVisitors()) {
            System.out.println(getName() + " cannot run: waiting line is empty.");
            return false;
        }

        return true;
    }
}