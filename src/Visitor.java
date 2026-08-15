
public class Visitor implements Comparable<Visitor> {

    private int id;
    private String name;
    private int age;
    private String ticketType;

    public Visitor(int id, String name, int age, String ticketType) {
    
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
    
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
            if (age <= 0 || age > 120) {
            throw new IllegalArgumentException("Age must be a sensible positive number (1-120)");
        }
    
        if (ticketType == null || ticketType.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket type must not be empty");
        }

        this.id = id;
        this.name = name.trim();          // remove leading/trailing spaces for cleaner data
        this.age = age;
        this.ticketType = ticketType.trim(); // same reason as above
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTicketType() {
        return ticketType;
    }

    @Override
    public String toString() {
        return "Visitor ID: " + id + ", Name: " + name + ", Age: " + age + ", Ticket Type: " + ticketType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Visitor other = (Visitor) obj;
        return this.id == other.id;   // same ID → same visitor
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);  // must match equals()
    }

    @Override
    public int compareTo(Visitor other) {
        return Integer.compare(this.age, other.age); // youngest → oldest
    }
}