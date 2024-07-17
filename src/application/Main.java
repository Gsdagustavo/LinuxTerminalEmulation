package application;


import util.DirectorySystem;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        DirectorySystem dirSys = new DirectorySystem();

        while (true)  {
            showInputLine();
            String input = sc.nextLine();

            int returnCode = validateCommand(input);
        }

    }

    public static void showInputLine() {
        System.out.print("user@user $ ");
    }

    public static int validateCommand(String userInput) {
        String[] arguments = userInput.split(" ");

        String firsArgument = arguments[0];

        // Execute commands based on the command and arguments received
        // GENERIC COMMANDS

        // Echo command
        if (firsArgument.compareTo("echo") == 0) {
            echoCommand(arguments);
            return 0;

        }

        // Clear command
        if (firsArgument.compareTo("clear") == 0) {
            clearCommand();
            return 0;
        }

        // Exit command
        if (firsArgument.compareTo("exit") == 0) {
            String argument = " ";

            if (arguments.length == 2) {
                if (arguments[1].compareTo("now") == 0) {
                    argument = "now";
                }
            }

            exitCommand(argument);
        }

        // DIRECTORY MANIPULATION COMMANDS

        // Creates a directory
        if (firsArgument.compareTo("mkdir") == 0) {
            String dirName = new String();

            if (arguments.length == 1) {
                System.out.print("Enter directory name: ");
                dirName = sc.nextLine();

                System.out.println("Directory with name '" + dirName + "' created.");
                return 0;
            } else {

                for (int i = 0; i < arguments.length; i++) {
                    if (i == 0) { continue; }

                    dirName += (arguments[i]);

                    if (!((arguments.length - 1) - i == 0)) {
                        dirName += " ";
                    }
                }
            }
            System.out.println("Directory with name '" + dirName + "' created.");
            wait(100);
            return 0;
        }

        if (userInput.isBlank()) {
            return -1;
        }

        System.err.println(userInput.strip() + " command not recognized.");
        wait(100);

        return -1;
    }

    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) { }
    }

    public static void clearCommand() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static int echoCommand(String[] arguments) {
        // Will return if there are no arguments
        if (arguments.length == 1) {
            return 1;
        }

        // Print the arguments in the console
        for (int i = 0; i < arguments.length; i++) {

            if (i == 0) { continue; }
            System.out.print(arguments[i]);

            if (!((i + 1) == arguments.length)) {
                System.out.print(" ");
            }
        }

        System.out.println();

        return 0;
    }

    public static int exitCommand(String arg) {

        // 0 means shutdown in 10 seconds
        // -1 means the command was not executed successfully
        // 1 means shutdown now

        if (arg.compareTo("now") == 0) {
            System.exit(1);
            return 0;
        } else if (arg.compareTo(" ") == 0) {
            wait(3 * 1000);
            System.exit(1);
            return 0;
        }

        return -1;
    }
}
