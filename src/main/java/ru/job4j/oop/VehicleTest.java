package ru.job4j.oop;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle[] array = new Vehicle[]{bus, airplane, train};
        for (Vehicle vehicle : array) {
            vehicle.move();
        }
    }
}
