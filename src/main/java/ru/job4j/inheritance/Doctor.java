package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String qualification;

    public Doctor(String name, String surname, String education, String birthday, String qualification) {
        super(name, surname, education, birthday);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public Diagnosis checkup(Patient patient) {
        return new Diagnosis();
    }
}

class Patient {
}

class Diagnosis {
}
