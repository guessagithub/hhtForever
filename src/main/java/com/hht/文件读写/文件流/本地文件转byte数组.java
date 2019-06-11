package com.hht.文件读写.文件流;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.hht.common.Commons;

public class 本地文件转byte数组 {

	public static void main(String[] args) {
		
		// 文件路径
		String filePath = Commons.getProjectPath() + "\\示例文件\\文件读取\\文件流\\本地文件转byte数组.txt";
		
		byte[] data = method1(filePath);
		
		System.out.println(data);
		
	}

	private static byte[] method1(String filePath) {
		InputStream in = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			in = new FileInputStream(filePath);
			byte[] buffer = new byte[1024 * 4];
			int n = 0;
			while ((n = in.read(buffer)) != -1) {
				out.write(buffer, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return out.toByteArray();
	}

}
