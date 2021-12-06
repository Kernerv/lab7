import org.codehaus.jackson.annotate.JsonAutoDetect;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
@JsonAutoDetect
public class House implements Serializable {
    String houseNumber, adres;
    Person mainPersonOfHouse;
    ArrayList<Flat> flatList;

    public House(){
        this.houseNumber = "unknown";
        this.adres = "unkown";
        this.mainPersonOfHouse = new Person();
        this.flatList = new ArrayList<>();
    }

    public House(String houseNumber, String adres, Person mainPersonOfHouse, ArrayList<Flat> flatList) {
        this.houseNumber = houseNumber;
        this.adres = adres;
        this.mainPersonOfHouse = mainPersonOfHouse;
        this.flatList = flatList;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Person getMainPersonOfHouse() {
        return mainPersonOfHouse;
    }

    public void setMainPersonOfHouse(Person mainPersonOfHouse) {
        this.mainPersonOfHouse = mainPersonOfHouse;
    }

    public ArrayList<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(ArrayList<Flat> flatList) {
        this.flatList = flatList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        House house = (House) o;
        return Objects.equals(getHouseNumber(), house.getHouseNumber()) &&
                Objects.equals(getAdres(), house.getAdres()) &&
                Objects.equals(getMainPersonOfHouse(), house.getMainPersonOfHouse()) &&
                Objects.equals(getFlatList(), house.getFlatList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHouseNumber(), getAdres(), getMainPersonOfHouse(), getFlatList());
    }



    @Override
    public String toString() {
        return "House{" +
                "houseNumber='" + houseNumber + '\'' +
                ", adres='" + adres + '\'' +
                ", mainPersonOfHouse=" + mainPersonOfHouse +
                ", flatList=" + flatList +
                '}';
    }


    public String sirilHouse(House house) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, house);
        String result = writer.toString();
        return result;
    }

    public House deSirilHouse(String s) throws IOException {
        StringReader reader = new StringReader(s);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, House.class);

    }

}

