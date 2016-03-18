import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/** 
 * Lab 8: mwu5 and pseger
 * Implementing adjacency matrix graph
 */

public class AdjMatGraph {
  private int n;
  private T[] vertices;
  private int[][] arcs;
  
  private String saveTGF;
  
  /**  
   * no args constructor to create an empty graph
   */
  public AdjMatGraph() {
    this.n = 0;
    this.vertices = (T[])(new Object[10]);
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
      while (input.next() != '#') {
        input.next();
        vertices[n] = input.next();
        n++;
      }
      
//      arcs
      while (scan.hasNext()){
        arcs[scan.nextInt()-1][scan.nextInt()-1] = 1;
      }
      
      
      input.close();
    }
    catch (IOException exception) {
      System.out.println("Constructor with filename failed with code: " + exception);
    }
  }
  
  
  
  /** Returns true if this graph is empty, false otherwise. */
  public boolean isEmpty(){
    return n == 0;
  }
  
  /** Returns the number of vertices in this graph. */
  public int n() {
    return n;
  }
  
  /** Returns the number of arcs in this graph. */
  public int m(){
    int count = 0;
    for (int i=0; i<arcs.length; i++){
      for (int j=0; j<arcs.length; j++){
        if (arcs[i][j] == 1)
          count ++;
      }
    }
    return count;
  }
  
//   /** Returns true iff a directed edge exists b/w given vertices */
//  public boolean isArc (T vertex1, T vertex2) {
//    if ( == 1 || check2 == 1) {
//      return true;
//    }
//  }
  
  /** Returns true iff an edge exists between two given vertices
    * which means that two corresponding arcs exist in the graph */
//   public boolean isEdge (T vertex1, T vertex2);
  
  /** Returns true IFF the graph is undirected, that is, for every
    * pair of nodes i,j for which there is an arc, the opposite arc
    * is also present in the graph.  */
//   public boolean isUndirected();
  
  /** Adds a vertex to this graph, associating object with vertex.
    * If the vertex already exists, nothing is inserted. */
//   public void addVertex (T vertex);
  
  /** Removes a single vertex with the given value from this graph.
    * If the vertex does not exist, it does not change the graph. */
//   public void removeVertex (T vertex);
  
  /** Inserts an arc between two vertices of this graph,
    * if the vertices exist. Else it does not change the graph. */
//   public void addArc (T vertex1, T vertex2);
  
  /** Removes an arc between two vertices of this graph,
    * if the vertices exist. Else it does not change the graph. */
//   public void removeArc (T vertex1, T vertex2);
  
  /** Inserts an edge between two vertices of this graph,
    * if the vertices exist. Else does not change the graph. */
//   public void addEdge (T vertex1, T vertex2);
  
  /** Removes an edge between two vertices of this graph,
    if the vertices exist, else does not change the graph. */
//   public void removeEdge (T vertex1, T vertex2);
  
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
      if (!file.exists()){
        file.createNewFile();
      }
      
      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(saveTGF);
      bw.close();
    }
    catch (IOException exception) {
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
    String path = "unnamed0.tgf";
    AdjMatGraph am1 = new AdjMatGraph(path);
    System.out.println(am1);
    am1.saveTGF("unnamed1.tgf");
  }
  
}