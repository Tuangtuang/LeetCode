package ArrayString;

import java.util.*;

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
        if (matrix == null) {
            return null;
        }
        int rows = matrix.length;
        if (rows == 0) {
            return result;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return result;
        }
        int[][] tagMatrix = new int[rows][cols];
        int j = 0, i = 0;
        result.add(matrix[0][0]);
        tagMatrix[0][0] = 1;
        int count = 1;
        int max = rows * cols;
        while (count <= max) {
            while (!(j == cols - 1 || tagMatrix[i][j + 1] == 1)) {
                j++;
                result.add(matrix[i][j]);
                tagMatrix[i][j] = 1;
            }
            while (!(i == rows - 1 || tagMatrix[i + 1][j] == 1)) {
                i++;
                result.add(matrix[i][j]);
                tagMatrix[i][j] = 1;
            }
            while (!(i == 0 || tagMatrix[i - 1][j] == 1)) {
                i--;
                result.add(matrix[i][j]);
                tagMatrix[i][j] = 1;
            }
            while (!(j == 0 || tagMatrix[i][j - 1] == 1)) {
                j--;
                result.add(matrix[i][j]);
                tagMatrix[i][j] = 1;
            }
            count++;
        }
        return result;
    }

    //    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>(1);
        temp.add(1);
        res.add(temp);
        if (numRows == 1) {
            return res;
        }
        temp = new ArrayList<>(1);
        temp.add(1);
        temp.add(1);
        res.add(temp);
        for (int i = 2; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }


    //    Given two binary strings, return their sum (also a binary string).
//
//    The input strings are both non-empty and contains only characters 1 or 0.
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int add = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            if (add > 1) {
                carry = 1;
                result.append(add % 2);
            } else {
                carry = 0;
                result.append(add);
            }
            i--;
            j--;
        }
        while (i >= 0) {
            int add = a.charAt(i) - '0' + carry;
            if (add > 1) {
                carry = 1;
                result.append(add % 2);
            } else {
                carry = 0;
                result.append(add);
            }
            i--;
        }
        while (j >= 0) {
            int add = b.charAt(j) - '0' + carry;
            if (add > 1) {
                carry = 1;
                result.append(add % 2);
            } else {
                carry = 0;
                result.append(add);
            }
            j--;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }


    //    Implement strStr().
//
//    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    //    Write a function to find the longest common prefix string amongst an array of strings.
//
//    If there is no common prefix, return an empty string "".
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length == 0) {
            return "";
        }
        int shortestIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < strs[shortestIndex].length()) {
                shortestIndex = i;
            }
        }
        String shortestString = strs[shortestIndex];
        int j = shortestString.length();
        while (j >= 0) {
            String temp = shortestString.substring(0, j);
            boolean tag = true;
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].substring(0, temp.length()).equals(temp)) {
                    tag = false;
                }
            }
            if (tag) {
                return temp;
            }
            j--;
        }
        return "";
    }

    //    Write a function that reverses a string. The input string is given as an array of characters char[].
