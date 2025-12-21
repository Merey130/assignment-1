public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(12.5, 4.0);
        System.out.println(r1.toString());
        System.out.println("Area: " + r1.area());
        System.out.println("Perimeter: " + r1.perimeter());

        Book Book1 = new Book("My life", "T.Merey", 2008);
        System.out.println( Book1);
        Book1.markAsBorrowed();
        System.out.println("After borrowing: " + Book1.isAvailable());


        LibraryApp myApp = new LibraryApp();
        myApp.run();
        }
    }

