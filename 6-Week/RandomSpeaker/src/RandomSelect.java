import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class RandomSelect {
    private HashMap<Integer, String> data;
    private HashMap<Integer, String> talked = new HashMap<>();
    private Random random = new Random();

    public RandomSelect(HashMap<Integer, String> data) {
        this.data = data;
    }

    public String getRandomPerson() {
        if (data.isEmpty()) {
            return "No data available.";
        }

        String randomPerson;
        int randomIndex;

        do {
            randomIndex = random.nextInt(data.size()) + 1; // Add 1 to match the key values
            randomPerson = data.get(randomIndex);

            if (randomPerson != null && !isTalked(randomPerson)) {
                break; // Found an "untalked" person that is not null
            }
        } while (true);

        return randomPerson;
    }


    public void processRandomSelection() {
        Scanner scanner = new Scanner(System.in);

        if ( data.isEmpty () ) {
            System.out.println("There are no untalked people left. Everyone has been talked to.");
        }else{



            while (!data.isEmpty()) {
                CreatedList.printUnTalkedMap (talked);
                System.out.print("Randomly selected person: ");
                String randomPerson = getRandomPerson();
                System.out.println(randomPerson);

                if (data.size() == 1) {
                    // Only one person left, so they must be talked to
                    System.out.print("Selected person : ");
                    moveToTalked(randomPerson);
                    if(data.isEmpty ()){
                        System.out.println ("Everyone Talked ");
                        break;
                    }
                }

                System.out.print("Enter 1 to continue and , 2 to skip:");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    moveToTalked(randomPerson);
                }

            }
        }


        scanner.close();
    }

    private boolean isTalked(String person) {
        return talked.containsValue(person);
    }

    private void moveToTalked(String person) {
        Integer key = getKeyByValue(data, person);
        if (key != null) {
            talked.put(key, person);
        }
        data.remove(key);
    }

    public void saveTalkedToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<Integer, String> entry : talked.entrySet()) {
                writer.write(entry.getKey() + " \"" + entry.getValue() + "\"");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    private Integer getKeyByValue(HashMap<Integer, String> map, String value) {
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(value)) {
                return key;
            }
        }
        return null;
    }
}
