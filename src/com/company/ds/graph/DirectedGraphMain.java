package com.company.ds.graph;

/**
 * Created by princegupta on 20/10/17.
 */
public class DirectedGraphMain {
    public static void main(String[] args) {
        DirectedGraph<Integer> directedGraph = new DirectedGraph<>();

        directedGraph.add(1, 0);
        directedGraph.add(0, 3);
        directedGraph.add(3, 4);
        directedGraph.add(0, 2);
        directedGraph.add(2, 1);
        directedGraph.add(4, 0);

        System.out.println(directedGraph.outDegree());
        System.out.println(directedGraph.inDegree());
    }
}
