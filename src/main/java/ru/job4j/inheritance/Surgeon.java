package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String equipment;

    public Surgeon(String name, String surname, String education, String birthday, String qualification, String equipment) {
        super(name, surname, education, birthday, qualification);
        this.equipment = equipment;
    }

    public String getEquipment() {
        return equipment;
    }

    public Surgery interventionProcess(Patient patient, String equipment, Diagnosis diagnosis) {
        return new Surgery();
    }
}

class Surgery {
}


