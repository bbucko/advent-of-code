import lombok.Data;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class DayThree {

    private final int[][][] fabric;
    private final boolean[] overclaimed;

    DayThree(int arraySize) {
        fabric = new int[arraySize][arraySize][2];
        overclaimed = new boolean[arraySize * 2];
    }

    public static void main(String[] args) throws Exception {
        var inputFile = Path.of(DayOne.class.getResource("dayThree.txt").toURI());
        var strings = Files.readAllLines(inputFile);
        System.out.println(new DayThree(1000).process(strings));
    }

    int process(List<String> strings) {
        strings.stream()
                .map(Claim::fromString)
                .peek(claim -> overclaimed[claim.claimId] = true)
                .collect(Collectors.toList())
                .forEach(this::claimOnFabric);

        return findUnclaimed(overclaimed);
    }

    private int findUnclaimed(boolean[] overclaimed) {
        for (int i = 0; i < overclaimed.length; i++) {
            if (overclaimed[i]) {
                return i;
            }
        }
        return -1;
    }

    private void printFabric() {
        for (int[][] ints : fabric) {
            for (int[] claims : ints) {
                if (claims[0] == 0) {
                    System.out.print(".");
                } else if (onlyOneClaim(claims)) {
                    System.out.print(claims[0]);
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    private boolean onlyOneClaim(int[] anInt) {
        return anInt[0] != 0 && anInt[1] == 0;
    }

    private boolean notClaimedYet(int[] ints) {
        return ints[0] == 0 && ints[1] == 0;
    }

    private void claimOnFabric(Claim claim) {
        for (int i = claim.x; i < claim.x + claim.width; i++) {
            for (int j = claim.y; j < claim.y + claim.height; j++) {
                var notClaimed = notClaimedYet(fabric[i][j]);
                var position = notClaimed ? 0 : 1;
                if (position == 1) {
                    var oldClaim = fabric[i][j][1];
                    var newClaim = claim.claimId;
                    overclaimed[fabric[i][j][0]] = false;
                    overclaimed[newClaim] = false;
                    overclaimed[oldClaim] = false;
                }
                fabric[i][j][position] = claim.claimId;
            }
        }
    }

    @Data
    static class Claim {
        private final int claimId;
        private final int x;
        private final int y;
        private final int width;
        private final int height;

        static Claim fromString(String s) {
            var split = s.split(" ");
            var claimId = Integer.parseInt(split[0].substring(1));

            var coords = split[2].split(",");
            var x = Integer.parseUnsignedInt(coords[0]);
            var y = Integer.parseUnsignedInt(coords[1].substring(0, coords[1].length() - 1));

            var dimensions = split[3].split("x");
            var width = Integer.parseUnsignedInt(dimensions[0]);
            var height = Integer.parseUnsignedInt(dimensions[1]);

            return new Claim(claimId, x, y, width, height);
        }
    }


}
