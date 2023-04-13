package tn.com.abt.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

/** @modelguid {0F6EAAED-EF9F-44F0-9025-B036B579DE8B} */
public class StrHandler {

	/** @modelguid {E4D62555-A916-418C-AAB0-E6B23A5E8EB4} */
	private static String DayMonthYearSeparator = "/";
	/** @modelguid {7A29471C-3105-4788-9DE8-22EFF0435B5B} */
	private static String HourMinuteSecondeSeparator = ":";
	/** @modelguid {AB4D66AC-B407-4F8C-B96C-C58C4F6405E7} */
	private static String DateTimeDelimiter = " ";
	/** @modelguid {A0CBECD0-F022-4180-ADE1-1BEF86B32969} */
	public static final String DateFormat = "dd" + DayMonthYearSeparator + "MM" + DayMonthYearSeparator + "yyyy";
	/** @modelguid {480F52AD-2665-41A7-B338-F7C7D521E002} */
	public static final String TimeFormat = "dd" + DayMonthYearSeparator + "MM" + DayMonthYearSeparator + "yyyy" + DateTimeDelimiter + "hh"
			+ HourMinuteSecondeSeparator + "mm" + HourMinuteSecondeSeparator + "ss";
	/** @modelguid {6B420613-0C85-41BA-B5FF-0CF43EB16386} */
	public static final NumberFormat NF = new DecimalFormat("#,###,###,##0.00");

	public StrHandler() {
	}

	/** @modelguid {8932E4AF-17FF-438A-BA7B-02B4795BD3EB} */
	public static String numberToStr(Number value, int scale) {
		DecimalFormat nbrF = new DecimalFormat("#0");
		nbrF.setMinimumFractionDigits(scale);

		if (value == null) {
			return "";
		} else {
			return StrHandler.replace(nbrF.format(new Double(value.doubleValue())), ",", ".");
		}
	}

	public static String double2StrSansSep(Double mnt) {
		if (mnt == null)
			return new String("");
		String ret = "";
		if (mnt.doubleValue() < 0) {
			ret = new DecimalFormat("-#########0.000").format(mnt.doubleValue() * (-1));
		} else {
			ret = new DecimalFormat("#########0.000").format(mnt.doubleValue());
		}
		return ret;
	}

	public static String double2Str(Double mnt) {
		if (mnt == null)
			return new String("");
		String ret = "";
		if (mnt.doubleValue() < 0) {
			ret = new DecimalFormat("-#,###,###,##0.000").format(mnt.doubleValue() * (-1));
		} else {
			ret = new DecimalFormat("#,###,###,##0.000").format(mnt.doubleValue());
		}
		return ret;
	}

	public static String double2Txt(Double mnt, int nbrdec) {
		String strdec = "";
		if (nbrdec == 1)
			strdec = "#,###,###,##0.0";
		if (nbrdec == 2)
			strdec = "#,###,###,##0.00";
		if (nbrdec == 3)
			strdec = "#,###,###,##0.000";
		if (nbrdec == 4)
			strdec = "#,###,###,##0.0000";
		if (nbrdec == 5)
			strdec = "#,###,###,##0.00000";
		if (nbrdec == 6)
			strdec = "#,###,###,##0.000000";
		if (nbrdec == 7)
			strdec = "#,###,###,##0.0000000";
		if (nbrdec == 8)
			strdec = "#,###,###,##0.00000000";
		if (nbrdec == 9)
			strdec = "#,###,###,##0.000000000";
		if (nbrdec == 10)
			strdec = "#,###,###,##0.0000000000";

		if (mnt == null || mnt.equals(new Double(0)))
			return new String("0,000");
		String ret = new DecimalFormat(strdec, new DecimalFormatSymbols(Locale.FRANCE)).format(mnt.doubleValue());
		return ret;
	}

	/** @modelguid {9D9D19A5-245D-4218-868B-5CA5A27F48EA} */
	public static Float strToFloat(String value) {
		if (value == null) {
			return null;
		} else if (value.trim().equals("")) {
			return null;
		} else {
			return new Float(value);
		}
	}

	public static Double opposeOfDouble(Double value) {
		Long val = null;
		Double val1 = null;
		if (value == null) {
			return (new Double(0));
		} else {
			val1 = new Double(value.doubleValue() * 1000);
			val = new Long((-1) * val1.longValue());
			return (new Double(val.doubleValue() / 1000));
		}
	}

