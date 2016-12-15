package raiti.Application.MemorizationOfPoemCardGame.util;

/**
 * カウンタークラスです。
 * lambdaでのループカウンターなど
 * <br>Created by Raiti-chan on 2016/12/15.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class Counter {
	
	/**
	 * 現在のカウント値
	 */
	private volatile int count = 0;
	
	/**
	 * 初期値を指定してカウンターを生成します。
	 *
	 * @param initialValue 初期値
	 */
	@SuppressWarnings("WeakerAccess")
	public Counter(int initialValue) {
		count = initialValue;
	}
	
	/**
	 * 初期値0でカウンターを生成します。
	 */
	public Counter() {
		this(0);
	}
	
	/**
	 * 値を加算します
	 * @param addValue 加算する値
	 * @return 加算される前の値
	 */
	@SuppressWarnings("WeakerAccess")
	public int addition(int addValue) {
		int retInt = count;
		count += addValue;
		return retInt;
	}
	
	/**
	 * カウンターを+1します
	 *
	 * @return 足す前の値
	 */
	public int countUp() {
		return addition(1);
	}
	
	/**
	 * カウンターを-1します
	 * @return 引く前の値
	 */
	public int countDown() {
		return addition(-1);
	}
	
	/**
	 * 現在のカウンターの値を取得します。
	 * @return 現在のカウンターの値。
	 */
	public int getCount() {
		return count;
	}
}
