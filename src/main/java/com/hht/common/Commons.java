package com.hht.common;

public class Commons {
	
	/**
	 * 获取项目所在的路径
	 * 
	 * @return
	 */
	public static String getProjectPath(){
		return System.getProperty("user.dir");
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(getProjectPath());
	}

}
