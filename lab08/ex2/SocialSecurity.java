import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SocialSecurity {

    private static Map<Person_ex2, Integer> persons = new HashMap<>();

    public static void regist(Person_ex2 person) {

        if (persons.containsKey(person)) {
            System.out.println(person.getName() + " - SS number: " + persons.get(person) );
        } else {
            Random random = new Random();
            int numberSS = random.nextInt(999999999 - 100000000 + 1) + 100000000;

            persons.put(person, numberSS);
            System.out.println(person.getName() + " - SS number: " + numberSS);
        }
    }


    
}
