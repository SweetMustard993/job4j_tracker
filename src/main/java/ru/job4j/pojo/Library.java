package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book zlatoustAndNarciss = new Book("Златоуст и Нарцисс", 459);
        Book vinoIzOduvanchikov = new Book("Вино из одуванчиков", 357);
        Book loznayaSlepota = new Book("Ложная слепота", 570);
        Book clenCode = new Book("Clean code", 532);
        Book[] shelf = new Book[4];
        shelf[0] = zlatoustAndNarciss;
        shelf[1] = vinoIzOduvanchikov;
        shelf[2] = loznayaSlepota;
        shelf[3] = clenCode;
        for (int i = 0; i < shelf.length; i++) {
            Book book = shelf[i];
            System.out.println("название книги: " + book.getName() + " ; " + "количество страниц: " + book.getCount());
        }
        Book copyBook = shelf[0];
        shelf[0] = shelf[3];
        System.out.println();
        shelf[3] = copyBook;
        for (int i = 0; i < shelf.length; i++) {
            Book book = shelf[i];
            System.out.println("название книги: " + book.getName() + " ; " + "количество страниц: " + book.getCount());
        }
        System.out.println("Show books only with name \"Clean code\"");
        for (int i = 0; i < shelf.length; i++) {
            Book book = shelf[i];
            if (book.getName().equals("Clean code")) {
                System.out.println("название книги: " + book.getName() + " ; " + "количество страниц: " + book.getCount());
            }
        }
    }
}
