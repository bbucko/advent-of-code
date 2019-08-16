import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {

    public static void main(String[] args) throws IOException, URISyntaxException {
        var inputFile = Path.of(DayOne.class.getResource("dayTwo.txt").toURI());
        var strings = Files.readAllLines(inputFile);
        System.out.println(new DayTwo().process(strings));
    }

    String process(List<String> input) {
        var pairs = new ArrayList<Pair<String>>();

        for (String a : input) {
            for (String b : input) {
                pairs.add(new Pair<>(a, b));
            }
        }

        return pairs.stream()
                .filter(this::onlyOneDifferentCharacter)
                .findFirst()
                .map(this::sameCharacters)
                .orElse("not found");
    }

    private boolean onlyOneDifferentCharacter(Pair<String> stringPair) {
        var differentCharacterAlreadyFound = false;
        for (int i = 0; i < stringPair.a.length(); i++) {
            if (stringPair.a.charAt(i) != stringPair.b.charAt(i)) {
                if (differentCharacterAlreadyFound) {
                    return false;
                }
                differentCharacterAlreadyFound = true;
            }
        }
        return differentCharacterAlreadyFound;
    }

    private String sameCharacters(Pair<String> stringPair) {
        var sameCharacters = new StringBuilder();
        for (int i = 0; i < stringPair.a.length(); i++) {
            if (stringPair.a.charAt(i) == stringPair.b.charAt(i)) {
                sameCharacters.append(stringPair.a.charAt(i));
            }
        }
        return sameCharacters.toString();
    }

    private static class Pair<T> {
        final T a;
        final T b;

        private Pair(T a, T b) {
            this.a = a;
            this.b = b;
        }
    }
}
