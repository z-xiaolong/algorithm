package io;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author long
 * @Date 2021/2/24 16:49
 * @Title
 * @Description //TODO
 **/

public class Kcontest {


    public static void main(String[] args) {
        try {
            System.out.println(mmap(Constants.PATH));
            System.out.println(notMap(Constants.PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static long mmap(String path) throws IOException {
        long start = System.currentTimeMillis();
        File file = new File(path);
        long len = file.length();
        long left = 0;
        long size = 1024 * 1024;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        FileChannel channel = randomAccessFile.getChannel();
        while (left + size <= len) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, left, size);
            solver(buffer);
            left += size;
        }
        return System.currentTimeMillis() - start;
    }

    public static void solver(MappedByteBuffer buffer) {
        int offset = 0;
        while (offset < buffer.limit()) {
            byte b = buffer.get(offset);
            offset++;
        }
        while (buffer.hasRemaining()) {
            byte b = buffer.get();
        }
    }


    public static long notMap(String path) throws IOException {
        long start = System.currentTimeMillis();
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[1024 * 1024];
        while (inputStream.read(buffer) != -1) {
            for (int i = 0; i < buffer.length; i++) {
                byte b = buffer[i];
            }
        }
        return System.currentTimeMillis() - start;
    }
}
