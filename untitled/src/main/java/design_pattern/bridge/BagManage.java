package design_pattern.bridge;

import java.awt.*;
import javax.swing.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;

import java.io.*;

/**
 * @Description
 * @auther hasee
 * @create 2019-11-08 10:54
 */
public class BagManage {
    public static void main(String[] args) {
        Color color;
        Bag bag;
        color = (Color) ReadXML.getObject("color");
        bag = (Bag) ReadXML.getObject("bag");
        bag.setColor(color);
        String name = bag.getName();
        show(name);
    }

    public static void show(String name) {
        JFrame jf = new JFrame("桥接模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JLabel l = new JLabel(new ImageIcon("/MyLearnProject/untitled/src/main/java/design_pattern/bridge/" + name + ".jpg"));
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("女士皮包"));
        p.add(l);
        contentPane.add(p, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//实现化角色：颜色
interface Color {
    String getColor();
}

//具体实现化角色：黄色
class Yellow implements Color {
    public String getColor() {
        return "yellow";
    }
}

//具体实现化角色：红色
class Red implements Color {
    public String getColor() {
        return "red";
    }
}

//抽象化角色：包
abstract class Bag {
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String getName();
}

//扩展抽象化角色：挎包
class HandBag extends Bag {
    public String getName() {
        return color.getColor() + "HandBag";
    }
}

//扩展抽象化角色：钱包
class Wallet extends Bag {
    public String getName() {
        return color.getColor() + "Wallet";
    }
}

class ReadXML {
    public static Object getObject(String args) {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("/MyLearnProject/untitled/src/main/java/design_pattern/bridge/bridge_config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = null;
            if (args.equals("color")) {
                classNode = nl.item(0).getFirstChild();
            } else if (args.equals("bag")) {
                classNode = nl.item(1).getFirstChild();
            }
            String cName = "design_pattern.bridge." + classNode.getNodeValue();
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}