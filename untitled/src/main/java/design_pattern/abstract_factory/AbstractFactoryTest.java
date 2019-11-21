package design_pattern.abstract_factory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @Description
 * @auther hasee
 * @create 2019-11-07 15:08
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        try {
            Product1 a;
            //使用抽象工厂，能让程序有更好的扩展性。
            AbstractFactory af;
            //工厂的指定更自由，可以是使用配置文件，也可以是参数传递
            af = (AbstractFactory) ReadXML1.getObject();
            //不关注工厂如何生产产品。
            a = af.newProduct1();
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//抽象产品1：提供了产品的接口
interface Product1 {
    public void show();
}

//抽象产品2：提供了产品的接口
interface Product2 {
    public void show();
}

//具体产品11：实现抽象产品中的抽象方法
class ConcreteProduct11 implements Product1 {
    public void show() {
        System.out.println("具体产品11显示...");
    }
}

//具体产品12：实现抽象产品中的抽象方法
class ConcreteProduct12 implements Product1 {
    public void show() {
        System.out.println("具体产品12显示...");
    }
}

//具体产品21：实现抽象产品中的抽象方法
class ConcreteProduct21 implements Product2 {
    public void show() {
        System.out.println("具体产品21显示...");
    }
}

//具体产品22：实现抽象产品中的抽象方法
class ConcreteProduct22 implements Product2 {
    public void show() {
        System.out.println("具体产品22显示...");
    }
}

//抽象工厂：提供了厂品的生成方法
interface AbstractFactory {
    public Product1 newProduct1();

    public Product2 newProduct2();
}

//具体工厂：与具体“产品”，是对应的。
//具体工厂1：实现了厂品的生成方法
class ConcreteFactory1 implements AbstractFactory {
    public Product1 newProduct1() {
        System.out.println("具体工厂 1 生成-->具体产品 11...");
        return new ConcreteProduct11();
    }

    public Product2 newProduct2() {
        System.out.println("具体工厂 1 生成-->具体产品 21...");
        return new ConcreteProduct21();
    }
}

//具体工厂2：实现了厂品的生成方法
class ConcreteFactory2 implements AbstractFactory {
    public Product1 newProduct1() {
        System.out.println("具体工厂 2 生成-->具体产品 12...");
        return new ConcreteProduct12();
    }

    public Product2 newProduct2() {
        System.out.println("具体工厂 2 生成-->具体产品 22...");
        return new ConcreteProduct22();
    }
}


class ReadXML1 {
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getObject() {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc = builder.parse(new File("/MyLearnProject/untitled/src/main/java/design_pattern/abstract_factory/config1.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            //完整类名
            String cName = "design_pattern.abstract_factory." + classNode.getNodeValue();
            //System.out.println("新类名："+cName);
            //通过类名生成实例对象并将其返回
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}