package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    // ----- パラメーターの文字列（ｙｙｙｙMMdd）を日付型に変換して曜日判定 -----
    @GetMapping("/dayofweek/{date}/")
    public DayOfWeek dispDayOfWeek(@PathVariable String date) {
        LocalDate date2 = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        DayOfWeek res = date2.getDayOfWeek();
        return res;
    }

    // ----- 足し算 -----
    @GetMapping("/plus/{val1}/{val2}")
    public int calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return res;
    }

    // ----- 引き算 -----
    @GetMapping("/minus/{val1}/{val2}")
    public int calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return res;
    }

    // ----- 掛け算 -----
    @GetMapping("/times/{val1}/{val2}")
    public int calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return res;
    }

    // ----- 割り算 -----
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        if (val2 == 0) {
            return "計算できません";
        }else {
        int res = val1 / val2;
        return "" + res;
        }
    }
}
