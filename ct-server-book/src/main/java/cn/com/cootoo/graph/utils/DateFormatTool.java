package cn.com.cootoo.graph.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTool
{
	public static final String pattern_Pretty = "yyyy-MM-dd HH:mm:ss";
	public static final String pattern_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String pattern_yyyyMMdd = "yyyyMMdd";
	public static final String pattern_yyyy_MM_dd = "yyyy-MM-dd";

	public static String format(Date date, String pattern)
	{
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	public static Date parse(String date, String pattern) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.parse(date);
	}
}