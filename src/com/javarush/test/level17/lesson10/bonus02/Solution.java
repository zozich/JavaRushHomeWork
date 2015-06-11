package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        ArrayList<String> params = new ArrayList<String>();
        for (int i=0;i<args.length-1;i++)
            params.add(args[i+1]);
        if (args[0].equals("-c"))
        {
            create(params);
        }
        else if (args[0].equals("-u"))
        {
            update(params);
        }
        else if (args[0].equals("-d"))
        {
            delete(params);
        }
        else if (args[0].equals("-i"))
        {
            info(params);
        }
    }

    public static void create(ArrayList<String> params) throws ParseException
    {
        int number = params.size()/3;
        for (int j=0;j<number;j++)
        {
            if (params.get(1+j*3).equals("м"))
                allPeople.add(Person.createMale(params.get(j*3),getDate(params.get(2+j*3))));
            else
                allPeople.add(Person.createFemale(params.get(j*3),getDate(params.get(2+j*3))));
            System.out.println(allPeople.size()-1);
        }
    }

    public static void update(ArrayList<String> params) throws ParseException
    {
        int number = params.size()/4;
        for (int j=0;j<number;j++)
        {
            Person updatedPerson = allPeople.get(Integer.parseInt(params.get(j*4)));
            updatedPerson.setName(params.get(1+j*4));
            if (params.get(2+j*4).equals("м"))
                updatedPerson.setSex(Sex.MALE);
            else
                updatedPerson.setSex(Sex.FEMALE);
            updatedPerson.setBirthDay(getDate(params.get(3+j*4)));
        }
    }

    public static void delete(ArrayList<String> params)
    {
        for (int j=0;j<params.size();j++)
        {
            Person deletePerson = allPeople.get(Integer.parseInt(params.get(j)));
            deletePerson.setBirthDay(null);
            deletePerson.setSex(null);
            deletePerson.setName(null);
        }
    }

    public static void info(ArrayList<String> params)
    {
        for (int j=0;j<params.size();j++)
        {
            Person infoPerson = allPeople.get(Integer.parseInt(params.get(j)));
            String sex;
            if (infoPerson.getSex()==Sex.MALE)
                sex = "м";
            else
                sex = "ж";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(infoPerson.getName() + " " + sex + " " + simpleDateFormat.format(infoPerson.getBirthDay()));
        }
    }

    public static Date getDate (String s) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(s);
        return date;
    }
}