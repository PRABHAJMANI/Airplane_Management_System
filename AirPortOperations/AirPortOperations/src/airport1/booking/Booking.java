package airport1.booking;

//import airport1.flight.Cargo;
import airport1.flight.Passenger;
import airport1.flight.Plane;

public interface Booking {
    String getBookingDetails();
    void bookFlight(Plane plane, Passenger passenger);
    void cancelBooking();
//	void bookFlight(Plane plane, Passenger passenger, Cargo cargo);
}