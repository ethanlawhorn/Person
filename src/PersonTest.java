import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.*;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() {
        person = new Person("1", "John", "Doe", "Mr.", 1980);
    }

    @Test
    public void testConstructor() {
        assertEquals("1", person.getID());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("Mr.", person.getTitle());
        assertEquals(1980, person.getYOB());
    }

    @Test
    public void testFullName() {
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    public void testGetAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(currentYear - 1980, person.getAge(1980));
    }

    @Test
    public void testToCSVDataRecord() {
        assertEquals("1, Doe, John, Mr., 1980", person.toCSVDataRecord());
    }
}