package QueueStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: test queue stack
 * @author: tyq
 * @create: 2020-09-23 11:09
 **/
public class QueueStackTest {

    public void testNumIslands(){
        System.out.println("\nTest Num Islands...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        char map[][]=new char[][]{
                {'1', '0', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int res=queueStackSolution.numIslands(map);
        System.out.println(res);
    }


    public void testOpenLock(){
        System.out.println("\nTest Open Lock...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        String []deadEnds=new String[]{"0201","0101","0102","1212","2002"};
        String target="0202";
        int res=queueStackSolution.openLock(deadEnds, target);
        System.out.println(res);
    }

    public void testNumSquares(){
        System.out.println("\nTest Num Squares...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        int n=13;
        System.out.println(queueStackSolution.numSquares(n));
    }

    public void testBracketValid(){
        System.out.println("\nTest Bracket Valid...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        String testString="([)]";
        System.out.println(queueStackSolution.isValid(testString));
    }

    public void testDailyTemperatures(){
        System.out.println("\nTest Daily Temperature...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        int []arr=new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int []res=queueStackSolution.dailyTemperatures(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    public void testEvalRPN(){
        System.out.println("\nTest Evaluate Reverse Polish Notation...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        String []polish=new String[]{"4", "13", "5", "/", "+"};
        System.out.println(queueStackSolution.evalRPN(polish));
    }

    public void testNumIslandsDFS(){
        System.out.println("\nTest Test Num Island...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        char [][] island=new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(queueStackSolution.numIslandsDFS(island));
    }


    public void testFindTargetSumWays(){
        System.out.println("\nTest Target Sum...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        int []nums=new int[]{1, 1, 1, 1, 1};
        int S=3;
        System.out.println(queueStackSolution.findTargetSumWays(nums,S));
    }

    public void testDecodeString(){
        System.out.println("\nTest Decode String...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        String test = "3[a2[c]]";
        System.out.println(queueStackSolution.decodeString(test));
    }

    public void testFloodFill(){
        System.out.println("\nTest Flood Fill...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        int [][]arr=new int[][]{
            {1,1,1},{1,1,0},{1,0,1}
        };
        queueStackSolution.floodFill(arr,1,1,2);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.print("\n");
        }
    }


    public void testUpdateMatrix(){
        System.out.println("\nTest Update Matrix...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        int [][]arr=new int[][]{
                {0,0,0},{0,1,0},{1,1,1}
        };
        arr=queueStackSolution.updateMatrix(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.print("\n");
        }
    }


    public void testCanVisitAllRooms(){
        System.out.println("\nTest Can Visit All Rooms...");
        QueueStackSolution queueStackSolution=new QueueStackSolution();
        List<List<Integer>> input=new ArrayList<>();
        int [][]arr = new int[][]{
                {1,3},
                {3,0,1},
                {2},
                {0},
        };
        for(int i=0;i<arr.length;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j=0;j<arr[i].length;j++){
                tmp.add(arr[i][j]);
            }
            input.add(tmp);
        }
        System.out.println(queueStackSolution.canVisitAllRooms(input));
    }
}
