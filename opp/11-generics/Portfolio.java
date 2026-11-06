import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private final List<Property> properties = new ArrayList<>();

    public boolean add(Property property) {
        if (property == null) {
            throw new IllegalArgumentException(
                "Property must not be null"
            );
        }

        if (properties.contains(property)) {
            return false;
        }

        properties.add(property);
        return true;
    }

    public boolean remove(String reference) {
        Property property = findByReference(reference);

        if (property == null) {
            return false;
        }

        return properties.remove(property);
    }

    public Property findByReference(String reference) {
        for (Property property : properties) {
            if (property.getReference().equals(reference)) {
                return property;
            }
        }

        return null;
    }

    public int size() {
        return properties.size();
    }

    public List<Property> getProperties() {
        return new ArrayList<>(properties);
    }

    public List<Property> getVacant() {
        List<Property> vacant = new ArrayList<>();

        for (Property property : properties) {
            if (!property.isRented()) {
                vacant.add(property);
            }
        }

        return vacant;
    }

    public List<Property> findByCity(String city) {
        List<Property> matches = new ArrayList<>();

        for (Property property : properties) {
            if (property.getAddress().city().equalsIgnoreCase(city)) {
                matches.add(property);
            }
        }

        return matches;
    }

    public int getTotalMonthlyRent() {
        int total = 0;

        for (Property property : properties) {
            total += property.getMonthlyRent();
        }

        return total;
    }

    public int getMonthlyIncome() {
        int total = 0;

        for (Property property : properties) {
            if (property.isRented()) {
                total += property.getMonthlyRent();
            }
        }

        return total;
    }

    public int getOccupancyRate() {
        if (properties.isEmpty()) {
            return 0;
        }

        int rentedCount = 0;

        for (Property property : properties) {
            if (property.isRented()) {
                rentedCount++;
            }
        }

        return (int) ((long) rentedCount * 100 / properties.size());
    }
}