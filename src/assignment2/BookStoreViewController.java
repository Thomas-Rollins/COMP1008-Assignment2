/**
 * INTRO TO OOP - WINTER 2017
 * ASSIGNMENT TWO
 * BOOKSTORE CONTROLLER CLASS
 */
package assignment2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thomas Rollins
 */
public class BookStoreViewController implements Initializable {
    
    @FXML private TableView<BookShelf> tableView;
    @FXML private TableColumn<BookShelf, Integer> capacityColumn;
    @FXML private TableColumn<BookShelf, String> genresColumn;
    @FXML private TableColumn<BookShelf, String> authorsColumn;
    @FXML private TableColumn<BookShelf, Integer> shelfColumnsColumn;
    @FXML private TableColumn<BookShelf, Integer> booksPerRowColumn;
    
    @FXML private TextField numberOfColumnsTextField;
    @FXML private TextField booksPerRowTextField;
    
    @FXML private Button deleteButton;
    @FXML private Button selectButton;
    
    private static final int STORE_SIZE = 100;
    protected static BookStore bookStore = new BookStore(STORE_SIZE);
    

    /**
     * changes scene back to bookshelf view
     * @param event
     * @throws IOException 
     */
    public void changeSceneToBookShelfView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookShelfView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        BookshelfViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //static value
        
        shelfColumnsColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, Integer> ("maxColumns"));
        booksPerRowColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, Integer> ("maxRows"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, Integer> ("totalCapacity"));
        authorsColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, String> ("authorListRangeOnShelf"));
        genresColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, String> ("shelfGenre"));
        
         tableView.setItems(getShelves());        
    }
    
    /**
     * creates table elements
     * @return 
     */
    public ObservableList<BookShelf> getShelves()
    {
        ArrayList<BookShelf> bookShelvesList = bookStore.getBookShelves();
        ObservableList<BookShelf> bookShelves = FXCollections.observableArrayList(bookShelvesList);
        
        return bookShelves;
    }
    
    /**
     * removes a shelf
     */
    public void deleteButtonPushed()
    {
        ObservableList<BookShelf> selectedRows, allShelves;
        allShelves = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for (BookShelf bookShelf : selectedRows)
        {
            allShelves.remove(bookShelf);
            bookStore.getBookShelves().remove(bookShelf);
        }
    }
    
    /**
     * adds a new shelf
     */
    public void newShelfButtonPushed()
    {
       int numOfColumns = Integer.parseInt(numberOfColumnsTextField.getText());
       int booksPerRowInt = Integer.parseInt(booksPerRowTextField.getText());
        
        BookShelf newBookShelf = new BookShelf(numOfColumns, booksPerRowInt);
        bookStore.addShelf(newBookShelf);
        
        tableView.getItems().add(newBookShelf);
        numberOfColumnsTextField.clear();
        booksPerRowTextField.clear();
    }
    
    /**
     * initialize method for returns
     * @param bookStore 
     */
    public void initData(BookStore bookStore)
    {
        
        shelfColumnsColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, Integer> ("maxColumns"));
        booksPerRowColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, Integer> ("maxRows"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, Integer> ("totalCapacity"));
        authorsColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, String> ("authorListRangeOnShelf"));
        genresColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, String> ("shelfGenre"));
        
        tableView.setItems(getShelves());
    }
    
    /**
     * unlocks buttons when table has a selected element
     */
    public void userClickedOnTable()
    {
        this.deleteButton.setDisable(false);
        this.selectButton.setDisable(false);
    }
    
}
