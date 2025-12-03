import java.math.BigInteger;
import java.util.*;

public class Day3 {
    public static Integer solvePartOne(List<String> input) {
        int result = 0;

        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);

            int joltage = 0;
            for (int j = 0; j < line.length(); j++) {
                for (int k = j + 1; k < line.length(); k++) {
                    String currentJoltage = String.valueOf(line.charAt(j)).concat(String.valueOf(line.charAt(k)));
                    if (Integer.parseInt(currentJoltage) > joltage) {
                        joltage = Integer.parseInt(currentJoltage);
                    }
                }
            }

            result += joltage;
        }

        return result;
    }

    public static BigInteger solve(List<String> input) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            Stack<Integer> numberStack = new Stack<>();
            int toRemove = line.length() - 12;

            for (int j = 0; j < line.length(); j++) {
                int digit = line.charAt(j) - '0';
                while (toRemove > 0 && !numberStack.isEmpty()
                        && numberStack.peek() < digit) {
                    numberStack.pop();
                    toRemove--;
                }
                numberStack.push(digit);
            }

            while (toRemove > 0) {
                numberStack.pop();
                toRemove--;
            }

            StringBuilder joltage = new StringBuilder();
            for (int d : numberStack) {
                joltage.append(d);
            }

            BigInteger joltageNum = new BigInteger(joltage.toString());

            result = result.add(joltageNum);
        }

        return result;
    }
}
