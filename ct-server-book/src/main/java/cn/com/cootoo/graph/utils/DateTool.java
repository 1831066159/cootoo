package cn.com.cootoo.graph.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class DateTool {
    private DateTool() {

    }

    public static boolean isYesterday(Date date) {
        return isSameDay(date, getYesterday());
    }

    public static Date getYesterday() {
        return toYesterday(new Date());
    }

    /**
     * 获取前一天
     *
     * @param date
     * @return
     */
    public static Date toYesterday(Date date) {
        Calendar calendar = CalendarTool.newLocalCalendar(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static boolean isToday(Date date) {
        return CalendarTool.isSameDay(Calendar.getInstance(),
                CalendarTool.newLocalCalendar(date));
    }

    public static boolean isTomorrow(Date date) {
        return isSameDay(date, getTomorrow());
    }

    public static Date getTomorrow() {
        return toTomorrow(new Date());
    }

    /**
     * 获取下一天
     *
     * @param date
     * @return
     */
    public static Date toTomorrow(Date date) {
        Calendar calendar = CalendarTool.newLocalCalendar(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    public static boolean isSameDay(Date date, Date other) {
        return CalendarTool.isSameDay(CalendarTool.newLocalCalendar(date),
                CalendarTool.newLocalCalendar(other));
    }

    public static int getDate(Date date) {
        return CalendarTool.getDate(CalendarTool.newLocalCalendar(date));
    }

    public static int getMonth(Date date) {
        return CalendarTool.getMonth(CalendarTool.newLocalCalendar(date));
    }

    public static int getYear(Date date) {
        return CalendarTool.getYear(CalendarTool.newLocalCalendar(date));
    }

    public static String getNow4yyyyMMddHHmmss(){
        return getDate(null,null);
    }

    public static String getDate(Date date, String format) {
        if (format == null || format.length() == 0) {
            format = "yyyyMMddHHmmss";
        }
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取两段时间的天数差
     *
     * @param start
     * @param end
     * @return
     */
    public static int getNaturalDays(Date start, Date end) {
        Calendar startCalendar = CalendarTool.newLocalCalendar(start);
        CalendarTool.truncateTime(startCalendar);

        Calendar endCalendar = CalendarTool.newLocalCalendar(end);
        CalendarTool.truncateTime(endCalendar);

        return (int) TimeUnit.MILLISECONDS.toDays(endCalendar.getTimeInMillis() -
                startCalendar.getTimeInMillis());
    }

    public static int getDaysOfMonth(Date date) {
        return CalendarTool.getDaysOfMonth(CalendarTool.newLocalCalendar(date));
    }

    public static long getMinMillis(Date date) {
        return getMinTime(date).getTime();
    }

    /**
     * 转换为毫秒时间
     *
     * @param date
     * @return
     */
    public static Date getMinTime(Date date) {
        Calendar calendar = CalendarTool.newLocalCalendar(date);
        CalendarTool.toMinTime(calendar);
        return calendar.getTime();
    }

    public static long getMaxMillis(Date date) {
        return getMaxTime(date).getTime();
    }

    public static Date getMaxTime(Date date) {
        Calendar calendar = CalendarTool.newLocalCalendar(date);
        CalendarTool.toMaxTime(calendar);
        return calendar.getTime();
    }

    //获得两个日期之前相差的月份
    public static int getMonth(Date start, Date end) {
        if (start.after(end)) {
            Date t = start;
            start = end;
            end = t;
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar temp = Calendar.getInstance();
        temp.setTime(end);
        temp.add(Calendar.DATE, 1);

        int year = endCalendar.get(Calendar.YEAR)
                - startCalendar.get(Calendar.YEAR);
        int month = endCalendar.get(Calendar.MONTH)
                - startCalendar.get(Calendar.MONTH);

        if ((startCalendar.get(Calendar.DATE) == 1)
                && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month + 1;
        } else if ((startCalendar.get(Calendar.DATE) != 1)
                && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month;
        } else if ((startCalendar.get(Calendar.DATE) == 1)
                && (temp.get(Calendar.DATE) != 1)) {
            return year * 12 + month;
        } else {
            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
        }
    }
}