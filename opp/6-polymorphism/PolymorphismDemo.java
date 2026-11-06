public class PolymorphismDemo {
    public static void main(String[] args) {
        Property[] properties = {
            new Property(
                "P-001",
                new Address("5 Rue Victor Hugo", "69002", "Lyon"),
                40,
                800,
                EnergyClass.C
            ),
            new Apartment(
                "P-002",
                new Address("12 Rue de la Paix", "75002", "Paris"),
                25,
                950,
                EnergyClass.D,
                3,
                true
            ),
            new House(
                "P-003",
                new Address("8 Chemin des Vignes", "33000", "Bordeaux"),
                120,
                1800,
                EnergyClass.B,
                400
            )
        };

        int total = 0;

        for (Property property : properties) {
            int monthlyCost = property.getMonthlyCost();
            total += monthlyCost;

            System.out.println(
                property.getClass().getSimpleName()
                + " " + property.getReference()
                + ": " + monthlyCost + " EUR/month"
            );
        }

        System.out.println("Total: " + total + " EUR/month");
    }
}