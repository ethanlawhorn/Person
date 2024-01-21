import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductReader {
    public static ArrayList<Product> readProductsFromFile() {
        ArrayList<Product> products = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");
                    if (data.length < 4) {
                        System.out.println("Skipping incomplete line: " + line);
                        continue;
                    }
                    Product product = new Product(data[0].trim(), data[1].trim(), data[2].trim(), Double.parseDouble(data[3].trim()));
                    products.add(product);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    private static void printProducts(ArrayList<Product> products) {
        System.out.printf("%-15s%-30s%-15s%-15s\n", "Name", "Description", "ID", "Cost");
        System.out.println("=================================================================================================");
        for (Product product : products) {
            System.out.printf("%-15s%-30s%-15s%-15.2f\n", product.getName(), product.getDescription(), product.getID(), product.getCost());
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> products = readProductsFromFile();
        printProducts(products);
    }
}