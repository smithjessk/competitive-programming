import java.util.Arrays;
import java.util.Scanner;

class FASHION {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            in.nextLine(); // skip over n
            int[] maleScores = Arrays.stream(in.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).sorted().toArray();
            int[] femaleScores = Arrays.stream(in.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).sorted().toArray();
            int score = 0;
            for (int i = 0; i < maleScores.length; i++) {
                score += maleScores[i] * femaleScores[i];
            }
            System.out.println(score);
        }
    }
}
