public class PropertyDemo {
    public static void main(String[] args) {
        Property firstProperty = new Property(
            "P-001",
            new Address("12 Rue de la Paix", "75002", "Paris"),
            25,
            950,
            EnergyClass.C
        );

        Property secondProperty = new Property(
            "P-002",
            new Address("8 Chemin des Vignes", "33000", "Bordeaux"),
            120,
            1800,
            EnergyClass.D
        );

        System.out.println(
            firstProperty.getReference()
            + ": " + firstProperty.getSurface()
            + " m2, " + firstProperty.getMonthlyRent()
            + " EUR/month, " + firstProperty.getAnnualRent()
            + " EUR/year"
        );

        System.out.println(
            secondProperty.getReference()
            + ": " + secondProperty.getSurface()
            + " m2, " + secondProperty.getMonthlyRent()
            + " EUR/month, " + secondProperty.getAnnualRent()
            + " EUR/year"
        );
    }
}