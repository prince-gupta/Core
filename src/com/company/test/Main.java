package com.company.test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        long sortedArray[] = {1,2,3,4,5,6,7};
        int unsortedArray[] = {3,2,7,4,8,5,9,6};
        System.out.println(Arrays.binarySearch(sortedArray, 2));
        System.out.println(Arrays.binarySearch(sortedArray, 10));
        System.out.println(Arrays.binarySearch(unsortedArray, 4));
        Arrays.sort(unsortedArray);
        for(int i=0;i<unsortedArray.length;i++)
        System.out.print(unsortedArray[i]);

        String string1 = new String("abc");
        String string2 = new String("abc");
        String string3 = "bcd";
        String string4 = "bcd";
        Set set = new HashSet();
        set.add(string1);
        set.add(string2);
        set.add(string3);
        set.add(string4);
        System.out.println(set);
        List<? super Parent> parentList;
        List<Object> child1List = new ArrayList<Object>();
        child1List.add(new Child1("Child1"));
        parentList = child1List;

        List<? extends Parent> parentList2;
        List<Object> child1List2 = new ArrayList<Object>();
        child1List.add(new Child1("Child1"));
        parentList = child1List2;



        List<? super Parent> parentList3 = new ArrayList<Object>();

        Set<Parent> parentSet = new HashSet<Parent>();
        Parent parent = new Parent("Prince",25);
        parentSet.add(parent);
        //parent.setName("Prince");
        parent.setAge(22);
        parentSet.add(parent);
        System.out.println("Set : " + parentSet);

        HashMap<User,String> hashMap = new HashMap<User, String>();
        User key1 = new User("Prince",26);
        User key2 = new User("Prince",23);
        hashMap.put(key1,"Prince");
        hashMap.put(key2,"Jyoti");
        System.out.println(hashMap);

        System.out.println(hashMap.get(key1));

    }
}
