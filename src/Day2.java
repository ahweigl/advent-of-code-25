import java.util.*;

public class Day2 {
    public static Long solvePartOne(List<String> input) {
        long result = 0;
        for (String line : input) {
            String[] ranges = line.split(",");
            for (String s : ranges) {
                int splitIndex = s.indexOf('-');
                long start = Long.parseLong(s.substring(0, splitIndex));
                long end = Long.parseLong(s.substring(splitIndex + 1));

                for (long i = start; i <= end; i++) {
                    String longString = Long.toString(i);
                    if (longString.length() % 2 == 0 &&
                            longString.substring(0, longString.length() / 2)
                                    .equals(longString.substring(longString.length() / 2))) {
                        result += i;
                    }
                }
            }

        }

        return result;
    }

    public static Long solve(List<String> input) {
        long result = 0;
        for (String line : input) {
            String[] ranges = line.split(",");
            for (String s : ranges) {
                int splitIndex = s.indexOf('-');
                long start = Long.parseLong(s.substring(0, splitIndex));
                long end = Long.parseLong(s.substring(splitIndex + 1));

                for (long i = start; i <= end; i++) {
                    String longString = Long.toString(i);

                    if (isRepeatedSubstring(longString)) {
                        result += i;
                    }
                }
            }
        }
                    
        return result;
    }

    private static boolean isRepeatedSubstring(String s) {
        int len = s.length(); 
        for (int size = 1; size <= len / 2; size++) {
            if (len % size != 0) continue; 

            String sub = s.substring(0, size);
            StringBuilder repeated = new StringBuilder();
            int times = len / size;
            for (int i = 0; i < times; i++) {
                repeated.append(sub);
            }

            if (repeated.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}
