package maze.action;


import java.util.ArrayList;
import java.util.List;

public class Node implements GraphElement {
    private final List<GraphElement> edges = new ArrayList<>();
    private String value = "\u2588\u2588";
    private boolean flag = false;

    @Override
    public void routePrint() {
        value = "//";
    }

    @Override
    public boolean getFlag() {
        return flag;
    }

    @Override
    public void setFlag() {
        flag = true;
    }

    @Override
    public void print() {
        System.out.print(value);
    }

    @Override
    public void set(GraphElement cell) {
        edges.add(cell);
    }

    @Override
    public void openPath() {
        value = "  ";
    }

    @Override
    public List<GraphElement> getList() {
        return edges;
    }

    @Override
    public String toString() {
        return value;
    }
}