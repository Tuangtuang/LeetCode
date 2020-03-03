package ArrayString;

public class ArrayStringSolution {
    //    Given an array of integers nums, write a method that returns the "pivot" index of this array.
//    We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
//    If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
//    https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
            rightSum -= nums[i + 1];
        }
        if (leftSum == 0) {
            return nums.length - 1;
        }
        return -1;
    }
}
