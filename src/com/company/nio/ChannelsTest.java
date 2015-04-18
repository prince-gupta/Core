package com.company.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Pgupta on 1/15/2015.
 */
public class ChannelsTest {
    public static void main (String args []) throws IOException {
        RandomAccessFile file = new RandomAccessFile("F:\\Work\\BeachBody\\Pioneer\\Core\\src\\com\\company\\nio\\nio-test-file.txt","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = channel.read(buffer);
        while(bytesRead != -1){
            System.out.println("Read " + bytesRead);
            buffer.flip();

            while(buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }

            buffer.clear();
            bytesRead = channel.read(buffer);
        }
        file.close();
    }
}