//
//    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//    You may assume all the characters consist of printable ascii characters.
    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        int start = 0, end = s.length - 1;
        while (start <= end) {
            // swap start and end elements
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        return;
    }

    //    Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        if (nums.length == 0) {
            return sum;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }


    //    Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
    public int[] twoSum(int[] numbers, int target) {
//        int []result=new int[2];
//        for(int i=0;i<numbers.length-1;i++){
//            int searchTarget=target-numbers[i];
//            int index=binarySearch(numbers,searchTarget,i+1,numbers.length-1);
//            if(index==-1){
//                continue;
//            }else{
//                result[0]=i+1;
//                result[1]=index+1;
//            }
//        }
//        return result;
        int[] result = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                break;
            }
        }
        result[0] = i + 1;
        result[1] = j + 1;
        return result;
    }

    public int binarySearch(int[] vector, int target, int start, int end) {
        if (vector == null || vector.length == 0) {
            return -1;
        }
        if (vector[start] > target || vector[end] < target) {
            return -1;
        }
        if (start > end) {
            return -1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (vector[mid] > target) {
                end = mid - 1;
            } else if (vector[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    //    Given an array nums and a value val, remove all instances of that value in-place and return the new length.
//
//    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return j + 1;
    }

    //    Given a binary array, find the maximum number of consecutive 1s in this array.
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        return max > count ? max : count;
    }

//    Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        // 滑动窗口
        int low=0,high=0,currSum=0,minLength=Integer.MAX_VALUE;
        while(low<nums.length&&high<nums.length){
            if(currSum<s){
                currSum+=nums[high];
                high++;
            }else{
                minLength=Integer.min(high-low,minLength);
                currSum-=nums[low];
                low++;
            }
        }
        // 可能仍有多余项
        while (currSum>=s){
            minLength=Integer.min(high-low,minLength);
            currSum-=nums[low];
            low++;
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

//    Given an array, rotate the array to the right by k steps, where k is non-negative.
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0||nums.length==1){
            return;
        }
        int pos=k%nums.length;
        reverseArray(nums,0,nums.length);

        reverseArray(nums,0,pos);

        reverseArray(nums,pos,nums.length);


    }

    public  void reverseArray(int []arr,int start,int end){
        if(arr==null||arr.length==0||arr.length==1){
            return;
        }
        if(start<0||end>arr.length){
            return;
        }
        int i=start,j=end-1;
        while (i<j){
            // swap arr[i] and arr[j]
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0){
            return null;
        }
        Integer []res=new Integer[rowIndex+1];
        res[0]=1;
        if(rowIndex==0){
            return new ArrayList<Integer>(Arrays.asList(res));
        }
        res[1]=1;
        if(rowIndex==1){
            return new ArrayList<Integer>(Arrays.asList(res));
        }
        int i=2;
        while (i<=rowIndex){
            res[i]=1;
            int j=1;
            int lastRes=0;
            while(j<=i){
                int curRes=res[j]+res[j-1];
                if(lastRes!=0){
                    res[j-1]=lastRes;
                }
                lastRes=curRes;
                j++;
            }
            i++;
        }
        return new ArrayList<Integer>(Arrays.asList(res));

    }

//    Given an input string, reverse the string word by word.
    public String reverseWords(String s) {
       if(s==null){
           return null;
       }
       String []arr=s.split("\\s{1,}");
       StringBuilder res = new StringBuilder();
       for(int i=arr.length-1;i>=0;i--){
           res.append(arr[i]);
           res.append(" ");
       }
       return res.toString().trim();

    }

//    Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word
//    Note: In the string, each word is separated by single space and there will not be any extra space in the string.
    public String reverseWords2(String s) {
        char []str=s.toCharArray();
        int start=0,end=0;
        for(;end<str.length;){
            if(str[end]==' '){
                reverseArrayChar(str,start,end);
                end++;
                start=end;
            }else {
                end++;
            }
        }
        reverseArrayChar(str,start,end);
        return new String(str);
    }

    public  void reverseArrayChar(char []arr,int start,int end){
        if(arr==null||arr.length==0||arr.length==1){
            return;
        }
        if(start<0||end>arr.length){
            return;
        }
        int i=start,j=end-1;
        while (i<j){
            // swap arr[i] and arr[j]
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

//    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//
//    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int i=1,j=1;
        int curNum=nums[0];
        while (j<nums.length){
            if(nums[j]==curNum){
                j++;
            }else {
                curNum=nums[j];
                nums[i]=nums[j];
                i++;
                j++;
            }
        }
        return i;
    }

//    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1){
            return;
        }
        int i=0,j=0;
        for(;j<nums.length;j++){
            if(nums[j]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
    }

//    Given an array nums of integers, return how many of them contain an even number of digits.
    public int findNumbers(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(countDigits(nums[i])%2==0){
                count++;
            }
        }
        return count;
    }

    public int countDigits(int number){
        int count=0;
        while (number!=0){
            count++;
            number=number/10;
        }
        return count;
    }

//    Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
    public int[] sortedSquares(int[] A) {
        if(A==null){
            return null;
        }
        int []result=new int[A.length];
        int low=0,high=A.length-1;
        int i=A.length-1;
        while (i>=0){
            if(Math.abs(A[low])>Math.abs(A[high])){
                result[i]=A[low]*A[low];
                i--;
                low++;
            }else {
                result[i]=A[high]*A[high];
                i--;
                high--;
            }
        }
        return result;
    }


//    Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
//
//    Note that elements beyond the length of the original array are not written.
    public void duplicateZeros(int[] arr) {
        if(arr==null||arr.length==0||arr.length==1){
            return;
        }
        // count possible zeros
        int length=arr.length-1;
        int zeros=0;
        for(int i=0;i+zeros<=length;i++){
            if(arr[i]==0){
                if(i==length-zeros){
                    arr[length]=0;
                    length--;
                    break;
                }
                zeros++;
            }
        }
        if(zeros==0){
            return;
        }
        int curLength=length-zeros;
        for(int j=curLength;j>=0;j--){
            if(arr[j]==0){
                arr[j+zeros]=0;
                zeros--;
                arr[j+zeros]=0;
            }else {
                arr[j+zeros]=arr[j];
            }
        }
        return;

    }

//    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//    [1,2,4,0,0]
//    [3,5]
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if(n<=0||m<=0){
//            return;
//        }
        if(nums1==null||nums2==null){
            return;
        }
        int i=m-1,j=n-1;
        int pos=m+n-1;
        while (i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[pos]=nums1[i];
                i--;
                pos--;
            }else{
                nums1[pos]=nums2[j];
                j--;
                pos--;
            }
        }
        // if nums2 is longer
        while (j>=0){
            nums1[pos]=nums2[j];
            pos--;
            j--;
        }

    }

