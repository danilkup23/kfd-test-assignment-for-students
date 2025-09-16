package biti.danilkup23.model;

public class Faculty extends User {
    public Faculty(int id, String type, String firstName, String lastName, String email) {
        super(id, type, firstName, lastName, email);
    }

    @Override
    public int getMaxBooks() {
        return 10;
    }

    @Override
    public int getMaxDays() {
        return 30;
    }
}
