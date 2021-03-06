package business;

import dataaccess.CheckoutEntry;
import dataaccess.DataStorageFactory;
import dataaccess.Memory;
import dataaccess.Role;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class SearchBookWindowController {

    @FXML
    private TextField txtIsbn;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView tbBook;

    @FXML
    private TableColumn<CheckoutEntry, String> IsbnCol;
    @FXML
    private TableColumn<CheckoutEntry, String> bookTitleCol;
    @FXML
    private TableColumn<CheckoutEntry, String> copyNumberCol;
    @FXML
    private TableColumn<CheckoutEntry, String> memberIdCol;
    @FXML
    private TableColumn<CheckoutEntry, String> dueDateCol;
    @FXML
    private TableColumn<CheckoutEntry, String> isDueCol;

    @FXML
    public void onActionHandle(ActionEvent event) {
        String isbn = txtIsbn.getText();

        System.out.println(isbn);
//        CheckoutEntry ce = DataStorageFactory.getCheckoutEntryByIsbn(isbn);
        List<CheckoutEntry> ces = DataStorageFactory.getCheckoutEntryByIsbn(isbn);
//        CheckoutEntry ce = new CheckoutEntry("M001", "11111", "MPP", "C001", "08/15/2018", "08/20/2018");

        IsbnCol.setMinWidth(80);
        IsbnCol.setEditable(false);

        bookTitleCol.setMinWidth(80);
        bookTitleCol.setEditable(false);

        copyNumberCol.setMinWidth(80);
        copyNumberCol.setEditable(false);

        dueDateCol.setMinWidth(80);
        dueDateCol.setEditable(false);

        memberIdCol.setMinWidth(80);
        memberIdCol.setEditable(false);

        isDueCol.setMinWidth(80);
        isDueCol.setEditable(false);

        IsbnCol.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("isbn"));
        bookTitleCol.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("bookTitle"));
        copyNumberCol.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("copyNumber"));
        memberIdCol.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("memberID"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("dueDate"));
        isDueCol.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("isDue"));

        tbBook.setItems(FXCollections.observableArrayList(ces));
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        switch (Memory.getRole()) {
            case LIBRARIAN:
                EventHandler.login(event, this, Role.LIBRARIAN);
                break;
            case BOTH:
                EventHandler.login(event, this, Role.BOTH);
                break;
            case ADMIN:
                EventHandler.login(event, this, Role.ADMIN);
                break;
        }
    }
}
    
