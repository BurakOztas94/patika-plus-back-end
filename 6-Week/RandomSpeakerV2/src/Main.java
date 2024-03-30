import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.readDataFromFile("original.txt");
        dataManager.sortData();
        Talker talker = new Talker(dataManager);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Person randomPerson = talker.selectRandomPersonToTalk();

            if (randomPerson == null) {
                System.out.println("All people have talked.");
                break;
            }

            System.out.println("Talking to: " + randomPerson);
            System.out.print("Did this person talk? (1 = Yes, 2 = No): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                dataManager.movePersonToTalked(randomPerson);
            }
        }

        // Save the state when exiting the program
        dataManager.saveState();
    }
}
