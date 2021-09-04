package idv.maxy.maxec.core.util;

import java.util.Arrays;
import java.util.List;

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
	
	/**
	 * 
	 * @param delim
	 * @return
	 */
	public static String[] parseArray(String str, String delim) {
		return str == null ? null : str.split(delim, -1);
	}
	
	/**
	 * 
	 * @param delim
	 * @return
	 */
	public static List<String> parseList(String str, String delim) {
		String[] arr = parseArray(str, delim);
		return arr == null ? null : Arrays.asList(arr);
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Integer parseInt(String str) {
		return str != null && str.matches("\\d+") ? Integer.parseInt(str) : null;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean parseBoolean(String str) {
		return "true".equalsIgnoreCase(str) || "Y".equalsIgnoreCase(str);
	}
	
}
