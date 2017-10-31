package com.company.ds.graph;

/**
 * Created by princegupta on 20/10/17.
 */
public class GraphUtil {
    public static void main(String[] args) {
        Graph cycledGraph = new Graph(5);
        cycledGraph.addVertices(0,1);
        cycledGraph.addVertices(1,2);
        cycledGraph.addVertices(2,0);
        cycledGraph.addVertices(0,3);
        cycledGraph.addVertices(3,4);
        System.out.println("Does Graph has cycle : " + cycledGraph.hasCycle());
        System.out.println("Does Graph is a tree : " + cycledGraph.isTree());

        Graph nonCycledGraph = new Graph(5);
        nonCycledGraph.addVertices(0,1);
        nonCycledGraph.addVertices(1,2);
        nonCycledGraph.addVertices(0,3);
        nonCycledGraph.addVertices(3,4);
        System.out.println("Does Graph has cycle : " + nonCycledGraph.hasCycle());
        System.out.println("Does Graph is a tree : " + nonCycledGraph.isTree());
    }

}
