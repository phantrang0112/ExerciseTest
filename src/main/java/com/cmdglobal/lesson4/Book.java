package com.cmdglobal.lesson4;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book() {
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + isAvailable);
    }
    public boolean checkAvailability() {
        return isAvailable;
    }
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is currently unavailable.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned successfully.");
    }
}
