package com.rich;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by hanwang206326 on 16/1/23.
 */
public class Time {
    public static void main(String[] args) throws InterruptedException {
        /*Instant start = Instant.now();
        Thread.sleep(2000);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());*/
        /*LocalDate today = LocalDate.now();
        System.out.println(today.getMonthValue());*/
        LocalDate firstTuesDay = LocalDate.of(2016, 1, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        TemporalAdjuster NEXT_WORKDAY = w -> {
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= 6);
            return result;
        };
        TemporalAdjuster NEXT_WORKDAY1 = TemporalAdjusters.ofDateAdjuster(w -> {
            LocalDate result = w;
            do {
                result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= 6);
            return result;
        });
        ZonedDateTime zonedDateTime = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, ZoneId.of("America/New_York"));
    }
}
