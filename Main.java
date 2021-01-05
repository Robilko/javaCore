package lesson6;

//Домашка Java. Уровень 1. Урок 6
//1.Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
//2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
//3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
//4. ** Написать метод, проверяющий, есть ли указанное слово в папке

import java.io.*;
import java.util.Scanner;


public class Main {

    static final String STR1 = "1. Денек выдался ветреным.\nВерхушки деревьев изгибались в сторону дороги, точно кланялись отъезжающим.\nПо зелени необъятных полей одна за другой непрерывно бежали волны.\nТени облаков бежали наперегонки с золотистыми полосами солнечного света.\nА ветер все не утихал и вместе с ним летели и гнались друг за другом полосы света и теней.\n";
    static final String STR2 = "2. День стоял жаркий. Ни одно облачко не смело заслонить солнышко.\nЛенивый ветерок слегка обдувал раскаленную поверхность земли.\nПрирода замерла. Едва покачивались верхушки деревьев.\nМедленно текла река, будто потоки жидкого хрусталя.\nВсе живое спешило укрыться куда-нибудь от палящего зноя.\nСтада бежали в воду. Птицы прятались в рощах и в густой траве.";
    static File file1 = new File("File1.txt");
    static File file2 = new File("File2.txt");
    static File resultFile = new File("Result_file.txt");


    public static void writeFile(File fileName, String str) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(str.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mergeFiles(File file1, File file2, File result) {
        File[] files = {file1, file2};
        try {
            FileOutputStream fos = new FileOutputStream(result);
            for (File file : files){
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fos.write(buffer);
                fis.close();
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean findTheWord(String word, String file) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String str;
            while ((str = br.readLine()) != null) {
                if (str.toLowerCase().contains(" " + word + " ")) return true;
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static String findWordInFile(String word, File catalog) {
        StringBuilder sb = new StringBuilder();
        File[] files;
        if ((files = catalog.listFiles()) != null) {
            for (File file : files) {
                if (file.isFile() && findTheWord(word, file.getName())) sb.append(file.getPath() + "\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        //1.Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
        writeFile(file1, STR1);
        writeFile(file2, STR2);

        //2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
        mergeFiles(file1, file2, resultFile);

        //3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово для поиска в файле:");
        String word = scanner.nextLine().toLowerCase();
        System.out.println("В каком файле Вы хотите искать слово \"" + word + "\" - " + file1.getName() + ", " + file2.getName() + " или " + resultFile.getName() + " ?");
        String fileName = scanner.nextLine();
        scanner.close();


        System.out.println("************************************************");
        System.out.println("Результат выполнения программы (Задание 6, пункт 3):\n");
        if (findTheWord(word, fileName)) System.out.println("В файле " + fileName + " присутствует слово \"" + word + "\"");
        else System.out.println("В файле " + fileName + " нет слова \"" + word + "\"");

        //4. ** Написать метод, проверяющий, есть ли указанное слово в папке

        System.out.println("*************************************************");
        System.out.println("Результат выполнения программы (Задание 6, пункт 4):\n");
        File rootProject = new File(".");
        String array = findWordInFile(word, rootProject);
        if (array.length() > 0) System.out.println("В данной папке слово \"" + word + "\" найдено в следующих файлах:\n" + array);
        else System.out.println("В данной папке нет файла содержащего слово \"" + word + "\"");
    }
}
