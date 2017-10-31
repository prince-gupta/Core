package com.company.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by princegupta on 20/10/17.
 */
public class DirectedGraph<V> {

    private Map<V, List<V>> adjecents = new HashMap<>();

    private void add(V vertex) {
        if (adjecents.containsKey(vertex))
            return;
        adjecents.put(vertex, new ArrayList<>());
    }

    public void add(V from, V to) {
        this.add(from);
        this.add(to);
        adjecents.get(from).add(to);
    }

    private boolean contains(V vertex) {
        return adjecents.containsKey(vertex);
    }

    public void remove(V from, V to) {
        if (!this.contains(from) || !this.contains(to)) {
            throw new IllegalArgumentException("Nonexistence of Vertex");
        }
        adjecents.get(from).remove(to);
    }

    public Map<V, Integer> outDegree() {
        Map<V, Integer> result = new HashMap<>();

        for (V v : adjecents.keySet()) {
            result.put(v, adjecents.get(v).size());
        }
        return result;
    }

    public Map<V, Integer> inDegree() {
        Map<V, Integer> result = new HashMap<>();
        for(V v : adjecents.keySet())
            result.put(v, 0);
        for(V from : adjecents.keySet()){
            for(V to : adjecents.get(from)){
                result.put(to, result.get(to) + 1);
            }
        }
        return result;
    }


}
