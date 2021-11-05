
import classes.Field;
import classes.Gender;
import classes.Person;
import classes.SortFactor;
import functions.FilterPerson;
import functions.Pagination;
import functions.SortPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

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
        Map<Field, String> criteria = new HashMap<>();
        criteria.put(Field.NAME, "Artem");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Artem", "Brown", LocalDate.of(2012, 1, 25), Gender.MALE));
        expected.add(new Person("Artem", "Ivanov", LocalDate.of(2002, 11, 7), Gender.MALE));
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterBySurnameIvanov(){
        Map<Field, String> criteria = new HashMap<>();
        criteria.put(Field.SURNAME, "Ivanov");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Petr", "Ivanov", LocalDate.of(2002, 11, 20), Gender.MALE));
        expected.add(new Person("Artem", "Ivanov", LocalDate.of(2002, 11, 7), Gender.MALE));
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterByNameJenyaAndSurnameAlekseev(){
        Map<Field, String> criteria = new HashMap<>();
        criteria.put(Field.SURNAME, "Alekseev");
        criteria.put(Field.NAME, "Jenya");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Jenya", "Alekseev", LocalDate.of(2002, 12, 12), Gender.MALE));
        expected.add(new Person("Jenya", "Alekseev", LocalDate.of(2013, 4, 5), Gender.MALE));
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterByGenderFEMALE(){
        Map<Field, String> criteria = new HashMap<>();
        criteria.put(Field.GENDER, "FEMALE");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        expected.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        expected.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterFEMALESortNameAscending(){
        Map<Field, String> criteriaFilter = new HashMap<>();
        criteriaFilter.put(Field.GENDER, "FEMALE");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteriaFilter);
        Map<Field, SortFactor> criteriaSort = new HashMap<>();
        criteriaSort.put(Field.NAME, SortFactor.ASC);
        List<Person> sortedPersons = SortPerson.sort(filteredPersons, criteriaSort);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        expected.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
        expected.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        assertIterableEquals(expected, sortedPersons);
    }

    @Test
    public void sortBySurnamesDescending(){
        Map<Field, SortFactor> criteriaSort = new HashMap<>();
        criteriaSort.put(Field.SURNAME, SortFactor.DES);
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
        assertIterableEquals(expected, paginated);
    }

}