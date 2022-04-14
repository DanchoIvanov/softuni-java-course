package strategy_pattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int compared = Integer.compare(person1.getName().length(), person2.getName().length());
        if (compared ==0){
            char firstLetterOfPerson1 = person1.getName().toLowerCase().charAt(0);
            char firstLetterOfPerson2 = person2.getName().toLowerCase().charAt(0);
            compared = Integer.compare(firstLetterOfPerson1, firstLetterOfPerson2);
        }
        return compared;
    }
}
