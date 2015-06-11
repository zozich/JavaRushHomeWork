package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(3d, "aaa");
        labels.put(2d, "aab");
        labels.put(1d, "aav");
        labels.put(4d, "aac");
        labels.put(6d, "aae");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
