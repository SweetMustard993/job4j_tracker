package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void show() {
        System.out.println("active: " + active + ", status " + status + ", message " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(false, -1, "process crushed while trying to read a file");
        Error error3 = new Error(false, 0, "file not found");
    }
}
