package org.example.streamtask.functions;

import org.example.streamtask.classes.Person;
import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    public static List<Person> paginate(List<Person> persons, int countOnPage, int page){
        int currentPos = countOnPage * (page - 1);
        persons = persons.stream()
                .skip((long) currentPos)
                .limit(countOnPage)
                .collect(Collectors.toList());
        return persons;
    }
}
