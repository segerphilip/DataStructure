import javafoundations.ArrayStack;
import javafoundations.LinkedQueue;

import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * An extended Adjacency Matrix graph implementation.  Complete this template for the exam.
 * Developer: Philip (and base code from professors)
 * NOTE:
 *      Assumed due at midnight (was that right?), and did not have much time to complete
 *      this exam. As such, listByPriority is not implemented at all. Also, searches are
 *      sort of started implemented, but no bug checking has been done and they are not
 *      fully functioning. The other methods in this class should work, however that is a
 *      big note. Also, more testing specific to working functions has been added in
 *      Exam3Testing
 */
public class AdjMatGraphPlus<T> extends AdjMatGraph<T> implements GraphPlus<T> {

    /** DO NOT MODIFY THE FIRST THREE METHODS **************************
     * The methods you will implement follow below.
     */

    /**
     * Construct an empty graph.
     */
    public AdjMatGraphPlus() {
        super();
    }

    /**
     * Construct a graph with the same vertices and edges as the given original.
     *
     * @param original
     */
    public AdjMatGraphPlus(AdjMatGraph<T> original) {
        super(original);
    }

    /**
     * Read a TGF file and create an AdjMatGraphPlus<String> from it.
     *
     * @param tgfFile - the TGF file to read
     * @return a graph created from the TGF file
     * @throws FileNotFoundException if TGF file is not found.
     */
    public static AdjMatGraphPlus<String> fromTGF(String tgfFile) throws FileNotFoundException {
        AdjMatGraphPlus<String> g = new AdjMatGraphPlus<String>();
        AdjMatGraph.loadTGF(tgfFile, g);
        return g;
    }


    /****
     * IMPLEMENT THE METHODS BELOW *********************************
     * Replace "throw new UnsupportedOperationException();" with
     * a working implementation.
     ******************************************************************/

    /**
     * Clones the current graph by saving as a tgf, then reads from tgf
     * and uses the fromTGF method to create a new instance.
     * @return tempG (cloned graph)
     */
    public GraphPlus<T> clone() {
        AdjMatGraphPlus<T> tempG = null;

//        save current graph as a tgf
        try {
            saveTGF("temp.tgf");
        } catch (Exception exception) {
            System.out.println("Unable to write temp file");
        }

//        load saved graph and assign to tempG
        try {
            tempG = (AdjMatGraphPlus<T>) fromTGF("temp.tgf");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file");
        }

//        return cloned graph
        return tempG;
    }

    /**
     * Return true if the number of successors of the vertex is 0.
     * @param vertex: the potential sink vertex
     * @return true/false if is sink
     */
    public boolean isSink(T vertex) {
        return getSuccessors(vertex).size() == 0;
    }

    /**
     * Goes through all vertices, checks if isSink, adds to sink list
     * @return list of all possible sinks
     */
    public LinkedList<T> allSinks() {
//        list sink that we will add all the sinks to
        LinkedList<T> sink = new LinkedList<T>();

//        loops through all and the kitchen sink (HA), checking if isSink
        for (int i = 0; i < this.n(); i++) {
            if (isSink(getVertex(i))) {
                sink.add(getVertex(i));
            }
        }

        return sink;
    }

    /**
     * Return true if the number of predecessors of the vertex is 0.
     * @param vertex: the potential source vertex
     * @return true/false if is source
     */
    public boolean isSource(T vertex) {
        return getPredecessors(vertex).size() == 0;
    }

    /**
     * Goes through all vertices, checks if isSource, adds to source list
     * @return list of all possible sources
     */
    public LinkedList<T> allSources() {
//        list source that we will add all the sinks to
        LinkedList<T> source = new LinkedList<T>();

//        loops through all and the kitchen source (doesn't work as well ), checking if isSource
        for (int i = 0; i < this.n(); i++) {
            if (isSource(getVertex(i))) {
                source.add(getVertex(i));
            }
        }

        return source;
    }

    /**
     * True if both isSink and isSource
     * @param vertex: the vertex to check for isolation
     * @return true/false depending on source/sink
     */
    public boolean isIsolated(T vertex) {
        return isSink(vertex) && isSource(vertex);
    }

    /**
     * What is priority, where is this coming from? Also, ran out of time to implement
     * this method.
     * TODO: this method does not work at all, is not implemented because of time constraints
     * @return
     * @throws GraphCycleException
     */
    public LinkedList<T> listByPriority() throws GraphCycleException {
        throw new UnsupportedOperationException();
    }

    /**
     * Goes to lowest level of graph, then adds element to sorted LinkedList
     * TODO: this method does not work properly (expected output is BCD for testing,
     * actual output is DBCB), but ran out of time to debug and check implementation
     * @param startVertex
     * @return sorted linked list
     */
    public LinkedList<T> dfsTraversal(T startVertex) {
//        clone graph, plus new sort ll which will be returned at the end, plus stack path
        AdjMatGraphPlus<T> tempG = (AdjMatGraphPlus<T>) clone();
        LinkedList<T> sort = new LinkedList<T>();
        ArrayStack<T> stack = new ArrayStack<T>();

//        add initial vertex to stack
        stack.push(startVertex);

//        start going through the stack
        while (!stack.isEmpty()) {
//            save successors for checking neighbors
            LinkedList<T> successors = this.getSuccessors(stack.peek());
            T successor = null;

//            loop through all successors until get to leaf node
            for (int i = 0; i < successors.size(); i++) {
                if (tempG.getIndex(successors.get(i)) != NOT_FOUND) {
                    successor = successors.get(i);
                }
            }

            if (successor == null) {
//                backtrack
                sort.add(stack.pop());
            } else {
//                select new nodes to check
                stack.push(successor);
                tempG.removeVertex(successor);
            }
        }

        return sort;
    }

    /**
     * Goes through all levels of graph, then adds element to sorted LinkedList
     * TODO: this method does not work properly because ran out of time for implementation
     * @param startVertex
     * @return
     */
    public LinkedList<T> bfsTraversal(T startVertex) {
//          sort list to be returned, path, check if visited
        LinkedList<T> sort = new LinkedList<T>();
        LinkedQueue<T> path = new LinkedQueue<T>();
        boolean[] visited = new boolean[this.n()];

//        if start not exist, return the ll
        if (getIndex(startVertex) == -1) {
            return sort;
        }

//        enqueue the initial position, and set as visited
        path.enqueue(this.getVertex(getIndex(startVertex)));
        visited[getIndex(startVertex)] = true;

//        now actually traverse the rest of things
        while (!path.isEmpty()) {
//            mouthful, but add to the ll the vertex at position of one from queue
            sort.add(path.dequeue());

            for (int i = 0; 0 < this.n(); i++) {
//                TODO: ran out of time, but should add child elements
//                also, thinking about it, this might have been easier as a recursive method
                break;
//                break added because it causes infinite loop, not great for testing
            }
        }

        return sort;
    }

    /**
     * Initial testing method, main testing found in Exam3Testing.java
     * @param args
     */
    public static void main(String[] args) {
        AdjMatGraphPlus<String> ag1 = new AdjMatGraphPlus<String>();
        ag1.addVertex("a");
        ag1.addVertex("b");
        ag1.addArc("a", "b");

//        making sure clone works
        System.out.println(ag1.clone());
    }
}