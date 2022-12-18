package logicPackage.logicClass;

import logicPackage.logicInterface.MiddleClass;
import logicPackage.logicInterface.SuperClass;
import utilPackage.UtilLogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

public class LogicClass {
    public static void logic1() {
        UtilLogic.utilLogic1();
    }

    public static void logic2() {
        UtilLogic.utilLogic2();
    }

    public static void logic3() {
        UtilLogic.utilLogic3();
    }

    public static void logic4() {
        UtilLogic.utilLogic4();
    }

    public static void logic5() {
        UtilLogic.utilLogic5();
    }

    public static void logic6() {
        UtilLogic.utilLogic6();
    }

    public static void logic7() {
        UtilLogic.utilLogic7();
    }

    public static void logic8() {
        UtilLogic.utilLogic8();
    }

    public static void logic9() {
        UtilLogic.utilLogic9();
    }

    public static void logic10() {
        UtilLogic.utilLogic10();
    }

    public static void logic11() {
        UtilLogic.utilLogic11();
    }

    public static void logic12() {
        UtilLogic.utilLogic12();
    }

    public static void logic13() {
        UtilLogic.utilLogic13();
    }

    public static void logic14() {
        UtilLogic.utilLogic14();
    }

    public static void logic15() {
        UtilLogic.utilLogic15();
    }

    public static void logic16() {
        UtilLogic.utilLogic16();
    }

    public static void logic17() {
        UtilLogic.utilLogic17();
    }

    public static void logic18() {
        SuperClass sc = new MiddleClass();
        int a = sc.b;
        System.out.println("a = " + a);
        sc.superMethod();

        System.out.println(" =========== ");

        SuperClass scc = new SuperClass();
        int a1 = scc.b;
        System.out.println("a1 = " + a1);
        scc.superMethod();

        System.out.println(" =========== ");

        MiddleClass mc = new MiddleClass();
        int b = mc.b;
        System.out.println("b = " + b);

        mc.middleMethod();
        mc.superMethod();

    }

    public static void logic19() {
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        System.out.println("year = " + year);
        int month = today.get(Calendar.MONTH);
        System.out.println("month = " + month);
        int dayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        System.out.println("dayOfMonth = " + dayOfMonth);
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        System.out.println("dayOfWeek = " + dayOfWeek);


        Calendar today1 = Calendar.getInstance();
        today1.set(2020, 10, 22);
        Calendar today2 = Calendar.getInstance();
        today2.set(2021, 10, 22);

        long day = (today2.getTimeInMillis() - today1.getTimeInMillis()) / (60 * 60 * 24) / 1000;
        System.out.println("day = " + day);
        System.out.println("today1 = " + today1.getTime());

        Calendar time1 = Calendar.getInstance();
        time1.set(Calendar.HOUR_OF_DAY, 10);
        time1.set(Calendar.MINUTE, 20);
        time1.set(Calendar.SECOND, 30);
        System.out.println("time1 = " + time1.getTime());

        Calendar time2 = Calendar.getInstance();
        time2.set(Calendar.HOUR_OF_DAY, 9);
        time2.set(Calendar.MINUTE, 10);
        time2.set(Calendar.SECOND, 40);
        System.out.println("time2 = " + time2.getTime());

        time1.add(Calendar.DATE, 5);
        System.out.println("time1 = " + time1.getTime());
        time2.add(Calendar.MONTH, 2);
        System.out.println("time2 = " + time2.getTime());

        today1.roll(Calendar.MONTH, 11);
        System.out.println("today1 = " + today1.getTime());

        // 1. 캘린더 타입을 데이트 타입으로 변경
        Calendar c = Calendar.getInstance();
        Date d = new Date(c.getTimeInMillis());
        System.out.println("d = " + d);

        // 2. 데이트 타입을 캘린더 타입으로 변경
        Date d1 = new Date();
        System.out.println("d1.getTime() = " + d1.getTime());
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        System.out.println("c1.getTime() = " + c1.getTime());

        // 형식화 데이터 출력
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(d);
        System.out.println("format = " + format);

        DateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat sdf2 = new SimpleDateFormat("yyyy년 / MM월 / dd일");
        try {
            Date parseDate = sdf1.parse("2019년 10월 24일");
            String format1 = sdf2.format(parseDate);
            System.out.println("format1 = " + format1);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

        LocalDate ld = LocalDate.now();
        LocalDate localDate = ld.withYear(2004)
                .withMonth(10)
                .withDayOfMonth(24);
        System.out.println("localDate = " + localDate);

        LocalTime lt = LocalTime.now();
        LocalTime localTime = lt.withHour(10)
                .withMinute(24)
                .withSecond(34);
        System.out.println("localTime = " + localTime);

        LocalDateTime ldt = LocalDateTime.of(ld,lt);
        System.out.println("ldt = " + ldt);

        LocalDateTime ldt1 = LocalDateTime.now();

        int i = ldt.compareTo(ldt1);
        System.out.println("i = " + i);

        long l = ld.toEpochDay();
        System.out.println("l = " + l);

        LocalDate localDate1 = ldt1.toLocalDate();
        System.out.println("localDate1 = " + localDate1);
        LocalTime localTime1 = ldt1.toLocalTime();
        System.out.println("localTime1 = " + localTime1);

        LocalDate lll = LocalDate.now();
        LocalDate localDate2 = lll.plusDays(10).plusMonths(12).minusDays(2);
        System.out.println("localDate2 = " + localDate2);


        // period 날짜 - 날짜
        Period between = Period.between(localDate1, localDate2);
        System.out.println("between = " + between.getYears());
        System.out.println("between = " + between.getMonths());
        System.out.println("between = " + between.getDays());

        // duration 시간 - 시간
        Duration between1 = Duration.between(lt, lt);
        long l1 = between1.toDays();
        System.out.println("l1 = " + l1);


        LocalDate ld2 = LocalDate.of(2022,12,24);
        boolean before = ld.isBefore(ld2);
        boolean equal = ld.isEqual(ld2);
        System.out.println("equal = " + equal);
        boolean after = ld.isAfter(ld2);
        System.out.println("after = " + after);
        System.out.println("before = " + before);

        DayOfWeek dayOfWeek1 = ld.getDayOfWeek();
        System.out.println("dayOfWeek1 = " + dayOfWeek1);


        Period until = ld.until(ld2);
        System.out.println("until = " + until);

        int i1 = ld.get(ChronoField.YEAR);
        LocalDate with = ld.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("with = " + with);

        LocalDate parse = LocalDate.parse("2022-10-24", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("parse = " + parse);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format1 = dateTimeFormatter.format(parse);
        System.out.println("format1 = " + format1);

    }
}
