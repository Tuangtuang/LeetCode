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

    // create random linked list


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
        System.out.println();
    }

    public void testReverseList(){
        System.out.println("\nTest Reverse List...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums=new int[]{1,2};
        ListNode head=createLinkedList(nums,-1);
//        while (head!=null){
//            System.out.print(head.val+" ");
//            head=head.next;
//        }
        head = linkedListSolution.reverseList(head);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }


    public void testRemoveElements(){
        System.out.println("\nTest Remove Elements...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums=new int[]{1,1};
        ListNode head=createLinkedList(nums,-1);
        head = linkedListSolution.removeElements(head, 1);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }


    public void testOddEvenList(){
        System.out.println("\nTest Odd Even List...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums=new int[]{1,2,3,4};
        ListNode head=createLinkedList(nums,-1);
        head = linkedListSolution.oddEvenList(head);

        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }

    public void testIsPalindrome(){
        System.out.println("\nTest Is Palindrome...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums=new int[]{1,2,2,1};
        ListNode head=createLinkedList(nums,-1);
        System.out.println(linkedListSolution.isPalindrome(head));
    }

    public void testMergeTwoLists(){
        System.out.println("\nMerge Two Lists...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums1=new int[]{1,2,3};
        ListNode head1=createLinkedList(nums1,-1);
        int []nums2=new int[]{1,3};
        ListNode head2=createLinkedList(nums2,-1);
        ListNode head = linkedListSolution.mergeTwoLists(head1, head2);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();

    }


    public void testAddTwoNumbers(){
        System.out.println("\nMerge Two Numbers...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums1=new int[]{9,9};
        ListNode head1=createLinkedList(nums1,-1);
        int []nums2=new int[]{1,8,9,9};
        ListNode head2=createLinkedList(nums2,-1);
        ListNode head=linkedListSolution.addTwoNumbers(head1,head2);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();

    }

    public void testCopyRandomList(){
        System.out.println("\nCopy Random Lists...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums1=new int[]{9,9};

    }

    public void testRotateRight(){
        System.out.println("\nCopy Random Lists...");
        LinkedListSolution linkedListSolution=new LinkedListSolution();
        int []nums=new int[]{1,2};
        ListNode head=createLinkedList(nums,-1);
        head=linkedListSolution.rotateRight(head,2);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }

}
