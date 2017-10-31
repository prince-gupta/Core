package com.company.serialization.file;

import java.io.*;

/**
 * Created by princegupta on 05/09/17.
 */
public class Serializer {

    public static void serialize(String outFile, Object object) throws IOException {
        FileOutputStream fos = new FileOutputStream(outFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
    }

    public static Object deserialize(String inFile) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(inFile);
        ObjectInputStream ois  = new ObjectInputStream(fis);
        return ois.readObject();
    }

    public static void main(String[] args) throws IOException {
        SerializationBox serializationBox = new SerializationBox();
        serialize("serial.out",serializationBox);
    }
}
