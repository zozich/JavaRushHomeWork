package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Externalizable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать.
Объект всегда должен содержать актуальные на сегодняшний день данные.
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution s1 = new Solution(4);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaProjects\\test.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(s1);
        System.out.println(s1);
        fileOutputStream.close();
        out.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\JavaProjects\\test.txt");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        Solution s_recovered = (Solution)in.readObject();
        System.out.println(s_recovered);
    }

    private static final long serialVersionUID = 1233455689;
    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

}
