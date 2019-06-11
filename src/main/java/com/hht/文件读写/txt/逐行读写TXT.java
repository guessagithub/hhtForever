package com.hht.文件读写.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.hht.common.Commons;

public class 逐行读写TXT {

    public static void readTxt(String filePath){
        /* 读取数据 */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                String[] strs = lineTxt.split(",");
                System.out.println(strs[0]+" - "+strs[1]+" - "+strs[2]);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
    }
    
    public static void writeTxt(String filePath, List<String> strsList){
		/* 输出数据 */
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath)), "UTF-8"));
			for (String str : strsList) {
				bw.write(str);
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.err.println("write errors :" + e);
		}
    }
    
	public static void main(String[] args) {
		
		String filePathRead = Commons.getProjectPath() + "\\file\\文件读写\\逐行读TXT.txt";
		readTxt(filePathRead);
		
		String filePathWrite = Commons.getProjectPath() + "\\file\\文件读写\\逐行写TXT.txt";
		List<String> strsList = new ArrayList<String>();
		strsList.add("第1行数据");
		strsList.add("第2行数据");
		strsList.add("第3行数据");
		writeTxt(filePathWrite, strsList);
		
	}
	
}
