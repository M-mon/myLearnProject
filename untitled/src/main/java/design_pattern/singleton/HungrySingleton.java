package design_pattern.singleton;

/**
 * @Description 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
 * @auther hasee
 * @create 2019-11-07 10:22
 */
public class HungrySingleton {

    //类加载即进行实例化，static final  限制修改
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
