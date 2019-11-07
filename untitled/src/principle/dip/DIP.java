package principle.dip;

/**
 * @Description
 * @auther hasee
 * @create 2019-11-06 22:42
 */
public class DIP {

    public static void main(String[] args) {
        Customer wang = new Customer();
        System.out.println("顾客购买以下商品：");
        wang.shopping(new ShaoguanShop());
        wang.shopping(new WuyuanShop());
    }
}

//商店
interface Shop {
    public String sell(); //卖
}

//韶关网店
class ShaoguanShop implements Shop {
    public String sell() {
        return "韶关土特产：香菇、木耳……";
    }
}

//婺源网店
class WuyuanShop implements Shop {
    public String sell() {
        return "婺源土特产：绿茶、酒糟鱼……";
    }
}

//顾客
class Customer {

    //以下2个是错误例子，顾客每更换一家商店，都要修改一次代码，这明显违背了开闭原则。
    //解决方法是：定义“婺源网店”和“韶关网店”的共同接口 Shop，顾客类面向该接口编程
    public void shopping(ShaoguanShop shop)
    {
        //购物
        System.out.println(shop.sell());
    }

    public void shopping(WuyuanShop shop)
    {
        //购物
        System.out.println(shop.sell());
    }

    //正确例子，不管顾客类 Customer 访问什么商店，或者增加新的商店，都不需要修改原有代码了
    public void shopping(Shop shop) {
        //购物
        System.out.println(shop.sell());
    }
}