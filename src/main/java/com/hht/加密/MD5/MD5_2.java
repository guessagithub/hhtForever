package com.hht.加密.MD5;

import java.security.MessageDigest;

public class MD5_2 {
	
	public static void main(String[] args) {
		System.out.println(md5("111111"));
	}
	
	
	
	/**
	 * @param str
	 * @param charset
	 * @return
	 */
	public static String md5(String str, String charset) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes(charset));
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return str;
	}
	

	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}

	public static String md5Sign(String content, String signkey) {
		String content4Sign = content + signkey;
		return md5(content4Sign);
	}

}
