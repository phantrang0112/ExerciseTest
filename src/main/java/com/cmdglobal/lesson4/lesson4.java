package com.cmdglobal.lesson4;

public class lesson4 {
    public static void main(String[] args) {
        Library library = new Library(5);

        Book book1 = new Book("Cho tôi xin một vé đi tuổi thơ", "Nguyễn Nhật Ánh", "12345");
        Book book2 = new Book("Mắt biếc", "Nguyễn Nhật Ánh", "67890");
        Book book3 = new Book("Cô gái đến từ hôm qua", "Nguyễn Nhật Ánh", "11223");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("\nAll Books in Library:");
        library.displayAllBooks();

        System.out.println("\nBorrowing 'Mắt biếc':");
        library.borrowBook("Mắt biếc");

        System.out.println("\nAll Books in Library After Borrowing:");
        library.displayAllBooks();

        System.out.println("\nReturning 'Mắt biếc':");
        library.returnBook("Mắt biếc");

        System.out.println("\nAll Books in Library After Returning:");
        library.displayAllBooks();
    }
}
