package com.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtil {
	
	    /**
	     * 获取YYYY格式
	     * 
	     * @return
	     */
	    public static String getYear() {
	        return new SimpleDateFormat("yyyy").format(new Date());
	    }

	    /**
	     * 获取YYYY-MM-DD格式
	     * 
	     * @return
	     */
	    public static String getDay() {
	        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	    }

	    /**
	     * 获取YYYYMMDD格式
	     * 
	     * @return
	     */
	    public static String getDays() {
	        return new SimpleDateFormat("yyyyMMdd").format(new Date());
	    }

	    /**
	     * 返回 YYYY-MM-DD HH:mm:ss 格式日期
	     * 
	     * @return
	     */
	    public static String getTime() {
	        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	    }

	    /**
	     * @Title: compareDate
	     * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	     * @param s
	     * @param e
	     * @return boolean
	     * @throws @author luguosui
	     */
	    public static boolean compareDate(String s, String e) {
	        if (fomatDate(s) == null || fomatDate(e) == null) {
	            return false;
	        }
	        return fomatDate(s).getTime() >= fomatDate(e).getTime();
	    }

	    /**
	     * @Title: compareDate
	     * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	     * @param s
	     * @param e
	     * @return boolean
	     */
	    public static boolean compareDate(Date s, Date e) {
	        return s.getTime() >= e.getTime();
	    }

	    /**
	     * 返回 yyyy-MM-dd 格式日期
	     * 
	     * @return
	     */
	    public static Date fomatDate(String date) {
	        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            return fmt.parse(date);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public static Date yyyyMMddHHmmToDate(String date) {
	        return stringToDate(date, "yyyy-MM-dd HH:mm");
	    }

	    public static Date stringToDate(String date, String fmtStr) {
	        DateFormat fmt = new SimpleDateFormat(fmtStr);
	        try {
	            return fmt.parse(date);
	        } catch (ParseException e) {
	            return null;
	        }
	    }

	    /**
	     * 返回 yyyy-MM-dd 格式日期
	     * 
	     * @return
	     */
	    public static String fomatDate(Date date) {
	    	if(date == null){
	    		return "";
	    	}
	        return new SimpleDateFormat("yyyy-MM-dd").format(date);
	    }

	    /**
	     * 格式化日期
	     * 
	     * @return
	     */
	    public static String fomatDate(String pattern, Date date) {
	        SimpleDateFormat fmt = new SimpleDateFormat(pattern);
	        return fmt.format(date);
	    }

	    /**
	     * 
	     * 方法说明: 返回 yyyy-MM-dd HH:mm:ss 格式时间字符串
	     * 
	     * @param date
	     * @return
	     */
	    public static String fomatDate1(Date date) {
	    	if(date == null){
	    		return null;
	    	}
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String str = format.format(date);
	        return str;

	    }
	    
	    /**
	     * 
	     * 方法说明: 返回 HH:mm 格式时间字符串
	     * 
	     * @param date
	     * @return
	     */
	    public static String fomatDate3(Date date) {
	        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	        String str = format.format(date);
	        return str;

	    }

	    /**
	     * 
	     * 方法说明: 返回 yyyy年MM月dd日 格式时间字符串
	     * 
	     * @param date
	     * @return
	     */
	    public static String fomatDate2(Date date) {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
	        String str = format.format(date);
	        return str;
	    }

	    /**
	     * 校验日期是否合法
	     * 
	     * @return
	     */
	    public static boolean isValidDate(String s) {
	        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            fmt.parse(s);
	            return true;
	        } catch (Exception e) {
	            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
	            return false;
	        }
	    }

	    public static int getDiffYear(String startTime, String endTime) {
	        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
	            return years;
	        } catch (Exception e) {
	            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
	            return 0;
	        }
	    }

	    /**
	     * <li>功能描述：时间相减得到天数
	     * 
	     * @param beginDateStr
	     * @param endDateStr
	     * @return long
	     * @author Administrator
	     */
	    public static long getDaySub(String beginDateStr, String endDateStr) {
	        long day = 0;
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date beginDate = null;
	        Date endDate = null;

	        try {
	            beginDate = format.parse(beginDateStr);
	            endDate = format.parse(endDateStr);
	            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        return day;
	    }

	    /**
	     * <li>功能描述：时间相减得到天数
	     * 
	     * @param beginDate
	     * @param endDate
	     * @return long
	     * @author Administrator
	     */
	    public static Integer getDaySub(Date beginDate, Date endDate) {
	    	if(beginDate == null){
	    		return null;
	    	}
	    	if(endDate == null){
	    		return null;
	    	}
	        String str1 = fomatDate(beginDate);
	        String str2 = fomatDate(endDate);
	        return (int) getDaySub(str1,str2);
	    }

	    /**
	     * 得到n天之后的日期
	     * 
	     * @param days
	     * @return
	     */
	    public static String getAfterDayDateStr(Integer days) {

	        Calendar canlendar = Calendar.getInstance(); // java.util包
	        canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
	        Date date = canlendar.getTime();

	        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String dateStr = sdfd.format(date);

	        return dateStr;
	    }

	    /**
	     * 得到n天之后的日期
	     * 
	     * @param days
	     * @return
	     */
	    public static Date getAfterDayDate(Integer days) {

	        Calendar canlendar = Calendar.getInstance(); // java.util包
	        canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
	        Date date = canlendar.getTime();
	        return date;
	    }

	    /**
	     * @Title: getAfterDayDate
	     * @Description: 得到某天开始n天之后的日期
	     * @param d
	     *            开始日期
	     * @param days
	     *            天数
	     * @return
	     */
	    public static Date getAfterDayDate(Date d, Integer days) {
	        Calendar canlendar = Calendar.getInstance(); // java.util包
	        canlendar.setTime(d);
	        canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
	        return canlendar.getTime();
	    }

	    /**
	     * 获取时间段内的时间列表
	     * 
	     * @param startTime
	     * @param endTime
	     * @return
	     */
	    public static List<Date> getDateList(Date startTime, Date endTime) {
	        List<Date> list = new ArrayList<Date>();
	        Calendar canlendar = Calendar.getInstance();
	        canlendar.setTime(startTime);
	        while (compareDate(fomatDate(endTime), fomatDate(canlendar.getTime()))) {
	            list.add(canlendar.getTime());
	            canlendar.add(Calendar.DATE, 1);
	        }
	        return list;
	    }

	    /**
	     * 获取时间段内的时间列表
	     * 
	     * @param startTime
	     * @param endTime
	     * @return
	     */
	    public static List<String> getDateStrList(Date startTime, Date endTime) {
	        List<String> list = new ArrayList<String>();
	        Calendar canlendar = Calendar.getInstance();
	        canlendar.setTime(startTime);
	        while (compareDate(fomatDate(endTime), fomatDate(canlendar.getTime()))) {
	            list.add(new SimpleDateFormat("yyyy-MM-dd").format(canlendar.getTime()));
	            canlendar.add(Calendar.DATE, 1);
	        }
	        return list;
	    }

	    /**
	     * 得到n天之后是周几
	     * 
	     * @param days
	     * @return
	     */
	    public static String getAfterDayWeek(String days) {
	        int daysInt = Integer.parseInt(days);

	        Calendar canlendar = Calendar.getInstance(); // java.util包
	        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
	        Date date = canlendar.getTime();

	        SimpleDateFormat sdf = new SimpleDateFormat("E");
	        String dateStr = sdf.format(date);

	        return dateStr;
	    }

	    /**
	     * @Title: compare
	     * @Description: 比较两个时间大小 （时间1+秒数，时间2）
	     * @param d1
	     *            时间1
	     * @param d2
	     *            时间2
	     * @param time
	     *            秒数
	     * @return
	     */
	    public static int compare(Date d1, Date d2, int time) {
	        Date d = (Date) d1.clone();
	        d.setTime(d.getTime() + time * 1000);
	        return d.compareTo(d2);
	    }

	    /**
	     * @Title: getSecondSub
	     * @Description: 两个时间相差秒数(begin+time-endDate)
	     * @param beginDate
	     *            开始时间
	     * @param endDate
	     *            结束时间
	     * @param time
	     *            相差秒数
	     * @return
	     */
	    public static long getSecondSub(Date beginDate, Date endDate, int time) {
	        long second = (beginDate.getTime() - endDate.getTime() + time * 1000) / 1000;
	        return second;
	    }

	    /**
	     * 
	     * 方法说明: 计算某日期加n天后的日期
	     * 
	     * @param d
	     *            传入日期
	     * @param day
	     *            加多少天
	     * @return
	     */
	    public static Date rollDay(Date d, int day) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(d);
	        cal.add(Calendar.DAY_OF_MONTH, day);
	        return cal.getTime();
	    }

	    /**
	     * 格式化成中文日期
	     * 
	     * @return
	     */
	    public static String fomatDateToCN(Date date) {
	        if (date == null) {
	            return "";
	        }
	        return new SimpleDateFormat("yyyy年MM月dd日").format(date);
	    }

	    /**
	     * 格式化成贷斜线的日期
	     * 
	     * @param date
	     * @return
	     */
	    public static String formatSlashDate(Date date) {
	        if (date == null) {
	            return "";
	        }
	        return new SimpleDateFormat("yyyy/MM/dd").format(date);
	    }

	    /**
	     * @Title: getLastSecIntegralTime
	     * @Description: 根据传入的日期获得当天的最后一秒时间
	     * @param d
	     * @return Date
	     * @throws
	     */
	    public static Date getLastSecIntegralTime(Date d) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTimeInMillis(d.getTime());
	        cal.set(Calendar.HOUR_OF_DAY, 23);
	        cal.set(Calendar.SECOND, 59);
	        cal.set(Calendar.MINUTE, 59);
	        cal.set(Calendar.MILLISECOND, 0);
	        return cal.getTime();
	    }

	    /**
	     * @Title: rollMon
	     * @Description:在日期d的基础上进行mon个月份相加
	     * @param d
	     * @param mon
	     * @return Date
	     * @throws
	     */
	    public static Date rollMon(Date d, int mon) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(d);
	        cal.add(Calendar.MONTH, mon);
	        return cal.getTime();
	    }

	    /**
	     * 将制定字符串转换为日期
	     * @return
	     */
	    public static Date getDateByString(String date){
	    	DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        try {
	            return fmt.parse(date);
	        } catch (Exception e) {
	            return null;
	        }
	    }
	    
	    /**
	     * @Title: afterDayTime
	     * @Description: 返回几天后的某个时间点
	     * @param afterDay
	     *            天数
	     * @param time
	     *            时间 10:00
	     * @return
	     */
	    public static Date afterDayTime(Integer afterDay, String time) {
	        String[] a = time.split(":");
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.DATE, afterDay);
	        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(a[0]));
	        calendar.set(Calendar.MINUTE, Integer.valueOf(a[1]));
	        calendar.set(Calendar.SECOND, 0);
	        calendar.set(Calendar.MILLISECOND, 0);
	        return calendar.getTime();
	    }
	    
	    public static Date getTodayFrist() {
	        return getDayFrist(new Date());
	    }
	    
	    public static Date getTodayLast(){
	        return getDayLast(new Date());
	    }

	    /**
	     * @Title: getDayFrist
	     * @Description:某一天的开始时间
	     * @param date
	     *            00：00：00
	     * @return
	     */
	    public static Date getDayFrist(Date date) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.set(Calendar.HOUR_OF_DAY, 0);
	        calendar.set(Calendar.MINUTE, 0);
	        calendar.set(Calendar.SECOND, 0);
	        return calendar.getTime();
	    }

	    /**
	     * @Title: getDayLast
	     * @Description: 某一天的结束时间
	     * @param date
	     *            23：59：59
	     * @return
	     */
	    public static Date getDayLast(Date date) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.set(Calendar.HOUR_OF_DAY, 24);
	        calendar.set(Calendar.MINUTE, 59);
	        calendar.set(Calendar.SECOND, 59);
	        return calendar.getTime();
	    }

	    /** 
	    * @Title: secondsOffSet 
	    * @Description: 秒偏移 
	    * @param @param date
	    * @param @param seconds
	    * @param @return    设定文件 
	    * @return Date    返回类型 
	    * @throws 
	    */
	    public static Date secondsOffSet(Date date, long seconds) {
	        return new Date(date.getTime()+seconds*1000);
	    }
	    
	    /**
	     * 从 "2016-06-02(星期四) 10:00-12:00" 格式的字符串中获取两个前后时间
	     * @param str
	     * @return
	     * map : {
	     *          startTime -- 起始时间
	     *          endTime -- 结束时间
	     *       }
	     */
	    public static Map<String, Date> getTwoDateFromStr(String str){
	    	if(str == null){
	    		return null;
	    	}
	    	String[] arrs = str.split(" ");
	    	if(arrs != null && arrs.length == 2){
	    		String date = arrs[0].substring(0, arrs[0].indexOf("("));
	    		String time = arrs[1];
	    		String[] times = time.split("-");
	    		if(times != null && times.length == 2){
	    			Date startTime = yyyyMMddHHmmToDate(date + " " + times[0]);
	    			Date endTime = yyyyMMddHHmmToDate(date + " " + times[1]);
	    			Map<String, Date> map = new HashMap<>();
	    			map.put("startTime", startTime);
	    			map.put("endTime", endTime);
	    			return map;
	    		}
	    	}
			return null;
	    }
	    
	    /**
	     * 从两个时间中获取 2016-06-02(星期四) 10:00-12:00 格式字符串
	     * @param startTime
	     * @param endTime
	     * @return
	     */
	    public static  String getDateTimeStr(Date startTime,Date endTime){
	    	if(startTime == null){
	    		return "开始时间为空";
	    	}
	    	if(endTime == null){
	    		return "结束时间为空";
	    	}
	    	SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
	    	String date = dateSdf.format(startTime);
	    	
	    	String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	    	Calendar cal = Calendar.getInstance();
	    	cal.setTime(startTime);
	    	int day = cal.get(Calendar.DAY_OF_WEEK)-1;
	    	date = date + "(" + weekDays[day] + ")";
	    	
	    	SimpleDateFormat timeSdf = new SimpleDateFormat("HH:mm");
	    	String start = timeSdf.format(startTime);
	    	String end = timeSdf.format(endTime);
	    	String dateTime = date + " " + start + "-" + end;
			return dateTime;
	    }
	    
	    /**
	     * 获取多少小时之后的时间,如果获取多少小时之前的时间,则hour值为对应值的负数
	     * @param date
	     * @param hour
	     * @return
	     */
	    public static Date rollHour(Date date, int hour) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.HOUR_OF_DAY, hour);
	        return cal.getTime();
	    }
	    
	    /**
	     * 将一个Date对象的时间设置为  00:00:00
	     * @param date
	     * @return
	     */
	    public static Date getZeroTimeDate(Date date) {
	    	if(date == null){
	    		return null;
	    	}
	    	Calendar c = Calendar.getInstance();
	    	c.setTime(date);
	    	c.set(Calendar.HOUR_OF_DAY, 0);       
	        c.set(Calendar.MINUTE, 0);           
	        c.set(Calendar.SECOND, 0);    
	        c.set(Calendar.MILLISECOND, 0);
	        date = c.getTime();
			return date;
	    }

	    public static void main(String[] args) {
		}

	    public static String format2yyMMdd(Date date) {
	        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
	        String str = format.format(date);
	        return str;
	    }


	    public static String format2yyyyMMdd(Date date) {
	        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        String str = format.format(date);
	        return str;
	    }

}
