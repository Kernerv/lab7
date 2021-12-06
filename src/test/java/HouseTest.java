import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


public class HouseTest {

    @Test
    public void desirHouse() throws IOException {
        Person p1 = new Person("Алексей", "Иванович", "Петров");
        Person p2 = new Person("Генадий", "Владимирович", "Петров");
        Person p3 = new Person("Аркадий", "Дмитриевич", "Иванов");
        Person p4 = new Person("Петр", "Константинович", "Иванов");
        Person p5 = new Person("Елена", "Генадьевич", "Иванова");
        Person p6 = new Person("Василиса", "Олеговна", "Смирнова");
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
        House secondHouse = new House("12234", "Г. Омск ул. Проспект мира д.55А", p3, flatArrayList );
        //сериализация и вывод её в консоль
        String s = house.sirilHouse(house);
        System.out.println(s);
        //десериализация и проверка с изначальным входным значением
        Assert.assertEquals(house.deSirilHouse(s), house);
    }



}