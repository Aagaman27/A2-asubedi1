

public class Staff {

    private int id;
    private String name;
    private int age;
    private String role;

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

    @Override
    public String toString() {
        return "Staff ID: " + id + ", Name: " + name + ", Age: " + age + ", Role: " + role;
    }
}