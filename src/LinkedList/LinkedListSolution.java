package LinkedList;

/**
 * @program: LeetCode
 * @description: solution of linked list
 * @author: tyq
 * @create: 2020-09-06 15:20
 **/
public class LinkedListSolution {

//    Given a linked list, determine if it has a cycle in it.
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head,fast=head.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
