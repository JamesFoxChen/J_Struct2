package framework.utils;

import org.apache.log4j.Logger;

public class LogUtil {
	//日志已经写到log4j.properties设置的目录下
	private static Logger logger = Logger.getLogger(LogUtil.class); // LogDemo为相关的类

	/**
	   * debug方法
	   */
	public static void debug(String str) {
		logger.debug(str);
	}

	public static void info(String str) {
		logger.debug(str);
	}

	public static void error(String str) {
		logger.debug(str);
	}
	
	/*private static String getData(String str)
	{
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(DateTimeUtil.GetCurrentTime() + ":\r\n" + str);
		return sBuffer.toString();
	}*/
}
