package maze.action.acomands;


public class NotMenu implements Commands {

    @Override
    public void action() {
        System.out.println("Incorrect option. Please try again");
    }
}
