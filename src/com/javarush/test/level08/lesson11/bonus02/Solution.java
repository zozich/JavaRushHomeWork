package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> locations = new ArrayList<String>();
        List<String> addresses = new ArrayList<String>();
        while (true) {
            String adr = reader.readLine();
            if (adr.isEmpty()) {
                break;
            }
            String family = reader.readLine();
            locations.add(adr);
            addresses.add(family);
        }
        String adr = reader.readLine();
        int adrIndex = locations.indexOf(adr);
        if (adrIndex >= 0) {
            System.out.println(addresses.get(adrIndex));
        }
    }
}
