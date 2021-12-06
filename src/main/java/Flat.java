import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
@JsonAutoDetect
public class Flat implements Serializable {
    int number;
    double area;
    ArrayList<Person> personList;

    public Flat(){
        this.number = 0;
        this.area = 0;
        this.personList = new ArrayList<Person>();
    }

    public Flat(int number, double area, ArrayList<Person> personList) {
        this.number = number;
        this.area = area;
        this.personList = personList;
    }

    @JsonIgnore
    public int getLenght(){
        return personList.size();
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat)) return false;
        Flat flat = (Flat) o;
        return getNumber() == flat.getNumber() &&
                Double.compare(flat.getArea(), getArea()) == 0 &&
                Objects.equals(getPersonList(), flat.getPersonList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getArea(), getPersonList());
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", area=" + area +
                ", personList=" + personList +
                '}';
    }


}
