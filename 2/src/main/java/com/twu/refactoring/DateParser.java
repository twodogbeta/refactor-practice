package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;



public class DateParser {
    final int MINIMUM_YEAR = 2000;
    final int MAXIMUM_YEAR = 2012;
    final int INDEX_OF_START_YEAR = 0;
    final int INDEX_OF_END_YEAR = 4;
    final int LENGTH_OF_YEAE = 4;
    final int INDEX_OF_START_MONTH = 5;
    final int INDEX_OF_END_MONTH = 7;
    final int LENGTH_OF_MONTH = 2;
    final int MINIMUM_MONTH = 1;
    final int MAXIMUM_MONTH = 12;
    final int INDEX_OF_START_DATE = 8;
    final int INDEX_OF_END_DATE = 10;
    final int LENGTH_OF_DATE = 2;
    final int MINIMUM_DATE = 1;
    final int MAXIMUM_DATE = 31;
    final int INDEX_OF_START_HOUR = 11;
    final int INDEX_OF_END_HOUR_FIRST_CONDITION = 12;
    final int INDEX_OF_END_HOUR_SECOND_CONDITION = 13;
    final int LENGTH_OF_HOUR = 2;
    final int MINIMUM_HOUR = 0;
    final int MAXIMUM_HOUR = 23;
    final int INDEX_OF_START_MINUTE = 14;
    final int INDEX_OF_END_MINUTE = 16;
    final int LENGTH_OF_MINUTE = 2;
    final int MINIMUM_MINUTE = 0;
    final int MAXIMUM_MINUTE = 59;



    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        try {
            String yearString = dateAndTimeString.substring(INDEX_OF_START_YEAR, INDEX_OF_END_YEAR);
            year = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Year string is less than "+LENGTH_OF_YEAE+" characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Year is not an integer");
        }
        if (year < MINIMUM_YEAR || year > MAXIMUM_YEAR)
            throw new IllegalArgumentException("Year cannot be less than "+MINIMUM_YEAR+" or more than "+MAXIMUM_YEAR);

        try {
            String monthString = dateAndTimeString.substring(INDEX_OF_START_MONTH, INDEX_OF_END_MONTH);
            month = Integer.parseInt(monthString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Month string is less than "+LENGTH_OF_MONTH+" characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Month is not an integer");
        }
        if (month < MINIMUM_MONTH || month > MAXIMUM_MONTH)
            throw new IllegalArgumentException("Month cannot be less than "+MINIMUM_MONTH+" or more than "+MAXIMUM_MONTH);

        try {
            String dateString = dateAndTimeString.substring(INDEX_OF_START_DATE, INDEX_OF_END_DATE);
            date = Integer.parseInt(dateString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Date string is less than "+LENGTH_OF_DATE+" characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Date is not an integer");
        }
        if (date < MINIMUM_DATE || date > MAXIMUM_DATE)
            throw new IllegalArgumentException("Date cannot be less than "+MINIMUM_DATE+" or more than "+MAXIMUM_DATE);

        if (dateAndTimeString.substring(INDEX_OF_START_HOUR, INDEX_OF_END_HOUR_FIRST_CONDITION).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            try {
                String hourString = dateAndTimeString.substring(INDEX_OF_START_HOUR,INDEX_OF_END_HOUR_SECOND_CONDITION);
                hour = Integer.parseInt(hourString);
            } catch (StringIndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Hour string is less than "+LENGTH_OF_HOUR+" characters");
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Hour is not an integer");
            }
            if (hour < MINIMUM_HOUR || hour > MAXIMUM_HOUR)
                throw new IllegalArgumentException("Hour cannot be less than "+MINIMUM_HOUR+" or more than "+MAXIMUM_HOUR);

            try {
                String minuteString = dateAndTimeString.substring(INDEX_OF_START_MINUTE, INDEX_OF_END_MINUTE);
                minute = Integer.parseInt(minuteString);
            } catch (StringIndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Minute string is less than "+LENGTH_OF_MINUTE+" characters");
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Minute is not an integer");
            }
            if (minute < MINIMUM_MINUTE || minute > MAXIMUM_MINUTE)
                throw new IllegalArgumentException("Minute cannot be less than 0 or more than 59");

        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
