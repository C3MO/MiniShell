import java.io.*;
import java.util.*;

/**
 * Created by Cem Saygili, MTK: 87707 on 13.06.18.
 */
public class MShell


{

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
                if (command.equals("run")) {
                    if ((args.length <= 0) && (args[1].equals( "-l"))) {

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

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    continue;
                }
                if (command.equals("parallel")) {
                    if ((args.length <= 0) && (args[2].equals( "date"))) {

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

                    while ((line = br.readLine()) != null) {
                    String [] tokens = line.split(" ");
                    System.out.println(Arrays.toString(tokens));

                    }
                    continue;
                }

                    ArrayList<String> parms = new ArrayList<String>();

                    String[] lineSplit = command.split(" ");


                    int size = lineSplit.length;

                    for (int i = 0; i < size; i++) {

                        parms.add(lineSplit[i]);


                    }


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

