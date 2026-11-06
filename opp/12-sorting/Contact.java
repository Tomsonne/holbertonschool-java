public record Contact(String name, String email) {

    public Contact {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Name must not be blank"
            );
        }

        if (email == null
                || email.indexOf('@') <= 0
                || email.indexOf('@') != email.lastIndexOf('@')
                || email.endsWith("@")) {
            throw new IllegalArgumentException(
                "Invalid email: " + email
            );
        }
    }

    @Override
    public String toString() {
        return name + " <" + email + ">";
    }
}