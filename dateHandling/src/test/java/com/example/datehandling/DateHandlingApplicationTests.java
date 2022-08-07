package com.example.datehandling;

import com.example.datehandling.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

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
        System.out.println("将字符串格式化成LocalDateTime："+parse);

        String dayAfterTommorrow = "20180210";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("将yyyyMMdd格式化成yyyy-MM-dd：", dayAfterTommorrow, formatted);

    }

    @Test
    public void getSpecifiedDate() {
        // 指定日期 2022-02-09
        LocalDate localDate = LocalDate.of(2022, 2, 9);
        // 这个月的第一天 2022-02-01
        localDate.with(TemporalAdjusters.firstDayOfMonth());
        // 这个月的最后一天 2022-02-28
        localDate.with(TemporalAdjusters.lastDayOfMonth());
        // 下个月的第一天 2022-03-01
        localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        // 这一年的第一天 2022-01-01
        localDate.with(TemporalAdjusters.firstDayOfYear());
        // 这一年的最后一天 2022-12-31
        localDate.with(TemporalAdjusters.lastDayOfYear());
        // 下一年的第一天 2022-01-01
        localDate.with(TemporalAdjusters.firstDayOfNextYear());
        // 这个月的第一个星期一 2022-02-04
        localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        // 这个月的最后一个星期一 2022-02-25
        localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
        // 这个月的第二个星期一 2022-02-11
        localDate.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.MONDAY));
        // 这个月的倒数第二个星期一 2022-02-18
        localDate.with(TemporalAdjusters.dayOfWeekInMonth(-2, DayOfWeek.MONDAY));
        // 下一个星期六 2022-02-16
        localDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        // 下一个星期六，可以是当天 2022-02-09
        localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        // 上一个星期六 2022-02-02
        localDate.with(TemporalAdjusters.previous(DayOfWeek.SATURDAY));
        // 上一个星期六，可以是当天 2022-02-09
        localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));

    }
    
    @Test
    public void getFormat(){
        // 指定日期时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        // 2022-03-25 22:29:33
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(zonedDateTime);
        // 2022-03-25 等同于DateTimeFormatter.ISO_LOCAL_DATE
        DateTimeFormatter.ofPattern("yyyy-MM-dd").format(zonedDateTime);
        // 2022年03月25日 22时29分33秒
        DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒").format(zonedDateTime);
        // 2022年03月25日
        DateTimeFormatter.ofPattern("yyyy年MM月dd日").format(zonedDateTime);
        // 2022-03
        DateTimeFormatter.ofPattern("yyyy-MM").format(zonedDateTime);
        // 2022年03月
        DateTimeFormatter.ofPattern("yyyy年MM月").format(zonedDateTime);
        // 20220325
        DateTimeFormatter.ofPattern("yyyyMMdd").format(zonedDateTime);
        // 202203
        DateTimeFormatter.ofPattern("yyyyMM").format(zonedDateTime);

        //以下是格式化的一些标准提供格式
        // ISO_LOCAL_DATE 2022-03-25
        DateTimeFormatter.ISO_LOCAL_DATE.format(zonedDateTime);
        // ISO_OFFSET_DATE 2022-03-25+08:00
        DateTimeFormatter.ISO_OFFSET_DATE.format(zonedDateTime);
        // ISO_DATE 2022-03-25+08:00
        DateTimeFormatter.ISO_DATE.format(zonedDateTime);
        // ISO_LOCAL_TIME 22:22:55.6747072
        DateTimeFormatter.ISO_LOCAL_TIME.format(zonedDateTime);
        // ISO_OFFSET_TIME 22:22:55.6747072+08:00
        DateTimeFormatter.ISO_OFFSET_TIME.format(zonedDateTime);
        // ISO_TIME 22:22:55.6747072+08:00
        DateTimeFormatter.ISO_TIME.format(zonedDateTime);
        // ISO_LOCAL_DATE_TIME 2022-03-25T22:22:55.6747072
        DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(zonedDateTime);
        // ISO_OFFSET_DATE_TIME 2022-03-25T22:22:55.6747072+08:00
        DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime);
        // ISO_ZONED_DATE_TIME 2022-03-25T22:22:55.6747072+08:00[Asia/Shanghai]
        DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDateTime);
        // ISO_DATE_TIME 2022-03-25T22:22:55.6747072+08:00[Asia/Shanghai]
        DateTimeFormatter.ISO_DATE_TIME.format(zonedDateTime);
        // ISO_ORDINAL_DATE 2022-085+08:00
        DateTimeFormatter.ISO_ORDINAL_DATE.format(zonedDateTime);
        // ISO_WEEK_DATE 2022-W13-3+08:00
        DateTimeFormatter.ISO_WEEK_DATE.format(zonedDateTime);
        // ISO_INSTANT 2022-03-25T14:22:55.674707200Z
        DateTimeFormatter.ISO_INSTANT.format(zonedDateTime);
        // BASIC_ISO_DATE 20220325+0800
        DateTimeFormatter.BASIC_ISO_DATE.format(zonedDateTime);
        // RFC_1123_DATE_TIME Wed, 25 Mar 2022 22:22:55 +0800
        DateTimeFormatter.RFC_1123_DATE_TIME.format(zonedDateTime);

    }
    
    @Test
    public void trans(){

        LocalDate localDate = LocalDate.now();
        Date date = DateUtils.asDate(localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date1 = DateUtils.asDate(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 8, 7, 22, 54, 12);
        LocalDateTime localDateTime2 = LocalDateTime.now();

        // 1
        long year = localDateTime1.until(localDateTime2, ChronoUnit.YEARS);
        // 12
        long month = localDateTime1.until(localDateTime2, ChronoUnit.MONTHS);
        // 365
        long day = localDateTime1.until(localDateTime2, ChronoUnit.DAYS);
        // 8760
        long hour = localDateTime1.until(localDateTime2, ChronoUnit.HOURS);
        // 525603
        long minute = localDateTime1.until(localDateTime2, ChronoUnit.MINUTES);
        // 31536183
        long SECOND = localDateTime1.until(localDateTime2, ChronoUnit.SECONDS);

        LocalDate startDate = LocalDate.of(2020, 2, 20);
        LocalDate endDate = LocalDate.of(2021, 1, 15);
        long years = ChronoUnit.YEARS.between(startDate, endDate);
        long months = ChronoUnit.MONTHS.between(startDate, endDate);
        long weeks = ChronoUnit.WEEKS.between(startDate, endDate);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        long hours = ChronoUnit.HOURS.between(startDate, endDate);
        long minutes = ChronoUnit.MINUTES.between(startDate, endDate);
        long seconds = ChronoUnit.SECONDS.between(startDate, endDate);
        long milis = ChronoUnit.MILLIS.between(startDate, endDate);
        long nano = ChronoUnit.NANOS.between(startDate, endDate);

    }
    
    

}
