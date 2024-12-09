package airport1.flight;

import java.util.ArrayList;
import java.util.List;

public class PassengerPlane extends Plane {
    private List<CrewMember> crew;

    public PassengerPlane(String planeType, String planeVersion, int capacity) {
        super(planeType, planeVersion, capacity);
        this.crew = new ArrayList<>();
    }

    public PassengerPlane(String planeType, String planeVersion) {
        super(planeType, planeVersion, planeVersion.equalsIgnoreCase("Premium") ? 150 : 200);
        this.crew = new ArrayList<>();
    }

    public void addCrewMember(CrewMember crewMember) {
        crew.add(crewMember);
    }

    @Override
    public void displayPlaneDetails() {
        System.out.println("Plane Type: " + getPlaneType());
        System.out.println("Plane Version: " + getPlaneVersion());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Passengers:");
        for (Passenger passenger : getPassengers()) {
            System.out.println(passenger.getName() + " (Meal Preference: " + passenger.getMealPreference() + ", Destination: " + passenger.getDestination() + ", Arrival Place: " + passenger.getArrivalPlace() + ")");
        }
        System.out.println("Crew Members:");
        for (CrewMember crewMember : crew) {
            System.out.println(crewMember.getName() + " (" + crewMember.getRole() + ")");
        }
    }

    public void  loadCargo(Cargo cargo)
    {
    	//unused
    }
}