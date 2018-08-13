package jx.sun.feature.timeapi;

import java.time.*;

/**
 * @Auther: sunjx
 * @Date: 2018/8/13 0013 17:35
 * @Description: 新的时间API
 */
public class TimeMain {
    public static void main(String[] args) {
        // 1.Clock
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        // 2.LocalDate
        System.out.println("localDate now => " + LocalDate.now());

        // 3.localTime
        System.out.println("localDateTime now => " + LocalDateTime.now());

        // 4.localTime
        System.out.println("localTime now => " + LocalTime.now());

        // 5.ZonedDateTime
        System.out.println("ZonedDateTime now => " + ZonedDateTime.now());

        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 5,0);
        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );


    }
}
