import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Insurance {

    private static Map<Person_ex2, Integer> persons = new HashMap<>();

    public static void regist(Person_ex2 person){

        if (persons.containsKey(person)) {
            System.out.println(person.getName() + " - Insurance number: " + persons.get(person) );
        } else {
            Random random = new Random();
            int insuranceNum = random.nextInt(999999 - 100000 + 1) + 100000;

            persons.put(person, insuranceNum);
            System.out.println(person.getName() + " - Insurance number: " + insuranceNum);
        }
    }
    
    
}
