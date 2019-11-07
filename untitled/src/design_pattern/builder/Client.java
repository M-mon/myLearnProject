package design_pattern.builder;

/**
 * @Description
 * @auther hasee
 * @create 2019-11-07 17:22
 */
//客户类
public class Client {
    public static void main(String[] args) {
        //指定将要创建的内容，内容是指ConcreteBuilder的具体实现，对外隐藏实现。
        Builder builder = new ConcreteBuilder();
        //不手动调用实现，因为使用建造者模式，一般都有特定的步骤。改为使用指挥者，由指挥者执行步骤，客户端可以不关注步骤。
        Director director = new Director(builder);
        //最后指挥者会拥有你一开始想要的内容的最终结果。
        Product product = director.construct();
        product.show();
    }
}

//指挥者：调用建造者中的方法完成复杂对象的创建。
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}

//抽象建造者：包含创建产品各个子部件的抽象方法。
abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }
}

//具体建造者：实现了抽象建造者接口。
class ConcreteBuilder extends Builder {
    public void buildPartA() {
        product.setPartA("建造 PartA");
    }

    public void buildPartB() {
        product.setPartA("建造 PartB");
    }

    public void buildPartC() {
        product.setPartA("建造 PartC");
    }
}

//产品角色：包含多个组成部件的复杂对象。
class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        //显示产品的特性
    }
}