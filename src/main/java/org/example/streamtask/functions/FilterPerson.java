package org.example.streamtask.functions;

import org.example.streamtask.classes.Field;
import org.example.streamtask.classes.Person;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FilterPerson {

    private static Map<Field, Predicate<Person>> criteria = new HashMap<>();

    public void putCriterion(Field field, String val){
        switch (field){
            case NAME:
                criteria.put(field, person -> person.getName().equals(val));
            case SURNAME:
                criteria.put(field, person -> person.getSurname().equals(val));
            case BIRTHDATE:
                criteria.put(field, person -> person.getBirthDate().toString().equals(val));
            case GENDER:
                criteria.put(field, person -> person.getGender().toString().equals(val));
        }
    }
    public static List<Person> filter(List<Person> persons) {
        for (Field criterion : criteria.keySet()) {
            persons = persons.stream()
                    .filter(criteria.get(criterion))
                    .collect(Collectors.toList());
        }
        return persons;
    }
}
