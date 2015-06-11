package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Spielberg", new Date("AUGUST 1 1980"));
        map.put("Schwarz", new Date("JANUARY 1 1980"));
        map.put("aaa1", new Date("FEBRUARY 1 1980"));
        map.put("aaa2", new Date("JULY 1 1980"));
        map.put("a3", new Date("MARCH 1 1980"));
        map.put("a4", new Date("APRIL 1 1980"));
        map.put("a5", new Date("DECEMBER 1 1980"));
        map.put("a6", new Date("OCTOBER 1 1980"));
        map.put("a7", new Date("SEPTEMBER 1 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            int month = iterator.next().getValue().getMonth() + 1;
            if (6 <= month && month <= 8) {
                iterator.remove();
            }
        }
    }
}
