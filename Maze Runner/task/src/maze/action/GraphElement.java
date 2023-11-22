package maze.action;

import java.util.List;

public interface GraphElement {
    void print();

    void set(GraphElement cell);

    void setFlag();

    boolean getFlag();

    void openPath();

    void routePrint();

    List<GraphElement> getList();
}
