package QueueStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * @author: tyq
 * @create: 2020-09-27 11:06
 **/
public class MinStack {
    /** initialize your data structure here. */
    int min;
    Stack<Integer> minStack;
    public MinStack() {
        minStack = new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int x) {
        minStack.add(x);
        if(x<=min){
            // update minIndex
            min=x;
        }

    }

    public void pop() {
        if(minStack.isEmpty()){
            return;
        }
//        if(minIndex!=minStack.size()-1){
//            // the one we want to pop is not a min number
//            minStack.remove(minStack.size()-1);
//        }else{
//            minStack.remove(minStack.size()-1);
//            // find a new min
//            int minNumber=Integer.MAX_VALUE;
//            for(int i=0;i<minStack.size();i++){
//                if(minStack.get(i)<=minNumber){
//                    minNumber = minStack.get(i);
//                    minIndex=i;
//                }
//            }
//        }
        if(minStack.peek()!=min){
            minStack.pop();
        }else{
            minStack.pop();
            min = Integer.MAX_VALUE;
            for(Integer item:minStack){
                if(item<=min){
                    min=item;
                }
            }
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }
}
