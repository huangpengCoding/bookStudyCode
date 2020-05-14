package 算法.leetcode.n01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/31 2:52 PM
 * @Usage: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {
    /**
     * 时间复杂度o(n2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("cannot find indexs");
    }

    /**
     * 时间复杂度O(n) 两遍hash
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            mapIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (mapIndex.containsKey(j) && mapIndex.get(j) != i) {
                return new int[]{i, mapIndex.get(j)};
            }
        }
        throw new IllegalArgumentException("cannot find indexs");
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (mapIndex.containsKey(j) && mapIndex.get(j) != i) {
                return new int[]{i, mapIndex.get(j)};
            }
            mapIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("cannot find indexs");
    }


    public static void showArr(int[] arr) {
        for (int item : arr) {
            System.out.print(item + "\t");
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] rst;
        //1. O(n2)遍历两遍
//        rst = new Solution().twoSum1(nums, target);
        //2. O(N)两遍hash表
//        rst = new Solution().twoSum2(nums, target);
        //3. O(N)一遍hash表
        rst = new Solution().twoSum3(nums, target);
        showArr(rst);

    }
}
