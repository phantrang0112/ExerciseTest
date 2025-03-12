package com.cmdglobal.lesson4;

public class Library {
    private Book[] books;
    private int bookCount;

    public Library() {
    }

    public Library(Book[] books, int bookCount) {
        this.books = books;
        this.bookCount = bookCount;
    }

    public Library(int lenght) {
        this.books = new Book[lenght];
        this.bookCount = 0;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Book added to the library.");
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i] = books[bookCount - 1];
                books[bookCount - 1] = null;
                bookCount--;
                System.out.println("Book removed from the library.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public Book searchBook(String query) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(query) || books[i].getAuthor().equalsIgnoreCase(query)) {
                return books[i];
            }
        }
        return null;
    }

    public void displayAllBooks() {
        for (int i = 0; i < bookCount; i++) {
            books[i].displayDetails();
        }
    }

    public void borrowBook(String title) {
        Book book = searchBook(title);
        if (book != null) {
            book.borrowBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String title) {
        Book book = searchBook(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book not found.");
        }
    }
}
