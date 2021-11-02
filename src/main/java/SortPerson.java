import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortPerson {
    public static List<Person> sort(List<Person> persons, Map<String, String> criteria){
        for (String criterion: criteria.keySet()) {
            if (criteria.get(criterion).equals("asc")){
                switch (criterion) {
                    case "name":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getName).reversed())
                                .collect(Collectors.toList());
                    case "surname":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getSurname))
                                .collect(Collectors.toList());
                    case "date":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getDate))
                                .collect(Collectors.toList());
                    case "gender":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getGender))
                                .collect(Collectors.toList());
                }
            } else if (criteria.get(criterion).equals("des")){
                switch (criterion) {
                    case "name":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getName).reversed())
                                .collect(Collectors.toList());
                    case "surname":
                        persons = persons.stream()
                                .sorted((o1, o2) -> o2.getSurname().compareTo(o1.getSurname()))
                                .collect(Collectors.toList());
                    case "date":
                        persons = persons.stream()
                                .sorted((o1, o2) -> o2.getDate().compareTo(o1.getDate()))
                                .collect(Collectors.toList());
                    case "gender":
                        persons = persons.stream()
                                .sorted((o1, o2) -> o2.getGender().compareTo(o1.getGender()))
                                .collect(Collectors.toList());
                }
            }
        }
        return persons;
    }
}
