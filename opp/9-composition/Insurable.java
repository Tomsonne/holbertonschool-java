public interface Insurable {
    int MIN_PREMIUM = 150;
    int PREMIUM_RATE = 3;
    int PREMIUM_VALUE_UNIT = 1000;

    int getInsuredValue();

    default int getYearlyInsurancePremium() {
        int premium = getInsuredValue() * PREMIUM_RATE / PREMIUM_VALUE_UNIT;
        return Math.max(MIN_PREMIUM, premium);
    }
}