//    Given an array A of integers, return true if and only if it is a valid mountain array.
    public boolean validMountainArray(int[] A) {
        if(A==null){
            return false;
        }
        if(A.length<3){
            return false;
        }
        int i=1;
        for(;i<A.length;){
            if(A[i]<=A[i-1]){
                break;
            }
            i++;
        }
        if(i==1){
            return false;
        }
        if(i==A.length){
            return false;
        }
        int j=i;
        for(;j<A.length;j++){
            if(A[j]>=A[j-1]){
                break;
            }
        }
        return j==A.length;
    }

//    Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
    public boolean checkIfExist(int[] arr) {
        if(arr==null||arr.length==0||arr.length==1){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]*2)||arr[i]%2==0&&set.contains(arr[i]/2)||arr[i]==0&&set.contains(0)){
                return true;
            }else{
                set.add(arr[i]);
            }
        }
        return false;

    }

//    Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
    public int[] replaceElements(int[] arr) {
        if(arr==null){
            return null;
        }
        if(arr.length==1){
            arr[0]=-1;
            return arr;
        }
//        // find the max num and pos
//        int max=Integer.MIN_VALUE,pos=-1;
//        for(int i=1;i<arr.length;i++){
//            if(arr[i]>max){
//                max = arr[i];
//                pos=i;
//            }
//        }
//        arr[0]=max;
//        for(int i=1;i<arr.length-1;i++){
//            if(i<pos){
//                arr[i]=max;
//            }else{
//                // refind the max number
//                max=Integer.MIN_VALUE;
//                for(int j=i+1;j<arr.length;j++){
//                    if(arr[j]>max){
//                        max=arr[j];
//                        pos=j;
//                    }
//                }
//                arr[i]=max;
//            }
//        }
//        arr[arr.length-1]=-1;
//        return arr;
        int max=arr[arr.length-1];
        for(int i=arr.length-1;i>=0;i--){
            int temp=max;
            if(arr[i]>max){
                max=arr[i];
            }
            arr[i]=temp;
        }
        arr[arr.length-1]=-1;
        return arr;
    }


