package org.example.streamtask.functions;

import org.example.streamtask.classes.Field;
import org.example.streamtask.classes.Person;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FilterPerson {

    public static List<Person> filter(List<Person> persons, Map<Field, Predicate<Person>> criteria) {
        for (Field criterion : criteria.keySet()) {
            persons = persons.stream()
                    .filter(criteria.get(criterion))
                    .collect(Collectors.toList());
        }
        return persons;
    }
}
