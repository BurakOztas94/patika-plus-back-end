import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataManager {
    private List<Person> untalked;
    private List<Person> talked;

    public DataManager() {
        untalked = new ArrayList<>();
        talked = new ArrayList<>();
    }

    public void readDataFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                untalked.add(new Person(line, 0)); // ID is set to 0, as there's no ID in this version.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortData() {
        Collections.sort(untalked, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void movePersonToTalked(Person person) {
        untalked.remove(person);
        talked.add(person);
    }

    public List<Person> getUntalked() {
        return untalked;
    }

    public List<Person> getTalked() {
        return talked;
    }
}
