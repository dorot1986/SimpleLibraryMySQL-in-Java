/**
 * Created by Dorota Marszałek on 2017-03-01.
 */
public class User {
    private String name;
    private String surname;
    private int telephoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public User(String name, String surname, int telephoneNumber) {
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
    }

    public User() {
    }
}
