package com.rich.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by hanwang206326 on 2016/2/22.
 * new IO
 */
public class NioTest {
    @Test
    public void test() throws IOException {
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
        inChannel.read(bufferArray); //scatter 分散 从channel写到buffer里
        inChannel.write(bufferArray);//gather  聚集 读buffer到channel

        RandomAccessFile fromFile = new RandomAccessFile("D:\\nio-data.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("D:\\nio-data.txt", "rw");
        FileChannel toChannel = toFile.getChannel();
        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel, position, count);
        fromChannel.transferTo(position, count, toChannel);

        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
        int interestSet = key.interestOps();
        key.attach("aaaaa");

        Channel channel = key.channel();
        Selector __selector = key.selector();

        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
        while (keyIterator.hasNext()) {
            SelectionKey selectionKey = keyIterator.next();
            if (key.isAcceptable()) {
                // a connection was accepted by a ServerSocketChannel.
            } else if (key.isConnectable()) {
                // a connection was established with a remote server.
            } else if (key.isReadable()) {
                // a channel is ready for reading
            } else if (key.isWritable()) {
                // a channel is ready for writing
            }
            keyIterator.remove();
        }
    }

    @Test
    public void test2() {
        System.out.println(SelectionKey.OP_CONNECT);
    }


    @Test
    public void test3() throws IOException {
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        SelectionKey key = channel.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();
                if (selectionKey.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (selectionKey.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (selectionKey.isReadable()) {
                    // a channel is ready for reading
                } else if (selectionKey.isWritable()) {
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }
        }
    }

    @Test
    public void test4() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("D:\\nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while (buf.hasRemaining()) {
            channel.write(buf);
        }
        System.out.println(channel.size());
        channel.close();
    }

    @Test
    public void test5() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        //socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(buf);
        System.out.println(bytesRead);
        socketChannel.close();
    }

    @Test
    public void test6() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("not null");
            }
        }
    }

    @Test
    public void test7() throws IOException {
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sinkChannel = pipe.sink();
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while (buf.hasRemaining()) {
            sinkChannel.write(buf);
        }
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.clear();
        int bytesRead = sourceChannel.read(buf);
        System.out.println(bytesRead);
    }
}
