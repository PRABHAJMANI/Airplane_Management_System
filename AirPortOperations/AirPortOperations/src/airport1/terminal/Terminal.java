package airport1.terminal;

import airport1.booking.Booking;
import airport1.flight.Plane;

import java.util.ArrayList;
import java.util.List;

public class Terminal {
    protected String terminalName;
    protected List<Plane> planes;
    protected List<Booking> bookings;

    // Overloaded constructors
    public Terminal(String terminalName) {
        this.terminalName = terminalName;
        this.planes = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public Terminal(String terminalName, List<Plane> planes, List<Booking> bookings) {
        this.terminalName = terminalName;
        this.planes = planes;
        this.bookings = bookings;
    }

    // Overloaded methods
    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    // Vararg overloading
    public void addPlane(Plane... planes) {
        for (Plane plane : planes) {
            this.planes.add(plane);
        }
    }

    public void displayTerminalDetails() {
        System.out.println("Terminal: " + terminalName);
        System.out.println("Planes:");
        for (Plane plane : planes) {
            plane.displayPlaneDetails();
            System.out.println();
        }
        System.out.println("Bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking.getBookingDetails());
        }
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    	// Nested class
	    public static class TerminalStats {
	        private int numPlanes;
	        private int numBookings;
	
	        public TerminalStats(Terminal terminal) {
	            this.numPlanes = terminal.planes.size();
	            this.numBookings = terminal.bookings.size();
	        }
	
	        public int getNumPlanes() {
	            return numPlanes;
	        }
	
	        public int getNumBookings() {
	            return numBookings;
	        }
	    }

    	public List<Booking> getBookings() {
    		return bookings;
    	}

    	public void setBookings(List<Booking> bookings) {
    		this.bookings = bookings;
    	}

    	public String getTerminalName() {
    		return terminalName;
    	}

    	public void setTerminalName(String terminalName) {
    		this.terminalName = terminalName;
    	}

    	public List<Plane> getPlanes() {
    		return planes;
    	}

    	public void setPlanes(List<Plane> planes) {
    		this.planes = planes;
    	}

}