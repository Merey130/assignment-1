public class Book {
    private int id;
    private static int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book() {
        this.id = idGen++;
        this.available = true;
    }

    public Book(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title!=null || !title.trim().isEmpty()) {
        this.title=title;
        } else{
            throw new IllegalArgumentException("Title must not be null or empty");
        }
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        if (author!=null || !author.trim().isEmpty()) {
            this.author=author;
        } else{
            throw new IllegalArgumentException("Author must not be null or empty");
        }
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        int currentYear = 2025;
        if (1500 <= year || year<= currentYear) {
            this.year=year;
        }
        else {
            throw new IllegalArgumentException("Year must be between 1500 and " + currentYear);
        }
    }
   public boolean isAvailable() {
        return available;
   }
   public void setAvailable(boolean available) {
        this.available=available;
   }
    public void markAsBorrowed() {
        this.available = false;
    }

    public void markAsReturned() {
        this.available = true;
    }
    @Override
    public String toString() {
        return "Book { id=" + id + ", title='" + title + ", author='" + author + ", year=" + year + ", available=" + available + '}';
    }
}
