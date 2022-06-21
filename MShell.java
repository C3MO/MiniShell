import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class MShell {

    /**
     * The function takes in a command from the user and executes it
     */
    public static void main(String[] args) throws java.io.IOException {
        String command;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("***** MiniShell *****");
        while (true) {

            System.out.print(">");

            command = console.readLine();
            {
                if (command.equals("")) {


                    continue;


                } else if (command.equalsIgnoreCase("exit")) {

                    System.exit(0);

                }
                // This is the run command. It is taking in the command and executing it.
                if (command.equals("run")) {
                    if ((args.length <= 0) && (args[1].equals("-l"))) {

                        System.err.println("Need command to run");
                        System.exit(-1);
                    }

                    Runtime runtime = Runtime.getRuntime();
                    Process process = runtime.exec(args);
                    InputStream is = process.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String line;

                    System.out.printf("Output of running %s is:\n",
                            Arrays.toString(args));

                    // This is taking the command that the user has entered and executing it.
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    continue;
                }
                // This is the parallel command. It is taking in the command and executing it.
                if (command.equals("parallel")) {
                    // This is checking if the user has entered a command to run. If they have not entered a command, it
                    // will print out an error message and exit the program.
                    if ((args.length <= 0) && (args[2].equals("date"))) {

                        System.err.println("Need command to run");
                        System.exit(-1);
                    }

                    Runtime runtime = Runtime.getRuntime();
                    Process process = runtime.exec(args);
                    InputStream is = process.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String line;

                    System.out.printf("Output of running %s is:\n",
                            Arrays.toString(args));

                    // This is taking the command that the user has entered and executing it.
                    while ((line = br.readLine()) != null) {
                        String[] tokens = line.split(" ");
                        System.out.println(Arrays.toString(tokens));

                    }
                    continue;
                }

                String[] lineSplit = command.split(" ");


                ArrayList<String> parms = new ArrayList<>(Arrays.asList(lineSplit));


                ProcessBuilder pb = new ProcessBuilder(parms);
                Process proc = pb.start();

                InputStream is = proc.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String line;
                while ((line = br.readLine()) != null)
                    System.out.println(line);
                br.close();


            }

        }

    }

}

