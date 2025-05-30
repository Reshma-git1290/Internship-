package org.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookModel {
    private List<Book> books;
    private Map<String, Integer> categoryCounts;

    public BookModel() {
        books = new ArrayList<>();
        categoryCounts = new HashMap<>();
    }

    public void addBook(String title, String author, String category, int year) {
        if (title.isEmpty() || author.isEmpty() || category.isEmpty() || year < 1900 || year > 2023) {
            throw new IllegalArgumentException("Invalid input");
        }

        Book book = new Book(title, author, category, year);
        books.add(book);
        incrementCategoryCount(category);
    }

    public void editBook(int index, String title, String author, String category, int year) {
        if (index < 0 || index >= books.size() || title.isEmpty() || author.isEmpty() || category.isEmpty() || year < 1900 || year > 2023) {
            throw new IllegalArgumentException("Invalid input");
        }

        Book book = books.get(index);
        decrementCategoryCount(book.getCategory());
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setYear(year);
        incrementCategoryCount(category);
    }

    public void deleteBook(int index) {
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Invalid index");
        }

        Book book = books.get(index);
        decrementCategoryCount(book.getCategory());
        books.remove(index);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Map<String, Integer> getCategoryCounts() {
        return categoryCounts;
    }

    private void incrementCategoryCount(String category) {
        categoryCounts.put(category, categoryCounts.getOrDefault(category, 0) + 1);
    }

    private void decrementCategoryCount(String category) {
        categoryCounts.put(category, categoryCounts.get(category) - 1);
    }
}