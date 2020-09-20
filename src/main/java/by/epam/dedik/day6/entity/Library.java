package by.epam.dedik.day6.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private static Library instance;

    private List<CustomBook> books;

    private Library() {
        books = new ArrayList<>();
    }

    public static Library getInstance() {
        instance = instance == null ? new Library() : instance;
        return instance;
    }

    public List<CustomBook> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public boolean addBook(CustomBook book) {
        return books.add(book);
    }

    public boolean removeBook(CustomBook book) {
        return books.remove(book);
    }

    public void removeBook(int index) {
        books.remove(index);
    }
}
