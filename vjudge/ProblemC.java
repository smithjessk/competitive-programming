// source: http://vjudge.net/contest/135420#problem/C

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemC {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);
        HashMap<Integer, Integer> counts = new HashMap<>();

        // key = integer + "," + occurrence
        // value = 1-based index
        HashMap<String, Integer> locations = new HashMap<>();
        try {
            while (true) {
                String[] setupParts = in.readLine().split(" ");
                int numNumbers = Integer.parseInt(setupParts[0]);
                int numQueries = Integer.parseInt(setupParts[1]);
                int[] numbers = Arrays.stream(in.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int i = 0; i < numNumbers; i++) {
                    int n = numbers[i];
                    if (!counts.containsKey(n)) {
                        counts.put(n, 0);
                    }
                    counts.put(n, counts.get(n) + 1);
                    locations.put(n + "," + counts.get(n), i + 1);
                }
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < numQueries; i++) {
                    String[] parts = in.readLine().split(" ");
                    String key = parts[1] + "," + parts[0];
                    if (locations.containsKey(key)) {
                        output.append(locations.get(key) + "\n");
                    } else {
                        output.append("0\n");
                    }
                }
                System.out.print(output);
            }
        } catch (Exception e) {

        }

    }
}
