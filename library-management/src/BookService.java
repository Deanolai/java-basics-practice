import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public boolean removeByIsbn(String isbn){
        for(int i = 0; i < books.size(); i++){
            Book b = books.get(i);
            if(b.getIsbn().equals(isbn)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public Book findByIsbn(String isbn){
        for(int i = 0; i < books.size(); i++){
            Book b = books.get(i);
            if(b.getIsbn().equals(isbn)){
                return b;
            }
        }
        return null;
    }

    public List<Book> findByCategory(String category){
        List<Book> result = new ArrayList<>();
        for(int i = 0; i < books.size(); i++){
            Book b = books.get(i);
            if(b.getCategory().equals(category)){
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> findAvailableBooks(){
        List<Book> result = new ArrayList<>();
        for(int i = 0; i < books.size(); i++){
            Book b = books.get(i);
            if(!b.isBorrowed()){
                result.add(b);
            }
        }
        return result;
    }


    public void printAll(){
        for(int i = 0; i < books.size(); i++){
            Book b = books.get(i);
            System.out.println(b);
        }
    }

}