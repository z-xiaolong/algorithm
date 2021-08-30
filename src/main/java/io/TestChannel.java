package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author long
 * @Date 2021/3/1 15:05
 * @Title
 * @Description //TODO
 **/

public class TestChannel {


    static final String path1 = "C:\\Users\\long\\Desktop\\test\\1.pdf";
    static final String path2 = "C:\\Users\\long\\Desktop\\test\\2.pdf";
    static final String path3 = "C:\\Users\\long\\Desktop\\test\\3.pdf";

    public static void main(String[] args) throws IOException {
        /*
         * 1.利用通道完成文件的复制（非直接缓冲区）
         */
        long start = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream(path1);
            fos = new FileOutputStream(path2);
            //1.获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //2.分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //3.将通道中的数据缓冲区中
            while (inChannel.read(buffer) != -1) {

                buffer.flip();//切换成读数据模式

                //4.将缓冲区中的数据写入通道中
                outChannel.write(buffer);
                buffer.clear();//清空缓冲区
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("利用通道完成文件的复制（非直接缓冲区）,耗费时间为：" + (System.currentTimeMillis() - start));
        /*
         * 2.利用（直接缓冲区）通道完成文件的复制(内存映射文件的方式)
         */
        start = System.currentTimeMillis();
        FileChannel inChannel2 = FileChannel.open(Paths.get(path1), StandardOpenOption.READ);

        FileChannel outChannel2 = FileChannel.open(Paths.get(path3), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel2.map(FileChannel.MapMode.READ_ONLY, 0, inChannel2.size());
        MappedByteBuffer outMappedBuf = outChannel2.map(FileChannel.MapMode.READ_WRITE, 0, inChannel2.size());

        //直接对缓冲区进行数据读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel2.close();
        outChannel2.close();

        System.out.println("利用（直接缓冲区）通道完成文件的复制(内存映射文件的方式),耗费时间为：" + (System.currentTimeMillis() - start));

        /*
         * 通道之间的数据传输（直接缓冲区）
         */
        start = System.currentTimeMillis();
        FileChannel inChannel3 = FileChannel.open(Paths.get(path1), StandardOpenOption.READ);

        FileChannel outChannel3 = FileChannel.open(Paths.get(path3), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        inChannel3.transferTo(0, inChannel3.size(), outChannel3);
        //等价于
        //        outChannel3.transferFrom(inChannel3, 0, inChannel3.size());

        inChannel3.close();
        outChannel3.close();
        System.out.println("通道之间的数据传输（直接缓冲区）,耗费时间为：" + (System.currentTimeMillis() - start));
    }
}
