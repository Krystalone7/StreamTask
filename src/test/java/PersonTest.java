
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private List<Person> persons;

    @BeforeEach
    public void setUp(){
        persons = new ArrayList<>();
        persons.add(new Person("Петр", "Иванов", LocalDate.of(2002, 11, 20), "male"));
        persons.add(new Person("Артем", "Сидоров", LocalDate.of(2002, 11, 20), "male"));
        persons.add(new Person("Никита", "Кузнецов", LocalDate.of(2002, 11, 20), "male"));
        persons.add(new Person("Елисей", "", LocalDate.of(2002, 11, 20), "male"));
        persons.add(new Person("Женя", "Иванов", LocalDate.of(2002, 11, 20), "male"));
        persons.add(new Person("Вячеслав", "Иванов", LocalDate.of(2002, 11, 20), "male"));
        persons.add(new Person("Глеб", "Иванов", LocalDate.of(2002, 11, 20), "male"));
    }

    @Test
    public void sortByNames(){
        persons.stream()
                .sorted(((o1, o2) -> )
    }


}