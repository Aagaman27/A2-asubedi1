import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ParkFileManager {

    public static void savePark(Park park, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            for (Attraction attraction : park.getAttractions().values()) {

                String type;

                if (attraction instanceof Ride) {
                    type = "RIDE";
                } else if (attraction instanceof Show) {
                    type = "SHOW";
                } else {
                    continue;
                }

                String operatorId = "NONE";
                String operatorName = "NONE";
                String operatorAge = "NONE";
                String operatorRole = "NONE";

                if (attraction.getOperator() != null) {
                    Staff staff = attraction.getOperator();

                    operatorId = String.valueOf(staff.getId());
                    operatorName = staff.getName();
                    operatorAge = String.valueOf(staff.getAge());
                    operatorRole = staff.getRole();
                }

                writer.println(
                        "ATTRACTION|"
                                + type + "|"
                                + attraction.getId() + "|"
                                + attraction.getName() + "|"
                                + attraction.getMaxVisitorsPerCycle() + "|"
                                + operatorId + "|"
                                + operatorName + "|"
                                + operatorAge + "|"
                                + operatorRole
                );

                for (Visitor visitor : attraction.getWaitingLine()) {
                    writer.println(
                            "WAITING|"
                                    + attraction.getId() + "|"
                                    + visitor.getId() + "|"
                                    + visitor.getName() + "|"
                                    + visitor.getAge() + "|"
                                    + visitor.getTicketType()
                    );
                }

                for (Visitor visitor : attraction.getVisitHistory()) {
                    writer.println(
                            "HISTORY|"
                                    + attraction.getId() + "|"
                                    + visitor.getId() + "|"
                                    + visitor.getName() + "|"
                                    + visitor.getAge() + "|"
                                    + visitor.getTicketType()
                    );
                }
            }

            System.out.println("Park backup saved successfully to " + fileName + ".");

        } catch (IOException e) {
            System.out.println("Backup failed: " + e.getMessage());
        }
    }

    public static Park loadPark(String fileName) {
        Park park = new Park();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                try {
                    String[] parts = line.split("\\|");

                    if (parts[0].equals("ATTRACTION")) {

                        if (parts.length != 9) {
                            throw new IllegalArgumentException("Invalid attraction record.");
                        }

                        String type = parts[1];
                        int id = Integer.parseInt(parts[2]);
                        String name = parts[3];
                        int maxVisitors = Integer.parseInt(parts[4]);

                        Attraction attraction;

                        if (type.equals("RIDE")) {
                            attraction = new Ride(id, name, maxVisitors);
                        } else if (type.equals("SHOW")) {
                            attraction = new Show(id, name, maxVisitors);
                        } else {
                            throw new IllegalArgumentException("Unknown attraction type.");
                        }

                        if (!parts[5].equals("NONE")) {
                            Staff staff = new Staff(
                                    Integer.parseInt(parts[5]),
                                    parts[6],
                                    Integer.parseInt(parts[7]),
                                    parts[8]
                            );

                            attraction.assignOperator(staff);
                        }

                        park.registerAttraction(attraction);

                    } else if (parts[0].equals("WAITING")) {

                        if (parts.length != 6) {
                            throw new IllegalArgumentException("Invalid waiting record.");
                        }

                        int attractionId = Integer.parseInt(parts[1]);

                        Attraction attraction = park.getAttraction(attractionId);

                        if (attraction == null) {
                            throw new IllegalArgumentException(
                                    "Attraction does not exist."
                            );
                        }

                        Visitor visitor = new Visitor(
                                Integer.parseInt(parts[2]),
                                parts[3],
                                Integer.parseInt(parts[4]),
                                parts[5]
                        );

                        attraction.joinWaitingLine(visitor);

                    } else if (parts[0].equals("HISTORY")) {

                        if (parts.length != 6) {
                            throw new IllegalArgumentException("Invalid history record.");
                        }

                        int attractionId = Integer.parseInt(parts[1]);

                        Attraction attraction = park.getAttraction(attractionId);

                        if (attraction == null) {
                            throw new IllegalArgumentException(
                                    "Attraction does not exist."
                            );
                        }

                        Visitor visitor = new Visitor(
                                Integer.parseInt(parts[2]),
                                parts[3],
                                Integer.parseInt(parts[4]),
                                parts[5]
                        );

                        attraction.recordVisitor(visitor);

                    } else {
                        throw new IllegalArgumentException("Unknown record type.");
                    }

                } catch (Exception e) {
                    System.out.println("Skipping malformed line: " + line);
                    System.out.println("Reason: " + e.getMessage());
                }
            }

            System.out.println("Park restored successfully from " + fileName + ".");

        } catch (IOException e) {
            System.out.println("Restore failed: " + e.getMessage());
        }

        return park;
    }
}