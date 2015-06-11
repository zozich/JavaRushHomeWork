package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    private Solution() {
    }

    private Solution(String s) {
    }

    private Solution(int i) {
    }

    Solution(Integer j) {
    }

    Solution(boolean s) {
    }

    Solution(double i) {
    }

    protected Solution(Object j) {
    }

    protected Solution(float s) {
    }

    protected Solution(Double i) {
    }

    public Solution(Object j, int i) {
    }

    public Solution(float s, int i) {
    }

    public Solution(Double i, int j) {
    }

}

