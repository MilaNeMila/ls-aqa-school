package tests;

import org.junit.jupiter.params.provider.ValueSource;
import ru.ls.qa.school.core.OddTask;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddTaskTest {

    OddTask ot = new OddTask();

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15})
    public void isOddTest(int number){
        assertEquals(ot.isOdd(number), true);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, -4, 16, 0})
    public void isNotOddTest(int number){
        assertEquals(ot.isOdd(number), false);
    }
}
