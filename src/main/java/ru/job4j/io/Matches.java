package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        int withdrawn = 0;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до " + Math.min(count, 3) + ":");
            withdrawn = Integer.parseInt(input.nextLine());
            if (withdrawn <= Math.min(count, 3) && withdrawn > 0) {
                count = count - withdrawn;
                System.out.println("на столе осталось - " + count + " спичек");
                turn = !turn;
            } else {
                System.out.println("Жулничать нехорошо");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}