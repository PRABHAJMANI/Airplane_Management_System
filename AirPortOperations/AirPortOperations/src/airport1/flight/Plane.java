package airport1.flight;

import airport1.booking.Booking;
//import airport1.flight.Passenger;

import java.util.ArrayList;
import java.util.List;

public abstract class Plane implements FlightOperations {
    private String planeType;
    private String planeVersion;
    private int capacity;
    private List<Passenger> passengers;
    private List<Booking> bookings;

    public Plane(String planeType, String planeVersion, int capacity) {
        this.setPlaneType(planeType);
        this.setPlaneVersion(planeVersion);
        this.setCapacity(capacity);
        this.setPassengers(new ArrayList<>());
        this.bookings = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        if (getPassengers().size() < getCapacity()) {
            getPassengers().add(passenger);
        } else {
            System.out.println("Plane is full. Cannot add more passengers.");
        }
    }

    public void removePassenger(Passenger passenger) {
        getPassengers().remove(passenger);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public abstract void displayPlaneDetails();

    @Override
    public void takeOff() {
        System.out.println("Flight taking off...");
    }

    @Override
    public void land() {
        System.out.println("Flight landing...");
    }

    public String getPlaneVersion() {
        return planeVersion;
    }

    public void setPlaneVersion(String planeVersion) {
        this.planeVersion = planeVersion;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

	public void loadCargo(Cargo cargo) {
		
	}

	public void unloadCargo(Cargo cargo)
	{
		
	}
}
