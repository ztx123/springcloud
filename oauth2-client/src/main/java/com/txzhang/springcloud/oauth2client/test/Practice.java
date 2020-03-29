package com.txzhang.springcloud.oauth2client.test;

import java.util.*;

/**
 * @ClassName：Practice
 * @Author：txzhang
 * @Date：2020/3/23—11:37
 * @Description：
 **/
public class Practice {


    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int index = 0;
        for (int item : nums) {
            if (target == item) {
                if (result[0] == -1) {
                    result[0] = index;
                    result[1] = index;
                } else {
                    result[1] = index;
                }
            }
            index++;
        }
        return result;
    }

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> ints = Arrays.asList(nums);
//        for (int num : nums) {
//            List<Integer> item = new ArrayList<>();
//            item.add(num);
//            ints.remove(num);
//            for (Integer is : ints) {
//                item.add(is);
//            }
//
//        }
        return null;
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i <nums.length ; i++) {
            int cha = target - nums[i];
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[j] == cha) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }
        return result;
    }


    /**
     *
     给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

     返回被除数 dividend 除以除数 divisor 得到的商。

     整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        int count = 0;
        if (dividend == 0) {
            return 0;
        }
        if (dividend < 0 && divisor < 0) {
            int s = -dividend;
            int ss = -divisor;
            if (s < ss) {
                count = -1;
            }
            do {
                count++;
            } while ((s -= ss) >= ss);
            return count;
        } else if (dividend > 0 && divisor > 0) {
            if (dividend < divisor) {
                count = -1;
            }
            do {
                count++;
            } while ((dividend = dividend - divisor) >= divisor);
            return count;
        } else if (dividend > 0 && divisor < 0) {
            int ss = -divisor;
            if (dividend < ss) {
                count = -1;
            }
            do {
                count++;
            } while ((dividend = dividend - ss) >= ss);
            return -count;
        }
        int s = -dividend;
        if (s < divisor) {
            count = -1;
        }
        do {
            count++;
        } while ((s = s - divisor) >= divisor);
        return -count;
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

//        List<List<Integer>> ss = new ArrayList<>();
//        List<Integer> s = new ArrayList<>();
//        s.add(-1);
//        s.add(0);
//        s.add(1);
//        ss.add(s);
//        System.out.println(s.toString());
//        List<Integer> s1 = new ArrayList<>();
//        s1.add(-1);
//        s1.add(0);
//        s1.add(1);
//        List<Integer> s2 = new ArrayList<>();
//        s2.add(0);
//        s2.add(1);
//        s2.add(-1);
//        System.out.println(s1.toString());
//        System.out.println(ss.contains(s1));
//        System.out.println(ss.contains(s2));
    }
}
