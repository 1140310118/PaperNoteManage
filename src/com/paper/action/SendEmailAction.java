package com.paper.action;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.opensymphony.xwork2.ActionSupport;

public class SendEmailAction extends ActionSupport {
	private String from;
	private String password;
	private String to;
	private String subject;
	private String body;
	static Properties properties = new Properties();
	static {
		properties.put("mail.smtp.host", "smtp.163.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
	}
	
	public void setSender(String from,String password){
		this.from = from;
		this.password = password;
	}

	public String execute() {
		SendEmailAction se = new SendEmailAction();
		String ret = SUCCESS;
//		se.setSender("PaperManage2333@163.com", "papermanage2333");
		try {
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			});
			Message message = new MimeMessage(session);
			//加载发件人地址
			message.setFrom(new InternetAddress(from));
			//加载收件人地址
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			//加载标题
			message.setSubject(subject);
			message.setText(body);
			System.out.println(subject);
			System.out.println(body);	
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

	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		SendEmailAction.properties = properties;
	}
}