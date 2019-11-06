package day2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther hasee
 * @create 2019-11-05 15:18
 */
public class Title1 {
    /**
     *
     * 题目：1. 两数之和
     * 难度：  简单
     * 内容：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */


    public int[] twoSum_my(int[] nums, int target) {
        int length=nums.length;
        for (int i = 0; i < length-1; i++) {
            int which=target-nums[i];
            for (int j = i+1; j < length; j++) {
                if (which-nums[j]==0){
                    return  new int[]{i,j};
                }

            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 考核点：
     * 1.如何快速定位内容。使用Hash算法快速定位
     * 2.把两次循环变成一次循环。
     * 思路转变，正常思路，暴力破解：从数组头开始进行第一次循环，获取预期数，再进行第二次循环，从后续的数匹配预期数。
     * 转变：二次循环是以未知找未知，一次循环是已知找已知。要考虑已知的数，能否再次利用。
     */
    public int[] twoSum_best(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
