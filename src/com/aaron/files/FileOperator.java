package com.aaron.files;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;

/**
 * 操作文件工具
 * 
 * @author Aaron
 * @date 2017年6月3日
 * @version 1.0
 * @package_name com.aaron.files
 */
public class FileOperator {

	private static final String FILE_PATH = "E:" + File.separator + "temp";

	/**
	 * 创建一个新的文件 在用 \\ 时使用File.separator 表示获取当前系统下的\\ Linux 和 windows 不同
	 * 
	 * @throws IOException
	 */
	public static void createFile() throws IOException {
		String fileName = FILE_PATH + File.separator + "myfile.txt";
		File file = new File(fileName);
		// System.out.println(File.separator);
		// System.out.println(File.pathSeparator);
		file.createNewFile();
	}

	/**
	 * 删除一个文件
	 * 
	 * @throws IOException
	 */
	public static void deleteFile() throws IOException {
		String fileName = FILE_PATH + File.separator + "myfile.txt";
		File file = new File(fileName);
		file.delete();
	}

	/**
	 * 创建一个文件夹
	 */
	public static void createDir() {
		String pathname = FILE_PATH + File.separator + "myFile";
		File file = new File(pathname);
		file.mkdir();
	}

	/**
	 * 列出指定目录的全部文件（包括隐藏文件）,使用list列出指定目录的全部文件 listFiles输出的是完整路径
	 */
	public static void listFiles() {
		String fileName = FILE_PATH;
		File file = new File(fileName);
		String[] fileList = file.list();
		for (int i = 0; i < fileList.length; i++) {
			System.out.println(fileList[i]);
		}
		// listFiles输出的是完整路径
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			System.out.println(listFiles[i]);
		}
	}

	/**
	 * 判断一个指定的路径是否为目录
	 */
	public static void isDirectory() {
		String fileName = FILE_PATH + File.separator + "myFile";
		File file = new File(fileName);
		if (file.isDirectory()) {
			System.out.println("该文件为目录");
		} else {
			System.out.println("该文件不是目录");
		}
	}

	/**
	 * 搜索指定目录的全部内容
	 */
	public static void listFilesByCondition() {
		// 列出指定目录的全部内容
		String fileName = FILE_PATH;// + File.separator + "jar";
		File file = new File(fileName);
		print(file);
	}

	public static void print(File f) {
		if (f != null) {
			if (f.isDirectory()) {
				File[] fileArray = f.listFiles();
				if (fileArray != null) {
					for (int i = 0; i < fileArray.length; i++) {
						// 递归调用
						print(fileArray[i]);
					}
				}
			} else {
				System.out.println(f);
			}
		}
	}

	/**
	 * 使用RandomAccessFile写入文件
	 */
	public static void byRandomAccessFile() {
		String fileName = FILE_PATH + File.separator + "myfile.txt";
		File f = new File(fileName);
		try {
			RandomAccessFile demo = new RandomAccessFile(f, "rw");
			demo.writeBytes("asdsad");
			demo.writeInt(12);
			demo.writeBoolean(true);
			demo.writeChar('A');
			demo.writeFloat(1.21f);
			demo.writeDouble(12.123);
			demo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 字节流 向文件中写入字符串
	 */
	public static void ziJieLiu() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		try {
			OutputStream outputStream = new FileOutputStream(file);
			String str = "你好";
			byte[] b = new byte[1024];
			b = str.getBytes();
			outputStream.write(b);
			// ///////////////////
			// 一个一个字节写入
			// for (int i = 0; i < b.length; i++) {
			// outputStream.write(b[i]);
			// }
			// ////////////////////
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向文件中追加内容。FileOutputStream(file,true); 设为true表示支持追加写。
	 */
	public static void zhuiJiaXie() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		try {
			OutputStream out = new FileOutputStream(file, true);
			String str = "Rollen";
			// String str="\r\nRollen"; 可以换行
			byte[] b = str.getBytes();
			for (int i = 0; i < b.length; i++) {
				out.write(b[i]);
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 字节流 读文件内容,节省空间
	 */
	public static void readInputStream() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		try {
			byte[] b = new byte[(int) file.length()];
			InputStream inputStream = new FileInputStream(file);
			int ch = inputStream.read(b);
			System.out.println(new String(b)); // 会出现大量的空格
			// //////////////
			// 一个一个字节读
			// for (int i = 0; i < b.length; i++) {
			// System.out.print((b[i]));
			// }
			// //////////////
			System.out.println("写入的文件的长度为: " + ch);
			System.out.println("截取字符串：" + new String(b, 0, ch));
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在未知文件长度的情况下读取文件内容 以上读取文件内容都是在知道文件的内容多大，然后才展开的，有时候我们不知道文件有多大，
	 * 这种情况下，我们需要判断是否独到文件的末尾。 当读到文件末尾的时候会返回-1.正常情况下是不会返回-1的
	 */
	public static void chekcByEnd() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		try {
			InputStream inputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			int ch = 0;
			int count = 0;
			while ((ch = inputStream.read()) != -1) {
				b[count++] = (byte) ch;
			}
			inputStream.read(b);
			System.out.println(new String(b, 0, count));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 字符流 写入数据 （write读）
	 */
	public static void writerOut() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		try {
			Writer writer = new FileWriter(file, true);
			String str = "\r\nasdfasdfasdfsadfhh呵呵";
			writer.write(str);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 字符流 从文件中读内容（read）
	 */
	public static void readIn() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		char[] ch = new char[100];
		int count;
		try {
			Reader read = new FileReader(file);
			count = read.read(ch);
			System.out.println("读入的长度为：" + count);
			System.out.println("内容为\r" + new String(ch, 0, count));
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 当然最好采用循环读取的方式，因为我们有时候不知道文件到底有多大。 循环读文件内容
	 */
	public static void xunHuanRead() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		try {
			Reader read = new FileReader(file);
			char[] ch = new char[100];
			int count = 0;
			int temp = 0;
			while ((temp = read.read()) != -1) {
				ch[count++] = (char) temp;
			}
			System.out.println("读入的长度为：" + count);
			System.out.println("内容为" + new String(ch, 0, count));
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文件复制 从一个文件中读入内容，边读边写入另一个文件
	 * 
	 * @param args
	 */
	public static void copyFile(String source, String target) {
		if (source == null || target == null) {
			System.out.println("命令行参数输入有误，请检查");
			System.exit(1);
		}
		File file1 = new File(source);
		File file2 = new File(target);
		if (!file1.exists()) {
			System.out.println("被复制的文件不存在");
			System.exit(1);
		}
		try {
			InputStream input = new FileInputStream(file1);
			OutputStream output = new FileOutputStream(file2);
			if ((input != null) && (output != null)) {
				int temp = 0;
				while ((temp = input.read()) != (-1)) {
					output.write(temp);
				}
			}
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// OutputStreramWriter 和InputStreamReader类
	// 整个IO类中除了字节流和字符流还包括字节和字符转换流。
	// OutputStreramWriter将输出的字符流转化为字节流
	// InputStreamReader将输入的字节流转换为字符流
	// 但是不管如何操作，最后都是以字节的形式保存在文件中的。

	/**
	 * 将字节输出流转化为字符输出流 将字符串写进文件中
	 */
	public static void ziJieZhuanZiFuLiuWriter() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		try {
			Writer writer = new OutputStreamWriter(new FileOutputStream(file,
					true));
			String str = "\r\n哈哈哈123123";
			writer.write(str);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将字节输入流变为字符输入流 将文件中的内容读出来
	 */
	public static void ziJieZhuanZiFuLiuReader() {

		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		try {
			Reader reader = new InputStreamReader(new FileInputStream(file));
			char[] b = new char[100];
			int len = reader.read(b);
			System.out.println(new String(b, 0, len));
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 数据操作流 dataOutputStream
	 */
	public static void dataOutputStreamWrite() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		char[] ch = { 'A', 'B', 'C', '厂' };
		DataOutputStream dataOutputStream = null;
		try {
			dataOutputStream = new DataOutputStream(new FileOutputStream(file,
					true));
			for (char c : ch) {
				dataOutputStream.write(c);
			}
			dataOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 数据操作流 dataInputStream
	 */
	public static void dataInputStreamRead() {
		String fileName = FILE_PATH + File.separator + "myfile1.txt";
		File file = new File(fileName);
		DataInputStream dataInputStream = null;
		try {
			dataInputStream = new DataInputStream(new FileInputStream(file));
			byte[] b = new byte[1024];
			int ch = dataInputStream.read(b);
			System.out.println(new String(b));
			System.out.println("写入的文件的长度为: " + ch);
			System.out.println("截取字符串：" + new String(b, 0, ch));
			dataInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
