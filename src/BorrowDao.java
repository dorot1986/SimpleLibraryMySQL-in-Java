import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dorota Marszałek on 2017-03-01.
 */
public class BorrowDao {
    private MySQLConnector connect;

    public BorrowDao() {
        connect = MySQLConnector.getINSTANCE();
    }

    public void addBorrow(int userId, int bookId)  {
        String sql = "INSERT INTO borrow VALUES(?,?,?,?)";
        PreparedStatement state = connect.getPreparedStatement(sql);
        try {
            state.setNull(1, 0);
            state.setInt(2, userId);
            state.setInt(3, bookId);
            state.setNull(4, 0);
            state.execute();
            state.isCloseOnCompletion();
            System.out.println("The borrow has been added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAll(){
        Statement state = connect.getStatement();
        ResultSet rs;
        try {
            rs = state.executeQuery("SELECT * FROM borrow");
            while(rs.next()){
                System.out.println("");
                System.out.println("User ID: " + rs.getInt("user"));
                System.out.println("Book ID: " + rs.getInt("book"));
                System.out.println("Date of borrow: " + rs.getDate("date"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
