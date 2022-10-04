package me.day12.api.text.dateformat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormatExample {
    public static void main(String[] args) throws ParseException {
        Calendar calendar1 = Calendar.getInstance();
        DateFormat dateFormat1 = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat dateFormat3 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat dateFormat4 = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("calendar1 = " + calendar1);
        System.out.println("dateFormat1 = " + dateFormat1.format(calendar1.getTime()));
        System.out.println("dateFormat2 = " + dateFormat2.format(calendar1.getTime()));
        System.out.println("dateFormat3 = " + dateFormat3.format(calendar1.getTime()));
        System.out.println("dateFormat4 = " + dateFormat4.format(calendar1.getTime()));
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString1 = simpleDateFormat.format(Calendar.getInstance().getTime());
        String dateString2 = simpleDateFormat.format(new Date());
        System.out.println("dateString1 = " + dateString1);
        System.out.println("dateString2 = " + dateString2);

        Date date = simpleDateFormat.parse("2020-10-10");
        System.out.println("date = " + date);
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////
        Calendar calendar = Calendar.getInstance();
        DateFormat theDate = DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat germanDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.GERMANY);
        DateFormat frenchDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
        System.out.println("theDate.format(calendar) = " + theDate.format(calendar.getTime()));
        System.out.println("germanDate.format(calendar) = " + germanDate.format(calendar.getTime()));
        System.out.println("frenchDate.format(calendar) = " + frenchDate.format(calendar.getTime()));


    }
}
