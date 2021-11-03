import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
        persons.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        persons.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        List<Person> sorted = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
        System.out.println(sorted);
    }
}
