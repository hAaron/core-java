package com.aaron.util.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

/**
 * 图片处理工具类-等比例缩放
 * 
 * @author Aaron
 * @date 2017年8月16日
 * @version 1.0
 * @package_name com.aaron.util.image
 */
public class ImageUtil {

	/**
	 * 按照 宽高 比例压缩
	 * 
	 * @param img
	 * @param width
	 * @param height
	 * @param out
	 * @throws IOException
	 */
	public static void thumbnail_w_h(File img, int width, int height, OutputStream out) throws IOException {
		BufferedImage bi = ImageIO.read(img);
		// 源图宽度
		double srcWidth = bi.getWidth();
		// 源图高度
		double srcHeight = bi.getHeight();

		double scale = 1;

		if (width > 0) {
			scale = width / srcWidth;
		}
		if (height > 0) {
			scale = height / srcHeight;
		}
		if (width > 0 && height > 0) {
			scale = height / srcHeight < width / srcWidth ? height / srcHeight : width / srcWidth;
		}

		thumbnail(img, (int) (srcWidth * scale), (int) (srcHeight * scale), out);

	}

	/**
	 * 按照固定宽高原图压缩
	 * 
	 * @param img
	 * @param width
	 * @param height
	 * @param out
	 * @throws IOException
	 */
	public static void thumbnail(File img, int width, int height, OutputStream out) throws IOException {
		BufferedImage BI = ImageIO.read(img);
		Image image = BI.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = tag.getGraphics();
		g.setColor(Color.RED);
		g.drawImage(image, 0, 0, null); // 绘制处理后的图
		g.dispose();
		ImageIO.write(tag, "JPEG", out);
	}

	// **********************************************************************************************//
	// **********************************************************************************************//
	// **********************************************************************************************//
	/**
	 * 按照宽高裁剪
	 * 
	 * @param srcImageFile
	 * @param destWidth
	 * @param destHeight
	 * @param out
	 */
	public static void cut_w_h(File srcImageFile, int destWidth, int destHeight, OutputStream out) {
		cut_w_h(srcImageFile, 0, 0, destWidth, destHeight, out);
	}

