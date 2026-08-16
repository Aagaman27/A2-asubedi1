public class AssignmentTwo {

    public static void main(String[] args) {

        System.out.println("=== Ride Test ===");

        Staff mike = new Staff(1, "Mike", 30, "Ride Operator");

        Ride ride = new Ride(101, "Thunder Ride", 2);

        ride.assignOperator(mike);

        Visitor v1 = new Visitor(1001, "Alex", 25, "Adult");
        Visitor v2 = new Visitor(1002, "Sam", 28, "Adult");
        Visitor v3 = new Visitor(1003, "Jordan", 22, "Adult");

        ride.joinWaitingLine(v1);
        ride.joinWaitingLine(v2);
        ride.joinWaitingLine(v3);

        System.out.println();
        ride.displayWaitingLine();

        System.out.println();
        ride.runCycle();

        System.out.println();
        ride.displayWaitingLine();

        System.out.println();
        ride.runCycle();

        System.out.println();
        System.out.println(ride);

        System.out.println("Inspection result: " + ride.getInspectionResult());
        System.out.println("Closed for inspection: " + ride.isClosedForInspection());

        System.out.println();
        System.out.println("=== Inspection Test ===");

        mike.performInspection(ride);

        System.out.println();
        System.out.println("After inspection:");
        System.out.println("Inspection result: " + ride.getInspectionResult());
        System.out.println("Closed for inspection: " + ride.isClosedForInspection());

        System.out.println();
        ride.runCycle();
    }
}