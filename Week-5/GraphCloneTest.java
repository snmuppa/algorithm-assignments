package algorthims.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GraphCloneTest extends TestCase {
    /**
     * Definition for undirected graph.
     */
    class UndirectedGraphNode {
        int label;

        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GraphCloneTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(GraphCloneTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    private HashMap<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        cloneMap.put(node, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
}
