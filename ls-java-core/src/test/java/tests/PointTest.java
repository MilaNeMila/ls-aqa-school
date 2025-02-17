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
                Arguments.of(1, 2, 5, 5 ,5)
        );
    }
    @ParameterizedTest
    @MethodSource("oddIntSource")
    public void isOddTest(int x1, int y1, int x2, int y2, int result){
        assertEquals(new Point(x1, y1).distance(new Point(x2, y2)), result);
    }
}