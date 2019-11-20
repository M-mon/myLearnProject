package design_pattern.factory;


import java.awt.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;


/**
 * @Description
 * @auther hasee
 * @create 2019-11-07 16:06
 */
public class AnimalFarmTest
{
    public static void main(String[] args)
    {
        try
        {
            Animal a;
            AnimalFarm af;
            af=(AnimalFarm) ReadXML2.getObject();
            a=af.newAnimal();
            a.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
//抽象产品：动物类
interface Animal
{
    public void show();
}
//具体产品：马类
class Horse implements Animal
{
    JScrollPane sp;
    JFrame jf=new JFrame("工厂方法模式测试");
    public Horse()
    {
        Container contentPane=jf.getContentPane();
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：马"));
        sp=new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("/MyLearnProject/untitled/src/main/java/design_pattern/factory/A_Horse.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //用户点击窗口关闭
    }
    public void show()
    {
        jf.setVisible(true);
    }
}
//具体产品：牛类
class Cattle implements Animal
{
    JScrollPane sp;
    JFrame jf=new JFrame("工厂方法模式测试");
    public Cattle()
    {
        Container contentPane=jf.getContentPane();
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：牛"));
        sp=new JScrollPane(p1);
        contentPane.add(sp,BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("/MyLearnProject/untitled/src/main/java/design_pattern/factory/A_Cattle.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //用户点击窗口关闭
    }
    public void show()
    {
        jf.setVisible(true);
    }
}
//抽象工厂：畜牧场
interface AnimalFarm
{
    public Animal newAnimal();
}
//具体工厂：养马场
class HorseFarm implements AnimalFarm
{
    public Animal newAnimal()
    {
        System.out.println("新马出生！");
        return new Horse();
    }
}
//具体工厂：养牛场
class CattleFarm implements AnimalFarm
{
    public Animal newAnimal()
    {
        System.out.println("新牛出生！");
        return new Cattle();
    }
}

class ReadXML2
{
    public static Object getObject()
    {
        try
        {
            DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=dFactory.newDocumentBuilder();
            Document doc;
            doc=builder.parse(new File("/MyLearnProject/untitled/src/main/java/design_pattern/factory/config2.xml"));
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName="design_pattern.factory."+classNode.getNodeValue();
            System.out.println("新类名："+cName);
            Class<?> c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}