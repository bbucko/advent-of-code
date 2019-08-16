import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwoTest {

    private final DayTwo dayTwo = new DayTwo();

    @Test
    void testOneCharacterDifferent() {
        assertEquals("ac", dayTwo.process(Arrays.asList("abc", "adc")));
    }

    @Test
    void testTwoCharactersDifferent() {
        assertEquals("not found", dayTwo.process(Arrays.asList("abc", "ade")));
    }

}