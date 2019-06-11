package com.hht.其他;


public class IP转为整数 {
	
	public static void main(String[] args) {
		

		String ip = "255.255.255.255";
		
		test1(ip);
		
		test2(ip);
		
		
	}
	
	private static void test2(String ip) {
		
		String realBinary = "";
		
		String subIps[] = ip.split("\\.");
		
		for(String subIp : subIps) {
			int value = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(subIp)));
			realBinary = realBinary + String.format("%08d",value);  
		}
		
		System.out.println(Long.parseLong(realBinary, 2));
		
	}
	
	/**
	 * 通过左移位操作（<<）给每一段的数字加权，第一段的权为2的24次方，第二段的权为2的16次方，第三段的权为2的8次方，最后一段的权为1
	 */
	private static void test1(String ip) {
		
		String ips[] = ip.split("\\.");
		
		long val0 = Long.parseLong(ips[0])<<24;
		long val1 = Long.parseLong(ips[1])<<16;
		long val2 = Long.parseLong(ips[2])<<8;
		long val3 = Long.parseLong(ips[3]);
		
		long num = val0 + val1 + val2 + val3;
		
		// 注意位运算的优先级， 一定要用（）包起来
		long num2 = (Long.parseLong(ips[0])<<24)   +   (Long.parseLong(ips[1])<<16)   +   (Long.parseLong(ips[2])<<8)   +   Long.parseLong(ips[3])  ;
		
		System.out.println(num);
		System.out.println(num2);
		
	}
		
		
	
}
