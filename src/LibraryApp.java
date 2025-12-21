import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LibraryApp {
    private List<Book> books;
    private Scanner scanner;

    public LibraryApp() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n Welcome to Library App!");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    printAllBooks();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    isRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println(books.get(i).toString());
            }
        }
    }

    private void addNewBook() {
        System.out.print("title_: ");
        String title_ = scanner.nextLine();
        System.out.print("author_: ");
        String author_ = scanner.nextLine();
        System.out.print("year_: ");
        int year_ = scanner.nextInt();
        Book newBook = new Book(title_, author_, year_);
        books.add(newBook);
        System.out.println("Book added!");
    }

    private void searchBooks() {
        System.out.print("Enter part of title_ to search: ");
        String search = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            String titleInLower = b.getTitle().toLowerCase();
            if (titleInLower.contains(search)) {
                System.out.println(b.toString());
                found = true;
                if (found == false) {
                    System.out.println("No books found.");
                }
            }
        }
    }

    private void borrowBook() {
        System.out.print("Enter ID: ");
        int idToFind = scanner.nextInt();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getId() == idToFind) {
                if (b.isAvailable()) {
                    b.markAsBorrowed();
                    System.out.println("You took the book.");
                } else {
                    System.out.println("Already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
    private void returnBook() {
        System.out.print("Enter ID: ");
        int idToFind = scanner.nextInt();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getId() == idToFind) {
                b.markAsReturned();
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
    private void deleteBook() {
        System.out.print("Enter ID to delete: ");
        int idToFind = scanner.nextInt();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getId() == idToFind) {
                books.remove(i);
                System.out.println("Deleted.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
