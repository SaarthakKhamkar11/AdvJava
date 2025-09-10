import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", ISBN='" + isbn + '\'' +
                '}';
    }
}

class Library {
    private ArrayList<Book> collection;

    public Library() {
        collection = new ArrayList<>();
    }

    public void addBook(Book book) {
        collection.add(book);
        System.out.println("Added: " + book.getTitle());
    }

    public boolean removeBookByIsbn(String isbn) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getIsbn().equals(isbn)) {
                collection.remove(i);
                System.out.println("Removed book with ISBN: " + isbn);
                return true;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
        return false;
    }

    public void displayBooks() {
        if (collection.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            System.out.println("Library Collection:");
            for (Book book : collection) {
                System.out.println(book);
            }
        }
    }
}

public class exp3a1 {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "1234567890"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "0987654321"));
        library.addBook(new Book("1984", "George Orwell", "1122334455"));

        library.displayBooks();

        library.removeBookByIsbn("0987654321");

        library.displayBooks();
    }
}
