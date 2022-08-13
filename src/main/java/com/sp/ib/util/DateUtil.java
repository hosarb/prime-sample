package com.sp.ib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA. User: arbaboon Date: 5/12/12 Time: 2:57 PM To
 * change this template use File | Settings | File Templates.
 */
public class DateUtil {


    public static final String DATE_PATTERN = "yyyyMMdd";
    public static final String DATE_TIME_PATTERN = "yyyyMMddHHmmss";
    public static final String TODAY_DATE_IDENTIFIER = "today";
    public static final String YESTERDAY_DATE_IDENTIFIER = "yesterday";
    public static final String TOMORROW_DATE_IDENTIFIER = "tomorrow";
    public static final String LAST_YEAR_DATE_IDENTIFIER = "lastYear";
    public static final String NEXT_YEAR_DATE_IDENTIFIER = "nextYear";
    public static final String YEAR_START_DATE_IDENTIFIER = "yearStart";
    public static final String YEAR_END_DATE_IDENTIFIER = "yearEnd";
    public static final String LAST_MONTH_DATE_IDENTIFIER = "lastMonth";
    public static final String NEXT_MONTH_DATE_IDENTIFIER = "nextMonth";
    public static final String MONTH_START_DATE_IDENTIFIER = "monthStart";
    public static final String MONTH_END_DATE_IDENTIFIER = "monthEnd";

    public static Calendar roundDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static HijriShamsiCalendar roundDateFa(Date date) {
        HijriShamsiCalendar cal = new HijriShamsiCalendar();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static HijriShamsiCalendar ceilDateFa(Date date) {
        HijriShamsiCalendar cal = new HijriShamsiCalendar();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal;
    }

    public static Calendar ceilDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal;
    }

    public static Calendar floorDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static Date todayDate() {
        Calendar cal = roundDate(new Date());
        return cal.getTime();
    }

    public static Date todayDateTime() {
        return getTodayDateTime();
    }

