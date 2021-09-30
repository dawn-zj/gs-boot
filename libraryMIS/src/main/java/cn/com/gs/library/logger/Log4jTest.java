package cn.com.gs.library.logger;

import org.apache.log4j.Logger;

public class Log4jTest {
	private static Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		logger.error("error1...");
		System.out.println("日志测试结束");
	}
}