	/** @modelguid {A4CC665F-76BD-4F19-8DB5-BF711FACAE60} */
	public static BigDecimal strToBigDecimal(String value) {
		if (value == null) {
			return null;
		} else if (value.trim().equals("")) {
			return null;
		} else {
			return new BigDecimal(value);
		}
	}

	/** @modelguid {8B99FF86-EBE6-4F87-82CA-2C289321B1CB} */
	public static Double txt2Double(String str) {
		Double ret = new Double(0);
		if (str != null || !str.equals("")) {
			String str1;
			str1 = str.trim();
			String str2 = "";
			str1 = str1.replace(',', '.');
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == '0' || str1.charAt(i) == '1' || str1.charAt(i) == '2' || str1.charAt(i) == '3'
						|| str1.charAt(i) == '4' || str1.charAt(i) == '5' || str1.charAt(i) == '6' || str1.charAt(i) == '7'
						|| str1.charAt(i) == '8' || str1.charAt(i) == '9' || str1.charAt(i) == '.' || str1.charAt(i) == ',')
					str2 += str1.charAt(i);
			}
			ret = new Double(str2);
		}
		return ret;
	}

	public static Double strToDouble(String value) {
		if (value == null) {
			return null;
		} else if (value.trim().equals("")) {
			return null;
		} else {
			return new Double(value);
		}
	}

	/** @modelguid {77026D0D-E437-46B5-8FF8-301324383B49} */
	public static Integer strToInteger(String value) {
		if (value == null) {
			return null;
		} else if (value.trim().equals("")) {
			return null;
		} else {
			return new Integer(value);
		}
	}

	/** @modelguid {51E090A7-9D1C-4BF0-A78D-DAC4EEEF5143} */
	public static Long strToLong(String value) {
		if (value == null) {
			return null;
		} else if (value.trim().equals("")) {
			return null;
		} else {
			return new Long(value);
		}
	}

	/** @modelguid {1B00DEEB-1525-410C-B1FF-3FEE6C6F9682} */
	public static Short strToShort(String value) {
		if (value == null) {
			return null;
		} else if (value.trim().equals("")) {
			return null;
		} else {
			return new Short(value);
		}
	}

	/** @modelguid {74F41074-2FD3-416D-8CD8-BF8D2EEC2154} */
	public static BigInteger strToBigInteger(String value) {
		if (value == null) {
			return null;
		} else if (value.trim().equals("")) {
			return null;
		} else {
			return new BigInteger(value);
		}
	}

	public static double dateMinesDate(Date d1, Date d2) {
		java.util.Date date1 = CommonCalendrier.sqlDateToUtilDate(d1);
		java.util.Date date2 = CommonCalendrier.sqlDateToUtilDate(d2);
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.setTime(date1);
		GregorianCalendar gc2 = new GregorianCalendar();
		gc2.setTime(date2);
//     soustraction de deux calendriers
//     on passe par leur valeur en milisecondes
//     pour faire des soustractions entre deux calendriers
		long difference = gc2.getTime().getTime() - gc1.getTime().getTime();
//     calcul de la diff�rence en jours entre deux calendriers
//     on utilise la valeur en milisecondes et on la convertit en jours.

		double diffgc = difference / (24 * 60 * 60 * 1000);

		return diffgc;

	}

	public static int dateMinesDateUtil(java.util.Date d1, java.util.Date d2) {
		int j, j1, j2, n, n1, n2, m1, m2, m;
		GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("GMT+1"));

		gc.setTime(d1);
		n1 = GregorianCalendar.DAY_OF_MONTH;
		m1 = GregorianCalendar.MONTH;
		j1 = GregorianCalendar.DATE;
		gc.setTime(d2);
		n2 = GregorianCalendar.DAY_OF_MONTH;
		m2 = GregorianCalendar.MONTH;
		j2 = GregorianCalendar.DATE;

		n = j2 - j1;

		return n;

	}

	public static String getMonthOfDate(java.sql.Date value) {
		String m = "";
		if (value == null) {
			return "";
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new java.util.Date(value.getTime()));
			m = String.valueOf(gc.get(Calendar.MONTH) + 1);

			if (m.length() == 1) {
				m = "0" + m;
			}
			return m;
		}
	}

	public static String getDayOfDate(java.sql.Date value) {
		String d = "";

		if (value == null) {
			return "";
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new java.util.Date(value.getTime()));
			d = String.valueOf(gc.get(Calendar.DATE));
			if (d.length() == 1) {
				d = "0" + d;
			}
			return d;
		}
	}

	public static String getYearOfDate(java.sql.Date value) {
		if (value == null) {
			return "";
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new java.util.Date(value.getTime()));
			return String.valueOf(gc.get(Calendar.YEAR));
		}
	}

	/** @modelguid {889C823E-A68D-40F4-B67F-6ADDEEFB4FF8} */
	public static java.text.DateFormat strToDateFr(String value) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(DateFormat);
			df.setLenient(false);
			return SimpleDateFormat.getDateInstance(2, new Locale("fr", ""));
		} catch (Exception E) {
			return null;
		}
	}

	/** @modelguid {8224E978-1E3C-4F55-8E20-9F933FB15B78} */
	public static java.sql.Date strToDate(String value) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(DateFormat);
			df.setLenient(false);
			return new java.sql.Date(df.parse(value).getTime());
		} catch (Exception E) {
			return null;
		}
	}

	/** @modelguid {AB477977-AFF4-4BB0-970E-C3BB94193004} */
	public static String dateToStr(java.sql.Date value) {
		String d = "";
		String m = "";
		if (value == null) {
			return "";
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new java.util.Date(value.getTime()));
			d = String.valueOf(gc.get(Calendar.DATE));
			m = String.valueOf(gc.get(Calendar.MONTH) + 1);
			if (d.length() == 1) {
				d = "0" + d;
			}
			if (m.length() == 1) {
				m = "0" + m;
			}
			return String.valueOf(gc.get(Calendar.YEAR)) + DayMonthYearSeparator + m + DayMonthYearSeparator + d;
		}
	}

	/** @modelguid {FFC17E00-5BAC-4273-A2F3-7BAE54DC035B} */
	public static Time strToTime(String value) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(TimeFormat);
			return new java.sql.Time(df.parse(value).getTime());
		} catch (Exception E) {
			return null;
		}
	}

	/** @modelguid {F2C25FAA-6DCB-424C-BFAE-10AF7DD60DE8} */
	public static String timeToStr(Time value) {
		if (value == null) {
			return "";
		} else {
			GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("GMT+1"));
			gc.setTime(new java.util.Date(value.getTime()));
			return String.valueOf(gc.get(Calendar.DATE)) + DayMonthYearSeparator + String.valueOf(gc.get(Calendar.MONTH) + 1)
					+ DayMonthYearSeparator + String.valueOf(gc.get(Calendar.YEAR))
					+ DateTimeDelimiter + String.valueOf(gc.get(Calendar.HOUR_OF_DAY)) + HourMinuteSecondeSeparator
					+ String.valueOf(gc.get(Calendar.MINUTE)) + HourMinuteSecondeSeparator + String.valueOf(gc.get(Calendar.SECOND));
		}
	}

	/** @modelguid {B75EF1D0-E124-4AF7-8183-01DBD47A9247} */
	public static Timestamp strToTimestamp(String value) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(TimeFormat);
			return new java.sql.Timestamp(df.parse(value).getTime());
		} catch (Exception E) {
			E.printStackTrace(System.out);
			return null;
		}
	}

	/** @modelguid {82856107-5365-4ACD-A006-0E22BA4DE5FF} */
	public static String timestampToStr(Timestamp value) {
		if (value == null) {
			return "";
		} else {
			GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("GMT+1"));
			gc.setTime(new java.util.Date(value.getTime()));
			return String.valueOf(gc.get(Calendar.DATE)) + DayMonthYearSeparator + String.valueOf(gc.get(Calendar.MONTH) + 1)
					+ DayMonthYearSeparator + String.valueOf(gc.get(Calendar.YEAR))
					+ DateTimeDelimiter + String.valueOf(gc.get(Calendar.HOUR_OF_DAY)) + HourMinuteSecondeSeparator
					+ String.valueOf(gc.get(Calendar.MINUTE)) + HourMinuteSecondeSeparator + String.valueOf(gc.get(Calendar.SECOND));
		}
	}

	public static String strTimestampToStrDate(java.util.Date value) throws Exception {
		if (value != null) {
			String strdate = "";
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			strdate = dateFormat.format(value);
			return (strdate);
		} else {
			return ("");
		}
	}

	public static String strTimestampToStrTime(java.util.Date value) throws Exception {
		if (value != null) {
			String strdate = "";
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			strdate = dateFormat.format(value);
			return (strdate);
		} else {
			return ("");
		}
	}
	/*
	 * public static String validate(String str){
	 * if (validator.isValid(str)) return str ; else return null;
	 * }
	 * 
	 * @modelguid {56E7B17E-60B0-42F1-BB30-BB4D20457B95}
	 */

	public static String replace(String value, String ancien, String nouveau) {
		if (value == null)
			return null;
		else if (value.equals("")) {
			return "";
		} else if (value.indexOf(ancien) == -1) {
			return value;
		} else {
			return value.substring(0, value.indexOf(ancien)) + nouveau
					+ replace(value.substring(value.indexOf(ancien) + ancien.length(), value.length()), ancien, nouveau);
		}
	}

	/** @modelguid {76AD6A15-ECF9-4DC7-8531-737551D03092} */
	public static String QuotedStr(String value) {
		// fonction � revoir pour les sp�cial case.
		if (value != null)
			return "\'" + value + "\'";
		else
			return "NULL";
	}

	/** @modelguid {A015765D-DD98-4113-96CC-7743501D5486} */
	public static String repeatNtimes(char ch, int len) {
		String result = "";
		for (int i = 0; i < len; i++)
			result = result + ch;
		return result;
	}

	/** @modelguid {09A01F11-6BA2-4871-A24E-8821AC820A6E} */
	public static String fillWithZero(String value, int len) {
		return repeatNtimes(' ', len - value.length()) + value;
	}

	/** @modelguid {3EC5E1A5-AF5E-4879-991E-F21424B6EE53} */
	public static String[] split(String value, String delimiter) {
		StringTokenizer strTake = new StringTokenizer(value, delimiter);
		String[] result = new String[strTake.countTokens()];
		int i = 0;
		while (strTake.hasMoreTokens()) {
			result[i] = strTake.nextToken();
			i++;
		}
		return result;
	}

	/** @modelguid {66AFE2B3-6A52-45A6-B856-8F8989965636} */
	public static String emptyIfNull(String value) {
		if (value == null)
			return "";
		else
			return value;
	}

	/** @modelguid {771244C2-A039-4F90-A596-F466E1827358} */
	public static boolean isEmpty(String value) {
		return (value == null) || (value.trim().equals(""));
	}

	public static String date2Day(String date) {
		return date.toString().substring(0, 2);
	}

	public static String lefString(String strInput, char charRemplissage, int tailleFinale) {
		String resultat = strInput;
		int inputLength = strInput.length();
		if (inputLength < tailleFinale) {
			String Remplissage = "";
			while (Remplissage.length() < (tailleFinale - inputLength)) {
				Remplissage += charRemplissage;
			}
			resultat = Remplissage + resultat;

		} else {
			resultat = strInput.substring(0, tailleFinale);
		}

		return resultat;
	}

	public static String rightString(String strInput, char charRemplissage, int tailleFinale) {
		String resultat = strInput;
		int inputLength = strInput.length();
		if (inputLength < tailleFinale) {
			String Remplissage = "";
			while (Remplissage.length() < (tailleFinale - inputLength)) {
				Remplissage += charRemplissage;
			}
			resultat += Remplissage;

		} else {
			resultat = strInput.substring(0, tailleFinale);
		}

		return resultat;
	}

	public static String clobToString(Object clob) throws SQLException {
		if (clob != null && clob instanceof Clob) {
			long length = ((Clob) clob).length();
			return ((Clob) clob).getSubString(1, (int) length);
		} else {
			return null;
		}
	}

	public String getFileContent(String fName) throws java.io.IOException {
		File file = new File(fName);
		long size = file.length();
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream((int) size);
		String enc = "";
		if (!file.exists()) {
			// System.out.println("erreur");
		}

		for (long i = 0; i < size; i++) {
			baos.write(fis.read());
			if (i == 2L) {
				byte[] firstThree = baos.toByteArray();
				enc = "windows-1256";
			}
		}

		return baos.toString(enc);

	}

}