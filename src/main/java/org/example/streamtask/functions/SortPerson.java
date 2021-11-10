package org.example.streamtask.functions;

import org.example.streamtask.classes.Field;
import org.example.streamtask.classes.Person;
import org.example.streamtask.classes.SortFactor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortPerson {
    public static List<Person> sort(List<Person> persons, Map<Field, Comparator<Person>> criteria){
        for (Field criterion: criteria.keySet()) {
            persons = persons.stream()
                    .sorted(criteria.get(criterion))
                    .collect(Collectors.toList());
        }
        return persons;
    }
}
