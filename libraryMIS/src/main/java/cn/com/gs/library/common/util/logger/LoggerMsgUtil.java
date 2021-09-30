package cn.com.gs.library.common.util.logger;

import cn.com.gs.library.common.define.Constants;

import java.util.Hashtable;

/**
 * 将日志类型转为中文描述
 */
public class LoggerMsgUtil {
	// 存储中文描述
	private static Hashtable<String, String> container = new Hashtable<String, String>();

	static {
		container.put(Constants.LOG_OPTYPE_SYSUSERLOGIN, "登录");
	}

	public static String getLoggerMsg(String logOptype) {
		String ManageLoggerMsg = container.get(logOptype);
		if (ManageLoggerMsg == null) {
			return "没有对应的操作描述";
		} else {
			return ManageLoggerMsg;
		}
	}
}
