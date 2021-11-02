import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private final LocalDate date;
    private final String sex;

    public Person(String name, String surname, LocalDate date, String sex) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, sex, date.getMonth(), date.getYear(), date.getDayOfMonth());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj.hashCode() == hashCode()){
            if (obj)
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + date + " " + sex;
    }
}
