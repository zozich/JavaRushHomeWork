package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;


public class FileConsoleWriter extends FileWriter
{
    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    private char[] writeBuffer;
    private final int writeBufferSize = 1024;

    @Override
    public void write(int c) throws IOException {
        super.write(c);
        System.out.print((char)c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        super.write(cbuf, off, len);
        String s = String.copyValueOf(cbuf, off, len);
        System.out.print(s);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        super.write(cbuf);
    }

    @Override
    public void write(String str) throws IOException {
        super.write(str);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str, off, len);
        String s = str.substring(off, off + len);
        System.out.print(s);
    }

}