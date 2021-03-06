package ArrayString;

import java.util.Arrays;
import java.util.List;

public class ArrayStringTest {
    public void testPivotIndex() {
        System.out.println("Test Pivot Index...");
//        int []array={1, 7, 3, 6, 5, 6};
        int[] array = {-1, -1, 0, 1, 1, 0};
        ArrayStringSolution arrayStringSolution = new ArrayStringSolution();
        System.out.println(arrayStringSolution.pivotIndex(array));
    }

    public void testDominantIndex() {
        System.out.println("Test Dominant Index...");
        int[] array = {0, 0, 3, 2};
        ArrayStringSolution arrayStringSolution = new ArrayStringSolution();
        System.out.println(arrayStringSolution.dominantIndex(array));
    }

    public void testPlusOne() {
        System.out.println("Test Dominant Index...");
        int[] array = {8, 9};
        ArrayStringSolution arrayStringSolution = new ArrayStringSolution();
        int[] res = arrayStringSolution.plusOne(array);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public void testFindDiagonalOrder() {
        System.out.println("Test Find Diagonal Order...");
        int[][] array = {};
        ArrayStringSolution arrayStringSolution = new ArrayStringSolution();
        arrayStringSolution.findDiagonalOrder(array);
        int[] res = arrayStringSolution.findDiagonalOrder(array);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public void testSpiralOrder(){
        System.out.println("Test Spiral Order....");
        int [][] array=new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        List<Integer> res=arrayStringSolution.spiralOrder(array);
        for(Integer i:res){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public void testGenerate(){
        System.out.println("\nTest Generate....");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        List<List<Integer>> res=arrayStringSolution.generate(5);
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public void testAddBinary(){
        System.out.println("\nTest Add Binary...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        System.out.println(arrayStringSolution.addBinary("1111","11"));
    }

    public void testStrStr(){
        System.out.println("\nTest str Str...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        System.out.println(arrayStringSolution.strStr("Hello","ll"));
    }

    public void testLongestCommonPrefix(){
        System.out.println("\nTest Longest Common Prefix...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        String []strs=new String[]{
                "Hello","He","n"
        };
        System.out.println(arrayStringSolution.longestCommonPrefix(strs));
    }

    public void testReverseString(){
        System.out.println("\nTest Reverse String...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        char[] str=new char[]{'h','e','l','l','o'};
        arrayStringSolution.reverseString(str);
        for(int i=0;i<str.length;i++){
            System.out.print(str[i]+" ");
        }
        System.out.println();
    }

    public void testArrayPairSum(){
        System.out.println("\nTest Array Pair Sum...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []nums=new int[]{1,3,2,3};
        System.out.println(arrayStringSolution.arrayPairSum(nums));
    }


    public void testTwoSum(){
        System.out.println("\nTest Two Sum...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers = new int[]{2, 7, 11, 15};
        int target=9;
        int []res = arrayStringSolution.twoSum(numbers, target);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    public void testRemoveElement(){
        System.out.println("\nTest Remove Element...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers=new int[]{3};
        int length=arrayStringSolution.removeElement(numbers,3);
        for(int i=0;i<length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }


    public void testFindMaxConsecutiveOnes(){
        System.out.println("\nTest Find Max Consecutive Ones...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers=new int[]{1,1,0,1,1,1};
        int max=arrayStringSolution.findMaxConsecutiveOnes(numbers);
        System.out.println(max);
    }


    public void testMinSubArrayLen(){
        System.out.println("\nTest Min Sub Array Len...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers=new int[]{2,3,1,2,4,3};
        int min=arrayStringSolution.minSubArrayLen(7,numbers);
        System.out.println(min);
    }

    public void  testRotate(){
        System.out.println("\nTest Rotate...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers=new int[]{1,2,3,4,5,6,7};
        arrayStringSolution.rotate(numbers,3);
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.print("\n");
    }

    public void testGetRow(){
        System.out.println("\nTest Get Row...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        List<Integer> res=arrayStringSolution.getRow(5);
        for(Integer item:res){
            System.out.print(item);
        }
        System.out.print("\n");
    }


    public void testReverseWords(){
        System.out.println("\nTest Reverse Words...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        System.out.println(arrayStringSolution.reverseWords("  hello world!  "));
    }

    public void testReverseWords2(){
        System.out.println("\nTest Reverse Words 2...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        System.out.println(arrayStringSolution.reverseWords2("Let's take LeetCode contest"));
    }

    public void testRemoveDuplicates(){
        System.out.println("\nTest Remove Duplicates...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers=new int[]{0,0,1,1,1,2,2,3,3,4};
        int length = arrayStringSolution.removeDuplicates(numbers);
        for(int i=0;i<length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.print("\n");
    }

    public void testMoveZeroes(){
        System.out.println("\nTest Move Zeros...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers=new int[]{4,2,4,0,0,3,0,5,1,0};
        arrayStringSolution.moveZeroes(numbers);
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.print("\n");
    }

    public void testFindNumbers(){
        System.out.println("\nTest Find Numbers...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers=new int[]{555,901,482,1771};
        System.out.println(arrayStringSolution.findNumbers(numbers));
    }

    public void testSortedSquares(){
        System.out.println("\nTest Sorted Squares...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers=new int[]{-4,-1,0,3,10};
        int []res=arrayStringSolution.sortedSquares(numbers);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.print("\n");
    }

    public void testDuplicateZeros(){
        System.out.println("\nTest Duplicate Zeros...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []numbers=new int[]{1,0,2,3,0,4,5,0};
        arrayStringSolution.duplicateZeros(numbers);
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.print("\n");
    }


    public void testMerge(){
        System.out.println("\nTest Merge...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []nums1=new int[]{1,2,4,0,0};
        int []nums2=new int[]{3,5};
        arrayStringSolution.merge(nums1,3,nums2,2);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
        System.out.print("\n");
    }

    public void testValidMountainArray(){
        System.out.println("\nTest Valid Mountain Array...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []nums=new int[]{3,5,5};
        System.out.println(arrayStringSolution.validMountainArray(nums));
    }


    public void testCheckIfExist(){
        System.out.println("\nTest Check If Exist...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []nums=new int[]{3,1,7,11};
        System.out.println(arrayStringSolution.checkIfExist(nums));
    }

    public void testReplaceElements(){
        System.out.println("\nTest Replace Elements...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []nums=new int[]{17,18,5,4,6,1};
        nums=arrayStringSolution.replaceElements(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.print("\n");
    }


    public void testSortArrayByParity(){
        System.out.println("\nTest Sort Array Parity...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int []nums=new int[]{0,2};
        nums = arrayStringSolution.sortArrayByParity(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.print("\n");
    }


    public  void testHeightChecker(){
        System.out.println("\nTest Height Checker...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int[] nums = new int[]{1, 1, 4, 2, 1, 3};
        System.out.println(arrayStringSolution.heightChecker(nums));
    }

    public void testThirdMax(){
        System.out.println("\nTest Third Max...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int[] nums = new int[]{1,1,2};
        System.out.println(arrayStringSolution.thirdMax(nums));
    }

    public void testFindDisappearedNumbers(){
        System.out.println("\nTest Find Disappeared Numbers...");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res=arrayStringSolution.findDisappearedNumbers(nums);
        for(Integer item:res){
            System.out.print(item+" ");
        }
        System.out.print("\n");
    }

    public void testMaxLength(){
        System.out.println("\nTest Max Length..");
        int []arr = new int[]{2,3,4,5};
        ArrayStringSolution arrayStringSolution = new ArrayStringSolution();
        System.out.println(arrayStringSolution.maxLength(arr));
    }

    public void testUpperBound(){
        System.out.println("\nTest Upper Bound...");
        int []arr=new int []{1,2,4,4,6};
        int n=arr.length;
        int target=5;
        ArrayStringSolution arrayStringSolution = new ArrayStringSolution();
        int res=arrayStringSolution.upper_bound_(n, target, arr);
        System.out.println(res);
    }
}
