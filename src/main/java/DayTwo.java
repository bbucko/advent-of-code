import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DayTwo {

    public static void main(String[] args) throws IOException, URISyntaxException {
        var inputFile = Path.of(DayOne.class.getResource("dayTwo.txt").toURI());
        var strings = Files.readAllLines(inputFile);
        System.out.println(new DayTwo().process(strings));
    }

    int process(List<String> input) {
        var result = input.stream()
                .map(this::processLine)
                .reduce((pair, pair2) -> new Pair(pair.a + pair2.a, pair.b + pair2.b))
                .orElseGet(() -> new Pair(0, 0));
        return result.a * result.b;
    }


    private Pair processLine(String s) {
        var countOfCharacters = new int[256];
        for (char c : s.toCharArray()) {
            countOfCharacters[c]++;
        }

        return calculatePair(countOfCharacters);
    }

    private Pair calculatePair(int[] sum) {
        int twos = 0;
        int threes = 0;

        for (int count : sum) {
            if (count == 2) {
                twos = 1;
            }

            if (count == 3) {
                threes = 1;
            }
        }

        return new Pair(twos, threes);
    }

    private static class Pair {
        final int a;
        final int b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
