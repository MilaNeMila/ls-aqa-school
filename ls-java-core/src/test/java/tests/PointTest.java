package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ls.qa.school.core.Point;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    private static Stream<Arguments> oddIntSource() {
        return Stream.of(
                Arguments.of(1, 2, 5, 5, 5),
                Arguments.of(2, 6, 8, 1, 7.810249675906654),
                Arguments.of(2.3, 6.4, 8.5, 1.6, 7.840918313565064)
        );
    }

    @ParameterizedTest
    @MethodSource("oddIntSource")
    public void isOddTest(double x1, double y1, double x2, double y2, double result) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        assertEquals(p1.distance(p2), result);
        assertEquals(p2.distance(p1), result);
        assertEquals(p1.distance(p1), 0);
        assertEquals(p2.distance(p2), 0);
    }
}