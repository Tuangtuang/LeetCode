package LinkedList;

/**
 * @program: LeetCode
 * @description: test class for linked list solution
 * @author: tyq
 * @create: 2020-09-06 15:20
 **/
public class LinkedListTest {

    // create linked list by arrays
    public ListNode createLinkedList(int []nums,int pos){
        if(nums==null||nums.length==0){
            return null;
        }
        if(pos>=nums.length-1){
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode p=head;
        for(int i=1;i<nums.length;i++){
            p.next=new ListNode(nums[i]);
            p=p.next;
        }
        if(pos==-1){
            return head;
        }
        // find starts of the cycle
        int i=0;
        ListNode k=head;
        while (i!=pos){
           k=k.next;
           i++;
        }
        p.next=k;
        return head;
    }

    public void testHasCycle(){
        System.out.println("\nTest Has Cycle...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums=new int[]{1};
        int pos=-1;
        ListNode head=createLinkedList(nums,pos);
        boolean res=linkedListSolution.hasCycle(head);
        System.out.println(res);
    }

    public void testDetectCycle(){
        System.out.println("\nTest Detect Cycle...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums=new int[]{3,2,0,-4};
        int pos=1;
        ListNode head=createLinkedList(nums,pos);
        ListNode entrance = linkedListSolution.detectCycle(head);
        System.out.println(entrance!=null?entrance.val:null);
    }


    public void testRemoveNthFromEnd(){
        System.out.println("\nTest Remove Nth From End...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums=new int[]{1,2};
        int n=1;
        ListNode head=createLinkedList(nums,-1);
        head=linkedListSolution.removeNthFromEnd(head,n);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }

    }

}
