import java.util.ArrayList;
import java.util.Scanner;

class TOANDFRO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberColumns = in.nextInt();
        in.nextLine();
        while (numberColumns != 0) {
            String raw = in.nextLine();
            int numberRows = raw.length() / numberColumns;
            String[][] original = new String[numberRows][numberColumns];
            for (int i = 0; i < numberRows; i++) {
                int offset = i * numberColumns;
                String row = raw.substring(offset, offset + numberColumns);
                if (i % 2 == 0) {
                    original[i] = new StringBuilder(row).toString().split("");
                } else {
                    original[i] = new StringBuffer(row).reverse().toString().split("");
                }
            }
            for (int j = 0; j < numberColumns; j++) {
                for (int i = 0; i < numberRows; i++) {
                    System.out.print(original[i][j]);
                }
            }
            numberColumns = in.nextInt();
            in.nextLine();
            if (numberColumns != 0) {
                System.out.println();
            }
        }
    }
}
