import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        while (SafeInput.getYNConfirm(in, "Create new Person?")) {
            System.out.println("First name: ");
            String firstName = in.nextLine();
            System.out.println("Last name: ");
            String lastName = in.nextLine();
            System.out.println("ID: ");
            String ID = in.nextLine();
            System.out.println("Title: ");
            String title = in.nextLine();
            System.out.println("Year of birth: ");
            int YOB = in.nextInt();
            in.nextLine();

            people.add(new Person(firstName, lastName, ID, title, YOB));
        }

        System.out.println("Enter output file name: ");
        String outputFileName = in.nextLine();

        String filePath = "C:\\Users\\Ethan\\IdeaProjects\\Person\\src\\" + outputFileName;

        try (PrintWriter out = new PrintWriter(filePath)) {
            for (Person person : people) {
                out.println(person.toCSVDataRecord());
            }
            System.out.println("File saved to: " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }
}