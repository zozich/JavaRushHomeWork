package com.javarush.test.level08.lesson08.task01;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution {

    public static HashSet<String> createSet() {
        HashSet<String> set = new HashSet<String>();
        Collections.addAll(set, "люда", "лада", "лида", "лима", "лира", "леня", "леша", "леся", "ляха", "лях", "ли", "лед", "лиза", "лексус", "ланос", "литва", "латвия", "лекторн", "лектрючка", "липа");
        return set;
    }
}
