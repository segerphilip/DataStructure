import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Assignment 7: pseger
 * Implementing adjacency matrix graph
 */

public class AdjMatGraph<T> {
    private int n;
    private T[] vertices;
    private int[][] arcs;

    private String saveTGF;

    /**
     * no args constructor to create an empty graph
     */
    public AdjMatGraph() {
        this.n = 0;
        this.vertices = (T[]) (new Object[10]);
        this.arcs = new int[10][10];
    }

    /**
     * Constructor that opens an existing tgf file
     */
    public AdjMatGraph(String filename) {
        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);

//      vertices and n
            while (input.nextByte() != '#') {
                input.next();
                vertices[n] = (T) input.next();
                n++;
            }

//      arcs
            while (input.hasNext()) {
                arcs[input.nextInt() - 1][input.nextInt() - 1] = 1;
            }


            input.close();
        } catch (IOException exception) {
            System.out.println("Constructor with filename failed with code: " + exception);
        }
    }


    /**
     * Returns true if this graph is empty, false otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of vertices in this graph.
     */
    public int n() {
        return n;
    }

    /**
     * Returns the number of arcs in this graph.
     */
    public int m() {
        int count = 0;
        for (int i = 0; i < arcs.length; i++) {
            for (int j = 0; j < arcs.length; j++) {
                if (arcs[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    /**
     * Returns the index of a vertex in the graph
     */
    private int getVal(T vertex) {
        try {
            for (int i = 0; i < vertices.length; i++) {
                if (vertex == vertices[i]) {
                    return i;
                }
            }
        } catch (Exception exception) {
            System.out.println("No value found");
            return -1;
        }
        return -1;
    }

    /**
     * Expands the capactiy of arcs and vertices
     */
    private void expandCapacity() {
//        expand vertices
        T[] tempV = (T[]) new Object[vertices.length + 10];
        for (int i = 1; i <= n; i++) {
            tempV[i] = vertices[i];
        }
        vertices = tempV;

//        expand arcs
        int[][] tempA = new int[arcs.length + 10][arcs.length + 10];
        for (int i = 0; i < arcs.length; i++) {
            for (int j = 0; j < arcs.length; j++) {
                tempA[i][j] = arcs[i][j];
            }
        }
        arcs = tempA;
    }

    /**
     * Returns true iff a directed edge exists b/w given vertices
     */
    public boolean isArc(T vertex1, T vertex2) {
        if (getVal(vertex1) == -1 || getVal(vertex2) == -1) {
            return false;
        }

//        return true if there is an arc between 1 and 2 (so != 0) and no arc between 2 and 1 (so == 0)
        return (arcs[getVal(vertex1)][getVal(vertex2)] != 0 && arcs[getVal(vertex2)][getVal(vertex1)] == 0);
    }

    /**
     * Returns true iff an edge exists between two given vertices
     * which means that two corresponding arcs exist in the graph
     */
    public boolean isEdge(T vertex1, T vertex2) {
        return ((isArc(vertex1, vertex2) && isArc(vertex2, vertex1)));
    }

    /**
     * Returns true IFF the graph is undirected, that is, for every
     * pair of nodes i,j for which there is an arc, the opposite arc
     * is also present in the graph.
     */
    public boolean isUndirected() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    if (arcs[i][j] != arcs[j][i])
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * Adds a vertex to this graph, associating object with vertex.
     * If the vertex already exists, nothing is inserted.
     */
    public void addVertex(T vertex) {
//        check if it exists
        if (getVal(vertex) == 0) {
            if (n == vertices.length - 1) {// if vertices is full
                expandCapacity();
            }

            vertices[n + 1] = vertex;
            n++;
        }
    }

    /**
     * Removes a single vertex with the given value from this graph.
     * If the vertex does not exist, it does not change the graph.
     */
    public void removeVertex(T vertex) {
        if (getVal(vertex) != 0) {
            for (int i = getVal(vertex); i <= n; i++) {
                vertices[i] = vertices[i + 1];
            }
            n--;
        }
    }

    /**
     * Inserts an arc between two vertices of this graph,
     * if the vertices exist. Else it does not change the graph.
     */
    public void addArc(T vertex1, T vertex2) {
        if (getVal(vertex1) > 0 && getVal(vertex2) > 0) //Vertices exist
            arcs[getVal(vertex1)][getVal(vertex2)] = 1;
        else
            System.out.println("Vertices don't exist, can't add arc");
    }

    /**
     * Removes an arc between two vertices of this graph,
     * if the vertices exist. Else it does not change the graph.
     */
    public void removeArc(T vertex1, T vertex2) {
        if (isArc(vertex1, vertex2)) {
            arcs[getVal(vertex1)][getVal(vertex2)] = 0;
        }
    }

    /**
     * Inserts an edge between two vertices of this graph,
     * if the vertices exist. Else does not change the graph.
     */
    public void addEdge(T vertex1, T vertex2) {
        addArc(vertex1, vertex2);
        addArc(vertex2, vertex1);
    }

    /**
     * Removes an edge between two vertices of this graph,
     * if the vertices exist, else does not change the graph.
     */
    public void removeEdge(T vertex1, T vertex2) {
        if (isEdge(vertex1, vertex2)) {
            removeArc(vertex1, vertex2);
            removeArc(vertex2, vertex1);
        }
    }

    /** Retrieve from a graph the vertices adjacent to vertex v.
     Assume that the vertex is in the graph */
//   public LinkedList<T> getSuccessors(T vertex);

    /** Retrieve from a graph the vertices x preceding vertex v (x->v)
     and returns them onto a linked list */
//  public LinkedList<T> getPredecessors(T vertex);


    /**
     * Save saveTGF to a new file
     */
    public void saveTGF(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(saveTGF);
            bw.close();
        } catch (IOException exception) {
            System.out.println("Saving failed: " + exception);
        }
    }

    /**
     * Print out contents of saveTGF
     */
    public String toString() {
        String result = "";
        result += saveTGF;
        return result;
    }

    /**
     * Testing method
     */
    public static void main(String[] args) {
//        String path = "unnamed0.tgf";
//        AdjMatGraph am1 = new AdjMatGraph(path);
        AdjMatGraph<Integer> am1 = new AdjMatGraph<Integer>();
        am1.addArc(1, 2);
        am1.addEdge(3, 4);
        am1.getVal(1);
        am1.addVertex(5);
        am1.addVertex(1);
        am1.addVertex(2);
        am1.addVertex(3);
        am1.addVertex(4);
        System.out.println(am1);
        am1.saveTGF("unnamed1.tgf");
    }

}