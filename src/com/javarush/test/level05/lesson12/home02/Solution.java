package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution {

    public static void main(String[] args) {
        Man man1 = new Man("Andrew", 26, "Motorniy");
        Man man2 = new Man("Pasha", 31, "Mayorova");
        Woman w1 = new Woman("Natasha", 24, "Lesi");
        Woman w2 = new Woman("Dasha", 24, "Lesi");
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(w1);
        System.out.println(w2);
    }

    public static class Man {
        private String name;
        private String address;
        private int age;

        public Man(String name) {
            this.name = name;
        }

        public Man(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }

    public static class Woman {
        private String name;
        private String address;
        private int age;

        public Woman(String name) {
            this.name = name;
        }

        public Woman(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
