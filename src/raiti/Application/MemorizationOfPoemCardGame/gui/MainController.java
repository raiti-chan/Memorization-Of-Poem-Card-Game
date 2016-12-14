package raiti.Application.MemorizationOfPoemCardGame.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * <br>Created by Raiti-chan on 2016/12/14.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class MainController implements Initializable{
	
	/**
	 * 一覧リストのテーブルビュー
	 */
	@FXML
	private TableView<ListViewData> allListView;
	
	/**
	 * 各列の要素
	 */
	@FXML
	private TableColumn<ListViewData, String> upperCol, lowerCol, meaningCol;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		upperCol.setCellValueFactory(new PropertyValueFactory<>("upper"));
		lowerCol.setCellValueFactory(new PropertyValueFactory<>("lower"));
		meaningCol.setCellValueFactory(new PropertyValueFactory<>("meaning"));
		
		ObservableList<ListViewData> listViewData = allListView.getItems();
		listViewData.add(new ListViewData("あああ", "いいい", "ううう"));
		listViewData.add(new ListViewData("かかか", "ききき", "くくく"));
		listViewData.add(new ListViewData("さささ", "ししし", "すすす"));
	}
}
