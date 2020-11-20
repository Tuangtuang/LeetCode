package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
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
        if (head == null || head.next == null) {
            return head;
        }
//        reverse(1->2->3) = 1->reverse(2->3)
        ListNode lastNode = reverseList(head.next);
//        1 and (3->2); and 1 is pointed to 2, 2 is pointed to null, so we need to make 2 point to 1
        head.next.next = head;
//        make 1 point to null
        head.next = null;
//        last node is 3, we don't do any modification when recursion
        return lastNode;
    }

    //    Search in a Binary Search Tree
//    问题1）返回值问题，在左边找到就返回左子树的根，右边就返回右子树的根，而不是返回root
//    o(logn),n=depth
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (val < root.val) {
//        find left tree
            return searchBST(root.left, val);
        } else {
//        find right tree
            return searchBST(root.right, val);
        }
    }

    //    Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
//    时间复杂度O(n) 空间复杂度O(n^2)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.clear();
        if (rowIndex == 0) {
            res.add(1);
            return res;
        }
        if (rowIndex == 1) {
            res.add(1);
            res.add(1);
            return res;
        }
        List<Integer> lastRow = getRow(rowIndex - 1);
        res.add(1);
//        f(i,j)=f(i-1,j-1)+f(i-1,j) 当前行的第i个元素是上一行i-1个元素和i个元素之和
        for (int i = 1; i < rowIndex; i++) {
            res.add(lastRow.get(i - 1) + lastRow.get(i));
        }
        res.add(1);
        return res;
    }

    //    Fibonacci Number with memory
    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int[] cacheArr = new int[N + 1];
        for (int i = 3; i < N + 1; i++) {
            cacheArr[i] = -1;
        }
        cacheArr[1] = 1;
        cacheArr[2] = 1;
        return fibHelper(N, cacheArr);
    }

    public int fibHelper(int n, int[] cache) {
        if (n < 2) {
            return n;
        }
        int res = 0;
        if (cache[n] != -1) {
            res = cache[n];
        } else {
            res = fibHelper(n - 1, cache) + fibHelper(n - 2, cache);
        }
        return res;
    }


    //     f(n)=f(n-1)+f(n-2)
//     f(1)=1;f(2)=2
//    Climbing Stairs
    public int climbStairs(int n) {
//         注意初始化，否则下面的cache[0/1/2]越界
        if (n <= 2) {
            return n;
        }
        int[] cache = new int[n + 1];
//         base case
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            cache[i] = -1;
        }
        return climbStairsHelper(n, cache);

    }

    public int climbStairsHelper(int n, int[] cache) {
        int res = 0;
        if (cache[n] != -1) {
            res = cache[n];
        } else {
            res = climbStairsHelper(n - 1, cache) + climbStairsHelper(n - 2, cache);
            cache[n] = res;
        }
        return res;
    }

    //    Maximum Depth of Binary Tree
//    Tail recursion
//    时间复杂度O(2^n),n是层数
//    空间复杂度O(2^n)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // int leftMax=maxDepth(root.left);
        // int rightMax=maxDepth(root.right);
        // return Math.max(leftMax,rightMax)+1;

        return maxDepthHelper(root, 0, -1);
    }

    public int maxDepthHelper(TreeNode root, int depth, int maxDepth) {
        if (root == null) {
            return maxDepth;
        }
        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
        }
//        问题：
//        maxDepth=... 加和不加的区别，如果不加，下层的maxDepth没有返回上来？
        maxDepth = maxDepthHelper(root.left, depth, maxDepth);
        maxDepth = maxDepthHelper(root.right, depth, maxDepth);
        return maxDepth;
    }

    //    Pow(x, n)
//    快速幂
//    时间复杂度O(logn),空间复杂度O(logn)
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n % 2 == 0) {
//            防止stack overflow
            double tmp = myPow(x, n / 2);
            return tmp * tmp;
        } else {
            double tmp = myPow(x, (n - 1) / 2);
            return tmp * tmp * x;
        }
    }

//    Merge Two Sorted Lists
//    Recursion
//    问题1)递归关系，l1.next=mergeTwoLists(l1.next,l2);递归回来之后需要和上层的末尾节点连接
//    时间复杂度1）O(n) 2)空间复杂度O(n)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        } else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

//    K-th Symbol in Grammar
//    复杂度：时间O(n),空间O(n)
//    递推：f(n,k)=f(n-1,k), if k<=node(which is 2^(n-1))/2, 前半部分是上一行的照抄
//               =inverse(f(n-1,k-node)), if k>node, 后半部分是上一行取反
//    问题1）下标从1开始，注意解决后半部分的下标
    public int kthGrammar(int N, int K) {
        return kthGrammar(N,K,(int)Math.pow(2,N-1));
    }

    public int kthGrammar(int n, int k, int nodeCount){
        if(k<1||k>nodeCount){
            return -1;
        }
        if(n<1){
            return -1;
        }
        if(n==1){
            return 0;
        }

        if(k<=nodeCount/2){
            return kthGrammar(n-1,k,nodeCount/2);
        }else{
            return inverse(kthGrammar(n-1,k-nodeCount/2,nodeCount/2));
        }
    }

    public int inverse(int x){
        if(x==0){
            return 1;
        }
        if(x==1){
            return 0;
        }
        return -1;
    }


//    Unique Binary Search Trees I
//    当前节点为i
//    [1,i-1]left tree roots list; [i+1,n]right tree roots list
//    循环走left tree root lists 和right tree root list，分别分配给root的左右
//    时间复杂卡特兰数
    public List<TreeNode> generateTrees(int n) {
//        corner case
        if(n==0){
            return new LinkedList<>();
        }
        LinkedList[][] cache = new LinkedList[n + 1][n + 1];
        return buildTree(1,n,cache);
    }


    public LinkedList<TreeNode> buildTree(int start, int end,LinkedList [][]cache){
        LinkedList<TreeNode> res=new LinkedList<>();
        if(start>end){
            res.add(null);
            return res;
        }
//        已经算过了以start到end所有i为根节点的树
        if(cache[start][end]!=null){
            return cache[start][end];
        }
//        分割子问题
        for(int i=start;i<=end;i++){
            LinkedList<TreeNode> leftList=buildTree(start,i-1,cache);

            LinkedList<TreeNode> rightList=buildTree(i+1,end,cache);
//          合并子问题的解
            for(TreeNode k:leftList){
                for(TreeNode p:rightList){
                    TreeNode root=new TreeNode(i);
                    root.left=k;
                    root.right=p;
                    res.add(root);
                }
            }
        }
        cache[start][end]=res;
        return res;
    }


}
