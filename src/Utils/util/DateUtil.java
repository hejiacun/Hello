package Utils.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by kongxiangjian on 2018/11/22.
 */
public class DateUtil {
	/**
	 * 年-月-日 小时 yyyy-MM-dd HH
	 */
	public static final String SIMPLE_FORMAT = "yyyy-MM-dd HH";
	/**
	 * 完整时间 yyyy-MM-dd HH:mm:ss
	 */
	public static final String SIMPLE = "yyyy-MM-dd HH:mm:ss";

	public static final String DEFAULTDATEPATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String DATEPATTERN_HHMM = "HH:mm";

	public static final String DATEPATTERN_DAY_END_TIME = "yyyy-MM-dd 23:59:59";

    /**
     * 获取当前时间的秒值
     * @return
     */
    public static Integer getCurrentSecondTimestamp(){
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }
    
	public static long parse(String time, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(time).getTime();
	}

	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	public static String converLongToTime(Long time, String pattern) {
		if(StringUtil.hasBlank(time)){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(time);
	}

	/**
	 * 将long类型时间改为HH:mm:ss格式
	 * @param time
	 * @return
	 */
	public static String converLongTimeToStr(long time) {
		int ss = 1000;
		long times = Math.round((double) time / ss);
		int mi = 60;
		int hh = mi * 60;
		long hour = (times) / hh;
		long minute = (times - hour * hh) / mi;
		long second =  times - hour * hh - minute * mi;
		String strHour = hour < 10 ? "0" + hour : "" + hour;
		String strMinute = minute < 10 ? "0" + minute : "" + minute;
		String strSecond = second < 10 ? "0" + second : "" + second;
		if (hour > 0) {
			return strHour + ":" + strMinute + ":" + strSecond;
		} else {
			return "00:"+strMinute + ":" + strSecond;
		}
	}

		/**
		 * 返回当前时间精确到小时后 的时间戳
		 *
		 * @return
		 */
		public static Integer getNewHourTime() {
			String simpleDate = getFormat(SIMPLE_FORMAT).format(new Date()) + ":00:00";
			try {
				Date descDate = getFormat(SIMPLE).parse(simpleDate);
				return new Long(descDate.getTime() / 1000).intValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return 0;
		}

	/**
	 * 获取格式
	 *
	 * @param format
	 * @return
	 */
	public static final DateFormat getFormat(String format) {
		return new SimpleDateFormat(format);
	}

	/**
	 * Long类型转化为String类型
	 *
	 * @author Yiliya
	 */
	public static String formatLong2String(Long time, String format) {
		if (time == null || "".equals(time)) {
			return null;
		}
		Date date = formatLong2Date(time, format);
		DateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static Date formatLong2Date(Long time, String format) {
		if (time == null || "".equals(time)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);//这个是你要转成后的时间的格式
		Date sd = null;
		try {
			sd = new Date(time);
		} catch (Exception e) {
			return null;
		}
		return sd;
	}
	
	public static Integer getTime(int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, day);
		calendar.add(Calendar.MONTH, month);
		return (int)(calendar.getTime().getTime()/1000);
	}

	/**
	 * 获取当前时间戳 精确到秒
	 *
	 * @return
	 */
	public static Integer getCurrentSecondIntValue() {
		return new Long(System.currentTimeMillis() / 1000).intValue();
	}

	/**
	 * 把时间格式化成字符串
	 *
	 * @param date   时间
	 * @param format 格式
	 * @return
	 */
	public static String formatDate2String(Date date, String format) {
		if (null == date) {
			return null;
		}
		DateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static Long stringConvert2Long(String dateStr) {

		if (null == dateStr) {
			return 0L;
		}
		DateFormat formatter = new SimpleDateFormat(DEFAULTDATEPATTERN);

		try {
			return formatter.parse(dateStr).getTime();
		} catch (ParseException e) {
			return 0L;
		}
	}
}


