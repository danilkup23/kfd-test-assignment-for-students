package biti.danilkup23.model;

public class Student extends User {
    public Student(int id, String type, String firstName, String lastName, String email) {
        super(id, type, firstName, lastName, email);
    }

    @Override
    public int getMaxBooks() {
        return 3;
    }

    @Override
    public int getMaxDays() {
        return 14;
    }
}
