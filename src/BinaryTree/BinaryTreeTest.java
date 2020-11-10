package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTest {

    public void preorderTraversalTest(){
        System.out.println("\nTest Preorder Traversal...");
        BinaryTreeSolution binaryTreeSolution = new BinaryTreeSolution();
        Integer arr[] = new Integer[]{1,null,2,3};
        TreeNode root = TreeNode.InitTree(arr);
        List<Integer> res=binaryTreeSolution.preorderTraversal(root);
        for(Integer item:res){
            System.out.print(item+" ");
        }
        System.out.println();
    }


    public void postorderTraversalTest(){
        System.out.println("\nTest Preorder Traversal...");
        BinaryTreeSolution binaryTreeSolution = new BinaryTreeSolution();
        Integer arr[] = new Integer[]{1,null,2,3};
        TreeNode root = TreeNode.InitTree(arr);
        List<Integer> res=binaryTreeSolution.postorderTraversal(root);
        for(Integer item:res){
            System.out.print(item+" ");
        }
        System.out.println();
    }


    public void testLevelOrder(){
        System.out.println("\nTest Level Order...");
        BinaryTreeSolution binaryTreeSolution = new BinaryTreeSolution();
        Integer arr[] = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.InitTree(arr);
        List<List<Integer>> res = binaryTreeSolution.levelOrder(root);
        for(List<Integer> line: res){
            for(Integer item: line){
                System.out.print(item+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void testHasPathSum(){
        System.out.println("\nTest Has Path Sum...");
        BinaryTreeSolution binaryTreeSolution = new BinaryTreeSolution();
        Integer[] arr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeNode.InitTree(arr);
        System.out.println(binaryTreeSolution.hasPathSum(root,22));

    }


    public void testBuildTree(){
        System.out.println("\nTest Build Tree...");
        BinaryTreeSolution binaryTreeSolution = new BinaryTreeSolution();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode node = binaryTreeSolution.buildTree(inorder, postorder);
        TreeOperation.show(node);
    }


    public void testConnect(){
        System.out.println("\nTest Connect...");
        BinaryTreeSolution binaryTreeSolution=new BinaryTreeSolution();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Node root = Node.InitTree(arr);
        binaryTreeSolution.connect(root);
    }

}
