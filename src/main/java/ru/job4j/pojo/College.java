package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Genrih");
        student.setSurname("Kermen");
        student.setPatronymic("Vladislavovich");
        student.setGroup("OOD-0012");
        student.setDateAdmission(LocalDate.of(2020, 9, 1));
        System.out.println(student.getName() + " " + student.getSurname() + " "
                + student.getPatronymic() + " учится в группе "
                + student.getGroup() + ", поступил в " + student.getDateAdmission());
    }
}
