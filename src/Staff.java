public class Staff {

    private final int id;
    private final String name;
    private final int age;
    private final String role;

    public Staff(int id, String name, int age, String role) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        if (age <= 0 || age > 120) {
            throw new IllegalArgumentException("Age must be a sensible positive number (1-120)");
        }

        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role must not be empty");
        }

        this.id = id;
        this.name = name.trim();
        this.age = age;
        this.role = role.trim();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public void performInspection(Inspectable target) {
        if (target == null) {
            throw new IllegalArgumentException("Inspection target cannot be null.");
        }

        target.setClosedForInspection(true);

        System.out.println(name + " is inspecting the target.");
        System.out.println("Closed for inspection: " + target.isClosedForInspection());

        target.recordInspectionResult("Passed");

        System.out.println("Inspection result: " + target.getInspectionResult());

        target.setClosedForInspection(false);

        System.out.println("Inspection completed.");
        System.out.println("Closed for inspection: " + target.isClosedForInspection());
    }

    @Override
    public String toString() {
        return "Staff ID: " + id
                + ", Name: " + name
                + ", Age: " + age
                + ", Role: " + role;
    }
}