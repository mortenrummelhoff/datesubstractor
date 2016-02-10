package dk.mhr.test;

import dk.mhr.entity.Date;
import dk.mhr.exception.DateException;
import dk.mhr.service.DateSubstractorService;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Created by Morten on 05-12-2015.
 */
public class DateSubstractorTest {

    DateSubstractorService dateSubstractorService = new DateSubstractorService();

    @Test
    public void testDateSubstractor_testInvalidInput() {
        try {
            Date date = new Date(-12, 2,12);
            fail("Date is invalid: " + date);
        } catch (DateException e) {
        }
    }

    @Test
    public void testDateSubstractor_testDays() {
        Date date1 = new Date(2015, 1, 1);
        Date date2 = new Date(2015, 1, 4);

        assertEquals("Substractions not correct",
                getExactDays(date1, date2),
                dateSubstractorService.substractDates(date1, date2));

        assertEquals("Substractions not correct",
                getExactDays(date2, date1),
                dateSubstractorService.substractDates(date2, date1));
    }

    @Test
    public void testDateSubstractor_testMonths() {
        Date date1 = new Date(2015, 1, 1);
        Date date2 = new Date(2015, 2, 6);

        assertEquals("Substractions not correct",
                getExactDays(date1, date2),
                dateSubstractorService.substractDates(date1, date2));

        assertEquals("Substractions not correct",
                getExactDays(date2, date1),
                dateSubstractorService.substractDates(date2, date1));
    }

    @Test
    public void testDateSubstractor_testYears() {
        Date date1 = new Date(2014, 1, 1);
        Date date2 = new Date(2015, 3, 6);

        assertEquals("Substractions not correct",
                getExactDays(date1, date2),
                dateSubstractorService.substractDates(date1, date2));

        assertEquals("Substractions not correct",
                getExactDays(date2, date1),
                dateSubstractorService.substractDates(date2, date1));
    }

    @Test
    public void testDateSubstractor_testLeapYear() {
        //Test months
        Date date1 = new Date(2014, 6, 23);
        Date date2 = new Date(2023, 3, 6);

        assertEquals("Substractions not correct",
                getExactDays(date1, date2),
                dateSubstractorService.substractDates(date1, date2));
        assertEquals("Substractions not correct",
                getExactDays(date2, date1),
                dateSubstractorService.substractDates(date2, date1));

        date1 = new Date(1014, 8, 23);
        date2 = new Date(6023, 3, 21);

        assertEquals("Substractions not correct",
                getExactDays(date1, date2),
                dateSubstractorService.substractDates(date1, date2));
        assertEquals("Substractions not correct",
                getExactDays(date2, date1),
                dateSubstractorService.substractDates(date2, date1));
    }


    @Test
    public void testDateSubstractor_testRandomYears() {
        for (int i = 0; i < 100; i++) {
            Date date1 = new Date(randBetween(1, 10000), randBetween(1, 12), randBetween(1, 28));
            Date date2 = new Date(2015, 3, 6);

            assertEquals("Substractions not correct",
                    getExactDays(date1, date2),
                    dateSubstractorService.substractDates(date1, date2));
        }
    }
    /**
     * Get Exact days using Java 8 Date and Time API.
     * @param date1
     * @param date2
     * @return number of days between the two {@code Date}.
     */
    private long getExactDays(Date date1, Date date2) {
        LocalDate localDate1 = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDay());
        LocalDate localDate2 = LocalDate.of(date2.getYear(), date2.getMonth(), date2.getDay());

        long days = localDate1.until(localDate2, ChronoUnit.DAYS);
        return days;
    }

    /**
     * Primitive Random integer generator
     */
    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
