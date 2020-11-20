package Recursion;


import java.util.List;

public class RecursionTest {
    RecursionSolution recursionSolution=new RecursionSolution();

    // create linked list by arrays
    public ListNode createLinkedList(int []nums, int pos){
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

    public void printLinkedList(ListNode head){
        ListNode p=head;
        while (p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
        return;
    }

    public void testSwapPairs(){
        System.out.println("\nTest Swap Pairs...");
        int[] arr = new int[]{1, 2, 3};
        ListNode head = createLinkedList(arr,-1);
        head=recursionSolution.swapPairs(head);
        printLinkedList(head);
    }

    public void testReverseList(){
        System.out.println("\nTest Reverse List...");
        RecursionSolution linkedListSolution=new RecursionSolution();
        int []nums=new int[]{1,2,3};
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

    public void testFib(){
        System.out.println("\nTest Fib...");
        int res=recursionSolution.fib(3);
        System.out.println(res);
    }


    public void testMyPow(){
        System.out.println("\nTest My Pow...");
        double res = recursionSolution.myPow(0.1, 2147483647);
        System.out.println(res);
    }


    public void testGenerateTrees(){
        System.out.println("\nTest Generate Trees...");
        List<TreeNode> res = recursionSolution.generateTrees(2);
        for(TreeNode t:res){
            TreeOperation.show(t);
            System.out.println();
        }
    }


}
