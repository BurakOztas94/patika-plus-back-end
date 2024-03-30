import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class CreatedList{


    public static HashMap<Integer, String> createList(String filename) {
        HashMap<Integer, String> unTalked = new HashMap<>();
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            Integer key = null;

            while ((line = bufferedReader.readLine()) != null) {
                if (key == null) {
                    // Odd lines are integers
                    key = Integer.parseInt(line);
                } else {
                    // Even lines are strings
                    unTalked.put(key, line);
                    key = null;
                }
            }
            reader.close ();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return unTalked;
    }

    public static void printUnTalkedMap(HashMap<Integer, String> map) {
        System.out.println("UnTalked Map:");
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
