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

//    Reverse a singly linked list.
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=head,q=head.next;
        while (q!=null&&p!=null){
            ListNode temp=q.next;
            q.next=p;
            p=q;
            q=temp;
        }
        head.next=null;
        return p;
    }

//    Remove all elements from a linked list of integers that have value val.
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode p=head;
        if(head.next==null&&head.val==val){
            return null;
        }
        while (p!=null&&p.next!=null){
            if(p.next.val==val){
                p.next=p.next.next;
            }else{
                p=p.next;
            }
        }
        // 此时head的值还没有判断过
        if(head.val==val){
            head=head.next;
        }
        return head;
    }

//    Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=head,q=head.next,evenStart=head.next;
        while (q!=null&&p!=null){
            if(p.next!=null){
                p.next=p.next.next;
            }
            if(q.next!=null){
                q.next=q.next.next;
            }
            p=p.next;
            q=q.next;
        }
        p=head;
        while (p.next!=null){
            p=p.next;
        }
        p.next=evenStart;
        return head;
    }

//    Given a singly linked list, determine if it is a palindrome.
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        int countNode=0;
        ListNode p=head;
        while (p!=null){
            countNode++;
            p = p.next;
        }
        int mid = (int)Math.ceil((double)countNode / 2);
        countNode=0;
        p=head;
        while (countNode!=mid){
            countNode++;
            p=p.next;
        }
        ListNode lastHalf=reverseList(p),q=lastHalf;
        p=head;
        while (q!=null){
            if(p.val!=q.val){
                return false;
            }
            q=q.next;
            p=p.next;
        }
        return true;
    }
//    Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode p=l1,q=l2;
        ListNode resHead=null;
        if(p.val<q.val){
            resHead=p;
            p=p.next;
        }else{
            resHead=q;
            q=q.next;
        }
        ListNode k=resHead;
        while (p!=null&&q!=null){
            if(p.val<q.val){
                k.next=p;
                p=p.next;
            }else {
                k.next=q;
                q=q.next;
            }
            k=k.next;
        }
        if(p!=null){
            k.next=p;
        }
        if(q!=null){
            k.next=q;
        }
        return resHead;
    }

//    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p=l1,q=l2;
        ListNode res=new ListNode((p.val+q.val)%10);
        int carrier=0;
        if(p.val+q.val>=10){
            carrier=1;
        }
        p=p.next;
        q=q.next;
        ListNode pos=res;
        while (p!=null&&q!=null){
            pos.next=new ListNode((p.val+q.val+carrier)%10);
            if(p.val+q.val+carrier>=10){
                carrier=1;
            }else {
                carrier=0;
            }
            pos=pos.next;
            p=p.next;
            q=q.next;
        }
        while (p!=null){
            pos.next=new ListNode((p.val+carrier)%10);
            if(p.val+carrier>=10){
                carrier=1;
            }else {
                carrier=0;
            }
            pos=pos.next;
            p=p.next;
        }
        while (q!=null){
            pos.next=new ListNode((q.val+carrier)%10);
            if(q.val+carrier>=10){
                carrier=1;
            }else {
                carrier=0;
            }
            pos=pos.next;
            q=q.next;
        }
        if(carrier!=0){
            pos.next = new ListNode(1);
        }
        return res;
    }

//    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//    Return a deep copy of the list.
    public Node copyRandomList(Node head) {
        Node p=head;
        // mock the node after every node
        while(p!=null){
            Node temp=new Node(p.val);
            temp.next=p.next;
            temp.random=p.random;
            p.next=temp;
            p=temp.next;
        }
        Node res=head.next;
        p=res;
        // get the new linkedlist
        while(p!=null){
            if(p.random!=null){
                p.random=p.random.next;
            }
            if(p.next!=null){
                p.next=p.next.next;
            }else{
                p.next=null;
            }
            p=p.next;
        }
        // recover the fomer linkedlist
        p=head;
        while(p.next.next!=null){
            p.next=p.next.next;
            p=p.next;
        }
        return res;
    }

//    Given a linked list, rotate the list to the right by k places, where k is non-negative.
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        int countLength=0;
        ListNode p=head;
        while (p!=null){
            countLength++;
            p=p.next;
        }
        if(k%countLength==0){
            return head;
        }
        int movePos=countLength-k%countLength;
        int count=0;
        p=head;
        while (count!=movePos-1){
            count++;
            p=p.next;
        }
        ListNode newHead=p.next;
        p.next=null;
        p=newHead;
        while (p.next!=null){
            p=p.next;
        }
        p.next=head;
        return newHead;
    }


//    将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
//    如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
//    O(n^2)
//    用while循环的时候要记得字节++i
//    分请curTail和curHead
//    https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=190&&tqId=35192&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
//         count the # of node
        int count=0;
        ListNode p=head;
        while(p!=null){
            count++;
            p=p.next;
        }
        int groupNumber=count/k;
        int curGroup=1;
        ListNode curHead=head;
        ListNode curTail;
        ListNode preTail=null;
        ListNode nextHead;
        while(curGroup<=groupNumber){
//             找到当前组的tail
            p=curHead;
            for(int i=0;i<k-1;i++){
                p=p.next;
            }
            curTail=p;
//            定位找到下一组的head
            nextHead=p.next;
//            反转curHead到curTail的链表
            reverse(curHead,curTail);
//            前一组和将当前链表的头部连起来
            if(curHead==head){
                head=curTail;
            }else{
                preTail.next=curTail;
            }
//            更新前一组的尾部为当前组的尾部
            preTail=curHead;
//            更新下一组的头部
            curHead=nextHead;
//            最后一组，之后的不用翻转了
            if(curGroup==groupNumber){
                preTail.next=curHead;
                break;
            }
            curGroup++;
        }
        return head;
    }

    public void reverse(ListNode head,ListNode tail){
        ListNode p=head,pre=null;
        while(p!=tail){
            ListNode pNext=p.next;
            p.next=pre;
            pre=p;
            p=pNext;
        }
        p.next=pre;
    }

//    两个链表生成想加链表
//    牛客
//    https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=190&&tqId=35219&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode p1=reverseList(head1);
        ListNode p2=reverseList(head2);
        int carry=0;
        ListNode newHead=null;
        while(p1!=null&&p2!=null){
            int curDigit=p1.val+p2.val+carry;
            if(curDigit>=10){
                curDigit=curDigit%10;
                carry=1;
            }else{
                carry=0;
            }
            ListNode temp=new ListNode(curDigit);
            temp.next=newHead;
            newHead=temp;
            p1=p1.next;
            p2=p2.next;
        }

        while(p1!=null){
            int curDigit=p1.val+carry;
            if(curDigit>=10){
                curDigit=curDigit%10;
                carry=1;
            }else{
                carry=0;
            }
            ListNode temp=new ListNode(curDigit);
            temp.next=newHead;
            newHead=temp;
            p1=p1.next;
        }

        while(p2!=null){
            int curDigit=p2.val+carry;
            if(curDigit>=10){
                curDigit=curDigit%10;
                carry=1;
            }else{
                carry=0;
            }
            ListNode temp=new ListNode(curDigit);
            temp.next=newHead;
            newHead=temp;
            p2=p2.next;
        }
        if(carry!=0){
            ListNode temp=new ListNode(carry);
            temp.next=newHead;
            newHead=temp;
        }
        return newHead;
    }
}
