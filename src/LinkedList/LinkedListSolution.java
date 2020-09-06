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

//    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            // no cycle
            return null;
        }
        ListNode slow=head,fast=head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        // has cycle
        // 两个指针分别从链表头和相遇点出发，最后一定相遇于环入口。
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }

//    Write a program to find the node at which the intersection of two singly linked lists begins.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        int countA=0;
        ListNode p=headA;
        while (p!=null){
            countA++;
            p=p.next;
        }
        int countB=0;
        p=headB;
        while (p!=null){
            countB++;
            p=p.next;
        }
        int diff = Math.abs(countA - countB);
        p=headA;
        ListNode q=headB;
        if(countA>countB){
            // make p move diff
            while (diff>0){
                p=p.next;
                diff--;
            }
        }else {
            // make q move diff
            while (diff>0){
                q=q.next;
                diff--;
            }
        }
        while (p!=null&&q!=null){
            if(p==q){
                return p;
            }
            p=p.next;
            q=q.next;
        }
        return null;
    }

//    Given a linked list, remove the n-th node from the end of list and return its head.
//    Given n will always be valid.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        // make i go n+1 step
        ListNode front=head,back=head;
        while (n>=0&&front!=null){
            front=front.next;
            n--;
        }
        // the first one is the deleted one
        if(front==null&&n>=0){
            head=head.next;
        }
        while (front!=null){
            front=front.next;
            back=back.next;
        }
        //back.next is the node we want to delete
        if(back.next!=null){
            back.next=back.next.next;
        }
        return head;
    }

}