package org.Book;

public class BookController {
    public static void main(String[] args) {
        BookModel model = new BookModel();
        BookView view = new BookView(model);
        view.setVisible(true);
    }
}
