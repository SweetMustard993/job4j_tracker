package ru.job4j.inheritance;

public class Dantist extends Doctor {
    private String dentalUnit;

    public Dantist(String name, String surname, String education, String birthday, String qualification, String dentalUnit) {
        super(name, surname, education, birthday, qualification);
        this.dentalUnit = dentalUnit;
    }

    public ToothFilling installation(Patient patient, Diagnosis diagnosis, String dentalUnit) {
        return new ToothFilling();
    }
}

class ToothFilling {
}