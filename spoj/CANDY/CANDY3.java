import java.math.BigInteger;
import java.util.Scanner;

class CANDY3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            in.nextLine();
            BigInteger numberOfChildren = in.nextBigInteger();
            in.nextLine();
            BigInteger counter = numberOfChildren.subtract(BigInteger.ONE);
            BigInteger sum = BigInteger.ZERO;
            while (counter.compareTo(BigInteger.ZERO) >= 0) {
                sum = sum.add(in.nextBigInteger());
                counter = counter.subtract(BigInteger.ONE);
            }
            BigInteger remainder = sum.mod(numberOfChildren);
            if (remainder.compareTo(BigInteger.ZERO) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
