package maze.action.acomands;

public class FindOut implements Commands {
    private final Maze maze = Maze.getInstance();

    @Override
    public void action() {
        try {
            maze.routSave();
            System.out.println(maze);
        } catch (NullPointerException e) {
            System.out.println(Loading.getLoadRound());
        } catch (Exception r) {
            System.out.println(r.getMessage());
        }
    }
}
