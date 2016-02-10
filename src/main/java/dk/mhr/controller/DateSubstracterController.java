package dk.mhr.controller;

import dk.mhr.entity.Date;
import dk.mhr.service.DateSubstractorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Morten on 05-12-2015.
 *
 * RestController providing API for accessing the Date Substraction Service
 */
@RestController()
@CrossOrigin("*")
@Api(value = "Date Substraction", description = "Resources for Date substractions")
public class DateSubstracterController {

    @Inject
    private DateSubstractorService dateSubstractorService;

    @ApiOperation(value = "Get total number of days between two dates",
            notes = "Returns total number of days between 2 dates taking into account Leap year defined by the Gregorian calendar (https://en.wikipedia.org/wiki/Leap_year)")
    @RequestMapping(value= "/dates/extractions/{d1_year}/{d1_month}/{d1_day}/{d2_year}/{d2_month}/{d2_day}", method = RequestMethod.GET)
    public long extractDaysBetweenDates(@PathVariable int d1_year,
                                        @PathVariable int d1_month,
                                        @PathVariable int d1_day,
                                        @PathVariable int d2_year,
                                        @PathVariable int d2_month,
                                        @PathVariable int d2_day) throws Exception{

        Date d1 = new Date(d1_year, d1_month, d1_day);
        Date d2 = new Date(d2_year, d2_month, d2_day);
        return (dateSubstractorService.substractDates(d1, d2));
    }


}
