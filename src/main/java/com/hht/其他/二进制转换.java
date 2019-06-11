package com.hht.其他;

/**
 * 此示例是把IP地址转换为整数。  IP地址是由32位二进制分割成四部分，每部分转成整数再用“.”分割
 *
 * 需要考虑的点：替换“.”时要转义， 32位的二进制，Integer.parseInt(binary, 2)报错，超过integer长度
 *
 */

public class 二进制转换 {
	
	public static void main(String[] args) {
		
		String realBinary = "";
		String ip = "255.255.255.255";
		String subIps[] = ip.replaceAll(" ", "").split("\\.");
		
		for(String subIp : subIps) {
			// 方法1  ： 前面补0， 自己写的方法
			//realBinary = realBinary + fillCharLeft(toBinary(subIp), "0", 8);   
			
			// 方法2  ： 前面补0， String自带的方法
			int value = Integer.parseInt(toBinary(subIp));
			realBinary = realBinary + String.format("%08d",value);  
		}
		;
		System.out.println(realBinary);
		System.out.println(toDecimal(realBinary));
		
	}
	
	/**
	 * 十进制转为二进制
	 * 
	 * @param decimal
	 * @return
	 */
	private static String toBinary(String decimal) {
		int decimalInt = Integer.valueOf(decimal);
		return Integer.toBinaryString(decimalInt);
	}

	/**
	 * 二进制转为十进制
	 * 
	 * @param binary
	 * @return
	 */
	private static long toDecimal(String binary) {
		return Long.parseLong(binary, 2);
	}
	
	/**
	 * 左边补充指定字符到指定位数
	 * 
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String fillCharLeft(String str, String ch, int length) {
		String result = str;
		if(str.length() < length) {
			for(int i=0;i<length-str.length();i++) {
				result = ch + result;
			}
		}
		
		return result;
	}

}
