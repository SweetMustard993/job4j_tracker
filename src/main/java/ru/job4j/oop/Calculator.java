package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int z) {
        return z / x;
    }

    public int sumAllOperation(int arg) {
        return divide(arg) + minus(arg) + multiply(arg) + sum(arg);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.multiply(5));
        System.out.println(calc.divide(9));
        System.out.println(calc.sumAllOperation(10));
    }
}