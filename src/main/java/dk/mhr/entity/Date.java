package dk.mhr.entity;

import dk.mhr.exception.DateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Morten on 05-12-2015.
 *
 * Entity Class for storing Date values.
 */
public class Date {

    private static Logger logger = LoggerFactory.getLogger(Date.class);

    private int year, month, day;

    public static final int DAYS_LEAP_YEAR = 366;
    public static final int DAYS_COMMON_YEAR = 365;

    private static final int[] DAYS_IN_MONTHS_COMMON_YEAR = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DAYS_IN_MONTHS_LEAP_YEAR = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

        isValidDate();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        isValidDate();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        isValidDate();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
        isValidDate();
    }

    private void isValidDate() {
        //check year
        if (year < 0) {
            throw new DateException("Year must be a positive value");
        }
        //check month
        if (month > 12 || month < 1 ) {
            throw new DateException("Month must be in range [1-12]");
        }
        //check days
        if (isLeapYear(year)) {
            if (day > DAYS_IN_MONTHS_LEAP_YEAR[month-1] || day < 1) {
                throw new DateException("Days must be in range [1- " +
                        DAYS_IN_MONTHS_LEAP_YEAR[month-1] + "]");
            }
        }
        else {
            if (day > DAYS_IN_MONTHS_COMMON_YEAR[month-1] || day < 1) {
                throw new DateException("Days must be in range [1- " +
                        DAYS_IN_MONTHS_COMMON_YEAR[month-1] + "]");
            }
        }
    }

    /**
     * Calculates the total number of days between the two dates.
     * If date1 is before date2 a positive number will be returned, otherwise a negative.
     * @param date1
     * @param date2
     * @return total number of days between the two dates
     */
    public static long substractDates(Date date1, Date date2) {

        long totalDays = 0;

        long days1 = getTotalDays(date1);
        long days2 = getTotalDays(date2);

        logger.debug("Calculated days for Date1: {} -> {}, And Date2: {} -> {} days2",
                date1, days1, date2, days2);

        //days
        totalDays = getTotalDays(date2) - getTotalDays(date1);

        return totalDays;
    }

    /**
     * Following the Gregorian Calendar
     * @see <a href="https://en.wikipedia.org/wiki/Leap_year">https://en.wikipedia.org/wiki/Leap_year</a>
     */
    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {

            //century years are common except the ones that can be divided exact by 400
            if (year % 100 == 0) {

                if (year % 400 != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Calculates the total number of days for the given Date.
     * @param date
     * @return total number of days
     */
    private static long getTotalDays(Date date) {

        long totalDays = 0;

        //years
        for (int year = 0; year < date.getYear(); year++) {
            totalDays += isLeapYear(year) ? DAYS_LEAP_YEAR : DAYS_COMMON_YEAR;
        }

        //months
        for (int i = 1; i < date.getMonth(); i++) {
            if (isLeapYear(date.getYear())) {
                totalDays += DAYS_IN_MONTHS_LEAP_YEAR[i-1];
            }
            else {
                totalDays += DAYS_IN_MONTHS_COMMON_YEAR[i-1];
            }
        }

        //days
        totalDays += date.getDay();
        return totalDays;
    }


    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
