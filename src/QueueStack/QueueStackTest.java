package QueueStack;

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
                {'1', '0', '1', '1', '0','1','1'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '1', '1'}
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


}
