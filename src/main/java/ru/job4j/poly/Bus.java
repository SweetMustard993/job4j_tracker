package ru.job4j.poly;

import java.util.Scanner;

public class Bus implements Transport {
    @Override
    public void drive() {
        Scanner input =new Scanner(System.in);
        boolean stop = false;
        while (!stop){
            System.out.println("водитель совершает остановку по требованию");
            String busStop = input.nextLine();
            if (busStop == null){
                System.out.println("автобус проезжает без остановки");
            } else {
                System.out.println("автобус совершит остановку на" + busStop);
                stop = true;
            }
        }
    }

    @Override
    public void passanger(int passangersCount) {
        int allSeats = 20;
        int freeSeats = allSeats - passangersCount;
    }

    @Override
    public double refuel(double fuelVolume) {
        double cost = fuelVolume * 52.89;
        return cost;
    }
}
