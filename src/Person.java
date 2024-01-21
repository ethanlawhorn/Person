import java.util.Calendar;

public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }


    public String fullName() { return this.firstName + " " + this.lastName; }

    public String formalName() { return this.title + " " + fullName(); }

    public static int getAge(int year) {
        int date = Calendar.getInstance().get(Calendar.YEAR);
        return date - year;
    }

    public String toCSVDataRecord() { return this.ID + ", " + this.lastName + ", " + this.firstName + ", " + this.title + ", " + this.YOB; }
}