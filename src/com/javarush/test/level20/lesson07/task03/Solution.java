package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static class Person implements Externalizable {
        private static final long serialVersionUID = 123456789;
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person()
        {
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }

        @Override
        public String toString()
        {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", mother=" + mother +
                    ", father=" + father +
                    ", children=" + children +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person ivan = new Person("Ivan", "Durachok", 25);
        Person vasilisa = new Person("Vasilisa", "Premudraya", 50);
        Person ilya = new Person("Ilya", "Muromets", 55);
        ivan.setFather(ilya);
        ivan.setMother(vasilisa);
        Person son1 = new Person("Petya", "Pyatochkin", 5);
        Person d1 = new Person("Masha", "Medvedeva", 3);
        ArrayList chld = new ArrayList();
        Collections.addAll(chld, son1, d1);
        ivan.setChildren(chld);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaProjects\\test.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(ivan);
        fileOutputStream.close();
        out.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\JavaProjects\\test.txt");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        Object ivan_back = (Person)in.readObject();
        fileInputStream.close();
        in.close();
        System.out.println(ivan_back);
    }
}
