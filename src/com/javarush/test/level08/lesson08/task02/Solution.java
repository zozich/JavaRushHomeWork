package com.javarush.test.level08.lesson08.task02;

import java.util.*;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution {

    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<Integer>();
        Collections.addAll(set, 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() > 10) {
                iterator.remove();
            }
        }
        return set;
    }
}
