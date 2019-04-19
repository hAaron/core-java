package com.aaron.util.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 多个接收者，多个附件
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.email
 */
public class MailSender2 {
	private static MailSender2 instance = null;

	private MailSender2() {

	}

	public static MailSender2 getInstance() {
		if (instance == null) {
			instance = new MailSender2();
		}
		return instance;
	}

	public void send(String to[], String cs[], String ms[], String subject, String content, String formEmail,
			String fileList[]) {
		try {
			// Properties p = System.getProperties();
			Properties p = new Properties();
			p.put("mail.smtp.auth", "true");
			p.put("mail.transport.protocol", "smtp");
			p.put("mail.smtp.host", "smtp.163.com");
			p.put("mail.smtp.port", "25");
			// 建立会话
			Session session = Session.getInstance(p);
			// 建立信息
			Message msg = new MimeMessage(session);
			BodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			// 发件人
			msg.setFrom(new InternetAddress(formEmail));

			String toList = null;
			String toListcs = null;
			String toListms = null;

			// 发送,
			if (to != null) {
				toList = getMailList(to);
				InternetAddress[] iaToList = InternetAddress.parse(toList);
				// 收件人
				msg.setRecipients(Message.RecipientType.TO, iaToList);
			}

			// 抄送
			if (cs != null) {
				toListcs = getMailList(cs);
				InternetAddress[] iaToListcs = InternetAddress.parse(toListcs);
				// 抄送人
				msg.setRecipients(Message.RecipientType.CC, iaToListcs);
			}

			// 密送
			if (ms != null) {
				toListms = getMailList(ms);
				InternetAddress[] iaToListms = InternetAddress.parse(toListms);
				// 密送人
				msg.setRecipients(Message.RecipientType.BCC, iaToListms);
			}
			// 发送日期
			msg.setSentDate(new Date());
			// 主题
			msg.setSubject(subject);
			// 内容
			msg.setText(content);
			// 显示以html格式的文本内容
			messageBodyPart.setContent(content, "text/html;charset=gbk");
			multipart.addBodyPart(messageBodyPart);

			// 2.保存多个附件
			if (fileList != null) {
				addTach(fileList, multipart);
			}

			msg.setContent(multipart);
			// 邮件服务器进行验证
			Transport tran = session.getTransport("smtp");
			String host = "smtp.163.com";
			// 邮箱
			String user = "";
			// 密码
			String password = "";
			tran.connect(host, user, password);
			// 发送
			tran.sendMessage(msg, msg.getAllRecipients()); 
			System.out.println("邮件发送成功");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加多个附件
	 * 
	 * @param fileList
	 * @param multipart
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void addTach(String fileList[], Multipart multipart)
			throws MessagingException, UnsupportedEncodingException {
		for (int index = 0; index < fileList.length; index++) {
			MimeBodyPart mailArchieve = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(fileList[index]);
			mailArchieve.setDataHandler(new DataHandler(fds));
			mailArchieve.setFileName(MimeUtility.encodeText(fds.getName(), "GBK", "B"));
			multipart.addBodyPart(mailArchieve);
		}
	}

	private String getMailList(String[] mailArray) {

		StringBuffer toList = new StringBuffer();
		int length = mailArray.length;
		if (mailArray != null && length < 2) {
			toList.append(mailArray[0]);
		} else {
			for (int i = 0; i < length; i++) {
				toList.append(mailArray[i]);
				if (i != (length - 1)) {
					toList.append(",");
				}

			}
		}
		return toList.toString();

	}

	public static void main(String args[]) {
		MailSender2 send = MailSender2.getInstance();
		String[] to = { "1330195548@qq.com", "2539648260@qq.com" };
		String[] cs = null;
		String[] ms = null;
		String subject = "测试一下";
		String content = "这是邮件内容，仅仅是测试，不需要回复";
		String formEmail = "15000484641@163.com";
		String[] arrArchievList = new String[4];
		arrArchievList[0] = "E://temp//a.txt";
		arrArchievList[1] = "E://temp//[尚硅谷]_佟刚_Spring 面试题分析.pdf";
		arrArchievList[2] = "E://temp//淘淘商城项目总结以及就业指导.docx";
		arrArchievList[3] = "E://temp//基站维护信息.xls";
		// 2.保存多个附件
		send.send(to, cs, ms, subject, content, formEmail, arrArchievList);
	}

}
