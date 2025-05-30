import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Enhanced MiniShell with more functions and appealing terminal UI
 */
public class MShell {
    // ANSI color codes for terminal output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void main(String[] args) throws IOException {
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        
        // Print colorful banner
        System.out.println(ANSI_CYAN + "*************************************" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "***** " + ANSI_YELLOW + "Welcome to Enhanced MiniShell!" + ANSI_CYAN + " *****" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "*************************************" + ANSI_RESET);
        System.out.println("Type 'help' for available commands");
        
        while (true) {
            // Show prompt with current directory
            System.out.print(ANSI_BLUE + "[" + System.getProperty("user.dir") + "]" + ANSI_GREEN + "> " + ANSI_RESET);
            
            commandLine = console.readLine().trim();
            if (commandLine.isEmpty()) {
                continue;
            }
            
            // Split command into parts
            String[] parts = commandLine.split("\\s+");
            String command = parts[0].toLowerCase();
            
            try {
                switch (command) {
                    case "ls":
                        listDirectory(parts.length > 1 ? parts[1] : ".");
                        break;
                    case "cd":
                        changeDirectory(parts.length > 1 ? parts[1] : System.getProperty("user.home"));
                        break;
                    case "cat":
                        if (parts.length < 2) throw new IllegalArgumentException("Missing filename");
                        catFile(parts[1]);
                        break;
                    case "echo":
                        echoCommand(parts);
                        break;
                    case "clear":
                        clearScreen();
                        break;
                    case "help":
                        showHelp();
                        break;
                    case "cpu":
                        showCpuInfo();
                        break;
                    case "mem":
                        showMemoryInfo();
                        break;
                    case "date":
                        showDateTime();
                        break;
                    case "exit":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println(ANSI_RED + "Invalid command. Type 'help' for available commands" + ANSI_RESET);
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Error: " + e.getMessage() + ANSI_RESET);
            }
        }
    }
    
    private static void listDirectory(String path) {
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Directory not found: " + path);
        }
        
        System.out.println(ANSI_YELLOW + "Contents of " + dir.getAbsolutePath() + ":" + ANSI_RESET);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(ANSI_BLUE + file.getName() + "/" + ANSI_RESET);
                } else {
                    System.out.println(file.getName());
                }
            }
        }
    }
    
    private static void changeDirectory(String path) {
        File newDir = new File(path);
        if (!newDir.exists() || !newDir.isDirectory()) {
            throw new IllegalArgumentException("Directory not found: " + path);
        }
        System.setProperty("user.dir", newDir.getAbsolutePath());
    }
    
    private static void catFile(String filename) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        System.out.println(content);
    }
    
    private static void echoCommand(String[] parts) {
        for (int i = 1; i < parts.length; i++) {
            System.out.print(parts[i] + " ");
        }
        System.out.println();
    }
    
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    private static void showHelp() {
        System.out.println(ANSI_YELLOW + "Available commands:" + ANSI_RESET);
        System.out.println("ls [path]      - List directory contents");
        System.out.println("cd [path]      - Change directory");
        System.out.println("cat <file>     - Display file content");
        System.out.println("echo <text>    - Print text to console");
        System.out.println("clear          - Clear terminal screen");
        System.out.println("cpu            - Show CPU information");
        System.out.println("mem            - Show memory information");
        System.out.println("date           - Show current date and time");
        System.out.println("help           - Show this help message");
        System.out.println("exit           - Exit the shell");
    }
    
    private static void showCpuInfo() {
        System.out.println("Number of available processors: " + 
            ANSI_GREEN + Runtime.getRuntime().availableProcessors() + ANSI_RESET);
    }
    
    private static void showMemoryInfo() {
        long freeMem = Runtime.getRuntime().freeMemory();
        long totalMem = Runtime.getRuntime().totalMemory();
        System.out.println("Free memory: " + ANSI_GREEN + formatMemory(freeMem) + ANSI_RESET);
        System.out.println("Total memory: " + ANSI_GREEN + formatMemory(totalMem) + ANSI_RESET);
    }
    
    private static String formatMemory(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp-1);
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }
    
    private static void showDateTime() {
        System.out.println("Current time and date: " + 
            ANSI_GREEN + new Date() + ANSI_RESET);
    }
}
