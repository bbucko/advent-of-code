import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwoTest {

    private final DayTwo dayTwo = new DayTwo();

    @Test
    void testNoRepeats() {
        assertEquals(0, dayTwo.process(List.of("abcdef")));
    }

    @Test
    void testBothRepeats() {
        assertEquals(1, dayTwo.process(List.of("bababc")));
    }

}