package org.Book;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class BookView extends JFrame {
    private JList<Book> bookList;
    private DefaultListModel<Book> bookListModel;
    private JTextField titleField, authorField, categoryField, yearField;
    private JTextArea categorySummary;

    public BookView(BookModel model) {
        setTitle("Book Tracking App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel bookPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);
        bookPanel.add(new JScrollPane(bookList), BorderLayout.CENTER);

        titleField = new JTextField();
        authorField = new JTextField();
        categoryField = new JTextField();
        yearField = new JTextField();

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Year:"));
        inputPanel.add(yearField);

        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        categorySummary = new JTextArea();
        categorySummary.setEditable(false);

        mainPanel.add(bookPanel, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.WEST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(new JScrollPane(categorySummary), BorderLayout.EAST);

        add(mainPanel);

        updateBookList(model.getBooks());
        updateCategorySummary(model.getCategoryCounts());

        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String author = authorField.getText();
                String category = categoryField.getText();
                int year = Integer.parseInt(yearField.getText());
                model.addBook(title, author, category, year);
                clearInputFields();
                updateBookList(model.getBooks());
                updateCategorySummary(model.getCategoryCounts());
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        editButton.addActionListener(e -> {
            int selectedIndex = bookList.getSelectedIndex();
            if (selectedIndex != -1) {
                try {
                    String title = titleField.getText();
                    String author = authorField.getText();
                    String category = categoryField.getText();
                    int year = Integer.parseInt(yearField.getText());
                    model.editBook(selectedIndex, title, author, category, year);
                    clearInputFields();
                    updateBookList(model.getBooks());
                    updateCategorySummary(model.getCategoryCounts());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a book to edit", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = bookList.getSelectedIndex();
            if (selectedIndex != -1) {
                model.deleteBook(selectedIndex);
                updateBookList(model.getBooks());
                updateCategorySummary(model.getCategoryCounts());
            } else {
                JOptionPane.showMessageDialog(this, "Please select a book to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void updateBookList(List<Book> books) {
        bookListModel.clear();
        for (Book book : books) {
            bookListModel.addElement(book);
        }
    }

    private void updateCategorySummary(Map<String, Integer> categoryCounts) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : categoryCounts.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        categorySummary.setText(sb.toString());
    }

    private void clearInputFields() {
        titleField.setText("");
        authorField.setText("");
        categoryField.setText("");
        yearField.setText("");
    }
}
