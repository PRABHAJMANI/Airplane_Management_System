package airport1.flight;

public class CrewMember {
    private String name;
    private String role;

    public CrewMember(String name, String role) {
        this.name = name;
        this.role = role; //pilots, co-pilots,inflight attendants,passengers. 
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}