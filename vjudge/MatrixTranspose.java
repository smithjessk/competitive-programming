// source: http://vjudge.net/contest/135420#problem/A

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MatrixTranspose {
    public static class Value {
        int row;
        int value;

        Value(int r, int v) {
            this.row = r;
            this.value = v;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        // Maintain hashmap between column and ADT holding class
        // For each key in the hash, print out the key and then all the row indices
        // Then print out a new line and then all the row values

        // map of column to values
        HashMap<Integer, ArrayList<Value>> hash = new HashMap<>();

        for (int row = 1; row < m + 1; row++) {
            String[] firstLineParts = in.nextLine().split(" ");
            String[] secondLineParts = in.nextLine().split(" ");
            for (int i = 1; i < firstLineParts.length; i++) {
                int column = Integer.parseInt(firstLineParts[i]);
                int value = Integer.parseInt(secondLineParts[i - 1]);
                if (!hash.containsKey(column)) {
                    hash.put(column, new ArrayList<>());
                }
                hash.get(column).add(new Value(row, value));
            }
        }

        System.out.printf("%d %d\n", n, m);
        for (int column = 1; column < n + 1; column++) {
            if (!hash.containsKey(column)) {
                System.out.println("0\n");
            } else {
                String firstOutputLine = hash.get(column).size() + " ";
                String secondOutputLine = "";
                for (Value v : hash.get(column)) {
                    firstOutputLine += v.row + " ";
                    secondOutputLine += v.value + " ";
                }
                System.out.println(firstOutputLine.substring(0, firstOutputLine.length() - 1));
                System.out.println(secondOutputLine.substring(0, secondOutputLine.length() - 1));
            }
        }
    }
}
