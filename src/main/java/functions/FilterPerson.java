package functions;

import classes.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FilterPerson {
    public static List<Person> filter(List<Person> persons, Map<Field, String> criteria){
        for (Field criterion: criteria.keySet()){
            switch (criterion) {
                case NAME:
                    persons = persons.stream()
                            .filter(person -> person.getName().equals(criteria.get(criterion)))
                            .collect(Collectors.toList());
                    break;
                case SURNAME:
                    persons = persons.stream()
                            .filter(person -> person.getSurname().equals(criteria.get(criterion)))
                            .collect(Collectors.toList());
                    break;
                case DATE:
                    persons = persons.stream()
                            .filter(person -> person.getDate().equals(LocalDate.parse(criteria.get(criterion))))
                            .collect(Collectors.toList());
                    break;
                case GENDER:
                    persons = persons.stream()
                            .filter(person -> person.getGender().equals(Gender.valueOf(criteria.get(criterion))))
                            .collect(Collectors.toList());
                    break;
            }
        }
        return persons;
    }
}
