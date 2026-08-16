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

        Staff chris = new Staff(2, "Chris", 30, "Ride Operator");
        Staff jamie = new Staff(3, "Jamie", 35, "Show Operator");

        Ride rollerCoaster =
                new Ride(201, "Roller Coaster", 2);

        Show magicShow =
                new Show(202, "Magic Show", 50);

        rollerCoaster.assignOperator(chris);
        magicShow.assignOperator(jamie);

        Visitor morgan =
                new Visitor(1007, "Morgan", 26, "Adult");

        Visitor casey =
                new Visitor(1008, "Casey", 24, "Adult");

        rollerCoaster.joinWaitingLine(morgan);
        rollerCoaster.joinWaitingLine(casey);

        System.out.println();
        System.out.println("Ride with visitors waiting:");
        rollerCoaster.runCycle();

        System.out.println();
        System.out.println("Ride with an empty waiting line:");
        rollerCoaster.runCycle();

        System.out.println();
        System.out.println("Show with no visitors waiting:");
        magicShow.runCycle();

        System.out.println();
        System.out.println("Ride cycle count: "
                + rollerCoaster.getCycleCount());

        System.out.println("Show cycle count: "
                + magicShow.getCycleCount());

        System.out.println();
        System.out.println("=== Part 6 - Managing the Park ===");

        Park park = new Park();

        Ride parkRollerCoaster =
                new Ride(301, "Park Roller Coaster", 2);

        Show parkMagicShow =
                new Show(302, "Park Magic Show", 50);

        Ride waterRide =
                new Ride(303, "Water Ride", 2);

        Staff parkRideOperator =
                new Staff(4, "David", 30, "Ride Operator");

        Staff parkShowOperator =
                new Staff(5, "Emma", 28, "Show Operator");

        parkRollerCoaster.assignOperator(parkRideOperator);
        parkMagicShow.assignOperator(parkShowOperator);
        waterRide.assignOperator(parkRideOperator);

        Visitor parkAlex =
                new Visitor(1101, "Alex", 25, "Adult");

        Visitor parkSam =
                new Visitor(1102, "Sam", 28, "Adult");

        Visitor parkJordan =
                new Visitor(1103, "Jordan", 22, "Adult");

        parkRollerCoaster.joinWaitingLine(parkAlex);
        parkRollerCoaster.joinWaitingLine(parkSam);

        parkMagicShow.joinWaitingLine(parkAlex);

        waterRide.joinWaitingLine(parkJordan);

        parkRollerCoaster.runCycle();
        parkMagicShow.runCycle();
        waterRide.runCycle();

        park.registerAttraction(parkRollerCoaster);
        park.registerAttraction(parkMagicShow);
        park.registerAttraction(waterRide);

        System.out.println();

        park.getAttraction(302);

        System.out.println();

        park.displayVisitorCounts();

        System.out.println();

        park.displayDistinctVisitorCount();
    }
}