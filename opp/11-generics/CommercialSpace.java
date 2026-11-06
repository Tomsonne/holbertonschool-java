public class CommercialSpace extends Property {
    private static final int COMMON_CHARGES_MULTIPLIER = 2;
    private static final int INSURED_VALUE_PER_SQUARE_METER = 2000;
    private static final int INSURANCE_PREMIUM_MULTIPLIER = 2;

    private String activity;

    public CommercialSpace(String reference, Address address,
                           int surface, int monthlyRent,
                           EnergyClass energyClass, String activity) {
        super(reference, address, surface, monthlyRent, energyClass);

        if (activity == null || activity.isBlank()) {
            throw new IllegalArgumentException(
                "Activity must not be blank"
            );
        }

        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public String getType() {
        return "Commercial space";
    }

    @Override
    public int getMonthlyCharges() {
        return getCommonCharges() * COMMON_CHARGES_MULTIPLIER;
    }

    @Override
    public String toString() {
        return super.toString() + " | activity: " + activity;
    }

    @Override
    public int getInsuredValue() {
        return getSurface() * INSURED_VALUE_PER_SQUARE_METER;
    }

    @Override
    public int getYearlyInsurancePremium() {
        return super.getYearlyInsurancePremium()
            * INSURANCE_PREMIUM_MULTIPLIER;
    }
}