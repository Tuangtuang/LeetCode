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
}
