package com.javarush.test.level20.lesson07.task05;

import java.io.*;
import java.util.concurrent.TimeUnit;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    static final long serialVersionUID = 1L;
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
            try
            {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Tic");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Tac");
            }
            catch (InterruptedException e)
            {
            }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        startThread();
    }

    private void startThread()
    {
        runner = new Thread(this);
        runner.run();
    }

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException
    {
        Solution solution = new Solution(10);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\JavaProjects\\test.txt"));
        out.writeObject(solution);
        out.close();
        TimeUnit.SECONDS.sleep(3);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\JavaProjects\\test.txt"));
        Solution recovered = (Solution)in.readObject();
        in.close();
    }
}
