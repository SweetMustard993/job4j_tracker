package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int rslName = this.getName().compareTo(o.getName());
        return rslName != 0 ? rslName : Integer.compare(this.getAge(), o.getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}