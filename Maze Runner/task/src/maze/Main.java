package maze;


import maze.action.acomands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static String menu1 = "=== Menu ===\n1. Generate a new maze\n2. Load a maze\n3. Save the maze\n4. Display the maze\n5. Find the escape\n0. Exit";
    static String menu2 = "=== Menu ===\n1. Generate a new maze\n2. Load a maze\n0. Exit";
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Commands> loadingExitNotCommand = new HashMap<>();

    static {
        loadingExitNotCommand.put("1", Maze.getNewInstance());
        loadingExitNotCommand.put("2", new Loading());
        loadingExitNotCommand.put("3", new Save());
        loadingExitNotCommand.put("4", new Print());
        loadingExitNotCommand.put("5", new FindOut());
        loadingExitNotCommand.put("0", new Exit());
        loadingExitNotCommand.put("NotCommands", new NotMenu());
    }


    public static void main(String[] args) {
        start();
        while (true) {
            System.out.println(menu1);
            String numbMenu = scanner.nextLine();
            try {
                loadingExitNotCommand.getOrDefault(numbMenu, loadingExitNotCommand.get("NotCommands")).action();
                if (Objects.equals(numbMenu, "0")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getClass());
            }

        }
    }


    private static void start() {
        System.out.println(menu2);
        String numberMenu = scanner.nextLine();
        try {
            loadingExitNotCommand.getOrDefault(numberMenu, loadingExitNotCommand.get("NotCommands")).action();
        } catch (Exception e) {
            System.out.println("aй");
        }
    }
}

