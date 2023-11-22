package maze.action.acomands;

import java.io.FileWriter;
import java.util.Scanner;

public class Save implements Commands {
    private final Scanner scanner = new Scanner(System.in);
    private final Maze maze = Maze.getInstance();

    @Override
    public void action() {
        try (FileWriter writer = new FileWriter(".\\" + scanner.nextLine().trim())) {
            writer.write(maze.toString());
            writer.write("***");
            maze.routSave();
            writer.write(maze.toString());
        } catch (Exception e) {
            System.out.println("Exception! " + e.getMessage());
        }
    }
}