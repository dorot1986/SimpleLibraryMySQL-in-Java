import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dorota Marszałek on 2017-03-01.
 */
public class BookDao {
    private MySQLConnector connect;

    public BookDao() {
        connect = MySQLConnector.getINSTANCE();
    }

    public void addBook(Book book)  {
        String sql = "INSERT INTO book VALUES(?,?,?,?)";
        PreparedStatement state = connect.getPreparedStatement(sql);
        try {
            state.setNull(1, 0);
            state.setString(2, book.getTitle());
            state.setString(3, book.getAuthor());
            state.setInt(4, book.getYearOfPublication());
            state.execute();
            state.isCloseOnCompletion();
            System.out.println("The book has been added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void showAll(){
        Statement state = connect.getStatement();
        ResultSet rs;
        try {
            rs = state.executeQuery("SELECT * FROM book");
            while(rs.next()){
                System.out.println("");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Year of publication: " + rs.getInt("yearOfPublication"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
