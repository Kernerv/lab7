import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class SerDesirHouseTest {

    @Test
    public void serAndDesir(){
        Person p1 = new Person("Алексей", "Иванович", "Петров");
        Person p2 = new Person("Генадий", "Владимирович", "Петров");
        Person p3 = new Person("Аркадий", "Дмитриевич", "Иванов");
        Person p4 = new Person("Петр", "Константинович", "Иванов");
        Person p5 = new Person("Елена", "Генадьевич", "Иванова");
        Person p6 = new Person("Василиса", "Петрович", "Смирнов");
        ArrayList<Person> listPerson1 = new ArrayList<Person>();
        ArrayList<Person> listPerson2 = new ArrayList<>();
        ArrayList<Person> listPerson3 = new ArrayList<>();
        listPerson1.add(p1);listPerson1.add(p2);
        listPerson2.add(p3);listPerson2.add(p4);listPerson2.add(p5);
        listPerson3.add(p6);
        Flat flat1 = new Flat(1, 20, listPerson1);
        Flat flat2 = new Flat(22, 12, listPerson2);
        Flat flat3 = new Flat(31, 35, listPerson3);
        ArrayList<Flat> flatArrayList = new ArrayList<>();
        flatArrayList.add(flat1); flatArrayList.add(flat2); flatArrayList.add(flat3);
        House house = new House("412av", "Г. Омск ул. Проспект мира д.55А", p1, flatArrayList );


        //сериализация и десириализация средствами JAVA
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("serAndDeser.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.writeObject(house);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("serAndDeser.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            House house1 = (House) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(house);

    }

}