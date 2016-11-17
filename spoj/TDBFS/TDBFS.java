import java.util.*;

class TDBFS {
    public static void printDFS(boolean[][] connected, boolean[] printed, int index) {
        System.out.printf("%d ", index + 1);
        printed[index] = true;
        for (int j = 0; j < connected[index].length; j++) {
            if (connected[index][j] && !printed[j]) {
                printDFS(connected, printed, j);
            }
        }
    }

    public static void printBFS(boolean[][] connected, int index) {
        boolean[] printed = new boolean[connected.length];
        System.out.printf("%d ", index + 1);
        printed[index] = true;
        Queue<Integer> toVisit = new LinkedList<>();
            toVisit.add(index);
            while (!toVisit.isEmpty()) {
                int currentIndex = toVisit.remove();
                for (int j = 0; j < connected[currentIndex].length; j++) {
                    if (connected[currentIndex][j] && !printed[j]) {
                        System.out.printf("%d ", j + 1);
                        printed[j] = true;
                        toVisit.add(j);
                    }
                }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfGraphs = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numberOfGraphs; t++) {
            System.out.printf("graph %d\n", t + 1);
            int numberOfVertices = Integer.parseInt(in.nextLine());
            boolean[][] connected = new boolean[numberOfVertices][numberOfVertices];

            // Create adjacency matrix
            for (int i = 0; i < numberOfVertices; i++) {
                int[] parts = Arrays.stream(in.nextLine().split(" "))
                            .mapToInt(s -> Integer.parseInt(s) - 1).toArray();
                for (int j = 2; j < parts.length; j++) {
                    connected[parts[0]][parts[j]] = true;
                }
            }

            // Read in queries
            String query = in.nextLine();
            while (!query.equals("0 0")) {
                int startingIndex = Integer.parseInt(query.split(" ")[0]) - 1;
                if (query.split(" ")[1].equals("0")) {
                    printDFS(connected, new boolean[numberOfVertices], startingIndex);
                    System.out.println();
                } else {
                    printBFS(connected, startingIndex);
                    System.out.println();
                }
                query = in.nextLine();
            }
        }
    }
}
