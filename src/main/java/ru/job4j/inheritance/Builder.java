package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String brigade;

    public Builder(String name, String surname, String education, String birthday, String level, String brigade) {
        super(name, surname, education, birthday, level);
        this.brigade = brigade;
    }

    public Building constructionControl(Specification specification, Project project, String brigade) {
        return new Building();
    }
}

class Building {
}


