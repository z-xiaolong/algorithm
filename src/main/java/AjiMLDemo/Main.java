package AjiMLDemo;


import ajiML.generator.java.springcloud.main.Generate;

/**
 * @Author long
 * @Date 2021/7/1 14:11
 * @Title
 * @Description //TODO
 **/

public class Main {

    public static void main(String[] args) {
        String modelPath = "C:\\Users\\long\\Desktop\\毕业论文\\project\\CodeGenerator\\model\\CargoSystem.ajimlt";
        String output = "C:\\Users\\long\\Desktop\\gen";
        Generate.generate(modelPath, output);
        //AcceleoParser acceleoParser = new AcceleoParser();

    }

}
