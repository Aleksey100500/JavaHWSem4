import java.io.*;
import java.util.*;

public class JavaSem4HW {
    public static String[] append(String[] arr, String element) {
        String[] array = new String[arr.length + 1];
        System.arraycopy(arr, 0, array,0,  arr.length);
        array[arr.length] = element;
        return array;
    }

    public static void main(String[] args) throws Exception {

//        1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
//        2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
//        3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
//        4.Отсортировать по возрасту используя дополнительный список индексов.

        File file = new File("bd.txt");
        FileWriter fw = new FileWriter(file);

        fw.write("Zhuravsky N.N. 32 M\r\n");
        fw.write("Antipchyk N.V. 27 W\r\n");
        fw.write("Nikolaevich D.N. 29 M\r\n");
        fw.write("Andreev V.V. 31 M\r\n");
        fw.write("Alexeeva A.I. 26 W\r\n");
        fw.write("Nadinova N.A. 30 W");
        fw.flush();
        fw.close();

        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);
        ArrayList<String> list = new ArrayList<>();

        while (scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
//        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + " : " + list.get(i));
        }

        String[] surName = new String[0];
        String[] nameFname = new String[0];
        String[] yearsOld = new String[0];
        String[] sex = new String[0];
        String Regex = " ";
        String text = "";
        String[] newText;
        String secondText = "";
        String[] secondNewText;
        ArrayList<String> tempList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            text = list.get(i);
            newText = text.split(Regex);
            System.out.println(Arrays.toString(newText));

            surName = append(surName,newText[0]);
            nameFname = append(nameFname, newText[1]);
            yearsOld = append(yearsOld,newText[2]);
            sex = append(sex, newText[3]);
        }

        System.out.println(Arrays.toString(surName));
        System.out.println(Arrays.toString(nameFname));
        System.out.println(Arrays.toString(yearsOld));
        System.out.println(Arrays.toString(sex));

        Collections.sort(list);
        System.out.println(list);

        fr.close();
    }
}
