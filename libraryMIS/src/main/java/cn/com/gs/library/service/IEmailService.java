package cn.com.gs.library.service;

public interface IEmailService {
	public void sendEmail(String receiveMailAccount, String subject, String content) throws Exception;
}
