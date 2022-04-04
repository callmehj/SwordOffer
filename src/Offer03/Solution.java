package Offer03;

import java.util.Arrays;

public class Solution {
    //由于给的数据有着明显的特点：所有数字都在0～n-1之内
    //常见思路是直接遍历，然后统计
    //但是考虑到数据的特殊性，假如没有重复的数字，则所有的数字在排序后会和下标下同，利用这点进行如下的算法
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 3};
        System.out.println(Solution.findRepeatNumber(nums));
    }
}
