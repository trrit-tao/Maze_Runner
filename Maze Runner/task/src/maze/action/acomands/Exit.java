package maze.action.acomands;


public class Exit implements Commands {

    @Override
    public void action() {
        System.out.println("Bye!");
        System.exit(0);
    }
}