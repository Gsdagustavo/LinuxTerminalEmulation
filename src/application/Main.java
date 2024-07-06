package application;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static String[] commands = new String[2];

    public static void main(String[] args) {

        commands[0] = "echo";
        commands[1] = "clear";

        while (true)  {
            showInputLine();
            String input = sc.nextLine();

            int returnCode = validateCommand(input);
//            System.out.println(returnCode);
        }

    }

    public static void showInputLine() {
        System.out.print("user@user $ ");
    }

    public static int validateCommand(String userInput) {
        String[] arguments = userInput.split(" ");

        String firsArgument = arguments[0];

        // Execute commands based on the command and arguments received
        for (int i = 0; i < commands.length; i++) {

            // Echo command
            if (firsArgument.compareTo("echo") == 0) {
                echoCommand(arguments);
                return 0;

            // Clear command
            } else if (firsArgument.compareTo("clear") == 0) {
                clearCommand();
                return 0;
            } else if (firsArgument.compareTo("exit") == 0) {

            }
        }

        if (userInput.isBlank()) {
            return -1;
        }

        System.err.println(userInput + " command not recognized.");
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

    public static int exitCommand(String[] args) {
        
    }
}
