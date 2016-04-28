/* Testing program for EXAM3 - Implementation of GraphPlus
*/

import java.io.*;

public class Exam3Testing {


    public static void main(String[] args) throws FileNotFoundException {

        // Set up simple graph.
        GraphPlus<String> G = new AdjMatGraphPlus<String>();
        //add some vertices
        G.addVertex("A");
        G.addVertex("B");
        G.addVertex("C");
        G.addVertex("D");
        G.addVertex("E");
        G.addVertex("F");

        //add some edges
        G.addEdge("A", "B");
        G.addEdge("B", "C");
        G.addEdge("C", "D");
        G.addEdge("F", "A");
        G.addEdge("A", "D");

        G.addArc("A", "C"); // adding an arc, makes it directed
        G.removeArc("A", "C"); // removing an arc

        //test remove vertex
        G.removeVertex("A");

//        my testing
        System.out.println("\n*****************************************************");
        System.out.println("INITIAL TESTING OF WORKING FUNCTIONS");
        System.out.println("*****************************************************\n");

        System.out.println("ORIGINAL\n" + G);
        System.out.println("CLONED\n" + G.clone());

        System.out.println("All the sinks: " + G.allSinks());
        System.out.println("All the sources: " + G.allSources());
        System.out.println();

        System.out.println("B is a source " + G.isSource("B"));
        System.out.println("C is a source " + G.isSource("C"));
        System.out.println("D is a source " + G.isSource("D"));
        System.out.println("E is a source " + G.isSource("E"));
        System.out.println();

        System.out.println("B is a sink " + G.isSink("B"));
        System.out.println("C is a sink " + G.isSink("C"));
        System.out.println("D is a sink " + G.isSink("D"));
        System.out.println("E is a sink " + G.isSink("E"));
        System.out.println();

        System.out.println("B is isolated " + G.isIsolated("B"));
        System.out.println("C is isolated " + G.isIsolated("C"));
        System.out.println("D is isolated " + G.isIsolated("D"));
        System.out.println("E is isolated " + G.isIsolated("E"));
        System.out.println();

        System.out.println("Yep, those checks make sense and pass.");


//        my testing of loadTGF
        System.out.println("\n*****************************************************");
        System.out.println("TESTING OF WORKING FUNCTIONS and TGF");
        System.out.println("*****************************************************\n");
        GraphPlus<String> D = AdjMatGraphPlus.fromTGF("test.tgf");

        System.out.println("ORIGINAL\n" + D);
        System.out.println("CLONED\n" + D.clone());

        System.out.println("All the sinks: " + D.allSinks());
        System.out.println("All the sources: " + D.allSources());
        System.out.println();

        System.out.println("B is a source " + D.isSource("B"));
        System.out.println("C is a source " + D.isSource("C"));
        System.out.println("D is a source " + D.isSource("D"));
        System.out.println("E is a source " + D.isSource("E"));
        System.out.println("F is a source " + D.isSource("F"));
        System.out.println("G is a source " + D.isSource("G"));
        System.out.println();

        System.out.println("B is a sink " + D.isSink("B"));
        System.out.println("C is a sink " + D.isSink("C"));
        System.out.println("D is a sink " + D.isSink("D"));
        System.out.println("E is a sink " + D.isSink("E"));
        System.out.println("F is a sink " + D.isSink("F"));
        System.out.println("G is a sink " + D.isSink("G"));
        System.out.println();

        System.out.println("B is isolated " + D.isIsolated("B"));
        System.out.println("C is isolated " + D.isIsolated("C"));
        System.out.println("D is isolated " + D.isIsolated("D"));
        System.out.println("E is isolated " + D.isIsolated("E"));
        System.out.println("F is isolated " + D.isIsolated("F"));
        System.out.println("G is isolated " + D.isIsolated("G"));
        System.out.println();

        System.out.println("Yep, those checks make sense and pass as well.");

//        remainder of testing, some broken because of unimplemented methods
        System.out.println("\n*****************************************************\n");
        System.out.println("************* Sample Testing for Exam 3 *************");
        System.out.println("*****************************************************");

        System.out.println("Notation: (expected result: )  [actual result]\n");

        System.out.println(G);

        System.out.println("\n*** Testing DFS and BFS ***");
        try {
            System.out.print("DFS from B [B,C,D] \t: ");
            System.out.println(G.dfsTraversal("B"));
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }
        try {
            System.out.print("DFS from F     [F] \t: ");
            System.out.println(G.dfsTraversal("F"));
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }
        try {
            System.out.print("BFS from B [B,C,D] \t: ");
            System.out.println(G.bfsTraversal("B"));
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }
        try {
            System.out.print("BFS from F     [F] \t: ");
            System.out.println(G.bfsTraversal("F"));
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }

        System.out.println("\n*** Testing clone() ***");
        try {
            System.out.println("CLONED GRAPH (diamond): ");
            System.out.println(G.clone());
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }

        System.out.println("\n************* tests on the CS-COURSES graph **************");
        GraphPlus<String> C = AdjMatGraphPlus.fromTGF("cs-courses.tgf");
        try {
            System.out.println("CS graph in DFS: \n(CS111, CS230, CS232, CS231, CS235, CS251, CS242, CS315, CS240):");
            System.out.println(C.dfsTraversal("CS111"));
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }
        try {
            System.out.println("\nCS graph in BFS: \n(CS111, CS230, CS240, CS232, CS231, CS235, CS251, CS242, CS315):");
            System.out.println(C.bfsTraversal("CS111"));
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }
        try {
            System.out.println("\nCS-courses with no pre-requisites : \n(MATH225, CS110, CS114, CS111):");
            System.out.println(C.allSources());
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }
        try {
            System.out.println("\nNo followup courses:      \n(CS232, CS231, CS240, CS251, CS242, CS315):");
            System.out.println(C.allSinks());
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }
        System.out.println("\n--------> ONE WAY to satisfy pre-req:");
        try {
            System.out.println("(MATH225, CS110, CS114, CS215, CS111, CS230, CS232, CS231, CS235, CS240, CS251, CS242, CS315):");
            System.out.println(C.listByPriority());
        } catch (GraphCycleException e) {
            System.out.println("  FAILURE:  Stuck in the major forever!  (You erroneously reported a cycle where there is none.)");
        } catch (UnsupportedOperationException e) {
            System.out.println("UNIMPLEMENTED");
        }

        System.out.println("\nSAMPLE TESTING COMPLETE");
    }
}