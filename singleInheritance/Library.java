package singleInheritance;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class LibraryBook extends Book {
    private boolean isAvailable = true;

    public LibraryBook(String title, String author) {
        super(title, author);
    }

    public void borrowBook() {
        if (isAvailable) {
            System.out.println("Book borrowed successfully");
            isAvailable = false;
        } else {
            System.out.println("Book is already borrowed");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned successfully");
    }

    public void checkAvailability() {
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

public class Library {
    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Java Programming", "John Doe");

        book.displayBook();
        book.checkAvailability();
        book.borrowBook();
        book.checkAvailability();
        book.returnBook();
        book.checkAvailability();
    }
}
