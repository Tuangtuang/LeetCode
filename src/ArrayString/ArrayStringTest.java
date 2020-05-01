package ArrayString;

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
        System.out.println("Test Generate....");
        ArrayStringSolution arrayStringSolution=new ArrayStringSolution();
        List<List<Integer>> res=arrayStringSolution.generate(5);
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
