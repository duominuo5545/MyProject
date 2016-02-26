package com.rich.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by hanwang206326 on 2016/2/22.
 * new IO
 */
public class NioTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\nio-data.txt", "rw");
        FileChannel inChannel = accessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        accessFile.close();

        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = {buffer1, buffer2};
        inChannel.read(bufferArray); //scatter 分散
        inChannel.write(bufferArray);//gather  聚集

    }
}
