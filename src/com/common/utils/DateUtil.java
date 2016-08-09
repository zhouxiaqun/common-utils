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
	     * ��ȡYYYY��ʽ
	     * 
	     * @return
	     */
	    public static String getYear() {
	        return new SimpleDateFormat("yyyy").format(new Date());
	    }

	    /**
	     * ��ȡYYYY-MM-DD��ʽ
	     * 
	     * @return
	     */
	    public static String getDay() {
	        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	    }

	    /**
	     * ��ȡYYYYMMDD��ʽ
	     * 
	     * @return
	     */
	    public static String getDays() {
	        return new SimpleDateFormat("yyyyMMdd").format(new Date());
	    }

	    /**
	     * ���� YYYY-MM-DD HH:mm:ss ��ʽ����
	     * 
	     * @return
	     */
	    public static String getTime() {
	        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	    }

	    /**
	     * @Title: compareDate
	     * @Description: TODO(���ڱȽϣ����s>=e ����true ���򷵻�false)
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
	     * @Description: TODO(���ڱȽϣ����s>=e ����true ���򷵻�false)
	     * @param s
	     * @param e
	     * @return boolean
	     */
	    public static boolean compareDate(Date s, Date e) {
	        return s.getTime() >= e.getTime();
	    }

	    /**
	     * ���� yyyy-MM-dd ��ʽ����
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
	     * ���� yyyy-MM-dd ��ʽ����
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
	     * ��ʽ������
	     * 
	     * @return
	     */
	    public static String fomatDate(String pattern, Date date) {
	        SimpleDateFormat fmt = new SimpleDateFormat(pattern);
	        return fmt.format(date);
	    }

	    /**
	     * 
	     * ����˵��: ���� yyyy-MM-dd HH:mm:ss ��ʽʱ���ַ���
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
	     * ����˵��: ���� HH:mm ��ʽʱ���ַ���
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
	     * ����˵��: ���� yyyy��MM��dd�� ��ʽʱ���ַ���
	     * 
	     * @param date
	     * @return
	     */
	    public static String fomatDate2(Date date) {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd��");
	        String str = format.format(date);
	        return str;
	    }

	    /**
	     * У�������Ƿ�Ϸ�
	     * 
	     * @return
	     */
	    public static boolean isValidDate(String s) {
	        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            fmt.parse(s);
	            return true;
	        } catch (Exception e) {
	            // ���throw java.text.ParseException����NullPointerException����˵����ʽ����
	            return false;
	        }
	    }

	    public static int getDiffYear(String startTime, String endTime) {
	        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
	            return years;
	        } catch (Exception e) {
	            // ���throw java.text.ParseException����NullPointerException����˵����ʽ����
	            return 0;
	        }
	    }

	    /**
	     * <li>����������ʱ������õ�����
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
	     * <li>����������ʱ������õ�����
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
	     * �õ�n��֮�������
	     * 
	     * @param days
	     * @return
	     */
	    public static String getAfterDayDateStr(Integer days) {

	        Calendar canlendar = Calendar.getInstance(); // java.util��
	        canlendar.add(Calendar.DATE, days); // ���ڼ� ����������Ὣ�±䶯
	        Date date = canlendar.getTime();

	        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String dateStr = sdfd.format(date);

	        return dateStr;
	    }

	    /**
	     * �õ�n��֮�������
	     * 
	     * @param days
	     * @return
	     */
	    public static Date getAfterDayDate(Integer days) {

	        Calendar canlendar = Calendar.getInstance(); // java.util��
	        canlendar.add(Calendar.DATE, days); // ���ڼ� ����������Ὣ�±䶯
	        Date date = canlendar.getTime();
	        return date;
	    }

	    /**
	     * @Title: getAfterDayDate
	     * @Description: �õ�ĳ�쿪ʼn��֮�������
	     * @param d
	     *            ��ʼ����
	     * @param days
	     *            ����
	     * @return
	     */
	    public static Date getAfterDayDate(Date d, Integer days) {
	        Calendar canlendar = Calendar.getInstance(); // java.util��
	        canlendar.setTime(d);
	        canlendar.add(Calendar.DATE, days); // ���ڼ� ����������Ὣ�±䶯
	        return canlendar.getTime();
	    }

	    /**
	     * ��ȡʱ����ڵ�ʱ���б�
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
	     * ��ȡʱ����ڵ�ʱ���б�
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
	     * �õ�n��֮�����ܼ�
	     * 
	     * @param days
	     * @return
	     */
	    public static String getAfterDayWeek(String days) {
	        int daysInt = Integer.parseInt(days);

	        Calendar canlendar = Calendar.getInstance(); // java.util��
	        canlendar.add(Calendar.DATE, daysInt); // ���ڼ� ����������Ὣ�±䶯
	        Date date = canlendar.getTime();

	        SimpleDateFormat sdf = new SimpleDateFormat("E");
	        String dateStr = sdf.format(date);

	        return dateStr;
	    }

	    /**
	     * @Title: compare
	     * @Description: �Ƚ�����ʱ���С ��ʱ��1+������ʱ��2��
	     * @param d1
	     *            ʱ��1
	     * @param d2
	     *            ʱ��2
	     * @param time
	     *            ����
	     * @return
	     */
	    public static int compare(Date d1, Date d2, int time) {
	        Date d = (Date) d1.clone();
	        d.setTime(d.getTime() + time * 1000);
	        return d.compareTo(d2);
	    }

	    /**
	     * @Title: getSecondSub
	     * @Description: ����ʱ���������(begin+time-endDate)
	     * @param beginDate
	     *            ��ʼʱ��
	     * @param endDate
	     *            ����ʱ��
	     * @param time
	     *            �������
	     * @return
	     */
	    public static long getSecondSub(Date beginDate, Date endDate, int time) {
	        long second = (beginDate.getTime() - endDate.getTime() + time * 1000) / 1000;
	        return second;
	    }

	    /**
	     * 
	     * ����˵��: ����ĳ���ڼ�n��������
	     * 
	     * @param d
	     *            ��������
	     * @param day
	     *            �Ӷ�����
	     * @return
	     */
	    public static Date rollDay(Date d, int day) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(d);
	        cal.add(Calendar.DAY_OF_MONTH, day);
	        return cal.getTime();
	    }

	    /**
	     * ��ʽ������������
	     * 
	     * @return
	     */
	    public static String fomatDateToCN(Date date) {
	        if (date == null) {
	            return "";
	        }
	        return new SimpleDateFormat("yyyy��MM��dd��").format(date);
	    }

	    /**
	     * ��ʽ���ɴ�б�ߵ�����
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
	     * @Description: ���ݴ�������ڻ�õ�������һ��ʱ��
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
	     * @Description:������d�Ļ����Ͻ���mon���·����
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
	     * ���ƶ��ַ���ת��Ϊ����
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
	     * @Description: ���ؼ�����ĳ��ʱ���
	     * @param afterDay
	     *            ����
	     * @param time
	     *            ʱ�� 10:00
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
	     * @Description:ĳһ��Ŀ�ʼʱ��
	     * @param date
	     *            00��00��00
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
	     * @Description: ĳһ��Ľ���ʱ��
	     * @param date
	     *            23��59��59
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
	    * @Description: ��ƫ�� 
	    * @param @param date
	    * @param @param seconds
	    * @param @return    �趨�ļ� 
	    * @return Date    �������� 
	    * @throws 
	    */
	    public static Date secondsOffSet(Date date, long seconds) {
	        return new Date(date.getTime()+seconds*1000);
	    }
	    
	    /**
	     * �� "2016-06-02(������) 10:00-12:00" ��ʽ���ַ����л�ȡ����ǰ��ʱ��
	     * @param str
	     * @return
	     * map : {
	     *          startTime -- ��ʼʱ��
	     *          endTime -- ����ʱ��
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
	     * ������ʱ���л�ȡ 2016-06-02(������) 10:00-12:00 ��ʽ�ַ���
	     * @param startTime
	     * @param endTime
	     * @return
	     */
	    public static  String getDateTimeStr(Date startTime,Date endTime){
	    	if(startTime == null){
	    		return "��ʼʱ��Ϊ��";
	    	}
	    	if(endTime == null){
	    		return "����ʱ��Ϊ��";
	    	}
	    	SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
	    	String date = dateSdf.format(startTime);
	    	
	    	String[] weekDays = {"������", "����һ", "���ڶ�", "������", "������", "������", "������"};
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
	     * ��ȡ����Сʱ֮���ʱ��,�����ȡ����Сʱ֮ǰ��ʱ��,��hourֵΪ��Ӧֵ�ĸ���
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
	     * ��һ��Date�����ʱ������Ϊ  00:00:00
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
