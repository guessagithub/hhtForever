package com.hht.加密.MD5;

import java.security.MessageDigest;

public class MD5_1 {

	public static void main(String[] args) {
		System.out.println(md5("111111"));
	}

	// 十六进制下数字到字符的映射数组
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	public static String md5(String value) {
		String result = "";
		try {
			// 创建具有指定算法名称的信息摘要
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			// 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
			byte[] results = md5.digest(value.getBytes());
			// 将得到的字节数组变成字符串返回
			result = byteArrayToHexString(results);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 轮换字节数组为十六进制字符串
	 * 
	 * @param b字节数组
	 * @return 十六进制字符串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	// 将一个字节转化成十六进制形式的字符串
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

}
