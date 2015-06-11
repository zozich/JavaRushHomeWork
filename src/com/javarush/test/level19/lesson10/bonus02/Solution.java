package com.javarush.test.level19.lesson10.bonus02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Alex on 17.02.2015.
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter writer = new FileConsoleWriter("D:\\JavaProjects\\test.txt");
        writer.write("test");
        writer.write("test2");
        writer.write(121);
        writer.close();
    }
}
