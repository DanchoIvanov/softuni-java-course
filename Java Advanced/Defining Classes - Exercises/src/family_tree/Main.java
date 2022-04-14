package family_tree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String, Person> names = new HashMap<>();
        Map <String, Person> dates = new HashMap<>();
        String personOfInterestInfo = scanner.nextLine();
        getPerson(personOfInterestInfo, names, dates);

        String input = scanner.nextLine();
        while(!input.equals("End")){
            if (input.contains(" - ")){
                String parentInfo = input.split(" - ")[0];
                String childrenInfo = input.split(" - ")[1];
                Person parent = getPerson(parentInfo, names, dates);
                Person children = getPerson(childrenInfo, names, dates);
                parent.getChildren().add(children);
                children.getParents().add(parent);
            } else {
                String firstName = input.split("\\s+")[0];
                String lastName = input.split("\\s+")[1];
                String birthday = input.split("\\s+")[2];

                if (names.containsKey(firstName + " " + lastName) && dates.containsKey(birthday)){
                    names.get(firstName + " " + lastName).setDate(birthday);
                    Set<Person> parents1 = names.get(firstName + " " + lastName).getParents();
                    Set<Person> parents2 = dates.get(birthday).getParents();
                    Set<Person> children1 = names.get(firstName + " " + lastName).getChildren();
                    Set<Person> children2 = dates.get(birthday).getChildren();
                    Set<Person> mergedParents = new LinkedHashSet<>(parents1);
                    mergedParents.addAll(parents2);
                    mergedParents = mergedParents.stream().sorted(Comparator.comparingInt(Person::getPosition)).collect(Collectors.toCollection(LinkedHashSet::new));
                    Set<Person> mergedChildren = new LinkedHashSet<>(children1);
                    mergedChildren.addAll(children2);
                    mergedChildren = mergedChildren.stream().sorted(Comparator.comparingInt(Person::getPosition)).collect(Collectors.toCollection(LinkedHashSet::new));
                    names.get(firstName + " " + lastName).setParents(mergedParents);
                    names.get(firstName + " " + lastName).setChildren(mergedChildren);
                    dates.put(birthday, names.get(firstName + " " + lastName));

                } else if (names.containsKey(firstName + " " + lastName)){
                    names.get(firstName + " " + lastName).setDate(birthday);
                    dates.putIfAbsent(birthday, names.get(firstName + " " + lastName));
                } else if (dates.containsKey(birthday)){
                    dates.get(birthday).setFirstName(firstName);
                    dates.get(birthday).setLastName(lastName);
                    names.putIfAbsent(firstName + " " + lastName,dates.get(birthday));
                } else if (!names.containsKey(firstName + " " + lastName) && !dates.containsKey(birthday)){
                    names.put(firstName + " " + lastName, new Person(firstName, lastName, birthday));
                    dates.put(birthday, names.get(firstName + " " + lastName));
                }
            }
            input = scanner.nextLine();
        }

        Person personOfInterest = getPerson(personOfInterestInfo, names, dates);
        System.out.printf("%s %s %s%n",personOfInterest.getFirstName(), personOfInterest.getLastName(), personOfInterest.getDate());
        System.out.println("Parents:");
        personOfInterest.setParents(fixRelations(personOfInterest.getParents(), names, dates));
        personOfInterest.getParents().forEach(p -> System.out.printf("%s %s %s%n",p.getFirstName(), p.getLastName(), p.getDate()));
        System.out.println("Children:");
        personOfInterest.setChildren(fixRelations(personOfInterest.getChildren(), names, dates));
        personOfInterest.getChildren().forEach(p -> System.out.printf("%s %s %s%n",p.getFirstName(), p.getLastName(), p.getDate()));
    }

    private static Set<Person> fixRelations(Set<Person> people, Map<String, Person> names, Map<String, Person> dates) {
        Set<Person> fixedSet = new LinkedHashSet<>();
        for (Person person : people){
           if (person.getFirstName() == null){
                Person currentPerson = dates.get(person.getDate());
                fixedSet.add(currentPerson);
            } else if (person.getDate() == null){
                Person currentPerson = names.get(person.getFirstName() + " " + person.getLastName());
                fixedSet.add(currentPerson);
            } else {
               fixedSet.add(person);
           }
        }
        return fixedSet;
    }

    static public Person getPerson (String input, Map<String, Person> names, Map<String, Person> dates) {
        String[] personOfInterest = input.split("\\s+");
        if (personOfInterest.length == 2) {
            String firstName = personOfInterest[0];
            String lastName = personOfInterest[1];
            names.putIfAbsent(input, new Person(firstName, lastName));
            return names.get(input);
        } else {
            String birthday = personOfInterest[0];
            dates.putIfAbsent(birthday, new Person(birthday));
            return dates.get(birthday);
        }
    }
}
