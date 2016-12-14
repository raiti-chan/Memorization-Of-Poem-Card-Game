package raiti.Application.MemorizationOfPoemCardGame.gui;

/**
 * 一覧ビューのデータ構造クラス
 * <br>Created by Raiti-chan on 2016/12/14.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class ListViewData {
	
	
	
	/**
	 * 上の句
	 */
	private String upper;
	
	/**
	 * 下の句
	 */
	private String lower;
	

	/**
	 * 意味
	 */
	private String meaning;
	
	/**
	 * データの作成
	 * @param upper 上の句
	 * @param lower 下の句
	 * @param meaning 意味
	 */
	@SuppressWarnings("WeakerAccess")
	public ListViewData(String upper, String lower, String meaning){
		this.upper = upper;
		this.lower = lower;
		this.meaning = meaning;
		
		
	}
	
	/**
	 * 上の句の取得
	 * @return 上の句
	 */
	public String getUpper() {
		return upper;
	}
	
	/**
	 * 下の句の取得
	 * @return 下の句
	 */
	public String getLower() {
		return lower;
	}
	
	/**
	 * 説明の取得
	 * @return 説明
	 */
	public String getMeaning() {
		return meaning;
	}
	
	/**
	 * 上の句の設定
	 * @param upper 上の句
	 */
	public void setUpper(String upper) {
		this.upper = upper;
	}
	
	/**
	 * 下の句の設定
	 * @param lower 下の句
	 */
	public void setLower(String lower) {
		this.lower = lower;
	}
	
	/**
	 * 説明の設定
	 * @param meaning 説明
	 */
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	
}
