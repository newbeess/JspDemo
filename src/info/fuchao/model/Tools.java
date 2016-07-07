package info.fuchao.model;

/**
 * Created by elephant on 16/7/6.
 */
public class Tools {
	/**
	 * 用于转码，解决乱码问题
	 *
	 * @param input
	 * @return
	 */
	public String getNewString(String input) {
		String result = null;
		try {
			result = new String(input.getBytes("ISO8859_1"), "gb2312");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