	public static void cut_w_h(File srcImageFile, int x, int y, int destWidth, int destHeight, OutputStream out) {
		try {
			Image img;
			ImageFilter cropFilter;
			// 读取源图像
			BufferedImage bi = ImageIO.read(srcImageFile);
			int srcWidth = bi.getWidth(); // 源图宽度
			int srcHeight = bi.getHeight(); // 源图高度

			if (srcWidth >= destWidth && srcHeight >= destHeight) {
				Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);

				cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
				img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				g.drawImage(img, 0, 0, null); // 绘制截取后的图
				g.dispose();
				// 输出为文件
				ImageIO.write(tag, "JPEG", out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// #cut_w_h

	// **********************************************************************************************//
	// **********************************************************************************************//
	// **********************************************************************************************//

	/**
	 * 裁剪PNG图片工具类
	 * 
	 * @param fromFile
	 *            源文件
	 * @param toFile
	 *            裁剪后的文件
	 * @param outputWidth
	 *            裁剪宽度
	 * @param outputHeight
	 *            裁剪高度
	 * @param proportion
	 *            是否是等比缩放
	 */
	public static void resizePng(File fromFile, File toFile, int outputWidth, int outputHeight, boolean proportion) {
		try {
			BufferedImage bi2 = ImageIO.read(fromFile);
			int newWidth;
			int newHeight;
			// 判断是否是等比缩放
			if (proportion) {
				// 为等比缩放计算输出的图片宽度及高度
				double rate1 = ((double) bi2.getWidth(null)) / (double) outputWidth + 0.1;
				double rate2 = ((double) bi2.getHeight(null)) / (double) outputHeight + 0.1;
				// 根据缩放比率大的进行缩放控制
				double rate = rate1 < rate2 ? rate1 : rate2;
				newWidth = (int) (((double) bi2.getWidth(null)) / rate);
				newHeight = (int) (((double) bi2.getHeight(null)) / rate);
			} else {
				newWidth = outputWidth; // 输出的图片宽度
				newHeight = outputHeight; // 输出的图片高度
			}
			BufferedImage to = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = to.createGraphics();
			to = g2d.getDeviceConfiguration().createCompatibleImage(newWidth, newHeight, Transparency.TRANSLUCENT);
			g2d.dispose();
			g2d = to.createGraphics();
			@SuppressWarnings("static-access")
			Image from = bi2.getScaledInstance(newWidth, newHeight, bi2.SCALE_AREA_AVERAGING);
			g2d.drawImage(from, 0, 0, null);
			g2d.dispose();
			ImageIO.write(to, "png", toFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **********************************************************************************************//
	// **********************************************************************************************//
	// **********************************************************************************************//

	/**
	 * 循环文件夹下的文件
	 * 
	 * @param path
	 * @throws Exception
	 */
	private static void getFile(String path) throws Exception {
		File file = new File(path);
		File[] array = file.listFiles();
		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				// System.out.println("#####" + array[i]);
				// 把当前目录的图片替换掉
				compressPic(array[i].getPath(), array[i].getPath());
			} else if (array[i].isDirectory()) {
				getFile(array[i].getPath());
			}
		}
	}

	/**
	 * 图片压缩，大小保持不变
	 * 
	 */
	@SuppressWarnings("static-access")
	public static boolean compressPic(String srcFilePath, String descFilePath) throws IOException {
		File file = null;
		BufferedImage src = null;
		FileOutputStream out = null;
		ImageWriter imgWrier;
		ImageWriteParam imgWriteParams;
		// 指定写图片的方式为 jpg
		imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
		// 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
		imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);
		// 这里指定压缩的程度，参数qality是取值0~1范围内，
		imgWriteParams.setCompressionQuality((float) 0.7);
		imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);
		ColorModel colorModel = ImageIO.read(new File(srcFilePath)).getColorModel();// ColorModel.getRGBdefault();
		// 指定压缩时使用的色彩模式
		// imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(
		// colorModel, colorModel.createCompatibleSampleModel(16, 16)));
		imgWriteParams.setDestinationType(
				new javax.imageio.ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));

		try {
			if (isBlank(srcFilePath)) {
				return false;
			} else {
				file = new File(srcFilePath);
				// System.out.println(file.length());
				src = ImageIO.read(file);
				out = new FileOutputStream(descFilePath);

				imgWrier.reset();
				// 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何
				// OutputStream构造
				imgWrier.setOutput(ImageIO.createImageOutputStream(out));
				// 调用write方法，就可以向输入流写图片
				imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean isBlank(String string) {
		if (string == null || string.length() == 0 || string.trim().equals("")) {
			return true;
		}
		return false;
	}
	// **********************************************************************************************//
	// **********************************************************************************************//
	// **********************************************************************************************//

	public static void main(String[] args) throws Exception {
		File img = new File("e:\\temp\\yasuo1.jpg");
		System.out.println(img.length());
		FileOutputStream fos = new FileOutputStream("e:\\temp\\yasuo2.jpg");
		ImageUtil.thumbnail(img, 170, 107, fos);
		// ImageUtil.cut_w_h(img, 230, 200, fos);
		// ImageUtil.thumbnail_w_h(img, 170, 107, fos);
		// img.delete();
		img = new File("e:\\temp\\yasuo2.jpg");
		System.out.println(img.length());
		// **********************************************************************************************//

		File fromFile = new File("C:\\Users\\DELL\\Desktop\\pic\\03010000_01_1.png");
		File toFile = new File("C:\\Users\\DELL\\Desktop\\pic\\test.png");
		resizePng(fromFile, toFile, 300, 250, true);

		// **********************************************************************************************//

		String path = "C:\\Users\\DELL\\Desktop\\pic";
		getFile(path);
		// String pString = "C:\\Users\\DELL\\Desktop\\picc\\03010000_01_1.png";
		// String p2String = "C:\\Users\\DELL\\Desktop\\picc\\03010000_01_1.png";
		// compressPic(pString,p2String);

		// **********************************************************************************************//

	}

}