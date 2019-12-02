package design_pattern.interpreter;

import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 * @Description 存款利息的计算公式是：本金x利率x时间=利息，其相关代码如下
 * @auther hasee
 * @create 2019-12-02 17:47
 */
public class JepDemo
{
    public static void main(String[] args) throws ParseException {
        JEP jep=new JEP();
        //定义要计算的数据表达式
        String 存款利息="本金*利率*时间";
        //给相关变量赋值
        jep.addVariable("本金",10000);
        jep.addVariable("利率",0.038);
        jep.addVariable("时间",2);
        Node node=jep.parse(存款利息);    //解析表达式
        Object accrual=jep.evaluate(node);    //计算
        System.out.println("存款利息："+accrual);
    }
}