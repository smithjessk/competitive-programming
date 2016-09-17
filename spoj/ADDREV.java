import java.util.*;
import java.lang.*;

class ADDREV {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String line = in.nextLine();
			int sum = Arrays.stream(
						new StringBuilder(line).reverse().toString().split(" "))
							.map(Integer::parseInt)
							.reduce(0, (a, b) -> a + b);
			String result = new StringBuilder(sum + "").reverse().toString();
			while (result.length() > 1 && result.substring(0, 1).equals("0")) {
				result = result.substring(1);
			}
			System.out.println(result);
		}
	}
}