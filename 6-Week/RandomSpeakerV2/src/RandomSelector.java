import java.util.List;
import java.util.Random;

public class RandomSelector {
    public static Person selectRandomPerson(List<Person> people) {
        if (people.isEmpty()) {
            return null;
        }
        int randomIndex = new Random().nextInt(people.size());
        return people.get(randomIndex);
    }
}
