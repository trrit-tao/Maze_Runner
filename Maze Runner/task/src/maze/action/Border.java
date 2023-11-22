package maze.action;


import java.util.ArrayList;
import java.util.List;

public class Border implements GraphElement {
    private final String value = "\u2588\u2588";

    @Override
    public void print() {
        System.out.print(value);
    }

    @Override
    public void set(GraphElement cell) {
    }

    @Override
    public void setFlag() {
    }

    @Override
    public boolean getFlag() {
        return false;
    }

    @Override
    public void openPath() {
    }

    @Override
    public void routePrint() {

    }

    @Override
    public List<GraphElement> getList() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return value;
    }
}
