package com.gun.ardic.demo;

import com.gun.ardic.demo.calendar.MyCalendar;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootTest
public class MyCalendarTests {

    @Test
    public void leapYearsTest() {

        for (int year = 1900; year <= 2110; year++) {
            System.out.println(String.format("year: %s isLeap: %s", year, MyCalendar.isLeapYear(year)));
        }

    }

    @Test
    public void dayTest() {
        SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.set(1900, 0, 1, 0, 0, 0);

        while (true) {
            int startDayMyCalendar = MyCalendar.getStartDay(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1) + 1;
            int startDay = c.get(Calendar.DAY_OF_WEEK);

            System.out.println(String.format("date: %s, day: %s, startDay from MyCalendar: %s",
                    frm.format(c.getTime()),
                    startDay,
                    startDayMyCalendar
            ));

            assertEquals(startDayMyCalendar, startDay);

            c.add(Calendar.MONTH, 1);
            if (c.get(Calendar.YEAR) == 2001) {
                break;
            }
        }
    }

    @Test
    public void sundayTest() {
        SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat frmDayName = new SimpleDateFormat("EEEE");
        Calendar c = Calendar.getInstance();
        c.set(1900, 0, 1, 0, 0, 0);

        while (true) {
            int startDayMyCalendar = MyCalendar.getStartDay(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1) + 1;
            int startDay = c.get(Calendar.DAY_OF_WEEK);

            if (startDay == 1) {
                System.out.println(String.format("date: %s, day: %s, startDay from MyCalendar: %s",
                        frm.format(c.getTime()),
                        frmDayName.format(c.getTime()),
                        startDayMyCalendar
                ));
                assertEquals(startDayMyCalendar, startDay);
            }

            c.add(Calendar.MONTH, 1);
            if (c.get(Calendar.YEAR) == 2001) {
                break;
            }
        }
    }

}
