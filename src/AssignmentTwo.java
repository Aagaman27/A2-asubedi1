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

        System.out.println("Inspection result: "
                + ride.getInspectionResult());

        System.out.println("Closed for inspection: "
                + ride.isClosedForInspection());

        System.out.println();
        System.out.println("=== Inspection Test ===");

        mike.performInspection(ride);

        System.out.println();
        System.out.println("After inspection:");

        System.out.println("Inspection result: "
                + ride.getInspectionResult());

        System.out.println("Closed for inspection: "
                + ride.isClosedForInspection());

        System.out.println();

        ride.runCycle();

        System.out.println();
        System.out.println("=== Part 4 - Visit History ===");

        Visitor v4 = new Visitor(1004, "Alex", 20, "Student");
        Visitor v5 = new Visitor(1005, "Jordan", 30, "Senior");

        ride.recordVisitor(v1);
        ride.recordVisitor(v2);
        ride.recordVisitor(v3);
        ride.recordVisitor(v4);
        ride.recordVisitor(v5);

        System.out.println();

        ride.displayVisitHistory();

        System.out.println();

        ride.hasVisited(v2);

        System.out.println();

        Visitor unknownVisitor =
                new Visitor(1006, "Taylor", 24, "Adult");

        ride.hasVisited(unknownVisitor);

        System.out.println();

        ride.getVisitHistoryCount();

        System.out.println();

        ride.displayVisitHistoryByAge();

        System.out.println();

        ride.displayVisitHistoryByNameAndTicketType();
    }
}