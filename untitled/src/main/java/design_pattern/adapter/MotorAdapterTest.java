package design_pattern.adapter;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import java.io.*;

/**
 * @Description
 * @auther hasee
 * @create 2019-11-07 19:07
 */
//客户端代码
public class MotorAdapterTest {
    public static void main(String[] args) {
        System.out.println("适配器模式测试：");
        //选择适配器
        Motor motor = (Motor) ReadXML.getObject();
        motor.drive();
    }
}

//目标：发动机
interface Motor {
    public void drive();
}

//适配者1：电能发动机
class ElectricMotor {
    public void electricDrive() {
        System.out.println("电能发动机驱动汽车！");
    }
}

//适配者2：光能发动机
class OpticalMotor {
    public void opticalDrive() {
        System.out.println("光能发动机驱动汽车！");
    }
}

//电能适配器
class ElectricAdapter implements Motor {
    private ElectricMotor emotor;

    public ElectricAdapter() {
        emotor = new ElectricMotor();
    }

    //把电能发动机的驱动重新封装
    public void drive() {
        emotor.electricDrive();
    }
}

//光能适配器
class OpticalAdapter implements Motor {
    private OpticalMotor omotor;

    public OpticalAdapter() {
        omotor = new OpticalMotor();
    }

    //把光能发动机的驱动重新封装
    public void drive() {
        omotor.opticalDrive();
    }
}

class ReadXML {
    public static Object getObject() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("/MyLearnProject/untitled/src/main/java/design_pattern/adapter/adapter_config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "design_pattern.adapter." + classNode.getNodeValue();
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}