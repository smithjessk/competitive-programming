import java.util.Scanner;

class NSTEPS {

    public static void main(String[] args) {
        // (x, y) = (0, 0) -> n = 0
        // (x, y) = (1, 1) -> n = 1
        // for x % 2 = 0 and x > 0, there are points n for y s.t. y = x
        // or y = x - 2. in these cases, n = y + x
        // for x % 2 = 1 and x > 1, there are points n for y s.t. y = x - 2
        // or y = x. in these cases, n = y + x - 1
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x == 0 && y == 0) {
                System.out.println(0);
            } else if (x == 1 && y == 1) {
                System.out.println(1);
            } else if (x > 1 && (y == x || y == (x - 2))) {
                if (x % 2 == 0) {
                    System.out.println(x + y);
                } else {
                    System.out.println(x + y - 1);
                }
            } else {
                System.out.println("No Number");
            }
        }
    }
}
