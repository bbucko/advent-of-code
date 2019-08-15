import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class DayOne {

    public static void main(String[] args) throws IOException, URISyntaxException {
        var inputFile = Path.of(DayOne.class.getResource("dayOne.txt").toURI());
        var ints = Files.readAllLines(inputFile).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println(new DayOne().process(ints));
    }

    int process(int[] inputs) {
        var foundFreqs = new HashSet<Integer>();
        var currentFreq = 0;

        do {
            for (int input : inputs) {
                if (isFoundFreq(foundFreqs, currentFreq)) {
                    return currentFreq;
                } else {
                    foundFreq(foundFreqs, currentFreq);
                }
                currentFreq = currentFreq + input;
            }
        } while (true);
    }

    private void foundFreq(Set<Integer> foundFreqs, int currentFreq) {
        foundFreqs.add(currentFreq);
    }

    private boolean isFoundFreq(Set<Integer> foundFreqs, int currentFreq) {
        return foundFreqs.contains(currentFreq);
    }

}
