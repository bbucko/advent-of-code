import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayThreeTest {

    private final DayThree dayThree = new DayThree(8);

    @Test
    void testParsing() {
        var claim = DayThree.Claim.fromString("#1 @ 2,3: 4x5");
        assertEquals(1, claim.getClaimId());
        assertEquals(2, claim.getX());
        assertEquals(3, claim.getY());
        assertEquals(4, claim.getWidth());
        assertEquals(5, claim.getHeight());
    }

    @Test
    void testThreeOverlap() {
        assertEquals(3, dayThree.process(List.of(
                "#1 @ 1,3: 4x4",
                "#2 @ 3,1: 4x4",
                "#3 @ 5,5: 2x2")));
    }

}