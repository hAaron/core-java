package com.aaron.util.email;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.email
 */
public class MailSender {
	/**
	 * 以文本格式发送邮件
	 * 
	 * @param mail
	 *            待发送的邮件的信息
	 * @throws GeneralSecurityException
	 */
	public boolean sendTextMail(Email mail) throws GeneralSecurityException {
		// 判断是否需要身份认证
		MailAuthenticator authenticator = null;
		Properties pro = mail.getProperties();
		if (mail.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new MailAuthenticator(mail.getUserName(),
					mail.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mail.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mail.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mail.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// 设置邮件消息的主要内容
			String mailContent = mail.getContent();
			mailMessage.setText(mailContent);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 以HTML格式发送邮件
	 * 
	 * @param mail
	 *            待发送的邮件信息
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public boolean sendHtmlMail(Email mail) throws GeneralSecurityException,
			UnsupportedEncodingException {
		// 判断是否需要身份认证
		MailAuthenticator authenticator = null;
		Properties props = mail.getProperties();
		// 如果需要身份认证，则创建一个密码验证器
		if (mail.isValidate()) {
			authenticator = new MailAuthenticator(mail.getUserName(),
					mail.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(props,
				authenticator);
		sendMailSession.setDebug(true);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mail.getFromAddress(),
					mail.getFromNickName() == null ? ""
							: mail.getFromNickName());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中,可以设置多个收件人，逗号隔开
			// Message.RecipientType.TO属性表示接收者的类型为TO,CC表示抄送,BCC暗送
			mailMessage.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mail.getToAddress()));
			// 设置邮件消息的主题
			mailMessage.setSubject(mail.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			MimeBodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(mail.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 设置信件的附件(用本地上的文件作为附件)
			FileDataSource fds = null;
			DataHandler dh = null;
			for (File file : mail.getAttachments()) {
				html = new MimeBodyPart();
				fds = new FileDataSource(file);
				dh = new DataHandler(fds);
				html.setFileName(file.getName());
				html.setDataHandler(dh);
				mainPart.addBodyPart(html);
			}
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			mailMessage.saveChanges();
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	// 163邮箱发送邮件 -- 测试通过
	public static void main(String[] args) throws GeneralSecurityException,
			UnsupportedEncodingException {
		// 这个类主要是设置邮件
		Email mailInfo = new Email();
		// 发件邮箱的服务--你的邮箱服务为：smtp.163.com，而你的发送邮箱就必须是xxxx@163.com;接收邮箱随便。
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setFromNickName("hbaaron");
		// 163 发送邮件给qq
		mailInfo.setUserName("15000484641"); // 实际发送者
		mailInfo.setPassword("");// 您的邮箱密码
		mailInfo.setFromAddress("15000484641@163.com"); // 设置发送人邮箱地址
		mailInfo.setToAddress("1330195548@qq.com"); // 设置接受者邮箱地址

		mailInfo.setSubject("邮件测试");
		mailInfo.setContent("邮箱内容：你好！欢迎使用该邮件发送器");
		mailInfo.setAttachments(new ArrayList<File>() {
			{
				add(new File("C:\\Users\\Administrator\\Desktop\\pic\\2.jpg"));
				add(new File("C:\\Users\\Administrator\\Desktop\\pic\\1.png"));
			}
		});
		// 这个类主要来发送邮件
		MailSender sms = new MailSender();
		// sms.sendTextMail(mailInfo); // 发送文体格式
		boolean result = sms.sendHtmlMail(mailInfo); // 发送html格式
		System.out.println("邮件发送结果----" + result);
	}

	// qq邮箱发送邮件 一直测试没通过
	public static void main2(String[] args) throws GeneralSecurityException,
			UnsupportedEncodingException {
		// 这个类主要是设置邮件
		Email mailInfo = new Email();
		mailInfo.setMailServerHost("smtp.exmail.qq.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setFromNickName("hbaaron");
		mailInfo.setUserName("1330195548"); // 实际发送者
		mailInfo.setPassword("");// 您的邮箱密码
		mailInfo.setFromAddress("1330195548@qq.com"); // 设置发送人邮箱地址
		mailInfo.setToAddress("2539648260@qq.com"); // 设置接受者邮箱地址
		mailInfo.setSubject("邮件测试");
		mailInfo.setContent("邮箱内容：你好！欢迎使用该邮件发送器");
		mailInfo.setAttachments(new ArrayList<File>() {
			{
				add(new File("C:\\Users\\Administrator\\Desktop\\pic\\2.jpg"));
				add(new File("C:\\Users\\Administrator\\Desktop\\pic\\1.png"));
			}
		});
		// 这个类主要来发送邮件
		MailSender sms = new MailSender();
		// sms.sendTextMail(mailInfo); // 发送文体格式
		boolean result = sms.sendHtmlMail(mailInfo); // 发送html格式
		System.out.println("邮件发送结果----" + result);
	}

}