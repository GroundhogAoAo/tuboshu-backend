package com.tuboshu.common;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间工具类
 * 
 * @author Administrator
 *
 */
public class DateUtils {

	public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/*
	 * 获取格式化的当天时间
	 */
	public static String getFormatNow() throws ParseException{
		Date date = new Date();
		String format = TIME_FORMAT.format(date);
		return format;
	}
	

}
