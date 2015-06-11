package com.javarush.test.level08.lesson08.task05;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>()
        {{
                put("Иванов", "Андрей");
                put("Петров", "Андрей");
                put("Сидоров", "Коля");
                put("Козюля", "Андрей");
                put("Павлик", "Сергей");
                put("Сташко", "Андрей");
                put("Шеремета", "Павел");
                put("Климкин", "Павел");
                put("Порошенко", "Петр");
                put("Парцхаладзе", "Гиви");
        }};
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        HashMap<String, String> copy2 = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            copy2.remove(pair.getKey());
            if (copy2.containsValue(pair.getValue())) {
                removeItemFromMapByValue(map, pair.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }
}
