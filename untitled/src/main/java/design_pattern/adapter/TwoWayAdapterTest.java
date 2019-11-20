package design_pattern.adapter;

/**
 * @Description 双向适配器模式
 * @auther hasee
 * @create 2019-11-07 19:14
 */
//客户端代码
public class TwoWayAdapterTest {
    public static void main(String[] args) {
        System.out.println("目标通过双向适配器访问适配者：");
        //利用双向适配器，保存适配者对象实例，再把目标对象的方法重新封装成调用适配者对象的方法，即可使目标对象调用适配者对象的方法。
        //也就是说，返回的TwoWayTarget实例，实际上是只保存了TwoWayAdaptee实例的TwoWayAdapter。
        //双向适配器很少使用。因为本身适配器的目的是解决原接口兼容性问题，一般不会出现两边都不兼容的情况。
        TwoWayAdaptee adaptee = new AdapteeRealize();
        TwoWayTarget target = new TwoWayAdapter(adaptee);
        target.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
        TwoWayTarget target2 = new TargetRealize();
        TwoWayAdaptee adaptee2 = new TwoWayAdapter(target2);
        adaptee2.specificRequest();
    }
}


//适配者接口
interface TwoWayAdaptee {
    public void specificRequest();
}

//适配者实现
class AdapteeRealize implements TwoWayAdaptee {
    public void specificRequest() {
        System.out.println("适配者代码被调用！");
    }
}


//目标接口
interface TwoWayTarget {
    public void request();
}

//目标实现
class TargetRealize implements TwoWayTarget {
    public void request() {
        System.out.println("目标代码被调用！");
    }
}

//双向适配器
class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee {
    //同时保存目标接口与适配器
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;

    public TwoWayAdapter(TwoWayTarget target) {
        this.target = target;
    }

    public TwoWayAdapter(TwoWayAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }

    public void specificRequest() {
        target.request();
    }
}
