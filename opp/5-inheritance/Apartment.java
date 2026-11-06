public class Apartment extends Property {
    private int floor;
    private boolean hasElevator;

    public Apartment(String reference, Address address,
                     int surface, int monthlyRent,
                     EnergyClass energyClass, int floor,
                     boolean hasElevator) {
        super(reference, address, surface, monthlyRent, energyClass);

        if (floor < 0) {
            throw new IllegalArgumentException(
                "Floor must not be negative: " + floor
            );
        }

        this.floor = floor;
        this.hasElevator = hasElevator;
    }

    public int getFloor() {
        return floor;
    }

    public boolean hasElevator() {
        return hasElevator;
    }
}