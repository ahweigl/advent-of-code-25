import java.util.List;

public class Day1 {
    public static Integer solvePartOne(List<String> input) {
        int dialVal = 50;
        int result = 0;

        for (int i = 0; i < input.size(); i++) {
            String dir = input.get(i).substring(0, 1);
            int val = Integer.valueOf(input.get(i).substring(1));

            int delta = 0;
            switch (dir) {
                case "L":
                    delta = -val;
                    break;
                case "R":
                    delta = val;
                    break;
                default:
                    break;
            }

            dialVal = (dialVal + delta + 100) % 100;

            if (dialVal == 0)
                result++;
        }

        return result;
    }

    public static Integer solve(List<String> input) {
        int dialVal = 50;
        int result = 0;

        for (int i = 0; i < input.size(); i++) {
            String dir = input.get(i).substring(0, 1);
            int val = Integer.valueOf(input.get(i).substring(1));

            int deltaStep = 0;
            switch (dir) {
                case "L":
                    deltaStep = -1;
                    break;
                case "R":
                    deltaStep = 1;
                    break;
                default:
                    break;
            }

            for (int step = 0; step < val; step++) {
                dialVal = (dialVal + deltaStep + 100) % 100;
                if (dialVal == 0) result++;
            }
        }

        return result;
    }
}