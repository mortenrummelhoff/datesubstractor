package dk.mhr.service;

import dk.mhr.entity.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

/**
 * Created by Morten on 05-12-2015.
 *
 * Service implementing the business logic for the Date Substraction API
 */
@Named
public class DateSubstractorService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public DateSubstractorService() {
        logger.debug("Starting DateSubstractorService");
    }

    public long substractDates(Date date1, Date date2) {
        return Date.substractDates(date1, date2);
    }
}
