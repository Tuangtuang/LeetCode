package ArrayString;

import java.util.LinkedList;
import java.util.List;

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

    //    In a given integer array nums, there is always exactly one largest element.
//
//    Find whether the largest element in the array is at least twice as much as every other number in the array.
//
//    If it is, return the index of the largest element, otherwise return -1.
//    https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
    public int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int maxIndex = 0;
        int nextMaxIndex = 1;
        if (nums[1] > nums[0]) {
            maxIndex = 1;
            nextMaxIndex = 0;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                nextMaxIndex = maxIndex;
                maxIndex = i;
            } else {
                if (nums[i] > nums[nextMaxIndex]) {
                    nextMaxIndex = i;
                }
            }
        }
        if (nums[maxIndex] >= 2 * nums[nextMaxIndex]) {
            return maxIndex;
        }
        return -1;
    }

    //
//    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
//
//    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
//
//    You may assume the integer does not contain any leading zero, except the number 0 itself.
//    https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int i = size - 1;
        digits[i] += 1;
        while (digits[i] > 9 && i >= 1) {
            digits[i] = 0;
            digits[i - 1] += 1;
            i--;
        }
        if (i == 0 && digits[i] > 9) {
            int[] res = new int[size + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

    //    Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
//    https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int i = 0, j = 0;
        int resIndex = 0;
        res[resIndex] = matrix[i][j];
        resIndex++;
        boolean flag = false;
        while (resIndex < rows * cols) {
            if (flag == false) {
                i--;
                j++;
            } else {
                i++;
                j--;
            }
            if (i >= 0 && j >= 0 && i < rows && j < cols) {
                res[resIndex] = matrix[i][j];
                resIndex++;
                continue;
            }
            if (i < 0 && j >= cols) {
                i += 2;
                j = cols - 1;
            }
            if (i >= rows && j < 0) {
                j += 2;
                i = rows - 1;
            }
            if (i < 0) {
                i = 0;
            }
            if (i >= rows) {
                i = rows - 1;
                j += 2;
            }
            if (j < 0) {
                j = 0;
            }
            if (j >= cols) {
                j = cols - 1;
                i += 2;
            }
            flag = !flag;
            res[resIndex] = matrix[i][j];
            resIndex++;
        }
        return res;
    }


//    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if(matrix==null){
            return null;
        }
        int rows=matrix.length;
        if(rows==0){
            return result;
        }
        int cols=matrix[0].length;
        if(cols==0){
            return result;
        }
        int [][]tagMatrix=new int[rows][cols];
        int j=0,i=0;
        result.add(matrix[0][0]);
        tagMatrix[0][0]=1;
        int count=1;
        int max=rows*cols;
        while(count<=max){
            while(!(j==cols-1||tagMatrix[i][j+1]==1)){
                j++;
                result.add(matrix[i][j]);
                tagMatrix[i][j]=1;
            }
            while(!(i==rows-1||tagMatrix[i+1][j]==1)){
                i++;
                result.add(matrix[i][j]);
                tagMatrix[i][j]=1;
            }
            while(!(i==0||tagMatrix[i-1][j]==1)){
                i--;
                result.add(matrix[i][j]);
                tagMatrix[i][j]=1;
            }
            while(!(j==0||tagMatrix[i][j-1]==1)){
                j--;
                result.add(matrix[i][j]);
                tagMatrix[i][j]=1;
            }
            count++;
        }
        return result;

    }
}
