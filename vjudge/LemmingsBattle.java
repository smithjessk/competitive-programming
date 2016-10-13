import java.util.*;

public class LemmingsBattle {
    public static void main(String[] args) {
        // loop for N test cases
        // keep a heap for blue side lemmings
        // keep a heap for green side lemmings
        // while there are still lemmings in both heaps, go through the process
        // while there are still lemmings to be assigned and battlefields to fill,
        //      pop the top and fill the top ones
        // do this for both green and blue separately
        // for i from 0 to math.min(numberBlueFilled, ...GreenFilled), find the differences and re-assign
        // to the heaps as necessary
        // after the process, if greenHeap.size == blueHeap.size == 0, print they both died
        // else if greenHeap.size > 0 print green wins and the surviving soldiers
        // else print blue wins and the surviving soldiers
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while(n-- > 0) {
            int numBattlefields = in.nextInt();
            int greenArmySize = in.nextInt();
            int blueArmySize = in.nextInt();
            in.nextLine();
            PriorityQueue<Integer> greenLemmings = new PriorityQueue<>(greenArmySize, Collections.reverseOrder());
            PriorityQueue<Integer> blueLemmings = new PriorityQueue<>(blueArmySize, Collections.reverseOrder());
            for (int i = 0; i < greenArmySize; i++) {
                greenLemmings.add(Integer.parseInt(in.nextLine()));
            }
            for (int i = 0; i < blueArmySize; i++) {
                blueLemmings.add(Integer.parseInt(in.nextLine()));
            }
            while (greenLemmings.size() > 0 && blueLemmings.size() > 0) {
                int smallerArmySize = Math.min(greenLemmings.size(), blueLemmings.size());
                int numBattles = Math.min(numBattlefields, smallerArmySize);
                for (int i = 0; i < numBattles; i++) {
                    int bestGreen = greenLemmings.poll();
                    int bestBlue = blueLemmings.poll();
                    if (bestGreen > bestBlue) {
                        greenLemmings.add(bestGreen - bestBlue);
                    } else if (bestBlue > bestGreen) {
                        blueLemmings.add(bestBlue - bestGreen);
                    }
                }
            }
            if (greenLemmings.size() == 0) {
                if (blueLemmings.size() == 0) {
                    System.out.println("green and blue died");
                } else {
                    System.out.println("blue wins");
                    for (int strength : blueLemmings) {
                        System.out.println(strength);
                    }
                }
            } else {
                System.out.println("green wins");
                for (int strength : greenLemmings) {
                    System.out.println(strength);
                }
            }
            if (n > 0) {
                System.out.println();
            }
        }
    }
}
