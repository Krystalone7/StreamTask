import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Petr", "Ivanov", LocalDate.of(2002, 11, 20), Gender.MALE));
        persons.add(new Person("Artem", "Brown", LocalDate.of(2012, 1, 25), Gender.MALE));
        persons.add(new Person("Artem", "Ivanov", LocalDate.of(2002, 11, 7), Gender.MALE));
        persons.add(new Person("Nikita", "Sidorov", LocalDate.of(2002, 8, 5), Gender.MALE));
        persons.add(new Person("Elisey", "Kuznetzov", LocalDate.of(2002, 3, 8), Gender.MALE));
        persons.add(new Person("Jenya", "Alekseev", LocalDate.of(2002, 12, 12), Gender.MALE));
        persons.add(new Person("Slava", "Lomakin", LocalDate.of(2002, 11, 15), Gender.MALE));
        persons.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        persons.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        persons.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
        for (Person person: persons){
            System.out.println(person);
        }
    }
}
