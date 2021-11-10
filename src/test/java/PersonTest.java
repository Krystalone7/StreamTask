
import org.example.streamtask.classes.Field;
import org.example.streamtask.classes.Gender;
import org.example.streamtask.classes.Person;
import org.example.streamtask.functions.FilterPerson;
import org.example.streamtask.functions.Pagination;
import org.example.streamtask.functions.SortPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private List<Person> persons ;

    @BeforeEach
    public void setUp(){
        persons = new ArrayList<>();
        persons.add(new Person("Petr", "Ivanov", LocalDate.of(2002, 11, 20), Gender.MALE));
        persons.add(new Person("Artem", "Brown", LocalDate.of(2012, 1, 25), Gender.MALE));
        persons.add(new Person("Artem", "Ivanov", LocalDate.of(2002, 11, 7), Gender.MALE));
        persons.add(new Person("Nikita", "Sidorov", LocalDate.of(2002, 8, 5), Gender.MALE));
        persons.add(new Person("Elisey", "Kuznetzov", LocalDate.of(2002, 3, 8), Gender.MALE));
        persons.add(new Person("Jenya", "Alekseev", LocalDate.of(2002, 12, 12), Gender.MALE));
        persons.add(new Person("Jenya", "Alekseev", LocalDate.of(2013, 4, 5), Gender.MALE));
        persons.add(new Person("Slava", "Lomakin", LocalDate.of(2002, 11, 15), Gender.MALE));
        persons.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        persons.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        persons.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
    }

    @Test
    public void filterByNameArtem(){
        Map<Field, Predicate<Person>> criteria = new HashMap<>();
        criteria.put(Field.NAME, (o1) -> Objects.equals(o1.getName(), "Artem"));
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Artem", "Brown", LocalDate.of(2012, 1, 25), Gender.MALE));
        expected.add(new Person("Artem", "Ivanov", LocalDate.of(2002, 11, 7), Gender.MALE));
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterBySurnameIvanov(){
        Map<Field, Predicate<Person>> criteria = new HashMap<>();
        criteria.put(Field.SURNAME, (o1) -> o1.getSurname().equals("Ivanov"));
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Petr", "Ivanov", LocalDate.of(2002, 11, 20), Gender.MALE));
        expected.add(new Person("Artem", "Ivanov", LocalDate.of(2002, 11, 7), Gender.MALE));
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterByNameJenyaAndSurnameAlekseev(){
        Map<Field, Predicate<Person>> criteria = new HashMap<>();
        criteria.put(Field.SURNAME, (o1) -> o1.getSurname().equals("Alekseev"));
        criteria.put(Field.NAME, (o1) -> o1.getName().equals("Jenya"));
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Jenya", "Alekseev", LocalDate.of(2002, 12, 12), Gender.MALE));
        expected.add(new Person("Jenya", "Alekseev", LocalDate.of(2013, 4, 5), Gender.MALE));
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterByGenderFEMALE(){
        Map<Field, Predicate<Person>> criteria = new HashMap<>();
        criteria.put(Field.GENDER, (o1) -> o1.getGender().equals(Gender.FEMALE));
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        expected.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        expected.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterFEMALESortNameAscending(){
        Map<Field, Predicate<Person>> criteriaFilter = new HashMap<>();
        criteriaFilter.put(Field.GENDER, (o1) -> o1.getGender().equals(Gender.FEMALE));
        List<Person> filteredPersons = FilterPerson.filter(persons, criteriaFilter);

        Map<Field, Comparator<Person>> criteriaSort = new HashMap<>();
        //Ascending
        criteriaSort.put(Field.NAME, (Comparator.comparing(Person::getName)));

        List<Person> sortedPersons = SortPerson.sort(filteredPersons, criteriaSort);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        expected.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
        expected.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        assertIterableEquals(expected, sortedPersons);
    }

    @Test
    public void sortBySurnamesDescending(){
        Map<Field, Comparator<Person>> criteriaSort = new HashMap<>();
        criteriaSort.put(Field.SURNAME, (Comparator.comparing(Person::getSurname).reversed()));
        List<Person> sortedPersons = SortPerson.sort(persons, criteriaSort);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        expected.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
        expected.add(new Person("Nikita", "Sidorov", LocalDate.of(2002, 8, 5), Gender.MALE));
        expected.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        expected.add(new Person("Slava", "Lomakin", LocalDate.of(2002, 11, 15), Gender.MALE));
        expected.add(new Person("Elisey", "Kuznetzov", LocalDate.of(2002, 3, 8), Gender.MALE));
        expected.add(new Person("Petr", "Ivanov", LocalDate.of(2002, 11, 20), Gender.MALE));
        expected.add(new Person("Artem", "Ivanov", LocalDate.of(2002, 11, 7), Gender.MALE));
        expected.add(new Person("Artem", "Brown", LocalDate.of(2012, 1, 25), Gender.MALE));
        expected.add(new Person("Jenya", "Alekseev", LocalDate.of(2002, 12, 12), Gender.MALE));
        expected.add(new Person("Jenya", "Alekseev", LocalDate.of(2013, 4, 5), Gender.MALE));
        assertIterableEquals(expected, sortedPersons);
    }

    @Test
    public void paginate3Count3Page(){
        int countOnPage = 3;
        int page = 3;
        List<Person> paginated = Pagination.paginate(persons, countOnPage, page);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Jenya", "Alekseev", LocalDate.of(2013, 4, 5), Gender.MALE));
        expected.add(new Person("Slava", "Lomakin", LocalDate.of(2002, 11, 15), Gender.MALE));
        expected.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        System.out.println(paginated);

        // Такой момент - ты и после фильтрации, и после сортировки сравниваешь коллекции методом assertIterableEquals,
        // а по идее, в случае с фильтрацией нам важно, чтобы набор элементов был ожидаемым, а в случае с сортировкой -
        // чтобы элементы в коллекциях были в нужном порядке.
        // Нужно разобраться, как сравнивать коллекции поэлементно с учетом порядка и без.
        // Мы обычно используем org.assertj.core.api.AbstractIterableAssert#containsExactlyInAnyOrderElementsOf для сравнения
        // коллекций без учета их порядка, посмотри также еще и метод сравнения, который учитывает порядок элементов
        assertIterableEquals(expected, paginated);

    }

}