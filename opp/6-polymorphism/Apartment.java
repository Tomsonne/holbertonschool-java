public class Apartment extends Property {
    private int floor;
    private boolean hasElevator;
    private static final int ELEVATOR_CHARGE = 40; 

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

    @Override
    public int getMonthlyCharges() {
        return super.getMonthlyCharges()
            + (hasElevator ? ELEVATOR_CHARGE : 0);
    }

    @Override
    public String toString() {
        return "Apartment " + super.toString()
            + " | floor " + floor
            + ", " + (hasElevator ? "elevator" : "no elevator");
    }
}