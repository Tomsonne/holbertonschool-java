public abstract class Property implements Insurable, Comparable<Property> {
    private final String reference;
    private Address address;
    private int surface;
    private int monthlyRent;
    private EnergyClass energyClass;
    private static final int CHARGES_PER_SQUARE_METER = 2;
    private Owner owner;
    private Tenant tenant;

    protected Property(String reference, Address address,
                    int surface, int monthlyRent, EnergyClass energyClass) {
        this.reference = validateReference(reference);
        this.address = validateAddress(address);
        this.surface = validateSurface(surface);
        this.monthlyRent = validateMonthlyRent(monthlyRent);
        this.energyClass = validateEnergyClass(energyClass);
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

    public EnergyClass getEnergyClass() {
        return energyClass;
    }

    public void setEnergyClass(EnergyClass energyClass) {
        this.energyClass = validateEnergyClass(energyClass);
    }

    public boolean isRentable() {
        return energyClass.isRentable();
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

    private static EnergyClass validateEnergyClass(EnergyClass energyClass) {
        if (energyClass == null) {
            throw new IllegalArgumentException(
                "Energy class must not be null"
            );
        }

        return energyClass;
    }

    @Override
    public String toString() {
        return getType() + " " + reference + " | " + surface + " m2 | "
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

    public abstract String getType();

    public abstract int getMonthlyCharges();

    protected int getCommonCharges() {
        return surface * CHARGES_PER_SQUARE_METER;
    }

    public final int getMonthlyCost() {
        return monthlyRent + getMonthlyCharges();
    }

    @Override
    public int compareTo(Property other) {
        return reference.compareTo(other.reference);
    }

    public Owner getOwner() {
    return owner;
    }

    public void setOwner(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException(
                "Owner must not be null"
            );
        }

        this.owner = owner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public boolean isRented() {
        return tenant != null;
    }

    public void rentTo(Tenant tenant) {
        if (tenant == null) {
            throw new IllegalArgumentException(
                "Tenant must not be null"
            );
        }

        if (isRented()) {
            throw new IllegalStateException(
                reference + " is already rented"
            );
        }

        if (!isRentable()) {
            throw new IllegalStateException(
                reference + " cannot be rented: energy class G"
            );
    }

    this.tenant = tenant;
    }

    public void release() {
        if (!isRented()) {
            throw new IllegalStateException(
                reference + " is not rented"
            );
        }

        this.tenant = null;
    }
}