import java.util.*;

public class HardwoodSpecies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        in.nextLine(); // skip line that sets up the test case

        ArrayList<String> lines = new ArrayList<>();
        while (in.hasNextLine()) {
            lines.add(in.nextLine());
        }

        int lineIndex = 0;

        while(n-- > 0) {
            int numLines = 0;
            HashMap<String, Integer> counts = new HashMap<>();
            String line = lines.get(lineIndex);
            lineIndex++;
            while (!line.equals("")) {
                numLines++;
                if (!counts.containsKey(line)) {
                    counts.put(line, 0);
                }
                counts.put(line, counts.get(line) + 1);
                if (lineIndex < lines.size()) {
                    line = lines.get(lineIndex);
                    lineIndex++;
                } else {
                    line = "";
                }
            }
            String[] species = new String[counts.size()];
            Arrays.sort(counts.keySet().toArray(species));
            for (String s : species) {
                System.out.printf("%s %.4f\n", s, 100 * ((double) counts.get(s) / numLines));
            }
            if (n != 0) {
                System.out.println();
            }
        }
    }
}
