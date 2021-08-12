package idv.maxy.maxec.core.util;

/**
 * 
 * @author Max Chen
 *
 */
public class StringUtil {

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyOrNull(String str) {
		return str == null || str.matches("^\\s*$");
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmptyOrNull(String str) {
		return !isEmptyOrNull(str);
	}
	
}
