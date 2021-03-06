package Sort;


public class SortTest {

    public SortSolution sortSolution = new SortSolution();
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

    public void testSortInList(){
        System.out.println("Test In Sort...");
        ListNode head=createLinkedList(new int[]{3,2,1},-1);
        head=sortSolution.sortInList(head);
        ListNode p=head;
        while (p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }

    }
}
