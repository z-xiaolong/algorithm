package util;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

/**
 * @Author long
 * @Date 2020/1/16 15:42
 * @Title
 * @Description //TODO
 **/

public class Dom4jUtil {
    public static void main(String[] args) {
        String path = "C:\\Users\\long\\Desktop\\Exams\\action.xml";
        parserXml(path);
    }

    public void createXml(String fileName) {
        Document document = DocumentHelper.createDocument();
        Element employees = document.addElement("employees");
        Element employee = employees.addElement("employee");
        Element name = employee.addElement("name");
        name.setText("活这么大就没饱过");
        Element sex = employee.addElement("sex");
        sex.setText("m");
        Element age = employee.addElement("age");
        age.setText("24");
        try {
            Writer fileWriter = new FileWriter(fileName);
            XMLWriter xmlWriter = new XMLWriter(fileWriter);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void parserXml(String fileName) {
        File file = new File(fileName);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(file);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for (Element e : elements) {
                String name = e.attributeValue("name");
                String memory = e.attributeValue("memory");
                String id = e.attributeValue("id");
                Activity activity = new Activity(memory, name, id);
                System.out.println(activity);
            }

        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
