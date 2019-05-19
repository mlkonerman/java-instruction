import java.util.List;

public class BookManagerApp {

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        
        List<Book> booksByTitle = BookManager.getBooks( b -> b.getTitle().contains("Java"));
        System.out.println("\nBOOKS BY TITLE:");
        printList(booksByTitle);
        
        List<Book> booksByCategory = BookManager.getBooks(b -> b.getCategory().equals(Book.JAVA));
        System.out.println("\nBOOKS BY CATEGORY:");
        printList(booksByCategory);
        
        List<Book> booksByFormat = BookManager.getBooks(b -> b.getFormat().equals(Book.PAPERBACK));
        System.out.println("\nBOOKS BY FORMAT:");
        printList(booksByFormat);
        
    }
    
    public static void printList(List<Book> bookList) {
        for (Book b : bookList) {
            System.out.println(b);
        }
    }
}