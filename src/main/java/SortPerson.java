import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortPerson {
    public static List<Person> sort(List<Person> persons, Map<String, String> criteria){
        for (String criterion: criteria.keySet()) {
            if(criteria.get(criterion).equals("asc")) {
                switch (criterion) {
                    case "name":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getName))
                                .collect(Collectors.toList());
                        break;
                    case "surname":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getSurname))
                                .collect(Collectors.toList());
                        break;
                    case "date":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getDate))
                                .collect(Collectors.toList());
                        break;
                    case "gender":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getGender))
                                .collect(Collectors.toList());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + criterion);
                }
            } else if (criteria.get(criterion).equals("des")) {
                switch (criterion) {
                    case "name":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getName).reversed())
                                .collect(Collectors.toList());
                        break;
                    case "surname":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getSurname).reversed())
                                .collect(Collectors.toList());
                        break;
                    case "date":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getDate).reversed())
                                .collect(Collectors.toList());
                        break;
                    case "gender":
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getGender).reversed())
                                .collect(Collectors.toList());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + criterion);
                }
            }
        }
        return persons;
    }
}
