import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void Task1(){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        File file = new File("task1.txt");
        FileOutputStream out = null; //поток ввода в файл
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<arr.length;i++){
            try {
                out.write(Integer.toString(arr[i]).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream in = null; //поток чтения с файла
        try {
            in = new FileInputStream("task1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(in);
        if(scanner.hasNextLine()){
            System.out.println(scanner.nextInt());
        }
    }

    public static void Task2(){
        int[] array = {1,2,3,4,5,6,7,8,9};
        try (final FileWriter writer = new FileWriter("task2.txt", false))//символьный поток записи
        {
            for (int i = 0; i < array.length; ++i)
            {
                final String s = Integer.toString(array[i]);
                writer.write(s+" ");
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        try (final FileReader reader = new FileReader("task2.txt"))//символьный поток чтения
        {
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Task3(){
        int position = 4;
        try {
            RandomAccessFile raf = new RandomAccessFile("task1.txt", "r");
            raf.seek(position);
            System.out.println(raf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Task4(){
        String exp = "txt";//тип нужного расширения
        String path = new File("").getAbsolutePath();
        File curentFile = new File(path);
        String[] fileList =  curentFile.list();
        for(int i=0; i<fileList.length; i++){
            if(fileList[i].endsWith("."+exp)) System.out.println(fileList[i]);
        }
    }


    public static List<String> findAllFiles(File file, List<String> listName){//метод к заданию 5*
        File[] folderEntries = file.listFiles();
        for (File entry : folderEntries) {
            listName.add(entry.getName());
            if (entry.isDirectory()) {
                findAllFiles(entry, listName);
                continue;

            }
        }
        return listName;
    }

    public static void Task5(){
        String exp = "xml"; // тип нужного расширения
        List<String> list = new ArrayList<>();
        String path = new File("").getAbsolutePath();
        File file = new File(path);
        List<String> fileList = new ArrayList( findAllFiles(file, list));
        for(int i=0; i<fileList.size(); i++){
            String s = fileList.get(i);
            if(s.endsWith("."+exp)) System.out.println(s);
        }
    }


    public static void main(String[] args) throws IOException {
//        Task1();
//        Task2();
//        Task3();
//        Task4();
//        Task5();
    }
}
