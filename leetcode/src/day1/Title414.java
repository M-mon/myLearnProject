package day1;

/**
 * @Description
 * @auther hasee
 * @create 2019-11-04 14:52
 */
public class Title414 {




    /*414.第三大的数
    给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。

    要求算法时间复杂度必须是O(n)。
    示例 1:
    输入:[3,2,1]
    输出:1
    解释:第三大的数是 1.
    示例 2:
    输入:[1,2]

    输出:2

    解释:第三大的数不存在,所以返回最大的数 2 .
    示例 3:

    输入:[2,2,3,1]

    输出:1

    解释:注意，要求返回第三大的数，是指第三大且唯一出现的数。
    存在两个值为2的数，它们都排第二。*/

    /*给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
    数字x的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

    示例 1:

    输入:[1,2,1]
    输出:[2,-1,2]
    解释:第一个 1的下一个更大的数是 2；
    数字 2找不到下一个更大的数；
    第二个 1的下一个最大的数需要循环搜索，结果也是 2。
    注意:输入数组的长度不会超过 10000。*/


    /*删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

    说明:

    输入可能包含了除(和) 以外的字符。

    示例 1:

    输入:"()())()"
    输出:["()()()","(())()"]
    示例 2:

    输入:"(a)())()"
    输出:["(a)()()","(a())()"]
    示例 3:

    输入:")("
    输出:[""]*/

    /**
     * 题目：414. 第三大的数
     * 内容：给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     * 难度：简单
     * 考核点：
     * 1.如何进行数据初始化。
     * 2.类型上下限，需使用long类型覆盖int的下限。
     */
    public static int thirdMax_best(int[] nums) {
        long min = 0x8000000000000000L;
        long first = min, second = min, third = min;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        return (int) (min == third ? first : third);
    }


    public static void main(String[] args) {

//        int[] nums = new int[]{-2147483648, 1, 1};
//        int[] nums = new int[]{2,2,3,1};
//        int[] nums = new int[]{1,2};
//        int[] nums = new int[]{5,2,4,1,3,6,0};
        int[] nums = new int[]{3, 2, 1};
        System.out.println(thirdMax_best(nums));

    }


}
