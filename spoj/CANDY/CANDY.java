import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class CANDY {
    public static void main(String[] args) {
        // number of moves = sum (c_i - mu) for all i such that c_i > mu
        Scanner in = new Scanner(System.in);
        int numberOfPackets = in.nextInt();
        in.nextLine();
        while (numberOfPackets != -1) {
            int[] packetSizes = new int[numberOfPackets];
            for (int i = 0; i < numberOfPackets; i++) {
                packetSizes[i] = in.nextInt();
                in.nextLine();
            }

            // See if it's possible
            double averageSize = Arrays.stream(packetSizes).average().getAsDouble();
            if (averageSize % 1 != 0) {
                System.out.println(-1);
            } else {
                int numberOfMoves = Arrays.stream(packetSizes)
                        .filter(s -> s > averageSize)
                        .map(s -> s - (int) averageSize)
                        .sum();
                System.out.println(numberOfMoves);
            }

            // Move to next problem
            numberOfPackets = in.nextInt();
            in.nextLine();
        }
    }
}
