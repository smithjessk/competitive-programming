// source: http://vjudge.net/contest/135420#problem/A

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixTranspose {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int m = in.nextInt();
            int n = in.nextInt();
            in.nextLine();

            int[][] matrix = new int[m][n];
            for (int row = 0; row < m; row++) {
                String[] firstLineParts = in.nextLine().split(" ");
                String[] secondLineParts = in.nextLine().split(" ");
                for (int j = 1; j < firstLineParts.length; j++) {
                    int col = Integer.parseInt(firstLineParts[j]) - 1;
                    int value = Integer.parseInt(secondLineParts[j - 1]);
                    matrix[row][col] = value;
                }
            }

            System.out.printf("%d %d\n", n, m);
            for (int col = 0; col < n; col++) {
                ArrayList<Integer> nonZeroValues = new ArrayList<>();
                ArrayList<Integer> nonZeroRows = new ArrayList<>();
                for (int row = 0; row < m; row++) {
                    if (matrix[row][col] != 0) {
                        nonZeroRows.add(row + 1);
                        nonZeroValues.add(matrix[row][col]);
                    }
                }
                String firstLine = nonZeroRows.size() + "";
                for (int index : nonZeroRows) {
                    firstLine = firstLine + " " + index;
                }
                String secondLine = "";
                for (int value : nonZeroValues) {
                    secondLine = secondLine + " " + value;
                }
                System.out.println(firstLine);
                if (secondLine.length() > 0) {
                    secondLine = secondLine.substring(1);
                }
                System.out.println(secondLine);
            }
        }
    }
}
