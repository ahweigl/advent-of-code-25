import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("uh oh");
            return;
        }

        String day = args[0]; 
        String path = "inputs/" + day + ".txt";

        var lines = Files.readAllLines(Paths.get(path));

        switch (day) {
            case "day1":
                System.out.println(Day1.solve(lines));
                break;
            default: 
                System.out.println("oopsies invalid day");
        }
    }
}