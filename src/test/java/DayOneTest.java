import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTest {

    private final DayOne dayOne = new DayOne();

    @Test
    void testPlusOnes() {
        assertEquals(3, dayOne.process(List.of("+1", "+1", "+1")));
    }

    @Test
    void testPlusOneAndMinusTwo() {
        assertEquals(0, dayOne.process(List.of("+1", "+1", "-2")));
    }

    @Test
    void testMinusOneTwoThree() {
        assertEquals(-6, dayOne.process(List.of("-1", "-2", "-3")));
    }

}