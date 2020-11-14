package Recursion;

import java.util.ArrayList;
import java.util.List;

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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
//        new head is second node
        return secondNode;
    }


    //    Reverse Linked List
//    Recursion
//    问题：1）递归返回值是last Node
//    O(n)
    public ListNode reverseList(ListNode head) {
//        last node return, base case in recursion
        if(head==null||head.next==null){
            return head;
        }
//        reverse(1->2->3) = 1->reverse(2->3)
        ListNode lastNode = reverseList(head.next);
//        1 and (3->2); and 1 is pointed to 2, 2 is pointed to null, so we need to make 2 point to 1
        head.next.next=head;
//        make 1 point to null
        head.next=null;
//        last node is 3, we don't do any modification when recursion
        return lastNode;
    }

//    Search in a Binary Search Tree
//    问题1）返回值问题，在左边找到就返回左子树的根，右边就返回右子树的根，而不是返回root
//    o(logn),n=depth
    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        } else if(val<root.val){
//        find left tree
            return searchBST(root.left, val);
        }else{
//        find right tree
            return searchBST(root.right, val);
        }
    }

//    Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
//    haha
//    时间复杂度O(n^2) 空间复杂度O(n^2)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.clear();
        if(rowIndex==0){
            res.add(1);
            return res;
        }
        if(rowIndex==1){
            res.add(1);
            res.add(1);
            return res;
        }
        List<Integer> lastRow=getRow(rowIndex-1);
        res.add(1);
//        f(i,j)=f(i-1,j-1)+f(i-1,j) 当前行的第i个元素是上一行i-1个元素和i个元素之和
        for(int i=1;i<rowIndex;i++){
            res.add(lastRow.get(i - 1) + lastRow.get(i));
        }
        res.add(1);
        return res;
    }

}
