
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {



        HashMap<Integer, String> unTalked = CreatedList.createList("ogrencilistesi.txt");
        RandomSelect randomSelect = new RandomSelect(unTalked);

        System.out.println("UnTalked List:");
        CreatedList.printUnTalkedMap(unTalked);

        // Process random selections and move people to the "talked" list
        randomSelect.processRandomSelection();

        // Save the talked data to a file
        randomSelect.saveTalkedToFile("talked.txt");


    }}
