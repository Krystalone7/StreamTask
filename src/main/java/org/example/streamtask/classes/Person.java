package org.example.streamtask.classes;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private final LocalDate birthDate;
    private final Gender gender;

    public Person(String name, String surname, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public int hashCode() {
        if (birthDate == null){
            throw new NullPointerException();
        }
        return Objects.hash(name, surname, gender, birthDate.getMonth(), birthDate.getYear(), birthDate.getDayOfMonth());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj instanceof Person) {
            if (obj.hashCode() == hashCode()) {
                return ((Person) obj).name.equals(name) && ((Person) obj).surname.equals(surname) && ((Person) obj).birthDate.equals(birthDate) && ((Person) obj).gender.equals(gender);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + birthDate + " " + gender;
    }
}
