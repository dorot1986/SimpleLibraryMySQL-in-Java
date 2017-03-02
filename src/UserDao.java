import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by Dorota Marszałek on 2017-03-01.
 */
public class UserDao {
    private MySQLConnector connect;

    public UserDao() {
        connect = MySQLConnector.getINSTANCE();
    }

    public void addUser(User user)  {
        String sql = "INSERT INTO user VALUES(?,?,?,?)";
        PreparedStatement state = connect.getPreparedStatement(sql);
        try {
            state.setNull(1, 0);
            state.setString(2, user.getName());
            state.setString(3, user.getSurname());
            state.setInt(4, user.getTelephoneNumber());
            state.execute();
            state.isCloseOnCompletion();
            System.out.println("The user has been added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUser(int id)  {
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement state = connect.getPreparedStatement(sql);
        try {
            state.setInt(1, id);
            state.execute();
            state.isCloseOnCompletion();
            System.out.println("The user has been removed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(int id)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose data to edit:");
        System.out.println("1. Name");
        System.out.println("2. Surname");
        System.out.println("3. Telephone number");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
            {
                System.out.print("Enter new name: ");
                String name = sc.next();
                String sql = "UPDATE user SET name = '" + name + "' WHERE id=" + id + "";
                PreparedStatement state = connect.getPreparedStatement(sql);
                try {
                    state.execute();
                    state.isCloseOnCompletion();
                    System.out.println("Name has been changed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2:
            {
                System.out.print("Enter new surname: ");
                String surname = sc.next();
                String sql = "UPDATE user SET surname = '" + surname + "' WHERE id=" + id + "";
                PreparedStatement state = connect.getPreparedStatement(sql);
                try {
                    state.execute();
                    state.isCloseOnCompletion();
                    System.out.println("Surname has been changed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3:
            {
                System.out.print("Enter new telephone number: ");
                int telephoneNumber = sc.nextInt();
                String sql = "UPDATE user SET telephoneNumber = '" + telephoneNumber + "' WHERE id=" + id + "";
                PreparedStatement state = connect.getPreparedStatement(sql);
                try {
                    state.execute();
                    state.isCloseOnCompletion();
                    System.out.println("Telephone number has been changed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            default:
            {
                System.out.println("Incorrect data!");
            }
        }
        sc.close();
    }

    public void showAll(){
        Statement state = connect.getStatement();
        ResultSet rs;
        try {
            rs = state.executeQuery("SELECT * FROM user");
            while(rs.next()){
                System.out.println("");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name and surname: " + rs.getString("name") + " " + rs.getString("surname"));
                System.out.println("Telephone number: " + rs.getInt("telephoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
