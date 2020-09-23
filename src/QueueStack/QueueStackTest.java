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
}
