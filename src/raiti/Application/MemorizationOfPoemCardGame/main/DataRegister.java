package raiti.Application.MemorizationOfPoemCardGame.main;

import raiti.Application.MemorizationOfPoemCardGame.main.Node.PoemData;

import java.util.ArrayList;
import java.util.List;

/**
 * アプリケーション全体のレジスタークラス。<br>
 * このクラスは単一のインスタンを保持します。<br>
 * <br>Created by Raiti-chan on 2016/12/15.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class DataRegister {
	
	/**
	 * このクラス唯一のインスタンス
	 */
	@SuppressWarnings("WeakerAccess")
	public static final DataRegister OUR_INSTANCE = new DataRegister();
	
	/**
	 * 詩のデータを登録します。
	 * @param data 詩データ
	 */
	public static void registerPoem(PoemData data) {
		OUR_INSTANCE.addDataToPoemList(data);
	}
	
	//==================================================================================================================
	
	private List<PoemData> poemList = new ArrayList<>();
	
	private DataRegister() {}
	
	/**
	 * 詩データをリストに追加します。
	 * @param data 詩データ
	 */
	private void addDataToPoemList(PoemData data) {
		poemList.add(data);
	}
	
	private PoemData getDataInPormList(int index) {
		return poemList.get(index);
	}
	
}
