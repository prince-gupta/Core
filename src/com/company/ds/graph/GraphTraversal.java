package com.company.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by princegupta on 12/10/17.
 */
public class GraphTraversal {

    private int noOfVetrex;
    private LinkedList<Integer>[] adjencyList;

    public GraphTraversal(int noOfVetrex) {
        this.noOfVetrex = noOfVetrex;
        adjencyList = new LinkedList[noOfVetrex];

        for (int index = 0; index < this.noOfVetrex; index++) {
            adjencyList[index] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjencyList[source].add(destination);
    }

    public void BFS(int source) {

        boolean visited[] = new boolean[noOfVetrex];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {

            int polled = queue.poll();

            System.out.print(polled + "  ");

            Iterator<Integer> itr = adjencyList[polled].listIterator();

            while (itr.hasNext()) {
                int next = itr.next();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    private void DFSUtil(int currentVertex, boolean visited[]) {
        visited[currentVertex] = true;

        System.out.print(currentVertex + "  ");

        Iterator<Integer> itr = adjencyList[currentVertex].listIterator();
        while (itr.hasNext()) {
            int polled = itr.next();
            if (!visited[polled])
                DFSUtil(polled, visited);
        }
    }

    public void DFS(int source) {
        boolean visited[] = new boolean[noOfVetrex];
        DFSUtil(source, visited);
    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 3);

        graph.BFS(1);
        System.out.println();
        graph.DFS(1);
    }
}
