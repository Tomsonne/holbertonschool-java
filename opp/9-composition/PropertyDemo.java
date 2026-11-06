public class PropertyDemo {
    public static void main(String[] args) {
        Property firstProperty = new Apartment(
            "P-001",
            new Address("12 Rue de la Paix", "75002", "Paris"),
            25,
            950,
            EnergyClass.C,
            3,
            true
        );

        Property secondProperty = new House(
            "P-002",
            new Address("8 Chemin des Vignes", "33000", "Bordeaux"),
            120,
            1800,
            EnergyClass.D,
            400
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