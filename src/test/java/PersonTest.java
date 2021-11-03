
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
        Map<String, String> criteria = new HashMap<>();
        criteria.put("name", "Artem");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Artem", "Brown", LocalDate.of(2012, 1, 25), Gender.MALE));
        expected.add(new Person("Artem", "Ivanov", LocalDate.of(2002, 11, 7), Gender.MALE));
        //System.out.println(expected);
        //System.out.println(filteredPersons);
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterBySurnameIvanov(){
        Map<String, String> criteria = new HashMap<>();
        criteria.put("surname", "Ivanov");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Petr", "Ivanov", LocalDate.of(2002, 11, 20), Gender.MALE));
        expected.add(new Person("Artem", "Ivanov", LocalDate.of(2002, 11, 7), Gender.MALE));
        //System.out.println(expected);
        //System.out.println(filteredPersons);
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterByNameJenyaAndSurnameAlekseev(){
        Map<String, String> criteria = new HashMap<>();
        criteria.put("surname", "Alekseev");
        criteria.put("name", "Jenya");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Jenya", "Alekseev", LocalDate.of(2002, 12, 12), Gender.MALE));
        expected.add(new Person("Jenya", "Alekseev", LocalDate.of(2013, 4, 5), Gender.MALE));
        //System.out.println(expected);
        //System.out.println(filteredPersons);
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterByGenderFEMALE(){
        Map<String, String> criteria = new HashMap<>();
        criteria.put("gender", "FEMALE");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteria);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        expected.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        expected.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
        //System.out.println(expected);
        //System.out.println(filteredPersons);
        assertIterableEquals(expected, filteredPersons);
    }

    @Test
    public void filterFEMALESortName(){
        Map<String, String> criteriaFilter = new HashMap<>();
        criteriaFilter.put("gender", "FEMALE");
        List<Person> filteredPersons = FilterPerson.filter(persons, criteriaFilter);
        Map<String, String> criteriaSort = new HashMap<>();
        criteriaSort.put("name", "asc");
        List<Person> sortedPersons = SortPerson.sort(filteredPersons, criteriaSort);
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Anna", "Volkova", LocalDate.of(2002, 7, 6), Gender.FEMALE));
        expected.add(new Person("Daria", "Simonova", LocalDate.of(2002, 5, 7), Gender.FEMALE));
        expected.add(new Person("Julia", "Orlova", LocalDate.of(2002, 4, 5), Gender.FEMALE));
        System.out.println(filteredPersons);
        System.out.println(expected);
        System.out.println(sortedPersons);
        assertIterableEquals(expected, sortedPersons);
    }



}