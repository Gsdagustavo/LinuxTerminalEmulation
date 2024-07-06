package application;

import java.util.ArrayList;
import java.util.List;
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

            validateCommand(input);
        }

    }

    public static void showInputLine() {
        System.out.print("user@user $ ");
    }

    public static void validateCommand(String userInput) {
        String[] arguments = userInput.split(" ");
        int argumentsSize = arguments.length;

        String firsArgument = arguments[0];

        for (int i = 0; i < commands.length; i++) {

            if (firsArgument.compareTo("echo") == 0) {

                if (arguments.length == 1) {
                    return;
                }

                for (int j = 0; i < arguments.length; i++) {

                    if (i == 0) { continue; }
                    System.out.print(arguments[i]);

                    System.out.print(" ");
                }

//                wait(100);
                System.out.println();
                return;
            } else if (firsArgument.compareTo("clear") == 0) {
                clearCommand();
                return;
            }
        }

        System.err.println(userInput + " command not recognized.");
        wait(100);
    }

    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) { }
    }

    public static void echoCommand(String arg) {
        System.out.println(arg);
    }

    public static void clearCommand() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

//    public static void q
}
