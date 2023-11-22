package maze.action.acomands;


import java.io.EOFException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Loading implements Commands {
    private static final Scanner scanner = new Scanner(System.in);
    private static String[] temp;


    public static String getLoadMaze() {
        return temp[0];
    }

    public static String getLoadRound() {
        return temp[1];
    }


    public static void reading() {
        try {
            temp = Files.readString(Paths.get(".\\" + scanner.nextLine()))
                    .split("\\*\\*\\*");
        } catch (EOFException | NotSerializableException e) {
            System.out.println("Cannot load the maze. It has an invalid format");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void action() {
        reading();
    }
}