    /**
     * @param date
     * @param days
     * @return
     * @deprecated use <b>addDaysToDate(Date date, int days, boolean solar)</b>
     * instead.
     */
    @Deprecated
    public static Date addDaysToDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + days);
        return cal.getTime();
    }

    public static Date addHoursToDate(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + hours);
        return cal.getTime();
    }

    public static Date addMinutesToDate(Date date, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + minutes);
        return cal.getTime();
    }

    /**
     * @param date
     * @param months
     * @return
     * @deprecated use <b>addMonthsToDate(Date date, int months, boolean
     * solar)</b> instead.
     */
    @Deprecated
    public static Date addMonthsToDate(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + months);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * @param date
     * @param years
     * @return
     * @deprecated use <b>addYearsToDate(Date date, int years, boolean
     * solar)</b> instead.
     */
    @Deprecated
    public static Date addYearsToDate(Date date, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + years);
        return cal.getTime();
    }

    public static Date addDaysToDate(Date date, int days, boolean solar) {
        Calendar sourceCal = null;
        Calendar destCal = null;
        if (solar) {
            sourceCal = new HijriShamsiCalendar();
            destCal = new HijriShamsiCalendar();
        } else {
            sourceCal = new GregorianCalendar();
            destCal = new GregorianCalendar();
        }
        sourceCal.setTime(date);
        destCal.set(sourceCal.get(Calendar.YEAR), sourceCal.get(Calendar.MONTH), sourceCal.get(Calendar.DAY_OF_MONTH) + days, sourceCal.get(Calendar.HOUR_OF_DAY), sourceCal.get(Calendar.MINUTE), sourceCal.get(Calendar.SECOND));
        destCal.set(Calendar.MILLISECOND, sourceCal.get(Calendar.MILLISECOND));
        return destCal.getTime();
    }

    public static Date minusDaysToDate(Date date, String days) {
        Calendar sourceCal = null;
        Calendar destCal = null;
        sourceCal = new GregorianCalendar();
        destCal = new GregorianCalendar();
        sourceCal.setTime(date);
        destCal.set(sourceCal.get(Calendar.YEAR), sourceCal.get(Calendar.MONTH), sourceCal.get(Calendar.DAY_OF_MONTH) - Integer.parseInt(days), sourceCal.get(Calendar.HOUR_OF_DAY), sourceCal.get(Calendar.MINUTE), sourceCal.get(Calendar.SECOND));
        destCal.set(Calendar.MILLISECOND, sourceCal.get(Calendar.MILLISECOND));
        return destCal.getTime();
    }


    public static Date addMonthsToDate(Date date, int months, boolean solar) {
        Calendar sourceCal = null;
        Calendar destCal = null;
        if (solar) {
            sourceCal = new HijriShamsiCalendar();
            destCal = new HijriShamsiCalendar();
        } else {
            sourceCal = new GregorianCalendar();
            destCal = new GregorianCalendar();
        }
        sourceCal.setTime(date);
        destCal.set(sourceCal.get(Calendar.YEAR), sourceCal.get(Calendar.MONTH) + months, sourceCal.get(Calendar.DAY_OF_MONTH), sourceCal.get(Calendar.HOUR_OF_DAY), sourceCal.get(Calendar.MINUTE), sourceCal.get(Calendar.SECOND));
        return destCal.getTime();
    }

    public static Date addMonthsToDate(Date date, int months, int dayOfMonth, boolean solar) {
        Calendar sourceCal = null;
        Calendar destCal = null;
        if (solar) {
            sourceCal = new HijriShamsiCalendar();
            destCal = new HijriShamsiCalendar();
        } else {
            sourceCal = new GregorianCalendar();
            destCal = new GregorianCalendar();
        }
        sourceCal.setTime(date);
        final int numberOfMonthsFromStartOfSourceYear = sourceCal.get(Calendar.MONTH) + months;
        final int destinationYear = sourceCal.get(Calendar.YEAR) + numberOfMonthsFromStartOfSourceYear / 12;
        final int destinationMonth = numberOfMonthsFromStartOfSourceYear % 12;
        final int destinationDayOfMonth = decreaseDayOfMonthIfKabiseRuleViolates(solar, destinationMonth, dayOfMonth, sourceCal);
        destCal.set(destinationYear, destinationMonth, destinationDayOfMonth, sourceCal.get(Calendar.HOUR_OF_DAY), sourceCal.get(Calendar.MINUTE), sourceCal.get(Calendar.SECOND));
        return destCal.getTime();
    }

    private static int decreaseDayOfMonthIfKabiseRuleViolates(boolean solar, final int destinationMonth, int dayOfMonth, Calendar sourceCal) {
        if (solar && destinationMonth % 11 == 0 && dayOfMonth >= 30) {
            int destinationYear = sourceCal.get(Calendar.YEAR) + ((destinationMonth - 1) / 11);
            Boolean isKabiseDestination = (destinationYear - 1311) % 4 == 0;
            if (isKabiseDestination) {
                dayOfMonth = 30;
            } else {
                dayOfMonth = 29;
            }
        }
        return dayOfMonth;
    }

    public static Date addYearsToDate(Date date, int years, boolean solar) {
        Calendar sourceCal = null;
        Calendar destCal = null;
        if (solar) {
            sourceCal = new HijriShamsiCalendar();
            destCal = new HijriShamsiCalendar();
        } else {
            sourceCal = new GregorianCalendar();
            destCal = new GregorianCalendar();
        }
        sourceCal.setTime(date);
        int dayOfMonth = sourceCal.get(Calendar.DAY_OF_MONTH);
        if (solar && sourceCal.get(Calendar.MONTH) == 11 && dayOfMonth == 30) {
            Boolean isKabise = (sourceCal.get(Calendar.YEAR) - 1311) % 4 == 0;
            if (isKabise && ((years % 4) != 0)) {
                dayOfMonth = dayOfMonth - 1;
            }
        }
        destCal.set(sourceCal.get(Calendar.YEAR) + years, sourceCal.get(Calendar.MONTH), dayOfMonth, sourceCal.get(Calendar.HOUR_OF_DAY), sourceCal.get(Calendar.MINUTE), sourceCal.get(Calendar.SECOND));
        return destCal.getTime();
    }

    public static Date getYearStartForDate(Date date) {
        Calendar cal = roundDate(date);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    public static Date getMonthStartForDate(Date date) {
        Calendar cal = roundDate(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public static Date getSolarWeekStartForDate(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
            cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            return DateUtil.addDaysToDate(cal.getTime(), -1, true);
        }

        return date;
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static String formatDate(Date date, String pattern, String locale) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        if ("fa".equalsIgnoreCase(locale)) {
            dateFormat.setCalendar(new HijriShamsiCalendar());
        }
        return dateFormat.format(date);

    }

    public static Date parseDate(String dateValue, String pattern, String locale) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        if ("fa".equalsIgnoreCase(locale)) {
            dateFormat.setCalendar(new HijriShamsiCalendar());
        }
        return dateFormat.parse(dateValue);
    }

    public static Date getDateForIdentifier(String identifier) {
        if (TODAY_DATE_IDENTIFIER.equals(identifier)) {
            return todayDate();
        }

        if (YESTERDAY_DATE_IDENTIFIER.equals(identifier)) {
            return addDaysToDate(todayDate(), -1);
        }

        if (TOMORROW_DATE_IDENTIFIER.equals(identifier)) {
            return addDaysToDate(todayDate(), 1);
        }

        if (LAST_YEAR_DATE_IDENTIFIER.equals(identifier)) {
            return addYearsToDate(todayDate(), -1);
        }

        if (NEXT_YEAR_DATE_IDENTIFIER.equals(identifier)) {
            return addYearsToDate(todayDate(), 1);
        }

        if (YEAR_START_DATE_IDENTIFIER.equals(identifier)) {
            return getYearStartForDate(todayDate());
        }

        if (YEAR_END_DATE_IDENTIFIER.equals(identifier)) {
            Date date = getYearStartForDate(todayDate());
            date = addYearsToDate(date, 1);
            date = addDaysToDate(date, -1);
            return ceilDate(date).getTime();
        }

        if (LAST_MONTH_DATE_IDENTIFIER.equals(identifier)) {
            return addMonthsToDate(todayDate(), -1);
        }

        if (NEXT_MONTH_DATE_IDENTIFIER.equals(identifier)) {
            return addMonthsToDate(todayDate(), 1);
        }

        if (MONTH_START_DATE_IDENTIFIER.equals(identifier)) {
            return getMonthStartForDate(todayDate());
        }

        if (MONTH_END_DATE_IDENTIFIER.equals(identifier)) {
            Date date = getMonthStartForDate(todayDate());
            date = addMonthsToDate(date, 1);
            date = addDaysToDate(date, -1);
            return ceilDate(date).getTime();
        }

        return null;
    }

    public static String getDateForIdentifier(String identifier, String pattern) {
        Date date = getDateForIdentifier(identifier);
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(date);
        }
        return null;
    }

    public static Date getDayStartDate(Date date) {
        return roundDate(date).getTime();
    }

    public static Date getDayEndDate(Date date) {
        return ceilDate(date).getTime();
    }

    public static Date getSolarMonthStartDate(Date date) {
        HijriShamsiCalendar cal = new HijriShamsiCalendar();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Integer getDayOfMonth(Date date, boolean solar) {
        Calendar cal = solar ? new HijriShamsiCalendar() : new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static Integer getMonthOfYear(Date date, boolean solar) {
        Calendar cal = solar ? new HijriShamsiCalendar() : new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static Date getSolarMonthEndDate(Date date) {
        HijriShamsiCalendar cal = new HijriShamsiCalendar();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        if (month < 6) {
            cal.set(Calendar.DAY_OF_MONTH, 31);
        } else if (month < 11) {
            cal.set(Calendar.DAY_OF_MONTH, 30);
        } else if (cal.isLeapYear(cal.get(Calendar.YEAR))) {
            cal.set(Calendar.DAY_OF_MONTH, 30);
        } else {
            cal.set(Calendar.DAY_OF_MONTH, 29);
        }
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static int compareWithNow(Date date) {
        Date today = todayDate();
        return compareDates(today, date);
    }

    /**
     * @param date1
     * @param date2
     * @return the value <code>0</code> if the date1 is equal to
     * date2; a value less than <code>0</code> if date1
     * is before the date2; and a value greater than
     * <code>0</code> if date1 is after the date2.
     */
    public static int compareDates(Date date1, Date date2) {
        Date roundedDate1 = roundDate(date1).getTime();
        Date roundedDate2 = roundDate(date2).getTime();
        return roundedDate1.compareTo(roundedDate2);
    }

    public static Date getTodayDate() {
        return DateUtil.roundDate(new Date()).getTime();
    }

    public static Date getTodayDateTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getTomorrowDate() {
        return addDaysToDate(getTodayDate(), 1);
    }

    public static Date getYesterdayDate() {
        return addDaysToDate(getTodayDate(), -1);
    }

    public static Date combineDateAndTime(Date date, Date time) {
        if (date == null || time == null) {
            return null;
        }
        if (date != null && time == null) {
            return date;
        }
        if (date == null && time != null) {
            return time;
        }
        Calendar calendarA = Calendar.getInstance();
        calendarA.setTime(date);

        Calendar calendarB = Calendar.getInstance();
        calendarB.setTime(time);

        calendarA.set(Calendar.HOUR_OF_DAY, calendarB.get(Calendar.HOUR_OF_DAY));
        calendarA.set(Calendar.MINUTE, calendarB.get(Calendar.MINUTE));
        calendarA.set(Calendar.SECOND, calendarB.get(Calendar.SECOND));
        calendarA.set(Calendar.MILLISECOND, calendarB.get(Calendar.MILLISECOND));

        Date result = calendarA.getTime();
        return result;
    }


    public static String dateTimeToString(Date date, String locale) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_PATTERN);
        if ("fa".equalsIgnoreCase(locale)) {
            format.setCalendar(new HijriShamsiCalendar());
        }
        return format.format(date);
    }

    public static String toString(Date date, String locale) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        if ("fa".equalsIgnoreCase(locale)) {
            format.setCalendar(new HijriShamsiCalendar());
        }
        return format.format(date);
    }

    public static boolean realDayAndMonthRange(String value, String pattern) {
        int monthStartIndex = pattern.indexOf("M");
        int monthLenth = pattern.length() - pattern.replaceAll("[M]*", "").length();
        int monthVal = Integer.parseInt(value.substring(monthStartIndex, monthStartIndex + monthLenth));
        if (monthStartIndex > -1) {
            if (monthVal < 1 || monthVal > 12) {
                return false;
            }
        }
        int dayStartIndex = pattern.indexOf("d");
        int dayLenth = pattern.length() - pattern.replaceAll("[d]*", "").length();
        int dayVal = Integer.parseInt(value.substring(dayStartIndex, dayStartIndex + dayLenth));
        if (dayStartIndex > -1) {
            if (dayVal < 1 || dayVal > 31) {
                return false;
            }
        }
        return true;
    }

    public static Date updateDayOfMonth(Date date, int preferredMonthNumber, int dayOfMonth, boolean solar) {
        Calendar sourceCal;
        Calendar destCal;
        if (solar) {
            sourceCal = new HijriShamsiCalendar();
            destCal = new HijriShamsiCalendar();
        } else {
            sourceCal = new GregorianCalendar();
            destCal = new GregorianCalendar();
        }
        sourceCal.setTime(date);
        destCal.setTime(date);
        destCal.set(sourceCal.get(Calendar.YEAR), preferredMonthNumber - 1, dayOfMonth, sourceCal.get(Calendar.HOUR_OF_DAY), sourceCal.get(Calendar.MINUTE), sourceCal.get(Calendar.SECOND));
        return destCal.getTime();
    }

    public static Integer getDatesDifference(Date date1, Date date2) {
        long timeDiff = floorDate(date1).getTimeInMillis() - floorDate(date2).getTimeInMillis();
        long result = timeDiff / (1000 * 60 * 60 * 24);
        return (int) result;
    }

    public static Integer getTimesDifferenceInMinute(Date time1, Date time2) {
        long timeDiff = time1.getTime() - time2.getTime();
        long result = timeDiff / (1000 * 60);
        return (int) result;
    }

    public static Integer getTimesDifferenceInDay(Date time1, Date time2) {
        long timeDiff = time1.getTime() - time2.getTime();
        long result = timeDiff / (24 * 60 * 60 * 1000);
        return (int) result;
    }

    public static Date getDatesTimePart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    public static boolean afterTime(Date time1, Date time2) {
        long time1Value = Long.parseLong(formatDate(time1, "HHmmss"));
        long time2Value = Long.parseLong(formatDate(time2, "HHmmss"));
        return time1Value > time2Value;
    }

    public static Date floorTimeSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date ceilTimeSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static String getCurrentSolarYear() {
        String currentDate = formatDate(new Date(), "yyyy-MM-dd", "fa");
        return currentDate.substring(0, 4);
    }

    public static String getCurrentSolarFullFormat() {
        String currentDate = formatDate(new Date(), "yyyy-MM-dd", "fa");
        return currentDate;
    }

    public static String getCurrentSolarFullFormat(Date date) {
        String currentDate = formatDate(date, "yyyy-MM-dd", "fa");
        return currentDate;
    }

    public static String getCurrentSolarFullFormatTime(Date date) {
        String currentDate = formatDate(date, "HH:mm:ss", "fa");
        return currentDate;
    }

    public static int createDatePartition(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DAY_OF_MONTH);
        return (day + (month + 1) * 100 + year * 10000);
    }

    public static Date mergeDateAndTime(Date date, Date time) {
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(date);
        Calendar timeCal = Calendar.getInstance();
        timeCal.setTime(time);

        dateCal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
        dateCal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
        dateCal.set(Calendar.SECOND, timeCal.get(Calendar.SECOND));
        dateCal.set(Calendar.MILLISECOND, timeCal.get(Calendar.MILLISECOND));

        return dateCal.getTime();
    }


    public static int getWeekDayNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return ((dayOfWeek % 7) + 1);
    }

}
