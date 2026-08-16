import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Attraction {

    private final int id;
    private final String name;
    private final Queue<Visitor> waitingLine;
    private final List<Visitor> visitHistory;
    private Staff operator;
    private final int maxVisitorsPerCycle;
    private int cycleCount;

    public Attraction(int id, String name, int maxVisitorsPerCycle) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Attraction ID must be a positive integer."
            );
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Attraction name cannot be null or blank."
            );
        }

        if (maxVisitorsPerCycle <= 0) {
            throw new IllegalArgumentException(
                    "Maximum visitors per cycle must be greater than zero."
            );
        }

        this.id = id;
        this.name = name.trim();
        this.waitingLine = new LinkedList<>();
        this.visitHistory = new ArrayList<>();
        this.operator = null;
        this.maxVisitorsPerCycle = maxVisitorsPerCycle;
        this.cycleCount = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Staff getOperator() {
        return operator;
    }

    public int getMaxVisitorsPerCycle() {
        return maxVisitorsPerCycle;
    }

    public int getCycleCount() {
        return cycleCount;
    }

    public void assignOperator(Staff staff) {

        if (staff == null) {
            throw new IllegalArgumentException(
                    "Staff cannot be null."
            );
        }

        this.operator = staff;

        System.out.println(
                "Operator " + staff.getName()
                + " assigned to " + this.name + "."
        );
    }

    public void removeOperator() {

        this.operator = null;

        System.out.println(
                "Operator removed from " + this.name + "."
        );
    }

    protected boolean hasWaitingVisitors() {
        return !waitingLine.isEmpty();
    }

    public void joinWaitingLine(Visitor visitor) {

        if (visitor == null) {
            throw new IllegalArgumentException(
                    "Visitor cannot be null."
            );
        }

        waitingLine.add(visitor);

        System.out.println(
                visitor.getName()
                + " joined the waiting line for "
                + getName() + "."
        );
    }

    public void displayWaitingLine() {

        if (waitingLine.isEmpty()) {
            System.out.println(
                    getName() + " waiting line is empty."
            );
            return;
        }

        System.out.println(
                "Waiting line for " + getName() + ":"
        );

        for (Visitor visitor : waitingLine) {
            System.out.println(
                    "  - " + visitor.getName()
            );
        }
    }

    protected abstract boolean canRun();

    public void runCycle() {

        if (!canRun()) {
            return;
        }

        int served = 0;

        while (served < maxVisitorsPerCycle
                && !waitingLine.isEmpty()) {

            Visitor visitor = waitingLine.poll();

            visitHistory.add(visitor);

            System.out.println(
                    visitor.getName()
                    + " was served by "
                    + getName() + "."
            );

            served++;
        }

        cycleCount++;

        System.out.println(
                "Cycle completed for "
                + getName() + "."
        );
    }

    @Override
    public String toString() {

        String operatorName =
                (operator == null)
                ? "None"
                : operator.getName();

        return "Attraction[ID=" + id
                + ", Name=" + name
                + ", Operator=" + operatorName
                + ", MaxVisitorsPerCycle="
                + maxVisitorsPerCycle
                + ", CycleCount="
                + cycleCount + "]";
    }
}