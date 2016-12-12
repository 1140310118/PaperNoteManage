package com.paper.action;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.opensymphony.xwork2.ActionSupport;

public class SendEmailAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String from;
	private String password;
	private String to;
	private String subject;
	private String body;
	private String fileName;
	private String affix = ""; // 附件地址
	private String affixName = ""; // 附件名称
	static Properties properties = new Properties();
	static {
		properties.put("mail.smtp.host", "smtp.163.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
	}

	/**
	 * 根据传入的文件路径创建附件并返回
	 */
	public MimeBodyPart createAttachment(String fileName) throws Exception {
		MimeBodyPart attachmentPart = new MimeBodyPart();
		FileDataSource fds = new FileDataSource(fileName);
		attachmentPart.setDataHandler(new DataHandler(fds));
		attachmentPart.setFileName(fds.getName());
		return attachmentPart;
	}

	public String execute() {
		// SendEmailAction se = new SendEmailAction();
		String ret = SUCCESS;
		// se.setSender("PaperManage2333@163.com", "papermanage2333");
		try {
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			});
			Message message = new MimeMessage(session);
			// 加载发件人地址
			message.setFrom(new InternetAddress(from));
			// 加载收件人地址
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			// 加载标题
			message.setSubject(subject);
			// 加载正文(原先的方法)
			message.setText(body);
			 // 创建附件部分
			// MimeBodyPart attachment =
			 createAttachment("F:\\java\\Snake.java");
			 MimeBodyPart attachment = createAttachment(fileName);
			 // 将邮件中各个部分组合到一个"mixed"型的 MimeMultipart 对象
			 MimeMultipart allPart = new MimeMultipart("mixed");
			 allPart.addBodyPart(attachment);
			 // 将上面混合型的 MimeMultipart 对象作为邮件内容并保存
			 message.setContent(allPart);
            
			System.out.println("邮件标题：" + subject);
			System.out.println("邮件正文：" + body);
			System.out.println("文件路径：" + fileName);
			Transport.send(message);
		} catch (Exception e) {
			ret = ERROR;
			e.printStackTrace();
		}
		return ret;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAffix() {
		return affix;
	}

	public void setAffix(String affix) {
		this.affix = affix;
	}

	public String getAffixName() {
		return affixName;
	}

	public void setAffixName(String affixName) {
		this.affixName = affixName;
	}

}