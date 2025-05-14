package ru.ls.qa.school.core;

import lombok.Builder;
import lombok.Getter;

@Builder
public class SkyScrapper {

    @Getter
    private int firstFloorFlatSale;
    @Getter
    private int freqIncrease;
    @Getter
    private int floorsCount;

    public int totalGain(SkyScrapper s){
        int total = 0;
        for (int floor = 1; floor <= floorsCount; floor++){
            total += firstFloorFlatSale + 1000 * ((floor - 1) / freqIncrease);
        }
        return total;
    }
}
