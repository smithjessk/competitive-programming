import java.util.*;

public class BSEARCH1 {
    public static int find(int[] numbers, int target) {
        int lowIndex = 0;
        int highIndex = numbers.length - 1;
        while (lowIndex <= highIndex) {
            // To prevent overflow, we don't directly add low, hi
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            int current = numbers[middleIndex];
            if (target == current) {
                return middleIndex;
            } else if (target > current) { // recurse on RHS of array
                lowIndex = middleIndex + 1;
            } else { // recurse on LHS of array
                highIndex = middleIndex - 1;
            }
        }
        return -1; // immediately reaches here if length = 0
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        in.nextLine();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < q; i++) {
            System.out.println(find(numbers, Integer.parseInt(in.nextLine())));
        }
    }
}
