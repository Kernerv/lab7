import org.codehaus.jackson.annotate.JsonAutoDetect;

import java.io.Serializable;
import java.util.Objects;

@JsonAutoDetect
public class Person implements Serializable {
    String name, midleName, surname;

    public Person(){
        this.name = "unknown";
        this.midleName = "unknown";
        this.surname = "unkown";
    }

    public Person(String name, String midleName, String surname) {
        this.name = name;
        this.midleName = midleName;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getMidleName() {
        return midleName;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public String toString() {
        return surname+" "+name.charAt(0)+"."+midleName.charAt(0)+".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) &&
                Objects.equals(getMidleName(), person.getMidleName()) &&
                Objects.equals(getSurname(), person.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMidleName(), getSurname());
    }
}