package com.company.rnd.collection;

import java.util.*;

/**
 * Created by Pgupta on 4/4/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MyArrayList<?>  myArrayList = new MyArrayList<String>();
        List<?> list1 = new ArrayList<String>();
        list1.add(null);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(1);
        if(list.contains(1)){
            System.out.println(list.get(list.indexOf(1)));
            System.out.println((list.indexOf(1)));
        }

        Map<String, Set<Double>> firstMap = new HashMap<String, Set<Double>>();
        Map<String, Set<Double>> secondMap = new HashMap<String, Set<Double>>();
        Set<Map.Entry<String, Set<Double>>> entries = firstMap.entrySet();
        for ( Map.Entry<String, Set<Double>> entry : entries ) {
            Set<Double> secondMapValue = secondMap.get( entry.getKey() );
            if ( secondMapValue == null ) {
                secondMap.put( entry.getKey(), entry.getValue() );
            }
            else {
                secondMapValue.addAll( entry.getValue() );
            }
        }
    }
}
