import java.util.List;
import java.util.stream.Collectors;

public class BookManagerApp {

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        
        List<Book> booksByTitle = manager.getBooks(
                b -> b.getTitle().equals("Java Programming"));
        System.out.println("\nBOOKS BY TITLE:");
        //printList(booksByTitle);
        List<String> bookList = books.stream()
        		.map(Book::getTitle)
        		.collect(Collectors.toList());
        bookList.stream()
        		.forEach(System.out::println);

        
        List<Book> booksByCategory = manager.getBooks(
                b -> b.getCategory().equals(Book.JAVA));
        System.out.println("\nBOOKS BY CATEGORY:");
        //printList(booksByCategory);
        List<String> bookList = books.stream()
        		.map(Book::getCategory)
        		.collect(Collectors.toList());
        bookList.stream()
        		.forEach(System.out::println);
        
        List<Book> booksByFormat = manager.getBooks(
                b -> b.getFormat().equals(Book.PAPERBACK));
        System.out.println("\nBOOKS BY FORMAT:");
        printList(booksByFormat);
    }
    
    public static void printList(List<Book> bookList) {
        for (Book b : bookList) {
            System.out.println(b);
        }
    }    
}