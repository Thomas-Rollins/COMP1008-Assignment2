/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thomas Rollins
 */
public class BookStoreViewController implements Initializable {
    
    @FXML private TableView<BookShelf> tableView;
    @FXML private TableColumn<BookShelf, Integer> shelfNumberColumn;
    @FXML private TableColumn<BookShelf, Integer> capacityColumn;
    @FXML private TableColumn<BookShelf, String> genresColumn;
    @FXML private TableColumn<BookShelf, String> authorsColumn;
    @FXML private TableColumn<BookShelf, Integer> shelfColumnsColumn;
    @FXML private TableColumn<BookShelf, Integer> booksPerRowColumn;
    
    @FXML private TextField numberOfColumnsTextField;
    @FXML private TextField booksPerRowTextField;
    
    BookStore bookStore;

    
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
        
        bookStore = new BookStore(10);
        shelfColumnsColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, Integer> ("maxColumns"));
        booksPerRowColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, Integer> ("maxRows"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, Integer> ("totalCapacity"));
        authorsColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, String> ("authorListRangeOnShelf"));
        genresColumn.setCellValueFactory(new PropertyValueFactory<BookShelf, String> ("shelfGenre"));
        
        
        
          
        
        tableView.setItems(getShelves());        
    }
    
    public ObservableList<BookShelf> getShelves()
    {
        ObservableList<BookShelf> bookShelves = FXCollections.observableArrayList();
        
        return bookShelves;
    }
    
    public void deleteButtonPushed()
    {
        ObservableList<BookShelf> selectedRows, allShelves;
        allShelves = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for (BookShelf bookShelf : selectedRows)
        {
            allShelves.remove(bookShelf);
        }
    }
    
    public void newShelfButtonPushed()
    {
       int numOfColumns = Integer.parseInt(numberOfColumnsTextField.getText());
       int booksPerRowInt = Integer.parseInt(booksPerRowTextField.getText());
        
        BookShelf newBookShelf = new BookShelf(numOfColumns, booksPerRowInt);
        bookStore.addShelf(newBookShelf);
        
        tableView.getItems().add(newBookShelf);
    }
    
}
