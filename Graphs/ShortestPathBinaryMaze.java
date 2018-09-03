package algorthims.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <h2>Problem:</h2>
 * <p>
 * The input is an M x N (2d array) array <br>
 * It is a binary maze (or M X N array), meaning if the cell is traversable, the unit distance of the path is 1 <br>
 * Traversable cells are represented by 0 <br>
 * Non-Traversable cells are represented by 1 <br>
 * Cell 0,0 is always traversable and the starting point <br>
 * There is an obstacle (only one) at which is the cell is represented by 9 <br>
 * <br>
 * We need to start at zero and find the shortest path to 9 <br>
 * <h3>Rules:</h3>
 * ---------------<br>
 * Only possible traversals are Top, Right, Bottom, Left no traversal allowed diagonally<br>
 * Additionally we could only traverse if the cell is 0<br>
 * <p>
 * 
 * @author Sai Muppa
 */
public class ShortestPathBinaryMaze extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ShortestPathBinaryMaze(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ShortestPathBinaryMaze.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        List<List<Integer>> matrixList = new ArrayList<>();

        Integer matrix[][] = { { 0, 0, 0 },
                               { 0, 1, 0 },
                               { 0, 9, 0 } };
        matrixList = twoDArrayToList(matrix);
        System.out.println("Shortest Path: " + getSmallestPath(matrixList));

        // Other Test Cases
        //        Integer matrix[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 9, 0 } };
        //        matrixList = twoDArrayToList(matrix);
        //        System.out.println("Shortest Path: " + getSmallestPath(matrixList));
        //
        //        Integer matrix[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 9, 0 } };
        //        matrixList = twoDArrayToList(matrix);
        //        System.out.println("Shortest Path: " + getSmallestPath(matrixList));
        //
        //        Integer matrix[][] = { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 1, 9 } };
        //        matrixList = twoDArrayToList(matrix);
        //        System.out.println("Shortest Path: " + getSmallestPath(matrixList));
    }

    private int getSmallestPath(List<List<Integer>> matrix) {
        int result = -1; // return -1 if we cannot traverse to the obstacle

        Node nodes[][] = new Node[matrix.size()][matrix.get(0).size()];
        Node start = new Node(0, 0, true);
        Node destination = null;
        // Refresh the array to more readable for traversal
        for (int row = 0; row < matrix.size(); row++) {
            for (int column = 0; column < matrix.get(row).size(); column++) {
                int cellValue = matrix.get(row).get(column);
                if (cellValue == 0) {
                    nodes[row][column] = new Node(row, column, true);
                } else if (cellValue == 1) {
                    nodes[row][column] = new Node(row, column, false);
                } else { // in case of an obstacle consider it as traversable i.e. make the cell value to 1
                    nodes[row][column] = new Node(row, column, true);
                    destination = new Node(row, column, true);
                }
            }
        }

        Queue<LevelNode> runningQueue = new LinkedList<>();

        runningQueue.add(new LevelNode(1, start));

        boolean destinationReached = false;

        while (!runningQueue.isEmpty()) { // BFS
            LevelNode currentNode = runningQueue.poll();
            currentNode.getNode().setVisited(true); // set the visited flag

            List<Node> neighbors = getUnvisitedNeighbors(nodes, currentNode.getNode());

            for (Node node : neighbors) {
                if (node.equals(destination)) {
                    destinationReached = true;
                    break;
                }
                runningQueue.add(new LevelNode(currentNode.getLevelOrder() + 1, node));
            }

            if (destinationReached) {
                result = currentNode.getLevelOrder();
                break;
            }
        }

        return result;
    }

    private List<Node> getUnvisitedNeighbors(Node[][] nodes, Node referenceNode) {
        int row = referenceNode.getRow();
        int column = referenceNode.getColumn();

        List<Node> neighbors = new ArrayList<>();
        if (row != 0) { // Top
            addNeighbor(neighbors, nodes[row - 1][column]);
        }

        if (row < nodes.length - 1) { // Bottom
            addNeighbor(neighbors, nodes[row + 1][column]);
        }

        if (column != 0) { // Left
            addNeighbor(neighbors, nodes[row][column - 1]);
        }

        if (column < nodes[0].length - 1) { // Right
            addNeighbor(neighbors, nodes[row][column + 1]);
        }

        return neighbors;
    }

    private void addNeighbor(List<Node> neighbors, Node currentNode) {
        if (currentNode.isTraversable() && !currentNode.isVisited()) {
            neighbors.add(currentNode);
        }
    }

    public <T> List<List<T>> twoDArrayToList(T[][] twoDArray) {
        List<List<T>> list = new ArrayList<List<T>>();
        for (T[] array : twoDArray) {
            list.add(Arrays.asList(array));
        }
        return list;
    }

    private class LevelNode {
        private int levelOrder;

        private Node node;

        public LevelNode(int levelOrder, Node node) {
            this.levelOrder = levelOrder;
            this.node = node;
        }

        public int getLevelOrder() {
            return levelOrder;
        }

        public Node getNode() {
            return node;
        }
    }

    private class Node {
        private int row;

        private int column;

        private boolean traversable;

        private boolean visited;

        public Node(int row, int column, boolean traversable) {
            this.row = row;
            this.column = column;
            this.traversable = traversable;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public boolean isTraversable() {
            return traversable;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public boolean equals(Object obj) {
            // If the object is compared with itself then return true
            if (obj == this) {
                return true;
            }

            /* Check if o is an instance of Complex or not
              "null instanceof [type]" also returns false */
            if (!(obj instanceof Node)) {
                return false;
            }

            // typecast o to Complex so that we can compare data members
            Node node = (Node) obj;

            // Compare the data members and return accordingly
            return Integer.compare(row, node.row) == 0 && Integer.compare(column, node.column) == 0;
        }
    }
}
