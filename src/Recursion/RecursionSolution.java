package Recursion;

public class RecursionSolution {

//    Given a linked list, swap every two adjacent nodes and return its head.
    public ListNode swapPairs(ListNode head) {
////        0 or 1 node
//        if(head==null||head.next==null){
//            return head;
//        }
////        only 2 node
////        former head
//        ListNode p=head;
////        former head.next.next
//        ListNode q=head.next.next;
////        second node.next should be previous one
//        head.next.next=head;
////        new head is the next node
//        head=head.next;
////        former head now is the second one, it should be pointed to former head.next.next
//        p.next=q;
////        return之后需要将后两个节点和前两个节点连接上，
////        比如：1234，34交换完成，变为43之后，需要修改上一层21的尾部节点，几将1.next指向4，而不是3
//        head.next.next=swapPairs(q);
//        return head;
        if(head==null||head.next==null){
            return head;
        }
        ListNode firstNode=head;
        ListNode secondNode=head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next=firstNode;
//        new head is second node
        return secondNode;
    }


}
