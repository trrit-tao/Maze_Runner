package maze.action;


import java.util.ArrayList;
import java.util.List;

public class Edge implements GraphElement {
    private final List<GraphElement> nodes = new ArrayList<>();
    private String value = "\u2588\u2588";


    @Override
    public void routePrint() {
        value = "//";
    }

    @Override
    public void print() {
        System.out.print(value);
    }

    @Override
    public void set(GraphElement graphElement) {
        nodes.add(graphElement);
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
        value = "  ";
    }

    @Override
    public List<GraphElement> getList() {
        return nodes;
    }

    @Override
    public String toString() {
        return value;
    }
}
