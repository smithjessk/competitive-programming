import java.util.*;

public class AddAll {
    public static void main(String[] args) {
        // add the integers smallest to largest:
        // sort the integers
        // keep a running sum between them
        // sum = previousSum + currentElement
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while (n != 0) {
            int[] nums = Arrays.stream(in.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int cost = nums[0] + nums[1];
            int sum = nums[0] + nums[1];
            for (int i = 2; i < nums.length; i++) {
                cost += nums[i] + sum;
                sum += nums[i];
            }
            System.out.println(cost);
            n = Integer.parseInt(in.nextLine());
        }
    }
}
