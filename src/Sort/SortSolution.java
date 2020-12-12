package Sort;

public class SortSolution {
//    牛客，链表的选择排序
    public ListNode sortInList (ListNode head) {
        // write code here
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=null;
        while(head!=null){
            ListNode maxNode=head;
            ListNode maxNodePre=null;
            ListNode p=head.next;
            ListNode pPre=head;
//            只剩一个了，加到新链表中，直接break
            if(head.next==null){
                head.next=newHead;
                newHead=head;
                break;
            }
//            ListNode newHead=null;
            while(p!=null){
                if(maxNode.val<p.val){
                    maxNode=p;
                    maxNodePre=pPre;
                }
                p=p.next;
                pPre=pPre.next;
            }
//         add the maxNode to the new List
//         and delete the head from the original list
            if(maxNode==head){
                head=maxNode.next;
            }
            if(newHead==null){
                newHead=maxNode;
                if(maxNodePre!=null){
                    maxNodePre.next=maxNode.next;
                }
                maxNode.next=null;
            }else{

                if(maxNodePre!=null){
                    maxNodePre.next=maxNode.next;
                }
                maxNode.next=newHead;
                newHead=maxNode;
            }
        }
        return newHead;
    }
}
