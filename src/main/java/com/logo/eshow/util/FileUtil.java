package com.logo.eshow.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件Util类
 * 
 * @author leida
 */
public class FileUtil {

	public static final byte[] inputStreamToByte(InputStream is) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff = new byte[8192];
		int rc = 0;
		try {
			while ((rc = is.read(buff, 0, 8192)) != -1) {
				baos.write(buff, 0, rc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return baos.toByteArray();
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @return string
	 */
	public static String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

}