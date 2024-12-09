package airport1.flight;

public class Passenger {
    private String name;
    private String mealPreference;
    private String destination;
    private String arrivalPlace;

    public Passenger(String name, String mealPreference, String destination, String arrivalPlace) {
        this.name = name;
        this.mealPreference = mealPreference;
        this.destination = destination;
        this.arrivalPlace = arrivalPlace;
    }

    public String getName() {
        return name;
    }

    public String getMealPreference() {
        return mealPreference;
    }

    public String getDestination() {
        return destination;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

}