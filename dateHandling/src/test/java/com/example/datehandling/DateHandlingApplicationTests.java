package com.example.datehandling;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@SpringBootTest
class DateHandlingApplicationTests {

    @Test
    void getDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println("今天的日期：" + localDate + "/n");
        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println("本月一共多少天：" + dayOfMonth + "/n");
        int year = localDate.getYear();
        System.out.println("今年是哪一年：" + year + "/n");
        int monthValue = localDate.getMonthValue();
        System.out.println("本月是几月（数字）：" + monthValue + "/n");
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("今天是星期几：" + dayOfWeek + "/n");
        int dayOfYear = localDate.getDayOfYear();
        System.out.println("今天是今年的第多少天：" + dayOfYear + "/n");
        Month month = localDate.getMonth();
        System.out.println("本月是几月(英文)：" + month + "/n");
        boolean leapYear = localDate.isLeapYear();
        System.out.println("今年是否是闰年：" + leapYear + "/n");
        //plus(long类型数值，单位：可以是天、月、年、秒、小时等)，计算之后的
        LocalDate day = localDate.plus(1, ChronoUnit.DAYS);
        System.out.println("1天后的是几月几号：" + day + "/n");
        LocalDate nextDay = localDate.plusDays(1);
        System.out.println("1天后的是几月几号：" + nextDay + "/n");
        //minus(long类型数值，单位：可以是天、月、年、秒、小时等),计算之前的
        LocalDate preDay = localDate.minus(1, ChronoUnit.DAYS);
        System.out.println("1天前的是几月几号：" + nextDay + "/n");
        //判断日期是否在当前日期之前，在则返回TRUE
        LocalDate of = LocalDate.of(2022, 7, 25);
        boolean before = of.isBefore(localDate);
        System.out.println("判断日期是否在当前日期之前：" + before + "/n");
        //判断日期是否在当前日期之后，在则返回TRUE
        boolean after = of.isAfter(localDate);
        System.out.println("判断日期是否在当前日期之后：" + after + "/n");
        //判断2个时间是否相等
        boolean equals = of.equals(localDate);
        System.out.println("判断2个时间是否相等：" + equals + "/n");

    }
    @Test
    void getTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println("今天的时间,返回只有时分秒毫秒：" + localTime);
        int hour = localTime.getHour();
        System.out.println("今天的时间，返回 时（24小时制）：" + hour);
        int minute = localTime.getMinute();
        System.out.println("今天的时间，返回 分：" + minute);
        int second = localTime.getSecond();
        System.out.println("今天的时间，返回 秒：" + second);
        int nano = localTime.getNano();
        System.out.println("今天的时间，返回纳秒：" + nano);
        int i = localTime.toSecondOfDay();
        System.out.println("今天的时间，返回到目前为止，今天一共过了多少秒：" + nano);
        long l = localTime.toNanoOfDay();
        System.out.println("今天的时间，返回到目前为止，今天一共过了多少纳秒：" + nano);


    }
    @Test
    void getDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime max = LocalDateTime.MAX;
        LocalDateTime MIN = LocalDateTime.MIN;
    }
    @Test
    void getMonth() {
        //YearMonth用法基本和LocalDate相似
        YearMonth yearMonth = YearMonth.now();
        System.out.println("获取当前年月（格式：2022-07）：" + yearMonth + "/n");
        Month month = yearMonth.getMonth();
        System.out.println("获取当前月份（英文）：" + month + "/n");
        int year = yearMonth.getYear();
        System.out.println("获取当前年：" + year + "/n");
        int monthValue = yearMonth.getMonthValue();
        System.out.println("获取当前月份（数字）：" + monthValue + "/n");
        LocalDate localDate = yearMonth.atEndOfMonth();
        System.out.println("获取当前日期：" + localDate + "/n");
        boolean leapYear = yearMonth.isLeapYear();
        System.out.println("判断今年是否是闰年：" + leapYear + "/n");
        int lengthOfYear = yearMonth.lengthOfYear();
        System.out.println("今年一共有多少天：" + lengthOfYear + "/n");
        int lengthOfMonth = yearMonth.lengthOfMonth();
        System.out.println("本月一共有多少天：" + lengthOfMonth + "/n");
    }

    @Test
    void getDateTool() {
        LocalDate localDate = LocalDate.now();
        LocalDate date = LocalDate.of(2022, 7, 25);
        //计算两个日期之间的天数、周数或月数
        Period period = Period.between(localDate,date);
        int days = period.getDays();
        int months = period.getMonths();
        int years = period.getYears();
        System.out.println("计算今天和指定日期相差多少天：" + days + "----" + "相差多少月：" + months + "----" + "相差多少年：" + years);

        //字符串互转日期类型
        LocalDateTime localTime = LocalDateTime.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //日期转字符串
        String str = localTime.format(format1);

        System.out.println("日期转换为字符串:"+str);

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //字符串转日期
        LocalDate date2 = LocalDate.parse(str,format2);
        LocalTime date3 = LocalTime.parse(str,format2);
        LocalDateTime date4 = LocalDateTime.parse(str,format2);
        System.out.println("日期类型:"+date2);

        String str1="2022-07-05 12:24:12";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(str1, dtf);
        System.out.println(parse);

        String dayAfterTommorrow = "20180210";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);

    }

}
