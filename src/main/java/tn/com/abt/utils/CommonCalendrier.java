package tn.com.abt.utils;

/**
 *
 * @author Ammar Meher
 * @version 2.0
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CommonCalendrier {

	public CommonCalendrier() {
	}

	public static java.sql.Date utilDateToSqlDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static java.util.Date sqlDateToUtilDate(java.sql.Date date) {
		return new java.util.Date(date.getTime());
	}

	// timeZone = "GMT+1"
	public static java.util.Date addJour(java.util.Date date, int n, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		gc.add(GregorianCalendar.DAY_OF_MONTH, n);
		return gc.getTime();
	}

	public static java.util.Date addMonth(java.sql.Date date, int m, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(sqlDateToUtilDate(date));
		gc.add(GregorianCalendar.MONTH, m);
		return gc.getTime();
	}

	public static java.util.Date addMonth(java.util.Date date, int m, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		gc.add(GregorianCalendar.MONTH, m);
		return gc.getTime();
	}

	public static java.util.Date addHour(java.util.Date date, int h, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		gc.add(GregorianCalendar.HOUR, h);
		return gc.getTime();
	}

	public static java.util.Date addMinute(java.util.Date date, int m, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		gc.add(GregorianCalendar.MINUTE, m);
		return gc.getTime();
	}

	public static java.util.Date addSecond(java.util.Date date, int s, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		gc.add(GregorianCalendar.SECOND, s);
		return gc.getTime();
	}

	public static int getMonth(java.util.Date date, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		return gc.get(GregorianCalendar.MONTH);

	}

	public static int getYear(java.util.Date date, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		return gc.get(GregorianCalendar.YEAR);
	}

	public static int getHour(java.util.Date date, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		return gc.get(GregorianCalendar.HOUR_OF_DAY);
	}

	public static int getMinute(java.util.Date date, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		return gc.get(GregorianCalendar.MINUTE);
	}

	public static int getSecond(java.util.Date date, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.setTime(date);
		return gc.get(GregorianCalendar.SECOND);
	}

	public static java.sql.Date getDate(int day, int month, int year, String timeZone) {
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(timeZone));
		gc.set(year, month, day);
		return utilDateToSqlDate(gc.getTime());
	}

	public static java.util.Date nowTime() {
		Calendar cal = Calendar.getInstance();
		try {
			return cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static java.util.Date precisionNowTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
		java.util.Date now = null;
		Calendar cal = Calendar.getInstance();
		try {
			now = dateFormat.parse(dateFormat.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return now;
	}

	public static java.util.Date getFirstDateOfDate(java.util.Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	public static java.util.Date getLastDateOfDate(java.util.Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	public static java.util.Date getFirstDateOfYear(java.util.Date date) {
		try {
			SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");
			SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstants.FORMAT_DATE_1);
			return dateFormat.parse("01/01/" + yearDateFormat.format(date));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static java.util.Date getLastDateOfYear(java.util.Date date) {
		try {
			SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");
			SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstants.FORMAT_DATE_1);
			return dateFormat.parse("31/12/" + yearDateFormat.format(date));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int getMonthsBetweenDates(java.util.Date startDate, java.util.Date endDate) {
		if (startDate.getTime() > endDate.getTime()) {
			java.util.Date temp = startDate;
			startDate = endDate;
			endDate = temp;
		}
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		int yearDiff = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int monthsBetween = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH) + 12 * yearDiff;
		return monthsBetween;
	}

	public static boolean isDateOfMonth(java.util.Date ref, int sens, java.util.Date date, String timeZone) {
		SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
		SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");
		java.util.Date dateCourant = addMonth(ref, sens, timeZone);
		if (yearDateFormat.format(dateCourant).equals(yearDateFormat.format(date))
				&& monthDateFormat.format(dateCourant).equals(monthDateFormat.format(date))) {
			return true;
		} else {
			return false;
		}

	}

	public static String getDateAsString(String dateFormat, java.util.Date date) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(date);
	}

	public static java.util.Date getStringAsDate(String dateFormat, String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.parse(date);
	}

	public static String convertStringDateToOutputFormatAsString(String inputFormat, String outputFormat, String date)
			throws ParseException {
		SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputFormat);
		SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
		return outputDateFormat.format(inputDateFormat.parse(date));
	}

	public static boolean isValidStringDate(String dateFormat, String date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			format.setLenient(false);
			format.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(isValidStringDate("", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}