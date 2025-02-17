package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ls.qa.school.core.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    int x, y, x1, y1;
    Point point = new Point(x, y);
    Point point2 = new Point(x1, y1);

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15})
    public void isOddTest(int number){
        assertEquals(point.distance(point2), true);
    }
}