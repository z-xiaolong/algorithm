package tomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author long
 * @Date 2020/4/16 17:24
 * @Title
 * @Description //TODO
 **/

public class Request {

    private InputStream input;
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public String getUri() {
        return uri;
    }

    public void parse() {
        // Read a set of characters from the socket
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            // 读取流中内容
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            // 将每个字节转换为字符
            request.append((char) buffer[j]);
        }
        // 打印字符串
        System.out.print(request.toString());
        // 根据转换出来的字符解析URI
        uri = parseUri(request.toString());
    }

    private String parseUri(String requestString) {
        int index1, index2;
        // 找到第一个空格
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            // 找到第二个空格
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                // 截取第一个空格到第二个空格之间的内容
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }

}
