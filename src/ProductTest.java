import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Product("Product", "Description", "12345", 10.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Product", product.getName());
        assertEquals("Description", product.getDescription());
        assertEquals("12345", product.getID());
        assertEquals(10.00, product.getCost(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        product.setName("NewName");
        assertEquals("NewName", product.getName());

        product.setDescription("NewDescription");
        assertEquals("NewDescription", product.getDescription());

        product.setID("54321");
        assertEquals("54321", product.getID());

        product.setCost(19.99);
        assertEquals(19.99, product.getCost(), 0.001);
    }

    @Test
    public void testToCSVDataRecord() {
        String expectedCSV = "Product,Description,12345,10.0";
        assertEquals(expectedCSV, product.toCSVDataRecord());
    }
}