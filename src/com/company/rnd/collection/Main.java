package com.company.rnd.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Pgupta on 4/4/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MyArrayList<?>  myArrayList = new MyArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(1);
        if(list.contains(1)){
            System.out.println(list.get(list.indexOf(1)));
            System.out.println((list.indexOf(1)));
        }

        Map<Integer,Integer> map = new HashMap();
        System.out.println(map.get(1));

    }
}
