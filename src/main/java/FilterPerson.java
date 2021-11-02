import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterPerson {

    public static List<Person> filter(List<Person> persons, Map<String, String> criteria){
        for (String criterion: criteria.keySet()){
            switch (criterion) {
                case "name":
                    persons = persons.stream()
                            .filter(person -> person.getName().equals(criteria.get(criterion)))
                            .collect(Collectors.toList());
                    break;
                case "surname":
                    persons = persons.stream()
                            .filter(person -> person.getSurname().equals(criteria.get(criterion)))
                            .collect(Collectors.toList());
                    break;
                case "date":
                    persons = persons.stream()
                            .filter(person -> person.getDate().equals(LocalDate.parse(criteria.get(criterion))))
                            .collect(Collectors.toList());
                    break;
                case "gender":
                    persons = persons.stream()
                            .filter(person -> person.getGender().equals(Gender.valueOf(criteria.get(criterion))))
                            .collect(Collectors.toList());
                    break;
            }
        }
        return persons;
    }

}
