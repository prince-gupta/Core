package com.company.serialization;

import java.io.*;

/**
 * Created by Pgupta on 4/4/2015.
 */
public class SDController {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*EntityA entityA = new EntityA(1,8130768666l,"Gurgaon","Prince");
        FileOutputStream fos = new FileOutputStream("E:\\entity.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(entityA);*/

        FileInputStream fis = new FileInputStream("E:\\entity.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        EntityA entityA1 = (EntityA)ois.readObject();
        System.out.println(entityA1.toString());
    }
}
