package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import ru.ls.qa.school.core.SkyScrapper;

import java.util.Random;

import static org.assertj.guava.api.Assertions.assertThat;
import static org.assertj.guava.api.Assertions.entry;



public class SkyScrapperTests {


    public static int testCalculateGain(SkyScrapper s) {
        int x = s.getFirstFloorFlatSale();
        int m = s.getFreqIncrease();
        int n = s.getFloorsCount();

        int k = n / m;
        int sum = x * n + 1000 * (m * (k - 1) * k / 2 + (n % m) * k);
        return sum;
    }

    @RepeatedTest(100000)
    public void totalGainTest(){
        Random random = new Random();
        SkyScrapper s = SkyScrapper.builder()
                .firstFloorFlatSale(random.nextInt(10000)+1)
                .freqIncrease(random.nextInt(10000)+1)
                .floorsCount(random.nextInt(10000)+1).build();
        int actualResult = s.totalGain(s);
        Assertions.assertThat(actualResult).isEqualTo(testCalculateGain(s));
    }
}
