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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
		textList.forEach(str -> {
			String[] strings = str.split(",",3);
			if (strings.length != 3) throw new IllegalArgumentException("文字列が3分割にできません");
			listViewData.add(new ListViewData(strings[0], strings[1], strings[2]));
		});
		
	}
}
