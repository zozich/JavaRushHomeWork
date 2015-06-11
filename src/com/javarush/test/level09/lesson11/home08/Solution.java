package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Collections;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] i1 = {1, 2, 3, 4, 5};
        int[] i2 = {0, 1};
        int[] i3 = {9, 8, 7, 6};
        int[] i4 = {9, 8, 7, 6, 5, 4, 3};
        int[] i5 = new int[0];
        Collections.addAll(list, i1, i2, i3, i4, i5);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
