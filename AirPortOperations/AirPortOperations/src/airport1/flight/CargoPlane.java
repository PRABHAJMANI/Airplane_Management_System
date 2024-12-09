package airport1.flight;

//import java.util.ArrayList;

public class CargoPlane extends Plane {
    private double maxCargoWeight;
    private Cargo[] cargos;

    public CargoPlane(String planeType, String planeVersion, double maxCargoWeight) {
        super(planeType, planeVersion, 0);
        this.maxCargoWeight = maxCargoWeight;
        this.cargos = new Cargo[getCapacity()];
    }
    
    public CargoPlane(String planeType, String planeVersion) {
        super(planeType, planeVersion, 0);
        this.maxCargoWeight = planeVersion.equalsIgnoreCase("Premium") ? 150.0 : 200.0;
        this.cargos = new Cargo[getCapacity()];
    }

    public double getMaxCargoWeight() {
        return maxCargoWeight;
    }

    @Override
    public void displayPlaneDetails() {
        System.out.println("Plane Type: " + getPlaneType());
        System.out.println("Plane Version: " + getPlaneVersion());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Maximum Cargo Weight: " + maxCargoWeight + " kgs");
    }

    @Override
    public void addPassenger(Passenger passenger) {
        System.out.println("This is a cargo plane. Cannot add passengers.");
    }

    @Override
    public void removePassenger(Passenger passenger) {
        System.out.println("This is a cargo plane. No passengers to remove.");
    }

    @Override
    public void loadCargo(Cargo cargo) {
        double totalCargoWeight = getTotalCargoWeight() + cargo.getWeight();
        if (totalCargoWeight <= maxCargoWeight) {
            super.loadCargo(cargo);
        } else {
            System.out.println("Cannot load cargo. Maximum cargo weight exceeded.");
        }
    }

    private double getTotalCargoWeight() {
        double totalWeight = 0;
        for (Cargo cargo : getCargo()) {
            if (cargo != null) {
                totalWeight += cargo.getWeight();
            }
        }
        return totalWeight;
    }

    private Cargo[] getCargo() {
        return cargos;
    }
}
