package idv.maxy.maxec.core.util;

import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	
	/**
	 * 
	 * @param in
	 * @param out
	 * @throws Exception
	 */
	public static void copy(InputStream in, OutputStream out) throws Exception {
		byte[] buf = new byte[40960];
		while(true) {
			int r = in.read(buf);
			if(r < 0) { break; }
			out.write(buf, 0, r);
		}
	}
	
	
}
