package com.company.rnd.collection;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

/**
 * Created by Pgupta on 4/4/2015.
 */
public class MyArrayList<T> extends ArrayList<T> {
    Class<T> t ;
    MyArrayList() throws Exception {
        System.out.println(( ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]));
    }
}
