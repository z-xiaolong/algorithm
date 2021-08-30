package exam;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/10/21 11:02
 * @Title
 * @Description //TODO
 **/

public class RailwaySystem {


    public static void main(String[] args) {
        RailwaySystem railwaySystem = new RailwaySystem();
        Scanner in = new Scanner(System.in);
        System.out.println("输入：");
        while (true) {
            String line = in.nextLine();
            if (line.contains("checkin")) {
                String id = line.split(" ")[1];
                railwaySystem.checkin(id);
            } else if (line.contains("buy")) {
                String[] data = line.split(" ");
                String name = data[1];
                String id = data[2];
                railwaySystem.buy(name, id);
            } else if (line.contains("refund")) {
                String id = line.split(" ")[1];
                railwaySystem.refund(id);
            } else if ("exit".equals(line)) {
                railwaySystem.close();
                return;
            }

        }
    }


    private final Map<String, String> data = new HashMap<>();
    private final Map<String, String> checked = new HashMap<>();
    private OutputStreamWriter writerCheck = null;

    public RailwaySystem() {
        try {
            initSystem();
            if (writerCheck == null) {
                FileOutputStream fos = new FileOutputStream(new File(Constants.path + "\\B.txt"), true);
                writerCheck = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initSystem() throws FileNotFoundException {
        File A = new File(Constants.path + "\\A.txt");
        File B = new File(Constants.path + "\\B.txt");
        initData(new FileReader(A), data);
        initData(new FileReader(B), checked);
    }

    private void initData(FileReader reader, Map<String, String> map) {
        BufferedReader input = new BufferedReader(reader);
        String line;
        try {
            while ((line = input.readLine()) != null) {
                String[] data = line.split(" ");
                map.put(data[1], data[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void checkin(String id) {
        if (data.containsKey(id)) {
            if (checked.containsKey(id)) {
                System.out.println("该票已检！");
            } else {
                String name = data.get(id);
                checked.put(id, name);
                saveToFile(name, id);
                System.out.println("检票成功！");
            }
        }
    }

    private void saveToFile(String name, String id) {
        String data = name + " " + id;
        try {
            writerCheck.write(data);
            writerCheck.write("\n");
            writerCheck.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        saveData();
        try {
            if (writerCheck != null) {
                writerCheck.flush();
                writerCheck.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writerCheck = null;
        }
        System.out.println("系统关闭！");
    }

    private void saveData() {
        FileOutputStream fos = null;
        OutputStreamWriter writerBuy = null;
        try {
            fos = new FileOutputStream(new File(Constants.path + "\\A.txt"), true);
            writerBuy = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            OutputStreamWriter finalWriterBuy = writerBuy;
            data.forEach((k, v) -> {
                try {
                    finalWriterBuy.write(v + " " + k);
                    finalWriterBuy.write("\t\n");
                    finalWriterBuy.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fos = null;
            if (writerBuy != null) {
                try {
                    writerBuy.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            writerBuy = null;
        }

    }

    public void buy(String name, String id) {
        if (data.containsKey(id)) {
            System.out.println("不能重复订票！");
            return;
        }
        data.put(id, name);
        System.out.println("订票成功！");
    }

    public void refund(String id) {
        if (checked.containsKey(id)) {
            System.out.println("该票已检，不能退票！");
            return;
        }
        data.remove(id);
        System.out.println("退票成功！");
    }
}


class Constants {
    public static final String path = "C:\\Users\\long\\Desktop\\exam";
}


