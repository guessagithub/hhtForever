package com.hht.文件读写.PDF.PDF表单填充;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.hht.common.Commons;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * 
 * 需要引入包：itextpdf-5.5.13.1.jar 、 itextpdf-5.5.13.1.jar
 * 
 */
public class FillForm {

	private static final String property_font_type = "textfont";
	private static final String property_font_size = "textsize";
	private static final String property_font_color = "textcolor";
	
	private static final float fontSize = 10f;

	// 获取项目根路径
	static String rootPath = Commons.getProjectPath();
	// 原始PDF文件路径
	static String pdfPath = rootPath + "\\示例文件\\文件读写\\PDF\\PDF表单填充\\PDF表单填充模板.pdf";
	// 存放路径
	static String dirPath = rootPath + "\\示例文件\\文件读写\\PDF\\PDF表单填充\\";
	// 文件名
	static String fileName = "PDF表单填充-处理后的";
	
	public static void main(String[] args) throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("year", "2019");
		params.put("month", "12");
		params.put("day", "31");
		
		fillPDF(params);
	}
	
	
	private static void fillPDF(Map<String, String> params) throws Exception {
		//创建处理后的文件存放路径
		File dir = new File(dirPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		// 处理后的文件
		File newPDF = new File(dirPath + fileName + ".pdf");
		FileOutputStream fileOut = new java.io.FileOutputStream(newPDF, true);
		fileOut.close();

		PdfReader reader = new PdfReader(pdfPath);
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(newPDF));
		AcroFields form = stamper.getAcroFields();
		BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		
		Set<Entry<String, String>> entries = params.entrySet();
		for (Entry<String, String> entry : entries) {
			form.setFieldProperty(entry.getKey(), property_font_type, baseFont, null); // set the font type
			form.setFieldProperty(entry.getKey(), property_font_size, fontSize, null); // set font size to 11, this is a float value
			form.setFieldProperty(entry.getKey(), property_font_color, BaseColor.BLACK, null); // set the font color to be black
			// form.setFieldProperty(entry.getKey(), property_bg_color, BaseColor.WHITE,
			// null); // set the background color to be white
			form.setField(entry.getKey(), entry.getValue());
		}
		stamper.setFormFlattening(true);
		stamper.close();
	}
	
}
