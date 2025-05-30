package org.Book;

public class Book {
    private String title;
    private String author;
    private String category;
    private int year;

    public Book(String title, String author, String category, int year) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + category + ", " + year + ")";
    }
}