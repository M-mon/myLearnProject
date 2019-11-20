package design_pattern.decorator;

import java.awt.*;
import javax.swing.*;


/**
 * @Description
 * @auther hasee
 * @create 2019-11-08 16:18
 */
public class MorriganAensland {
    public static void main(String[] args) {
        Morrigan m0 = new original();
        m0.display();
        Morrigan m1 = new Succubus(m0);
        m1.display();
        Morrigan m2 = new Girl(m0);
        m2.display();
    }
}

//基础角色接口
//抽象构件角色：莫莉卡
interface Morrigan {
    public void display();
}

//基础角色接口的实现
//具体构件角色：原身
class original extends JFrame implements Morrigan {
    private static final long serialVersionUID = 1L;
    private String t = "Morrigan0.jpg";

    public original() {
        super("《恶魔战士》中的莫莉卡·安斯兰");
    }

    public void setImage(String t) {
        this.t = t;
    }

    public void display() {
        this.setLayout(new FlowLayout());
        JLabel l1 = new JLabel(new ImageIcon("/MyLearnProject/untitled/src/main/java/design_pattern/decorator/" + t));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//重新封装基础角色
//抽象装饰角色：变形
class Changer implements Morrigan {
    Morrigan m;

    public Changer(Morrigan m) {
        this.m = m;
    }

    public void display() {
        m.display();
    }
}

//继承重新封装后的对象，再扩展方法
//具体装饰角色：女妖
class Succubus extends Changer {
    public Succubus(Morrigan m) {
        super(m);
    }

    public void display() {
        setChanger();
        super.display();
    }

    public void setChanger() {
        ((original) super.m).setImage("Morrigan1.jpg");
    }
}

//继承重新封装后的对象，再扩展方法
//具体装饰角色：少女
class Girl extends Changer {
    public Girl(Morrigan m) {
        super(m);
    }

    public void display() {
        setChanger();
        super.display();
    }

    public void setChanger() {
        ((original) super.m).setImage("Morrigan2.jpg");
    }
}
