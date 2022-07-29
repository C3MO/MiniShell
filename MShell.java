import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by Cem Saygili on 29.7.2022
 * It's a simple shell that takes in commands from the user and executes them
 */
public class MShell {

    /**
     * It prints out the current time and date, the current working directory, the number of available processors, and the
     * amount of free memory
     */
    public static void main(String[] args) throws java.io.IOException {
        String command;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("***** MiniShell *****");
        while (true) {

            System.out.print(">>> ");

            command = console.readLine();

            // Checking if the command is run or RUN and if the argument is -d or -D. If it is, it prints out the
            // current time and date and the current working directory. If not, it prints out an invalid command.
            if ((command.equals("run")) || command.equals("RUN")) {
                if ((args[0].equals("-d")) || (args[0].equals("-D"))) {
                    System.out.println("Current time and date: " + new java.util.Date());
                    System.out.println("Current working directory: " + System.getProperty("user.dir"));
                }
                // Checking if the argument is -a or -A. If it is, it prints out the number of available processors and the
                // amount of free memory.
                if ((args[0].equals("-a")) || (args[0].equals("-A"))) {
                    System.out.println("Number of available processors: " + Runtime.getRuntime().availableProcessors());
                    System.out.println("Amount of free memory: " + Runtime.getRuntime().freeMemory());
                }
            } else {
                System.out.println("Invalid command");
                System.out.println("Goodbye!");
                break;
            }

        }
    }
}
