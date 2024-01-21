import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        ArrayList<Person> people = new ArrayList<>();

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try (Scanner in = new Scanner(selectedFile)) {
                while (in.hasNextLine()) {
                    String[] data = in.nextLine().split(",");
                    people.add(new Person(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), Integer.parseInt(data[4].trim())));
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
                return;
            }
        }

        printPeople(people);
    }

    private static void printPeople(ArrayList<Person> people) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "ID", "First Name", "Last Name", "Title", "YOB");
        System.out.println("======================================================================");
        for (Person person : people) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15d\n", person.getID(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYOB());
        }
    }
}