import java.util.Scanner;

/**
 * Created by Dorota Marszałek on 2017-03-01.
 */

/*Stwórzmy następujący projekt (połączenie z dowolną bazą danych):
     Projekt powinien symulować działanie biblioteki.
     Zaimplementuj następujące funkcjonalności:
        - dodawanie książek do biblioteki
        - dodawanie osób do biblioteki
        - dodawanie wypożyczeń do biblioteki
        - edycja danych osób w bibliotece
        - wyświetlanie wszystkich książek
        - wyświetlanie wszystkich wypożyczeń
        - wyświetlanie wszystkich osób
        - usuwanie konkretnej osoby*/


public class Main {
    public static void main(String[] args) {
        UserDao uDao = new UserDao();
        BookDao bDao = new BookDao();
        BorrowDao rDao = new BorrowDao();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("------Welcome in Simple MySQL Library v1.0!------");
        System.out.println();
        System.out.println("Choose option:");
        System.out.println();
        System.out.println("	______USERS______");
        System.out.println("1. Add new user");
        System.out.println("2. Edit user data");
        System.out.println("3. Remove user");
        System.out.println("4. Show all users");
        System.out.println("	______BOOKS______");
        System.out.println("5. Add new book");
        System.out.println("6. Show all books");
        System.out.println("	______BORROWS______");
        System.out.println("7. Add new borrow");
        System.out.println("8. Show all borrows");
        int choose = sc.nextInt();
        switch (choose){
            case 1:{
                //addUser
                User u = new User();
                sc.nextLine();
                System.out.print("Enter name: ");
                u.setName(sc.nextLine());
                System.out.print("Enter surname: ");
                u.setSurname(sc.nextLine());
                System.out.print("Enter telephone number: ");
                u.setTelephoneNumber(sc.nextInt());
                uDao.addUser(u);
                break;
            }
            case 2: {
                //editUser
                System.out.print("Enter user ID: ");
                uDao.editUser(sc.nextInt());
                break;
            }
            case 3: {
                //removeUser
                System.out.print("Enter user ID: ");
                uDao.removeUser(sc.nextInt());
                break;
            }
            case 4: {
                //showAllUsers
                uDao.showAll();
                break;
            }
            case 5: {
                //addBook
                Book b = new Book();
                sc.nextLine();
                System.out.print("Enter author: ");
                b.setAuthor(sc.nextLine());
                System.out.print("Enter title: ");
                b.setTitle(sc.nextLine());
                System.out.print("Enter year of publication: ");
                b.setYearOfPublication(sc.nextInt());
                bDao.addBook(b);
                break;
            }
            case 6: {
                //showAllBooks
                bDao.showAll();
                break;
            }
            case 7: {
                //addRent
                System.out.print("Enter user ID: ");
                int userId = sc.nextInt();
                System.out.print("Enter book ID: ");
                int bookId = sc.nextInt();
                rDao.addBorrow(userId, bookId);
                break;
            }
            case 8: {
                //showAllRents
                rDao.showAll();
                break;
            }
            default: {
                System.out.println("Incorrect data!");
            }
        }
        sc.close();

    }
}
