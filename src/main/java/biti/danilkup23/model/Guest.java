package biti.danilkup23.model;

public class Guest extends User {
    public Guest(int id, String type, String firstName, String lastName, String email) {
        super(id, type, firstName, lastName, email);
    }

    @Override
    public int getMaxBooks() {
        return 1;
    }

    @Override
    public int getMaxDays() {
        return 7;
    }
}
