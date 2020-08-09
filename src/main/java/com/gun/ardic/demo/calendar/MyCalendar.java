package com.gun.ardic.demo.calendar;

public class MyCalendar {


    public static void main(String[] args) {


        for (int year = 1900; year <= 2000; year++) {
            for (int month=1; month <= 12; month++) {
                int startDay = getStartDay(year, month);
                if (startDay == 0) { // sunday
                    System.out.println(String.format("year: %s month: %s day of week: %s",
                            year, month, startDay));
                }
            }
        }

    }

    public static int getStartDay(int year, int month) {
        int startDay1900Jun = 1;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        return (totalNumberOfDays+startDay1900Jun) %7;
    }

    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        for (int i=1900; i < year; i++) {
            if (isLeapYear(i)) {
                total += 366;
            } else {
                total += 365;
            }
        }

        for (int i=1; i<month; i++) {
            total += getNumberOfDaysInMonth(year, i);
        }

        return total;
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
            month == 8 || month == 10 || month == 12) {
            return 31;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0;
    }

    public static boolean isLeapYear(int year) {
        return (year%4 == 0 && year%100 != 0);
    }
}
