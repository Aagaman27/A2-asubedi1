public class Show extends Attraction {

    public Show(int id, String name, int maxVisitorsPerCycle) {
        super(id, name, maxVisitorsPerCycle);
    }

    @Override
    protected boolean canRun() {
        if (getOperator() == null) {
            System.out.println(getName() + " cannot run: no operator assigned.");
            return false;
        }

        return true;
    }
}