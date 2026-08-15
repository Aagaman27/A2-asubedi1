// AssignmentTwo.java
import java.util.Arrays;

public class AssignmentTwo {

    public static void main(String[] args) {

        // Test 1 — Normal visitors
        Visitor v1 = new Visitor(1001, "Alex", 21, "Adult");
        Visitor v2 = new Visitor(1002, "Sam", 18, "Student");
        Visitor v3 = new Visitor(1003, "Jordan", 30, "Senior");

        // Test 2 — Printing
        System.out.println("=== Printing Visitors ===");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println();

        // Test 3 — Age ordering
        System.out.println("=== Sorted by Age (youngest to oldest) ===");
        Visitor[] visitors = {v1, v2, v3};
        Arrays.sort(visitors);          // uses compareTo()
        for (Visitor v : visitors) {
            System.out.println(v);
        }
        System.out.println();

        // Test 4 — Equality
        System.out.println("=== Equality Test ===");
        Visitor visitorA = new Visitor(1001, "Alex", 21, "Adult");
        Visitor visitorB = new Visitor(1001, "Different Name", 99, "Child");
        System.out.println("visitorA.equals(visitorB) = " + visitorA.equals(visitorB));
        System.out.println();

        // Test 5 — Invalid Visitor
        System.out.println("=== Invalid Visitor Test ===");
        try {
            Visitor bad = new Visitor(-5, "", 0, "");
            System.out.println(bad); // will not reach here
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid visitor rejected: " + e.getMessage());
        }
    }
}