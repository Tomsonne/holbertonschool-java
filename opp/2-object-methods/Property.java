public class Property {
    private final String reference;
    private String address;
    private int surface;
    private int monthlyRent;

    public Property(String reference, String address, int surface, int monthlyRent) {
        this.reference = validateReference(reference);
        this.address = validateAddress(address);
        this.surface = validateSurface(surface);
        this.monthlyRent = validateMonthlyRent(monthlyRent);
    }

    public String getReference() {
        return reference;
    }
    
    private static String validateReference(String reference) {
        if (reference == null || !reference.matches("P-[0-9]{3}")) {
            throw new IllegalArgumentException(
                "Invalid reference: " + reference
            );
        }
    
        return reference;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address){
        this.address = validateAddress(Address);
    }

    private static String validateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException(
                "Address must not be blank"
            );
        }

        return address;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface){
            this.surface = validateSurface(surface);
    }

    private static int validateSurface(int surface) {
        if (surface <= 0) {
            throw new IllegalArgumentException(
                "Surface must be positive: " + surface
            );
        }
    
        return surface;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    private static int validateMonthlyRent(int monthlyRent){
        if (monthlyRent<0){
            throw new IllegalArgumentException(
                "Rent must not be negative: " + monthlyRent 
            );
        }
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent){
        this.monthlyRent = validateMonthlyRent(monthlyRent);
    }
    public int getAnnualRent() {
        return monthlyRent * 12;
    }

    @Override
    public String toString() {
        return reference + " | " + surface + " m2 | " + monthlyRent + " EUR/month | " + address;
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
        return this.reference.equals(other.reference);
    }

    @Override
    public int hashCode() {
        return reference.hashCode();
    }
}