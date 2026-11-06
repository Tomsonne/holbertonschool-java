public class Property {
    private String reference;
    private String address;
    private int surface;
    private int monthlyRent;

    public Property(String reference, String address, int surface, int monthlyRent) {
        this.reference = reference;
        this.address = address;
        this.surface = surface;
        this.monthlyRent = monthlyRent;
    }

    public String getReference() {
        return reference;
    }

    public String getAddress() {
        return address;
    }

    public int getSurface() {
        return surface;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public int getAnnualRent() {
        return monthlyRent * 12;
    }
}