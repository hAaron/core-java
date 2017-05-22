package com.aaron.util.xml;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.xml
 */
public class xml {

	/**
	 * 获取指定xml文档的Document对象,xml文件必须在classpath中可以找到
	 * 
	 * @param xmlFilePath
	 *            xml文件路径
	 * @return Document对象
	 * @throws Exception
	 */
	public static void parse2Document(String xmlFilePath) throws Exception {
		Document doc = new SAXReader().read(new File(xmlFilePath));
		List itemList = doc.selectNodes("/opDetail");

		System.out.println(itemList);
		for (Iterator iter = itemList.iterator(); iter.hasNext();) {
			Element el = (Element) iter.next();
			String startTime = el.elementText("startTime");
			String origin = el.elementText("origin");
			String classify = el.elementText("classify");
			System.out.println(classify + "");
			List content = el.elements("content");
			StringBuffer sbString = new StringBuffer();
			for (Iterator iter1 = content.iterator(); iter1.hasNext();) {
				Element turnosElt = (Element) iter1.next();
				List detail = turnosElt.elements("detail");
				for (Iterator iter2 = detail.iterator(); iter2.hasNext();) {
					Element detailElt = (Element) iter1.next();
					String type = turnosElt.elementText("type");
					String name = turnosElt.elementText("name");
					String total = turnosElt.elementText("total");
					String base = turnosElt.elementText("base");
					String max = turnosElt.elementText("max");
					String level = turnosElt.elementText("level");
					String ip_addr = turnosElt.elementText("ip_addr");
					System.out.println(ip_addr + "");
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		parse2Document("D:/temp/test.xml");
	}

}
