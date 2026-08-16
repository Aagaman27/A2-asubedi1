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

        System.out.println();
        System.out.println("=== Part 5 - Operating Attractions ===");

        Ride testRide = new Ride(102, "Roller Coaster", 2);
        Show show = new Show(201, "Magic Show", 50);

        Staff rideOperator =
                new Staff(2, "Chris", 35, "Ride Operator");

        Staff showOperator =
                new Staff(3, "Jamie", 29, "Show Operator");

        testRide.assignOperator(rideOperator);
        show.assignOperator(showOperator);

        Visitor v6 =
                new Visitor(1007, "Morgan", 19, "Student");

        Visitor v7 =
                new Visitor(1008, "Casey", 26, "Adult");

        testRide.joinWaitingLine(v6);
        testRide.joinWaitingLine(v7);

        System.out.println();
        System.out.println("Ride with visitors waiting:");

        testRide.runCycle();

        System.out.println();
        System.out.println("Ride with an empty waiting line:");

        testRide.runCycle();

        System.out.println();
        System.out.println("Show with no visitors waiting:");

        show.runCycle();

        System.out.println();
        System.out.println("Ride cycle count: "
                + testRide.getCycleCount());

        System.out.println("Show cycle count: "
                + show.getCycleCount());
    }
}