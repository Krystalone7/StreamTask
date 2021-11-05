package functions;

import classes.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortPerson {
    public static List<Person> sort(List<Person> persons, Map<Field, SortFactor> criteria){
        for (Field criterion: criteria.keySet()) {
            if(criteria.get(criterion).equals(SortFactor.ASC)) {
                switch (criterion) {
                    case NAME:
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getName))
                                .collect(Collectors.toList());
                        break;
                    case SURNAME:
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getSurname))
                                .collect(Collectors.toList());
                        break;
                    case DATE:
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getDate))
                                .collect(Collectors.toList());
                        break;
                    case GENDER:
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getGender))
                                .collect(Collectors.toList());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + criterion);
                }
            } else if (criteria.get(criterion).equals(SortFactor.DES)) {
                switch (criterion) {
                    case NAME:
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getName).reversed())
                                .collect(Collectors.toList());
                        break;
                    case SURNAME:
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getSurname).reversed())
                                .collect(Collectors.toList());
                        break;
                    case DATE:
                        persons = persons.stream()
                                .sorted(Comparator.comparing(Person::getDate).reversed())
                                .collect(Collectors.toList());
                        break;
                    case GENDER:
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
