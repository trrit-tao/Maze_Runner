package maze.action.acomands;

public class Print implements Commands {
    private final Maze maze = Maze.getInstance();

    @Override
    public void action() {
        try {
            System.out.println(maze);
        } catch (NullPointerException e) {
            System.out.println(Loading.getLoadMaze());
        } catch (Exception r) {
            System.out.println(r.getMessage());
        }
    }
}