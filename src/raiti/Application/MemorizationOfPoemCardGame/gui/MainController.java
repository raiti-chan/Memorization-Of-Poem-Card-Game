package raiti.Application.MemorizationOfPoemCardGame.gui;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import raiti.Application.MemorizationOfPoemCardGame.main.DataRegister;
import raiti.Application.MemorizationOfPoemCardGame.main.Node.PoemData;
import raiti.Application.MemorizationOfPoemCardGame.util.Counter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.net.URISyntaxException;
import java.net.URL;

/**
 * <br>Created by Raiti-chan on 2016/12/14.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class MainController implements Initializable {
	
	/**
	 * 一覧リストのテーブルビュー
	 */
	@FXML
	private TableView<PoemData> allListView;
	
	/**
	 * 各列の要素
	 */
	@FXML
	private TableColumn<PoemData, String> indexCol, upperCol, lowerCol, meaningCol;
	
	@FXML
	private Button testBT;
	
	@SuppressWarnings("deprecation")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setColumnProperty();
		resourceInit();
		
		allListView.setOnSort(event -> {
			
			if (event.getSource().getSortOrder().size() <= 0) {
				indexCol.setSortType(TableColumn.SortType.ASCENDING);
				event.getSource().getSortOrder().add(indexCol);
			}
		});
		
		testBT.setOnAction(event -> allListView.getItems().sorted((o1, o2) -> o1.getIndex() < o2.getIndex() ? -1 : o1.getIndex() == o2.getIndex() ? 0 : 2));
		
	}
	
	
	@SuppressWarnings("deprecation")
	private void setColumnProperty() {
		indexCol.setCellValueFactory(new PropertyValueFactory<>("index"));
		upperCol.setCellValueFactory(new PropertyValueFactory<>("upper"));
		lowerCol.setCellValueFactory(new PropertyValueFactory<>("lower"));
		meaningCol.setCellValueFactory(new PropertyValueFactory<>("meaning"));
		
		indexCol.impl_setReorderable(false);
		upperCol.impl_setReorderable(false);
		lowerCol.impl_setReorderable(false);
		meaningCol.impl_setReorderable(false);
		
		upperCol.setSortType(null);
	}
	
	private void resourceInit() {
		
		ObservableList<PoemData> listViewData = allListView.getItems();
		
		List<String> textList = null;
		try {
			URL resourcesURL = getClass().getClassLoader().getResource("Data.txt");
			assert resourcesURL != null : "リソースファイルが見つかりません";
			String[] strings = resourcesURL.toURI().toString().split("!");
			if (strings.length == 2) {
				FileSystem fileSystem = FileSystems.newFileSystem(URI.create(strings[0]), new HashMap<String, String>());
				textList = Files.readAllLines(fileSystem.getPath(strings[1]));
				fileSystem.close();
			} else {
				textList = Files.readAllLines(Paths.get(resourcesURL.toURI()));
			}
		} catch (IOException | URISyntaxException | AssertionError e) {
			e.printStackTrace();
			System.exit(1);
		}
		Counter counter = new Counter();
		textList.forEach(str -> {
			String[] strings = str.split(",", 3);
			if (strings.length != 3) throw new IllegalArgumentException("文字列が3分割にできません");
			PoemData data = new PoemData(counter.countUp(), strings[0], strings[1], strings[2]);
			listViewData.add(data);
			DataRegister.registerPoem(data);
		});
	}
}


