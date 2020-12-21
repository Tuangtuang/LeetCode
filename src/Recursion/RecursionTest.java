package Recursion;


import java.util.ArrayList;
import java.util.LinkedList;
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


    public void testIsValidBST(){
        System.out.println("\nTest Is Valid BST...");
        TreeNode t = TreeNode.InitTree(new Integer[]{10, 5, 15, null, null, 6, 20});
        System.out.println(recursionSolution.isValidBST(t));
    }

    public void testSearchMatrix(){
        System.out.println("\nTest Search Matrix...");
        int [][]arr=new int[1][3];
        arr[0][0]=1;
        arr[0][1]=3;
        arr[0][2]=5;
        System.out.println(recursionSolution.searchMatrix(arr,1));
    }

    public void testQueen2(){
        System.out.println("\nTest Queen 2...");
        System.out.println(recursionSolution.totalNQueens(4));

    }


    public void testSolveSudoku(){
        System.out.println("\nTest Solve Sudoku...");
        char [][]arr=new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        recursionSolution.solveSudoku(arr);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    public void testCombine(){
        System.out.println("\nTest Combine...");
        List<List<Integer>> res = new LinkedList<>();
        res = recursionSolution.combine(4, 2);
        for(List<Integer> i:res){
            for(Integer j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }


    public void testgenerateParentheses(){
        System.out.println("\nTest Generate Parentheses...");
        List<String> res = recursionSolution.generateParenthesis(3);
        for(String i:res){
            System.out.println(i);
        }
    }


    public void testPermutation(){
        System.out.println("\nTest Permutation...");
        int []nums=new int[]{1,2,3};
        List<List<Integer>> res = new LinkedList<>();
        res = recursionSolution.permute(nums);
        for(List<Integer> l:res){
            for(Integer item:l){
                System.out.print(item+" ");
            }
            System.out.println();
        }
    }

    public void testBinaryWatch(){
        System.out.println("\nTest Binary Watch...");
        List<String> res = recursionSolution.readBinaryWatch(2);
        for(String item:res){
            System.out.println(item);
        }
    }

    public void testCombination(){
        System.out.println("\nTest Combination Test...");
        int []arr=new int[]{1,2,3};
        List<ArrayList<Integer>> res=recursionSolution.combine(arr);
        for(ArrayList<Integer> curList:res){
            for(Integer item:curList){
                System.out.print(item+" ");
            }
            System.out.println();
        }
    }
}
