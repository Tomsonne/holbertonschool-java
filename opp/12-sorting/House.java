public class House extends Property {
    private int landSurface;
    private static final int LAND_AREA_PER_EURO = 20;
    private static final int INSURED_VALUE_PER_SQUARE_METER = 2500;
    private static final int INSURED_VALUE_PER_LAND_SQUARE_METER = 50;

    public House(String reference, Address address,
                 int surface, int monthlyRent,
                 EnergyClass energyClass, int landSurface) {
        super(reference, address, surface, monthlyRent, energyClass);

        if (landSurface < 0) {
            throw new IllegalArgumentException(
                "Land surface must not be negative: " + landSurface
            );
        }

        this.landSurface = landSurface;
    }

    public int getLandSurface() {
        return landSurface;
    }

    @Override
    public String getType() {
        return "House";
    }

    @Override
    public int getMonthlyCharges() {
        return getCommonCharges()
            + landSurface / LAND_AREA_PER_EURO;
    }

    @Override
    public String toString() {
        return super.toString()
            + " | land " + landSurface + " m2";
    }

    @Override
    public int getInsuredValue() {
        return getSurface() * INSURED_VALUE_PER_SQUARE_METER
            + landSurface * INSURED_VALUE_PER_LAND_SQUARE_METER;
    }
}