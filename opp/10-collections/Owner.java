public class Owner {
    private final Contact contact;

    public Owner(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException(
                "Contact must not be null"
            );
        }

        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public String getName() {
        return contact.name();
    }

    public String getEmail() {
        return contact.email();
    }
}