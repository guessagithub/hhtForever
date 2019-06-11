package com.hht.文件读写.PDF.PDF按页生成图片;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import com.hht.common.Commons;
import com.hht.common.UtilFile;
import com.hht.common.UtilsPrint;

/**
 * 
 * 需要引入包：pdfbox-app-2.0.0-RC3.jar
 * 
 */
public class CreateImgFromPDF {

	// 获取项目根路径
	static String rootPath = Commons.getProjectPath();
	// 原始PDF文件路径
	static String pdfPath = rootPath + "\\示例文件\\文件读写\\PDF\\PDF按页生成图片\\小牛普惠分期咨询服务协议(普惠与借款人）.pdf";
	// 图片存放路径
	static String imgsPath = rootPath + "\\示例文件\\文件读写\\PDF\\PDF按页生成图片\\";
	// 文件名
	static String fileName = "小牛普惠分期咨询服务协议(普惠与借款人）";

	public static void main(String[] args) {
		List<String> imgs = pdfToImgs(pdfPath);
		UtilsPrint.printList(imgs);
	}

	private static List<String> pdfToImgs(String pdfPath) {
		List<String> imgs = new ArrayList<String>();
		// PDF转成图片清晰度
		int pdfToImgDpi = 512;
		int pageCount = 0;
		PDDocument document = null;
		try {
			document = PDDocument.load(UtilFile.toByteArray(pdfPath));
			ImageType imageType = ImageType.RGB;
			pageCount = document.getNumberOfPages();
			PDFRenderer renderer = new PDFRenderer(document);
			for (int i = 0; i < pageCount; i++) { // 依次处理PDF的每一页
				BufferedImage image = renderer.renderImageWithDPI(i, pdfToImgDpi, imageType);
				String file = fileName + "_" + i + ".png";
				ImageIOUtil.writeImage(image, imgsPath + file, pdfToImgDpi);
				imgs.add(imgsPath + file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (document != null) {
				try {
					document.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		return imgs;
	}

}
