package cn.com.cootoo.utils;

import java.util.Calendar;
import java.util.Date;

public abstract class CalendarTool
{
	private static int[] daysOfPerMonth = {
			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static Calendar newLocalCalendar(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 判断两个时间是否在同一天
	 * @param calendar
	 * @param otherCalendar
	 * @return
	 */
	public static boolean isSameDay(Calendar calendar, Calendar otherCalendar)
	{
		return (isSameDate(calendar, otherCalendar)) &&
				(isSameMonth(calendar, otherCalendar)) &&
				(isSameYear(calendar, otherCalendar));
	}

	public static boolean isSameDate(Calendar calendar, Calendar otherCalendar)
	{
		return otherCalendar.get(5) == calendar.get(5);
	}

	public static boolean isSameMonth(Calendar calendar, Calendar otherCalendar)
	{
		return otherCalendar.get(2) == calendar.get(2);
	}

	public static boolean isSameYear(Calendar calendar, Calendar otherCalendar)
	{
		return otherCalendar.get(1) == calendar.get(1);
	}

	public static int getDate(Calendar calendar) {
		return calendar.get(5);
	}

	public static void setDate(Calendar calendar, int date) {
		calendar.set(5, date);
	}

	public static int getMonth(Calendar calendar) {
		return calendar.get(2);
	}

	public static void setMonth(Calendar calendar, int month) {
		calendar.set(2, month);
	}

	public static int getYear(Calendar calendar) {
		return calendar.get(1);
	}

	public static void setYear(Calendar calendar, int year) {
		calendar.set(1, year);
	}

	/**
	 * 设置为毫秒类型
	 * @param calendar
	 */
	public static void toMinTime(Calendar calendar) {
		setTime(calendar, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	public static void toMaxTime(Calendar calendar) {
		setTime(calendar, 23, 59, 59);
		calendar.set(14, 999);
	}

	public static void setYM(Calendar calendar, int year, int month) {
		calendar.set(1, year);
		calendar.set(2, month);
	}

	public static void setMD(Calendar calendar, int month, int date) {
		calendar.set(2, month);
		calendar.set(5, date);
	}

	public static void setTime(Calendar calendar, int hour, int minute, int second)
	{
		calendar.set(11, hour);
		calendar.set(12, minute);
		calendar.set(13, second);
	}

	public static void setHM(Calendar calendar, int hour, int minute) {
		calendar.set(11, hour);
		calendar.set(12, minute);
	}

	public static void truncateTime(Calendar calendar) {
		setTime(calendar, 0, 0, 0);
		calendar.set(14, 0);
	}

	public static int getDaysOfMonth(Calendar calendar)
	{
		int month = calendar.get(2);
		if ((month == 1) && (isBissextile(calendar.get(1)))) {
			return 29;
		}
		return daysOfPerMonth[month];
	}

	public static boolean isBissextile(int year)
	{
		return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
	}
}