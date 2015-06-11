package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("Vasya");
            user1.setLastName("Polonskyi");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            User user2 = new User();
            user2.setFirstName("Olena");
            user2.setLastName("Glogoviak");
            user2.setBirthDate(new Date());
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            for (User user:loadedObject.users)
                System.out.println(user);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println(users.size());
            for (User user:users)
            {
                String hasFirstName = user.getFirstName()!=null?"Yes":"No";
                printStream.println(hasFirstName);
                if (hasFirstName.equals("Yes"))
                    printStream.println(user.getFirstName());
                String hasLastName = user.getLastName()!=null?"Yes":"No";
                printStream.println(hasLastName);
                if (hasLastName.equals("Yes"))
                    printStream.println(user.getLastName());
                String hasBirthday = user.getBirthDate()!=null?"Yes":"No";
                printStream.println(hasBirthday);
                if (hasBirthday.equals("Yes"))
                    printStream.println(user.getBirthDate().getTime());
                printStream.println(user.isMale());
                String hasCountry = user.getCountry()!=null?"Yes":"No";
                printStream.println(hasCountry);
                if (hasCountry.equals("Yes"))
                    printStream.println(user.getCountry().getDisplayedName());
            }
            printStream.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int size = Integer.parseInt(reader.readLine());
            for (int i=0;i<size;i++)
            {
                User user = new User();
                if (reader.readLine().equals("Yes"))
                    user.setFirstName(reader.readLine());
                if (reader.readLine().equals("Yes"))
                    user.setLastName(reader.readLine());
                if (reader.readLine().equals("Yes"))
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                if (reader.readLine().equals("true"))
                    user.setMale(true);
                if (reader.readLine().equals("Yes"))
                {
                    String country = reader.readLine();
                    if (country.equals("Ukraine"))
                        user.setCountry(User.Country.UKRAINE);
                    if (country.equals("Russia"))
                        user.setCountry(User.Country.RUSSIA);
                    if (country.equals("Other"))
                        user.setCountry(User.Country.OTHER);
                }
                users.add(user);
            }
            reader.close();
        }
    }
}
