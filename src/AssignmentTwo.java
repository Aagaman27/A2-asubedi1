import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AssignmentTwo {

    public static void main(String[] args) {

        System.out.println("=== Part 1 - People ===");

        Staff mike = new Staff(1, "Mike", 30, "Ride Operator");
        Staff chris = new Staff(2, "Chris", 35, "Ride Operator");
        Staff jamie = new Staff(3, "Jamie", 32, "Show Operator");

        Visitor v1 = new Visitor(1001, "Alex", 25, "Adult");
        Visitor v2 = new Visitor(1002, "Sam", 28, "Adult");
        Visitor v3 = new Visitor(1003, "Jordan", 22, "Adult");

        System.out.println(mike);
        System.out.println(chris);
        System.out.println(jamie);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        List<Visitor> visitors = new ArrayList<>();

        visitors.add(v1);
        visitors.add(v2);
        visitors.add(v3);

        Collections.sort(visitors);

        System.out.println();
        System.out.println("Visitors sorted by age:");

        for (Visitor visitor : visitors) {
            System.out.println("  - " + visitor);
        }

        System.out.println();
        System.out.println("=== Part 2 - Attractions and Inspection ===");

        Ride ride = new Ride(101, "Thunder Ride", 2);
        Toilet toilet = new Toilet(201, "Main Park Toilet");

        ride.assignOperator(mike);

        System.out.println();
        System.out.println(ride);

        System.out.println("Inspection result: "
                + ride.getInspectionResult());

        System.out.println("Closed for inspection: "
                + ride.isClosedForInspection());

        System.out.println();
        System.out.println("Ride inspection:");

        mike.performInspection(ride);

        System.out.println();
        System.out.println("After ride inspection:");

        System.out.println("Inspection result: "
                + ride.getInspectionResult());

        System.out.println("Closed for inspection: "
                + ride.isClosedForInspection());

        System.out.println();
        System.out.println("Toilet inspection:");

        mike.performInspection(toilet);

        System.out.println("Inspection result: "
                + toilet.getInspectionResult());

        System.out.println("Closed for inspection: "
                + toilet.isClosedForInspection());

        System.out.println();
        System.out.println("Removing ride operator:");

        ride.removeOperator();

        System.out.println(ride);

        System.out.println();
        System.out.println("=== Part 3 - Waiting Line ===");

        ride.assignOperator(mike);

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

        Ride rollerCoaster =
                new Ride(301, "Roller Coaster", 2);

        Show magicShow =
                new Show(302, "Magic Show", 3);

        rollerCoaster.assignOperator(chris);
        magicShow.assignOperator(jamie);

        Visitor morgan =
                new Visitor(2001, "Morgan", 26, "Adult");

        Visitor casey =
                new Visitor(2002, "Casey", 24, "Adult");

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

        Staff david =
                new Staff(4, "David", 40, "Ride Operator");

        Staff emma =
                new Staff(5, "Emma", 29, "Show Operator");

        Ride parkRide =
                new Ride(401, "Park Roller Coaster", 2);

        Show parkShow =
                new Show(402, "Park Magic Show", 3);

        Ride waterRide =
                new Ride(403, "Water Ride", 2);

        parkRide.assignOperator(david);
        parkShow.assignOperator(emma);
        waterRide.assignOperator(david);

        parkRide.joinWaitingLine(v1);
        parkRide.joinWaitingLine(v2);

        parkShow.joinWaitingLine(v1);

        waterRide.joinWaitingLine(v3);

        park.registerAttraction(parkRide);
        park.registerAttraction(parkShow);
        park.registerAttraction(waterRide);

        System.out.println();

        park.getAttraction(402);

        System.out.println();

        parkRide.runCycle();
        parkShow.runCycle();
        waterRide.runCycle();

        System.out.println();

        park.displayVisitorCounts();

        System.out.println();

        park.displayDistinctVisitorCount();

        System.out.println();
        System.out.println("=== Part 7 - Backup and Restore ===");

        Ride backupRide =
                new Ride(501, "Backup Roller Coaster", 2);

        Show backupShow =
                new Show(502, "Backup Magic Show", 2);

        Staff backupStaff =
                new Staff(6, "Daniel", 31, "Ride Operator");

        Staff showStaff =
                new Staff(7, "Sophie", 27, "Show Operator");

        backupRide.assignOperator(backupStaff);
        backupShow.assignOperator(showStaff);

        Visitor backupVisitor1 =
                new Visitor(3001, "Chris", 25, "Adult");

        Visitor backupVisitor2 =
                new Visitor(3002, "Jamie", 21, "Student");

        Visitor backupVisitor3 =
                new Visitor(3003, "Taylor", 35, "Adult");

        backupRide.joinWaitingLine(backupVisitor1);
        backupRide.joinWaitingLine(backupVisitor2);

        backupRide.recordVisitor(backupVisitor3);

        backupShow.joinWaitingLine(backupVisitor3);
        backupShow.recordVisitor(backupVisitor1);

        Park backupPark = new Park();

        backupPark.registerAttraction(backupRide);
        backupPark.registerAttraction(backupShow);

        String fileName = "park_backup.txt";

        ParkFileManager.savePark(backupPark, fileName);

        System.out.println();
        System.out.println("Loading backup into a fresh park:");

        Park restoredPark =
                ParkFileManager.loadPark(fileName);

        System.out.println();
        System.out.println("Restored attractions:");

        Attraction restoredRide =
                restoredPark.getAttraction(501);

        Attraction restoredShow =
                restoredPark.getAttraction(502);

        System.out.println();
        System.out.println("Restored ride operator: "
                + restoredRide.getOperator());

        System.out.println("Restored show operator: "
                + restoredShow.getOperator());

        System.out.println();
        System.out.println("Restored ride waiting line:");

        restoredRide.displayWaitingLine();

        System.out.println();
        System.out.println("Restored ride visit history:");

        restoredRide.displayVisitHistory();

        System.out.println();
        System.out.println("Restored show waiting line:");

        restoredShow.displayWaitingLine();

        System.out.println();
        System.out.println("Restored show visit history:");

        restoredShow.displayVisitHistory();

        System.out.println();
        System.out.println("Testing missing backup file:");

        ParkFileManager.loadPark("missing_backup.txt");

        System.out.println();
        System.out.println("Part 7 completed.");

        System.out.println();
        System.out.println("=== Part 8 - Running the Park Concurrently ===");

        Park concurrentPark = new Park();

        Ride concurrentRide =
                new Ride(601, "Concurrent Roller Coaster", 2);

        Show concurrentShow =
                new Show(602, "Concurrent Magic Show", 2);

        Ride concurrentWaterRide =
                new Ride(603, "Concurrent Water Ride", 2);

        Staff ryan =
                new Staff(8, "Ryan", 30, "Ride Operator");

        Staff lucy =
                new Staff(9, "Lucy", 28, "Show Operator");

        Staff mark =
                new Staff(10, "Mark", 34, "Ride Operator");

        concurrentRide.assignOperator(ryan);
        concurrentShow.assignOperator(lucy);
        concurrentWaterRide.assignOperator(mark);

        Visitor visitorOne =
                new Visitor(4001, "Visitor One", 21, "Adult");

        Visitor visitorTwo =
                new Visitor(4002, "Visitor Two", 23, "Adult");

        Visitor visitorThree =
                new Visitor(4003, "Visitor Three", 25, "Adult");

        Visitor visitorFour =
                new Visitor(4004, "Visitor Four", 27, "Adult");

        concurrentRide.joinWaitingLine(visitorOne);
        concurrentRide.joinWaitingLine(visitorTwo);

        concurrentShow.joinWaitingLine(visitorThree);
        concurrentShow.joinWaitingLine(visitorFour);

        concurrentWaterRide.joinWaitingLine(visitorOne);
        concurrentWaterRide.joinWaitingLine(visitorThree);

        concurrentPark.registerAttraction(concurrentRide);
        concurrentPark.registerAttraction(concurrentShow);
        concurrentPark.registerAttraction(concurrentWaterRide);

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        Future<?> rideFuture = executor.submit(new Runnable() {
            @Override
            public void run() {
                concurrentRide.runCycle();
                concurrentPark.addVisitorsServed(
                        concurrentRide.getVisitCount()
                );
            }
        });

        Future<?> showFuture = executor.submit(new Runnable() {
            @Override
            public void run() {
                concurrentShow.runCycle();
                concurrentPark.addVisitorsServed(
                        concurrentShow.getVisitCount()
                );
            }
        });

        Future<?> waterFuture = executor.submit(new Runnable() {
            @Override
            public void run() {
                concurrentWaterRide.runCycle();
                concurrentPark.addVisitorsServed(
                        concurrentWaterRide.getVisitCount()
                );
            }
        });

        try {
            rideFuture.get();
            showFuture.get();
            waterFuture.get();

            executor.shutdown();

            System.out.println();
            System.out.println("All attraction tasks have finished.");

            System.out.println("Final park-wide visitors served: "
                    + concurrentPark.getTotalVisitorsServed());

        } catch (Exception e) {
            System.out.println(
                    "Park operation was interrupted: "
                            + e.getMessage()
            );
            executor.shutdown();
        }

        System.out.println();
        System.out.println("Part 8 completed.");

        System.out.println();
        System.out.println("=== Assessment Demonstration Complete ===");
    }
}