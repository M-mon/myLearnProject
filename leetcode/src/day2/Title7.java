package day2;

/**
 * @Description
 * @auther hasee
 * @create 2019-11-05 16:09
 */
public class Title7 {

    /**
     * 题目：7. 整数反转
     * 难度：  简单
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     * 示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int reverse_my(int x) {
        String numStr=Integer.valueOf(x).toString();
        String sign="";
        if (x<0){
            numStr=numStr.substring(1);
            sign="-";
        }
        String reverseStr=new StringBuffer(numStr).reverse().insert(0,sign).toString();
        long reverNum=Long.valueOf(reverseStr);
        if (reverNum>Integer.MAX_VALUE||reverNum<Integer.MIN_VALUE){
            return 0;
        }
        return (int)reverNum;
    }

    /**
     * 方法：弹出和推入数字 & 溢出前进行检查
     * 是否提前存储简单运算的值对内存无影响
     * 考核点：
     * 1.数字反转
     * 2.边界溢出检查
     */
    public int reverse_best(int x) {
        int rev = 0;

//        int max=Integer.MAX_VALUE/10;
//        int min=Integer.MIN_VALUE/10;
        while (x != 0) {
            //弹出（获取）尾数，尾数符号永远相同，使用加法时，就不会有符号位影响
            int pop = x % 10;
            x /= 10;
            //溢出检查，num>Integer.MAX_VALUE,num<Integer.MIN_VALUE,都算溢出
            //可提前检查，该方法是有且只能提前一位进行溢出检查。因为边界数换算成十进制不是规律数，上界：2147483647，下界：-2147483648
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//            if (rev > max || (rev == max && pop >  Integer.MAX_VALUE % 10)) return 0;
//            if (rev > max || (rev == max && pop >  7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
//            if (rev < min || (rev == min && pop < Integer.MIN_VALUE % 10)) return 0;
//            if (rev < min || (rev == min && pop < -8)) return 0;
            //上一次结果提升一位后，压入尾数
            rev = rev * 10 + pop;
        }
        return rev;
    }


}
