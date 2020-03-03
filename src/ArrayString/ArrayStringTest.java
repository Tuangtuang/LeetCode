package ArrayString;

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
        int[] array = {0,0,3,2};
        ArrayStringSolution arrayStringSolution = new ArrayStringSolution();
        System.out.println(arrayStringSolution.dominantIndex(array));
    }
}
