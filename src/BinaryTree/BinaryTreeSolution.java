package BinaryTree;

import java.util.*;

public class BinaryTreeSolution {

//  Binary Tree Preorder Traversal
//    Recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorderTraversalHelper(root,res);
        return res;
    }

    public void preorderTraversalHelper(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        res.add(root.val);
        preorderTraversalHelper(root.left,res);
        preorderTraversalHelper(root.right,res);
    }


//    Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> reslut = new ArrayList<>();
        if (root == null) {
            return reslut;
        }
        TreeNode p = root;
        TreeNode pVisit = null;
        Stack<TreeNode> stk = new Stack<>();
        stk.add(p);

        while (!stk.isEmpty()) {
            //只要你有左孩子，就将左孩子压入栈中
            if (p != null && p.left != null) {
                stk.add(p.left);
                p = p.left;
            } else {
                //栈顶元素，先出栈，可能还有右孩子
                p = stk.peek();
                if (p.right == null || p.right == pVisit) {
                    //如果没有右孩子或右孩子已经访问过了，出栈
                    reslut.add(p.val);
                    //这个很重要，考虑一下只有右孩子的树，得不断的回溯
                    pVisit = p;
                    //没有新节点加入，继续进行出栈操作
                    p = null;
                    stk.pop();
                } else {
                    //如果有右孩子，右孩子入栈
                    pVisit = p.right;
                    stk.add(p.right);
                    p = p.right;
                }
            }
        }
        return reslut;
    }

//    Binary Tree Level Order Traversal
//    O(n)
//    1) 注意层和层之间标识位什么时候放，放的条件 2）左右孩子是null时，不做插入
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode tagNode = new TreeNode(-1);
        q.add(root);
        q.add(tagNode);
        List<Integer> line=new ArrayList<>();
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur==tagNode){
                res.add(line);
                line = new ArrayList<>();
                if(!q.isEmpty()){
                    q.add(tagNode);
                }
            } else{
                line.add(cur.val);
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }

            }
        }
        return res;
    }

//  想到调整递归的参数，helper函数；本题涉及到两棵子树的对称关系
//    bottom up
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return t1.val == t2.val && isSymmetricHelper(t1.left, t2.right) && isSymmetricHelper(t1.right, t2.left);
    }

//  Path Sum
//  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//    "Top-down" Solution
//    O(n)
//    递归回到原来层时，curSum不需要减去root.val
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumHelper(root, sum, 0);
    }

    public boolean hasPathSumHelper(TreeNode root,int targetSum,int curSum){
        if(root==null){
            return false;
        }
        curSum += root.val;
        if(root.left==null&&root.right==null){
            return targetSum == curSum;
        }
        boolean leftResult=hasPathSumHelper(root.left, targetSum, curSum);
        boolean rightResult=hasPathSumHelper(root.right, targetSum, curSum);
        return leftResult||rightResult;

    }

//    Construct Binary Tree from Inorder and Postorder Traversal
//    Given inorder and postorder traversal of a tree, construct the binary tree.
//    top-down recursion
//    1) 最后一位-1，注意数组越界 2）在post order中找左右子树的方法，通过下标加减
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder==null||postorder==null){
            return null;
        }
        if(inorder.length!=postorder.length){
            return null;
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode buildTreeHelper(int []inorder, int []postorder,int startInorder,int endInorder,int startPostOrder,int endPostOrder){
        if(startInorder>endInorder||startPostOrder>endPostOrder){
            return null;
        }
        TreeNode root = new TreeNode(postorder[endPostOrder]);
//        find root val in inorder and divide the inorder
        int i=0;
        for(;i<inorder.length;i++){
            if(inorder[i]==root.val){
                break;
            }
        }
//        build left tree
        root.left=buildTreeHelper(inorder,postorder,startInorder,i-1,startPostOrder,startPostOrder+i-startInorder-1);
//        build right tree
        root.right = buildTreeHelper(inorder, postorder, i + 1, endInorder,startPostOrder+i-startInorder,endPostOrder-1);
        return root;

    }

//    Populating Next Right Pointers in Each Node
//    Recursion(top-down)
//    问题1）左子树的最右边需要和右子树的最左边连接，此时next=parent.next.left
//    2）parent.next.left可能是null,此时不需要为右子树最右边，不需要连接
//    3）考虑输入是[]的情况，别忘了加判断
//    时间复杂度：O(n) 空间：O(1)
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        if(root.left==null&&root.right==null){
            return root;
        }

        root.left.next=root.right;
        if(root.next!=null){
            root.right.next=root.next.left;
        }else{
            root.right.next=null;
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

//  问题1）先建右边的树再建左边的树，eg：【2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7】扫描时如果右边的树没建好，无法找到应该有的左子树的next
//    2）不是full binary tree，可能会缺孩子，next可能再右边的右边，需要扫描parent的同层，找到parent.child.next
//    top-bottom
    public Node connect2(Node root) {
        if(root==null){
            return null;
        }
//        leaves
        if(root.left==null&&root.right==null){
            return root;
        }
//        search next
        Node p=root;
        Node curNext=null;
        while (p!=null){
            p=p.next;
            if(p!=null&&p.left!=null){
                curNext = p.left;
                break;
            }
            if(p!=null&&p.right!=null){
                curNext = p.right;
                break;
            }
        }
        if(root.left!=null&&root.right!=null){
            root.left.next = root.right;
            root.right.next = curNext;
        }

        if(root.left!=null&&root.right==null){
            root.left.next=curNext;
        }

        if(root.left==null){
            root.right.next = curNext;
        }
        connect2(root.right);
        connect2(root.left);
        return root;
    }

//    Lowest Common Ancestor of a Binary Tree
//    思路：1）在left subtree中找lowestCommonAncestor，没找到说明在右边
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
//        查找CommonAncestor是否在左边
        TreeNode leftCommonAncestor = lowestCommonAncestor(root.left, p, q);
//        查找CommonAncestor是否在右边
        TreeNode rightCommonAncestor = lowestCommonAncestor(root.right, p, q);
//        左边没有，一定在右边
        if(leftCommonAncestor==null){
            return rightCommonAncestor;
        }
//        右边没有，一定在左边
        if(rightCommonAncestor==null){
            return leftCommonAncestor;
        }
//        都没有，CommonAncestor就是根结点
        return root;
    }

//  牛客，重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTreeHelper(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode reConstructBinaryTreeHelper(int [] pre,int preStart, int preEnd,
                                                int [] in, int inStart, int inEnd) {
// TODO 注意点：递归出口写作最前面，而不是new TreeNode 写在最前面
        if(preStart>preEnd){
            return null;
        }
        if(inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(pre[preStart]);
        int mid=0;
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==pre[preStart]){
                mid=i;
                break;
            }
        }
        root.left = reConstructBinaryTreeHelper(pre, preStart+1 ,preStart+(mid-inStart),
                in, inStart, mid-1);
        root.right = reConstructBinaryTreeHelper(pre, preStart+1+(mid-inStart), preEnd,
                in, mid+1, inEnd);
        return root;

    }




}
