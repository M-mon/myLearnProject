package design_pattern.prototype;

/**
 * @Description
 * @auther hasee
 * @create 2019-11-07 11:17
 */
class Realizetype implements Cloneable
{
    Realizetype()
    {
        System.out.println("具体原型创建成功！");
    }
    public Object clone() throws CloneNotSupportedException
    {
        System.out.println("具体原型复制成功！");
        //浅克隆
        return (Realizetype)super.clone();
    }
}
//原型模式的测试类
public class Prototype
{
    public static void main(String[] args)throws CloneNotSupportedException
    {
        Realizetype obj1=new Realizetype();
        Realizetype obj2=(Realizetype)obj1.clone();
        System.out.println("obj1==obj2?"+(obj1==obj2));
    }
}