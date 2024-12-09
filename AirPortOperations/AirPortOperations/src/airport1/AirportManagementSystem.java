package airport1;

import airport1.terminal.Terminal;
import airport1.booking.Booking;
import airport1.booking.FlightBooking;
import airport1.flight.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AirportManagementSystem {
    private static List<Terminal> terminals = new ArrayList<>();
    private static List<Plane> planes = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        // Create terminals
        Terminal internationalTerminal = new Terminal("International");
        Terminal domesticTerminal = new Terminal("Domestic");
        terminals.add(internationalTerminal);
        terminals.add(domesticTerminal);

        // Create planes
        PassengerPlane plane1 = new PassengerPlane("Boeing", "Standard", 200);
        PassengerPlane plane2 = new PassengerPlane("AirIndia", "Premium", 150);
        CargoPlane cargoPlane1 = new CargoPlane("Airbus", "Premium", 100.0);
        CargoPlane cargoPlane2 = new CargoPlane("Indigo", "Standard", 150.0);
        planes.add(plane1);
        planes.add(plane2);
        planes.add(cargoPlane1);
        planes.add(cargoPlane2);

        // Add planes to terminals
        internationalTerminal.addPlane(plane1, cargoPlane1);
        domesticTerminal.addPlane(plane2, cargoPlane2);

        // Create crew members
        CrewMember pilot1 = new CrewMember("John Doe", "Pilot");
        CrewMember copilot1 = new CrewMember("Jane Smith", "Co-Pilot");
        CrewMember attendant1 = new CrewMember("Bob Johnson", "Flight Attendant");
        CrewMember pilot2 = new CrewMember("Alice", "Pilot");
        CrewMember copilot2 = new CrewMember("Eve", "Co-Pilot");

        // Add crew members to planes
        plane1.addCrewMember(pilot1);
        plane1.addCrewMember(copilot1);
        plane1.addCrewMember(attendant1);
        plane2.addCrewMember(pilot2);
        plane2.addCrewMember(copilot2);

        // Create passengers
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of passengers: ");
        int numPassengers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numPassengers; i++) {
            System.out.println("Enter details for passenger " + (i + 1) + ":");
            System.out.print("Name: ");
            String passengerName = scanner.nextLine();
            System.out.print("Meal Preference: ");
            String mealPreference = scanner.nextLine();
            System.out.print("Destination: ");
            String destination = scanner.nextLine();
            System.out.print("Arrival Place: ");
            String arrivalPlace = scanner.nextLine();

            Passenger passenger = new Passenger(passengerName, mealPreference, destination, arrivalPlace);
            passengers.add(passenger);
        }

        // Book flights
        System.out.print("Enter number of bookings: ");
        int numBookings = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numBookings; i++) {
            System.out.println("Enter details for booking " + (i + 1) + ":");
            System.out.print("Passenger Name: ");
            String passengerName = scanner.nextLine();
            Passenger passenger = findPassenger(passengerName);
            if (passenger == null) {
                System.out.println("Passenger not found. Skipping this Booking");
                continue;
            }
            System.out.print("Flight Number: ");
            String flightNumber = scanner.nextLine();
            Plane plane = findPlane(flightNumber);
            if (plane == null) {
                System.out.println("Flight not found. Skipping this booking.");
                continue;
            }
            if (plane.getPassengers().size() >= plane.getCapacity()) {
                System.out.println("Plane is full. Cannot book more passengers.");
                continue;
            }

            System.out.print("Booking Date (yyyy-MM-dd): ");
            String bookingDate = scanner.nextLine();

            Booking booking = new FlightBooking(plane, passenger, bookingDate);
            booking.bookFlight(plane, passenger);
            bookings.add(booking);
            plane.addPassenger(passenger);
        }

        scanner.close();

        // Display terminal details
        for (Terminal terminal : terminals) {
            terminal.displayTerminalDetails();
            System.out.println();
        }

        // Write flight information to a file
        try {
            FileWriter writer = new FileWriter("flights.txt");
            writer.write("Terminals:\n");
            for (Terminal terminal : terminals) {
                writer.write("\nTerminal: " + terminal.getTerminalName() + "\n");
                writer.write("Planes:\n");
                for (Plane plane : terminal.getPlanes()) {
                    writer.write(plane.getPlaneType() + " (" + plane.getPlaneVersion() + "), Capacity: " + plane.getCapacity() + "\n");
                }
                writer.write("\nBookings:\n");
                for (Booking booking : terminal.getBookings()) {
                    writer.write(booking.getBookingDetails() + "\n");
                }
            }
            writer.close();
            System.out.println("Flight information written to flights.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Multithreading
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable takeOffTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Take off task started in a separate thread");
                for (Plane plane : planes) {
                    if (plane.getPassengers().size() > 0) {
                        plane.takeOff();
                    }
                }
            }
        };
        executorService.submit(takeOffTask);

        Runnable landingTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Landing task started in a separate thread");
                for (Plane plane : planes) {
                    if (plane.getPassengers().size() > 0) {
                        plane.land();
                    }
                }
            }
        };
        executorService.submit(landingTask);

        executorService.shutdown();
    }

    private static Passenger findPassenger(String passengerName) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(passengerName)) {
                return passenger;
            }
        }
        return null;
    }

    private static Plane findPlane(String flightNumber) {
        for (Plane plane : planes) {
            if (plane.getPlaneType().equalsIgnoreCase(flightNumber)) {
                return plane;
            }
        }
        return null;
    }
}
