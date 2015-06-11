package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();

//        String[] s2 = s.split(" ");
        if (args[0].equals("-c")) {
            Date date = new Date(args[3]);
            create(args[1], args[2], date);
        } else if (args[0].equals("-u")) {
            Date date = new Date(args[4]);
            update(Integer.parseInt(args[1]), args[2], args[3], date);
        } else if (args[0].equals("-d")) {
            delete(Integer.parseInt(args[1]));
        } else if (args[0].equals("-i")) {
            info(Integer.parseInt(args[1]));
        } else if (args[0].equals("print")) {
            for (Person x : allPeople) {
                System.out.println(x);
            }
        }
    }

    public static void create(String name, String sex, Date bd) {
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, bd));
        } if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, bd));
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void update(int id, String name, String sex, Date bd) {
        allPeople.remove(id);
        if (sex.equals("м")) {
            allPeople.add(id, Person.createMale(name, bd));
        } if (sex.equals("ж")) {
            allPeople.add(id, Person.createFemale(name, bd));
        }
    }

    public static void delete(int id) {
        allPeople.get(id).setBirthDay(null);
    }

    public static void info(int id) {
        Person person = allPeople.get(id);
        String name = person.getName();
        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
        DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String birthday = format.format(person.getBirthDay());
        String result = name + " " + sex + " " + birthday;
        System.out.println(result);
    }
}
