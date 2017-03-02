import java.text.DateFormat;
import java.time.LocalDate;

/**
 * Created by Dorota Marszałek on 2017-03-01.
 */
public class Borrow {
    private User user;
    private Book book;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrow(User user, Book book, LocalDate date) {
        this.user = user;
        this.book = book;
    }
}
