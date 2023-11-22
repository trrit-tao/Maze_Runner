package maze.action.acomands;

import maze.action.Border;
import maze.action.Edge;
import maze.action.GraphElement;
import maze.action.Node;

import java.util.*;

public class Maze implements Commands {
    private static Maze staticMaze;
    private final Set<GraphElement> visitedNodes = new HashSet<>();
    private final List<GraphElement> stackEdge = new ArrayList<>();
    private final List<GraphElement> stackRoute = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private GraphElement[][] maze;
    private boolean flssss = false;

    public static Maze getInstance() {
        if (staticMaze == null) {
            staticMaze = new Maze();
        }
        return staticMaze;
    }

    public static Maze getNewInstance() {
        staticMaze = new Maze();
        return staticMaze;
    }

    public void completionMaze() {
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                if (x == 0 || x == maze.length - 1 || y == 0 || y == maze[x].length - 1) {
                    maze[x][y] = new Border();
                } else if ((x % 2 == 0 && y == maze[x].length - 2) || (x == maze.length - 2 && y % 2 == 0)) {
                    maze[x][y] = new Node();
                } else if (x % 2 != 0 && y % 2 != 0) {
                    maze[x][y] = new Node();
                } else {
                    maze[x][y] = new Edge();
                }
            }
        }
        generatingEntryExit();
    }

    public void bindingCells() {
        for (int x = 1; x < maze.length - 1; x++) {
            for (int y = 1; y < maze[x].length - 1; y++) {
                if (x % 2 != 0 && y % 2 != 0) {
                    bindingVertical(x, y);
                    bindingHorizontal(x, y);
                } else if ((x % 2 == 0 && y == maze[x].length - 1) || (x == maze.length - 1 && y % 2 == 0)) {
                    bindingVertical(x, y);
                    bindingHorizontal(x, y);
                } else if (x % 2 == 0 && y % 2 != 0) {
                    bindingVertical(x, y);
                } else if (x % 2 != 0) {
                    bindingHorizontal(x, y);
                }
            }
        }
        completionDate(maze[1][1]);
    }

    public void bindingVertical(int x, int y) {
        maze[x][y].set(maze[x - 1][y]);
        maze[x][y].set(maze[x + 1][y]);
    }


    public void bindingHorizontal(int x, int y) {
        maze[x][y].set(maze[x][y - 1]);
        maze[x][y].set(maze[x][y + 1]);
    }

    private void generatingEntryExit() {
        maze[0][1] = new Node();
        maze[0][1].openPath();
        if ((maze[0].length) % 2 == 0) {
            maze[maze.length - 1][maze[0].length - 3] = new Node();
            maze[maze.length - 1][maze[0].length - 3].setFlag();
            maze[maze.length - 1][maze[0].length - 3].openPath();
        } else {
            maze[maze.length - 1][maze[0].length - 2] = new Node();
            maze[maze.length - 1][maze[0].length - 2].setFlag();
            maze[maze.length - 1][maze[0].length - 2].openPath();
        }
    }


    public void printRoute(GraphElement entry) {
        visitedNodes.add(entry);
        if (entry.toString().equals("  ")) {
            if (entry.getFlag() || flssss) {
                stackRoute.add(entry);
                flssss = true;
                return;
            }
            for (GraphElement edge : entry.getList()) {
                if (!edge.toString().equals("  ")) {
                    continue;
                }
                if (edge.getFlag()) {
                    stackRoute.add(entry);
                    stackRoute.add(edge);
                    flssss = true;
                    return;
                }
                for (GraphElement nodeToVisit : edge.getList()) {
                    if (visitedNodes.contains(nodeToVisit)) {
                        continue;
                    }
                    printRoute(nodeToVisit);
                    if (flssss) {
                        stackRoute.add(entry);
                        stackRoute.add(edge);
                        return;
                    }
                }
            }
        }
    }

    public void completionDate(GraphElement cell) {
        visitedNodes.add(cell);
        cell.openPath();
        stackEdge.addAll(cell.getList());
        while (!stackEdge.isEmpty()) {
            Collections.shuffle(stackEdge);
            GraphElement edge = stackEdge.remove(0);
            for (int i = 0; i < edge.getList().size(); i++) {
                if (!visitedNodes.contains(edge.getList().get(i))) {
                    edge.openPath();
                    completionDate(edge.getList().get(i));
                }
            }
        }
    }

    public void print() {
        for (GraphElement[] cells : maze) {
            for (GraphElement cell : cells) {
                cell.print();
            }
            System.out.println();
        }
    }

    private void pathMapping() {
        stackRoute.add(maze[0][1]);
        for (GraphElement graphElement : stackRoute) {
            graphElement.routePrint();
        }
    }

    public void routSave() {
        stackRoute.clear();
        visitedNodes.clear();
        stackEdge.clear();
        printRoute(maze[1][1]);
        flssss = false;
        pathMapping();
    }

    @Override
    public void action() {
        stackEdge.clear();
        visitedNodes.clear();
        System.out.println("Enter the size of a new maze");
        final int sizeMaze = scanner.nextInt();
        maze = new GraphElement[sizeMaze][sizeMaze];
        completionMaze();
        bindingCells();
        print();
    }

    @Override
    public String toString() {
        String stringMaze = "";
        for (GraphElement[] cells : maze) {
            for (GraphElement cell : cells) {
                stringMaze += cell.toString();
            }
            stringMaze += "\n";
        }
        return stringMaze;
    }
}
