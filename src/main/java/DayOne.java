import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DayOne {

    public static void main(String[] args) throws IOException, URISyntaxException {
        var uri = DayOne.class.getResource("dayOne.txt");
        var lines = Files.readAllLines(Path.of(uri.toURI()));
        System.out.println(new DayOne().process(lines));
    }

    int process(List<String> inputs) {
        return inputs
                .stream()
                .map(Integer::parseInt)
                .reduce(Integer::sum).orElse(-1);
    }

}
