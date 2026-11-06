public class Property {
    private final String reference;
    private Address address;
    private int surface;
    private int monthlyRent;

    public Property(String reference, Address address,
                    int surface, int monthlyRent) {
        this.reference = validateReference(reference);
        this.address = validateAddress(address);
        this.surface = validateSurface(surface);
        this.monthlyRent = validateMonthlyRent(monthlyRent);
    }

    public String getReference() {
        return reference;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = validateAddress(address);
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = validateSurface(surface);
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = validateMonthlyRent(monthlyRent);
    }

    public int getAnnualRent() {
        return monthlyRent * 12;
    }

    private static String validateReference(String reference) {
        if (reference == null || !reference.matches("P-[0-9]{3}")) {
            throw new IllegalArgumentException(
                "Invalid reference: " + reference
            );
        }

        return reference;
    }

    private static Address validateAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException(
                "Address must not be null"
            );
        }

        return address;
    }

    private static int validateSurface(int surface) {
        if (surface <= 0) {
            throw new IllegalArgumentException(
                "Surface must be positive: " + surface
            );
        }

        return surface;
    }

    private static int validateMonthlyRent(int monthlyRent) {
        if (monthlyRent < 0) {
            throw new IllegalArgumentException(
                "Rent must not be negative: " + monthlyRent
            );
        }

        return monthlyRent;
    }

    @Override
    public String toString() {
        return reference + " | " + surface + " m2 | "
            + monthlyRent + " EUR/month | " + address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Property)) {
            return false;
        }

        Property other = (Property) o;
        return reference.equals(other.reference);
    }

    @Override
    public int hashCode() {
        return reference.hashCode();
    }
}