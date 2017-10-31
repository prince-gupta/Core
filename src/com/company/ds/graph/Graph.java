package com.company.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by princegupta on 20/10/17.
 */
public class Graph {

    private int V;
    private List[] adjcents;

    public Graph(int V) {
        this.V = V;
        this.adjcents = new LinkedList[V];
        for (int index = 0; index < V; index++) {
            this.adjcents[index] = new LinkedList();
        }
    }

    public void addVertices(int v, int w) {
        adjcents[v].add(w);
        adjcents[w].add(v);
    }

    public boolean isTree() {
        boolean visited[] = new boolean[this.V];
        if(cycleUtil(0,visited,-1)){
            return false;
        }
        else{
            for(boolean hasVisited : visited){
                if(!hasVisited){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean hasCycle() {
        boolean visited[] = new boolean[this.V];
        return cycleUtil(0, visited, -1);
    }

    private boolean cycleUtil(int v, boolean[] visited, int parent) {

        visited[v] = true;
        Integer i;
        Iterator<Integer> itr = adjcents[v].iterator();

        while (itr.hasNext()) {
            i = itr.next();

            if (!visited[i]) {
                if(cycleUtil(i, visited, v))
                    return true;
            }
            else if (i != parent){
                return true;
            }
        }
        return false;
    }
}
