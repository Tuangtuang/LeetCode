package QueueStack;

/**
 * @program: LeetCode
 * @description: test min stack
 * @author: tyq
 * @create: 2020-09-27 11:32
 **/
public class MinStackTest {

    public void testMinStack(){
        System.out.println("\nTest Min Stack...");
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
