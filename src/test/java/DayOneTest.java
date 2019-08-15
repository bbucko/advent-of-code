import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTest {

    private final DayOne dayOne = new DayOne();

    @Test
    void testPlusMinus() {
        assertEquals(0, dayOne.process(new int[]{1, -1}));
    }

    @Test
    void testTen() {
        assertEquals(10, dayOne.process(new int[]{+3, +3, +4, -2, -4}));
    }

    @Test
    void testFirstLong() {
        assertEquals(5, dayOne.process(new int[]{-6, +3, +8, +5, -6}));
    }

}