//    Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
    public int[] sortArrayByParity(int[] A) {
        if(A==null||A.length==1){
            return A;
        }
        int low=0,high=A.length-1;
//        3,1,2,4
        while (low<high&&low<A.length&&high>=0){
            while (high>=0&&A[high]%2==1){
                high--;
            }
            while (low<A.length&&A[low]%2==0){
                low++;
            }
            // swap high and low
            if(low<high){
                int temp = A[high];
                A[high] = A[low];
                A[low]=temp;
            }

        }
        return A;
    }


//    Students are asked to stand in non-decreasing order of heights for an annual photo.
//    Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
    public int heightChecker(int[] heights) {
        if(heights==null||heights.length==0||heights.length==1){
            return 0;
        }
        int[] init = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            init[i] = heights[i];
        }
        Arrays.sort(heights);
        int count=0;
        for(int i=0;i<heights.length;i++){
            if(init[i]!=heights[i]){
                count++;
            }
        }
        return count;
    }


//    Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
    public int thirdMax(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        if(nums.length==2){
            return nums[1];
        }else {
            int count=1;
            int j=nums.length-2;
            for(;j>=0;j--){
                if(nums[j]!=nums[j+1]){
                    count++;
                }
                if(count==3){
                    break;
                }
            }

            return j!=-1?nums[j]:nums[nums.length-1];
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            int pos = Math.abs(nums[i])-1;
            if(nums[pos]>0){
                nums[pos]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }

//    牛客，最大不重复子串，hash+slide window
    public int maxLength (int[] arr) {
        // write code here

        if(arr==null||arr.length==0){
            return 0;
        }
        if(arr.length==1){
            return 1;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int i=0,j=0;
        int maxLength=0;
        while(j<arr.length){
            if(map.containsKey(arr[j])){
//             i从之前出现位置的下一位开始计算
                i=Integer.max(map.get(arr[j])+1,i);
            }
            map.put(arr[j],j);
            maxLength=Integer.max(maxLength,j-i+1);
            j++;
        }
        return maxLength;
    }


//    牛客，容器盛水问题
//    https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=190&&tqId=36005&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
    public long maxWater (int[] arr) {
        // write code here
        int []leftMax=new int [arr.length];
        int []rightMax=new int [arr.length];
//         为每个位置找左边的最大值
        for(int i=1;i<arr.length;i++){
            leftMax[i]=arr[i-1]>leftMax[i-1]?arr[i-1]:leftMax[i-1];
        }
//         为每个位置找右边的最大值
        for(int i=arr.length-2;i>=0;i--){
            rightMax[i]=arr[i+1]>rightMax[i+1]?arr[i+1]:rightMax[i+1];
        }
//         每个位置能存放的就是左右两边最大值中较小的一个，减去他本身的高度
        long sum=0;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>Integer.min(leftMax[i],rightMax[i])){
                continue;
            }
            sum+=(Integer.min(leftMax[i],rightMax[i])-arr[i]);
        }
        return sum;
    }


//    牛客，二分查找变体
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        if(v>a[n-1]){
            return n+1;
        }
        int low=0,high=n-1;

        int resIndex=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(v<a[mid]){
                if(mid==0||mid>=1&&v>a[mid-1]){
                    resIndex=mid;
                    break;
                }
                high=mid-1;
            }else if(v==a[mid]){
                resIndex=mid;
                break;
            }else{
                if(mid==n-1||mid<=n-2&&v<a[mid+1]){
                    resIndex=mid+1;
                    break;
                }
                low=mid+1;
            }
        }
        while(resIndex>=1){
            if(a[resIndex-1]==a[resIndex]){
                resIndex--;
            }else{
                break;
            }
        }
        return resIndex+1;
    }
}
