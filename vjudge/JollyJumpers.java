import java.util.*;

public class JollyJumpers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (in.hasNextLine()) {
            lines.add(in.nextLine());
        }
        for (String s : lines) {
            String[] parts = s.split(" ");
            int n = Integer.parseInt(parts[0]);
            if (n == 1) {
                System.out.println("Jolly");
            } else {
                Set<Integer> diffs = new HashSet<>();
                for (int i = 1; i <= n - 1; i++) {
                    diffs.add(i);
                }
                int previous = Integer.parseInt(parts[1]);
                for (int i = 2; i < parts.length; i++) {
                    int current = Integer.parseInt(parts[i]);
                    diffs.remove(Math.abs(current - previous));
                    previous = current;
                }
                if (diffs.size() == 0) {
                    System.out.println("Jolly");
                } else {
                    System.out.println("Not jolly");
                }
            }
        }
    }
}
