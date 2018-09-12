package dataaccess;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataStorageFactory {

    public static String OUTPUT_DIR = System.getProperty("user.dir") + "\\Library\\src\\dataaccess\\storage\\";

    public static void saveMemebr(LibraryMember libraryMember) {
        try {
            List<LibraryMember> members;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "LibraryMember.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            members = (List<LibraryMember>) ois.readObject();
            members.add(libraryMember);
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + "LibraryMember.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(members);
            oos.close();
            readMember();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readMember() {
        try {
            List<LibraryMember> members;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "LibraryMember.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            members = (List<LibraryMember>) ois.readObject();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            String txt = "Current Members Are: \n";
            for (LibraryMember member : members) {
                txt = txt + member.getFirstName() + "-" + member.getLastName() + "\n";
            }
            alert.setTitle("Success");
            alert.setHeaderText("Member Created");
            alert.setContentText("Successfully created a Library Member\n" + txt);
            alert.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Book getBookByIsnb(String isbn) {
        try {
            List<Book> books;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "Book.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            books = (List<Book>) ois.readObject();
            for (Book book : books) {
                if (book.getIsbn().toLowerCase().equals(isbn.toLowerCase())) {
                    return book;
                }
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Write the Initial Value here
     */
    public static void createInitialData() {
        try {
            //For Library Members
            List<LibraryMember> members = new ArrayList<>();
            LibraryMember member = new LibraryMember();
            member.setMemberId(1L);
            member.setFirstName("Ganbat");
            member.setLastName("Bayar");
            member.setPhoneNumber("123");
            Address add = new Address("1000N 4th Street", "Fairfield", "IA", "52557");
            member.setAddress(add);
            members.add(member);
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + "LibraryMember.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(members);
            oos.close();

            //Add Books
            List<Book> books = new ArrayList<>();
            List<Author> authors = new ArrayList<>();
            Author auth = new Author();
            auth.setFirstName("Ganbat");
            auth.setLastName("Bayar");
            auth.setAddress(add);
            auth.setShortBio("Decent Author");
            auth.setCredentials("Creds");
            authors.add(auth);
            books.add(new Book(UUID.randomUUID().toString(), "978-3-598-21500-1", authors, "How to Live", true));
            books.add(new Book(UUID.randomUUID().toString(), "978-3-598-21500-2", authors, "How to Live 2", true));
            fos = new FileOutputStream(OUTPUT_DIR + "Book.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
