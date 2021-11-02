import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private final LocalDate date;
    private final Gender gender;

    public Person(String name, String surname, LocalDate date, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender, date.getMonth(), date.getYear(), date.getDayOfMonth());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj instanceof Person) {
            if (obj.hashCode() == hashCode()) {
                return ((Person) obj).name.equals(name) && ((Person) obj).surname.equals(surname) && ((Person) obj).date.equals(date) && ((Person) obj).gender.equals(gender);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + date + " " + gender;
    }
}
