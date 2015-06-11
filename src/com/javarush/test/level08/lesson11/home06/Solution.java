package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Solution {

    public static void main(String[] args) {
        Human son1 = new Human("Andrey", true, 27, new ArrayList<Human>());
        Human son2 = new Human("Mark", true, 31, new ArrayList<Human>());
        Human daughter1 = new Human("Katya", false, 31, new ArrayList<Human>());
        ArrayList<Human> children = new ArrayList<Human>();
        Collections.addAll(children, son1, son2, daughter1);

        Human father = new Human("Alexandr", true, 60, children);
        Human mother = new Human("Luda", false, 58, children);
        ArrayList<Human> p1 = new ArrayList<Human>();
        p1.add(father);
        ArrayList<Human> p2 = new ArrayList<Human>();
        p2.add(mother);

        Human gf1 = new Human("Vladimir", true, 90, p1);
        Human gm1 = new Human("Manya", false, 87, p1);
        Human gf2 = new Human("Kolya", true, 85, p2);
        Human gm2 = new Human("Katya", false, 83, p2);

        ArrayList<Human> all = new ArrayList<Human>();
        Collections.addAll(all, son1, son2, daughter1, father, mother, gf1, gf2, gm1, gm2);
        for (int i=0;i<all.size();i++) {
            System.out.println(all.get(i));
        }
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: "+this.children.get(0).name;
                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }
            return text;
        }
    }
}
