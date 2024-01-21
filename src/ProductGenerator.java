import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        while (SafeInput.getYNConfirm(in, "Do you want to add a new product?")) {
            System.out.println("Product Name: ");
            String name = in.nextLine();

            System.out.println("Product Description: ");
            String description = in.nextLine();

            System.out.println("Product ID: ");
            String ID = in.nextLine();

            System.out.println("Product Cost: ");
            double cost = in.nextDouble();
            in.nextLine();

            products.add(new Product(name, description, ID, cost));
        }

        System.out.println("Enter the filename to save products data: ");
        String outputFileName = in.nextLine();

        String defaultDirectory = "C:\\Users\\Ethan\\IdeaProjects\\Person\\src\\";
        String filePath = defaultDirectory + outputFileName;

        try (PrintWriter out = new PrintWriter(filePath)) {
            for (Product product : products) {
                out.println(product.toCSVDataRecord());
            }
            System.out.println("Products data saved to: " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }
}