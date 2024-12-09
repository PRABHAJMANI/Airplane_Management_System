package airport1.booking;

//import airport1.flight.Cargo;
import airport1.flight.Passenger;
import airport1.flight.Plane;

public class FlightBooking implements Booking {
    private Plane plane;
    private Passenger passenger;
    private String bookingDate;
    private boolean isBooked;

    public FlightBooking(Plane plane, Passenger passenger, String bookingDate) {
        this.plane = plane;
        this.passenger = passenger;
        this.bookingDate = bookingDate;
        this.isBooked = false;
    }

    @Override
    public String getBookingDetails() {
        return "Passenger: " + passenger.getName() + ", Plane: " + plane.getPlaneType() + " (" + plane.getPlaneVersion() + "), Booking Date: " + bookingDate;
    }

 
    @Override
    public void bookFlight(Plane plane, Passenger passenger) {
        if (isBooked) {
            System.out.println("Flight already booked.");
        } else if (plane.getPassengers().contains(passenger)) {
            System.out.println("Passenger is already booked on this flight.");
        } else {
            plane.addPassenger(passenger);
            isBooked = true;
            System.out.println("Flight booked successfully.");
        }
    }


    @Override
    public void cancelBooking() {
        if (isBooked) {
            plane.removePassenger(passenger);
            isBooked = false;
            System.out.println("Booking canceled successfully.");
        } else {
            System.out.println("No booking found to cancel.");
        }
    }

//	@Override
//	public void bookFlight(Plane plane, Passenger passenger, Cargo cargo) {
//		// TODO Auto-generated method stub
//		
//	}
}