package com.csc207.routop;

import java.time.LocalDate;

public class InstantiateWeek {
    public static Week instantiateWeek(LocalDate startDate){
        return new Week(startDate);
    }
}
