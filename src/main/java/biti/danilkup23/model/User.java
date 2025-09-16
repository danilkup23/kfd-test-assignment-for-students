package biti.danilkup23.model;

abstract public class User {
    private int id;
    private String type;
    private String firstName;
    private String lastName;
    private String email;

    public User(int id, String type, String firstName, String lastName, String email) {
        this.id = id;
        setType(type);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() { return email; }

    // TODO: add check type
    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("The type cannot be empty!");
        }
        this.type = type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // TODO: add regular expressions for email
    public void setEmail(String email) {
        this.email = email;
    }

    abstract public int getMaxBooks();

    abstract public int getMaxDays();
}
