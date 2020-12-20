package Recursion;

import java.util.*;

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
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //    K-th Symbol in Grammar
//    复杂度：时间O(n),空间O(n)
//    递推：f(n,k)=f(n-1,k), if k<=node(which is 2^(n-1))/2, 前半部分是上一行的照抄
//               =inverse(f(n-1,k-node)), if k>node, 后半部分是上一行取反
//    问题1）下标从1开始，注意解决后半部分的下标
    public int kthGrammar(int N, int K) {
        return kthGrammar(N, K, (int) Math.pow(2, N - 1));
    }

    public int kthGrammar(int n, int k, int nodeCount) {
        if (k < 1 || k > nodeCount) {
            return -1;
        }
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }

        if (k <= nodeCount / 2) {
            return kthGrammar(n - 1, k, nodeCount / 2);
        } else {
            return inverse(kthGrammar(n - 1, k - nodeCount / 2, nodeCount / 2));
        }
    }

    public int inverse(int x) {
        if (x == 0) {
            return 1;
        }
        if (x == 1) {
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
        if (n == 0) {
            return new LinkedList<>();
        }
        LinkedList[][] cache = new LinkedList[n + 1][n + 1];
        return buildTree(1, n, cache);
    }


    public LinkedList<TreeNode> buildTree(int start, int end, LinkedList[][] cache) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
//        已经算过了以start到end所有i为根节点的树
        if (cache[start][end] != null) {
            return cache[start][end];
        }
//        分割子问题
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftList = buildTree(start, i - 1, cache);

            LinkedList<TreeNode> rightList = buildTree(i + 1, end, cache);
//          合并子问题的解
            for (TreeNode k : leftList) {
                for (TreeNode p : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = k;
                    root.right = p;
                    res.add(root);
                }
            }
        }
        cache[start][end] = res;
        return res;
    }


    //     merge sort
//     recursion time logN
//     in every recursion, we have a merge, O(n)
//     total O(logN)
    public int[] sortArray(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int mid = (0 + nums.length) / 2;
//         sort the left one
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
//         sort the right one
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
//         merge the two ordered lists
        return merge(left, right);

    }

    public int[] merge(int[] leftList, int[] rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }
        int[] res = new int[leftList.length + rightList.length];
        int i = 0, j = 0, k = 0;
        while (i < leftList.length && j < rightList.length) {
            if (leftList[i] < rightList[j]) {
                res[k] = leftList[i];
                i++;
                k++;
            } else {
                res[k] = rightList[j];
                j++;
                k++;
            }
        }
//         left list remain
        while (i < leftList.length) {
            res[k] = leftList[i];
            i++;
            k++;
        }
//         right list remain
        while (j < rightList.length) {
            res[k] = rightList[j];
            j++;
            k++;
        }
        return res;
    }


    //    Validate Binary Search Tree
//    Divide and Conquer
//    问题1）设置upper bound和lower bound 来保证所有左边的数都小于root.val和保证所有右边的数都大于root.val，注意upper和lower的更新
    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null && root.right.val <= root.val) {
            return false;
        }
        if (root.right == null && root.left.val >= root.val) {
            return false;
        }
//        divide to left and right
        return isValidBSTHelper(root.left, root.val, null) && isValidBSTHelper(root.right, null, root.val);

    }

    public boolean isValidBSTHelper(TreeNode root, Integer upperBound, Integer lowerBound) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
//        all the numbers in the left tree must be less than root.val
//        all the numbers in the right tree must be larger than root.val
        if (upperBound != null && root.val >= upperBound || lowerBound != null && root.val <= lowerBound) {
            return false;
        }
//          left sub-problem
//        the upper bound is the new root val, the lower bound is the same as the last level
        boolean isValidLeft = isValidBSTHelper(root.left, root.val, lowerBound);
//          right sub-problem
//        the lower bound is the new root val, the upper bound is the same as the last level
        boolean isValidRight = isValidBSTHelper(root.right, upperBound, root.val);
//          combine left and right
        return isValidLeft && isValidRight;
    }


    //  问题1）递归，注意下标变化，对于mid对应的行列，需要分别划给第一，第三象限
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null) {
//             only with col
            return false;
        }

        return searchMatrixHelper(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    public boolean searchMatrixHelper(int[][] matrix, int target, int start_x, int start_y, int end_x, int end_y) {
        if (start_x < 0 || start_y < 0 || start_x >= matrix.length || start_y >= matrix[0].length) {
            return false;
        }
        if (end_x < 0 || end_y < 0 || end_x >= matrix.length || end_y >= matrix[0].length) {
            return false;
        }
        if (start_x > end_x || start_y > end_y) {
            return false;
        }
        int midRow = (start_x + end_x) / 2;
        int midCol = (start_y + end_y) / 2;
        if (matrix[midRow][midCol] == target) {
            return true;
        } else if (matrix[midRow][midCol] < target) {
            return searchMatrixHelper(matrix, target, midRow + 1, midCol + 1, end_x, end_y) ||
                    searchMatrixHelper(matrix, target, start_x, midCol + 1, midRow, end_y) ||
                    searchMatrixHelper(matrix, target, midRow + 1, start_y, end_x, midCol);
        } else {
            return searchMatrixHelper(matrix, target, start_x, start_y, midRow - 1, midCol - 1) ||
                    searchMatrixHelper(matrix, target, start_x, midCol, midRow - 1, end_y) ||
                    searchMatrixHelper(matrix, target, midRow, start_y, end_x, midCol - 1);
        }

    }


    int count;

    //  N-Queens II
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] solution = new int[n];
//        n max is 9, -10 表示不可达
        for (int i = 0; i < n; i++) {
            solution[i] = -10;
        }
        totalNQueensHelper(0, n, solution);
        return count;
    }


    public void totalNQueensHelper(int row, int n, int[] res) {
//        找到一个解
        if (row >= n) {
            count++;
        } else {
//            尝试放第row行的每个位置
            for (int col = 0; col < n; col++) {
//                 can be placed
                if (is_not_under_attack(row, col, res)) {
//                    表示[row,col]行放上了一个皇后
                    res[row] = col;
                    totalNQueensHelper(row + 1, n, res);
//                    取下来，尝试下一个位置
                    res[row] = -10;
                }
            }
        }
        return;
    }

    //     check whther under attack
    public boolean is_not_under_attack(int x, int y, int[] res) {
        for (int i = 0; i < res.length; i++) {
//            i表示横坐标，res[i]表示纵坐标
//            横纵坐标差值相同，表示对角线
//            y == res[i]表示同一列
            if (Math.abs(i - x) == Math.abs(y - res[i]) || y == res[i]) {
                return false;
            }
        }
        return true;
    }


    //    数独
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
    }

    public boolean solveSudokuHelper(char[][] board, int row, int col) {
//        行末，换行
        if (col >= 9) {
            row++;
            col = 0;
        }
//          完成
        if (row >= 9) {
            return true;
        }

        if (board[row][col] != '.') {
            return solveSudokuHelper(board, row, col + 1);
        }

        for (char tar = '1'; tar <= '9'; tar++) {
            board[row][col] = tar;
//            可以放tar并且，接下来有解
            if (check_line(board, tar, row, col)
                    && check_col(board, tar, row, col)
                    && check_grid(board, tar, row, col)
                    && solveSudokuHelper(board, row, col + 1)) {
                return true;

            }
//            放不了，恢复原样
            board[row][col] = '.';
        }

        return false;
    }

    public boolean check_line(char[][] board, char target, int row, int col) {
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == target && j != col) {
                return false;
            }
        }
        return true;
    }


    public boolean check_col(char[][] board, char target, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == target && i != row) {
                return false;
            }
        }
        return true;
    }


    public boolean check_grid(char[][] board, char target, int row, int col) {
//         get start point
        int x = (row / 3) * 3;
        int y = (col / 3) * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == target && i != row && j != col) {
                    return false;
                }
            }
        }
        return true;
    }


    List<List<Integer>> res = new LinkedList<>();
    List<Integer> a = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        ArrayDeque<Integer> tmp = new ArrayDeque<>();
        combineHelper(n, k, 0, tmp);
        return res;
    }

    public void combineHelper(int n, int k, int level, ArrayDeque<Integer> temp) {
//        total number in the list must <k
        if (level >= k) {
//            find one solution
            res.add(new LinkedList<>(temp));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isValid(i, temp)) {
//                add current i
                temp.add(i);
//                find next
                combineHelper(n, k, level + 1, temp);
//                remove added one
                temp.removeLast();
            }
        }
    }

    public boolean isValid(int i, ArrayDeque<Integer> res) {
        if (res.size() == 0) {
            return true;
        }
        for (Integer item : res) {
            if (item >= i) {
                return false;
            }
        }
        return true;
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!isSameNode(p, q)) {
            return false;
        }
        ArrayDeque<TreeNode> queueP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> queueQ = new ArrayDeque<TreeNode>();
        queueP.addFirst(p);
        queueQ.addFirst(q);
        while (!queueP.isEmpty()) {
            TreeNode curP = queueP.removeFirst();
            TreeNode curQ = queueQ.removeFirst();
            if (!isSameNode(curP, curQ)) {
                return false;
            }
//            case: curP is not null, curQ is null is returned
//            so we can make sure, if curP is not null, curQ must be not null
            if (curP != null) {
//                compare left child,
//                if not same, return
                if (!isSameNode(curP.left, curQ.left)) {
                    return false;
                }
//                case curP.left is not null, curQ.left is null is returned on the last line
                if (curP.left != null) {
                    queueP.addLast(curP.left);
                    queueQ.addLast(curQ.left);
                }
                if (!isSameNode(curP.right, curQ.right)) {
                    return false;
                }
                if (curP.right != null) {
                    queueP.addLast(curP.right);
                    queueQ.addLast(curQ.right);
                }
            }
        }
        return true;
    }

    public boolean isSameNode(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return true;
    }


    //    Generate Parentheses
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generate(res, 0, 0, n, "");
        return res;
    }

    public void generate(List<String> res, int left, int right, int n, String cur) {
        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }

        if (left < n) {
            generate(res, left + 1, right, n, cur + "(");
        }
        if (right < left) {
            generate(res, left, right + 1, n, cur + ")");
        }
    }

    //    Permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> temp = new LinkedList();
        boolean[] visited = new boolean[nums.length];
        permuteHelper(nums, 0, temp, ans, visited);
        return ans;
    }


    public void permuteHelper(int[] nums, int start, List<Integer> cur, List<List<Integer>> res, boolean[] visited) {
        if (start >= nums.length) {
            res.add(new LinkedList(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                permuteHelper(nums, start + 1, cur, res, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }

        }

        return;
    }


    public List<String> letterCombinations(String digits) {
//         init phone board
        String[] mappings = initMapping();
        List<String> ans = new LinkedList<>();
//         corner case
        if (digits.length() == 0) {
            return ans;
        }
        StringBuilder cur = new StringBuilder();
        letterCombinationsHelper(digits, 0, mappings, ans, cur);
        return ans;

    }

    public void letterCombinationsHelper(String digits, int curPos, String[] mappings, List<String> res, StringBuilder cur) {
        if (curPos >= digits.length()) {
//             find a word
            res.add((cur.toString()));
            return;
        }
//         get the letters related  to the number
        String letters = mappings[digits.charAt(curPos) - '0'];
        for (int i = 0; i < letters.length(); i++) {
//             put letter
            cur.append(letters.charAt(i));
//             next letter in the word
            letterCombinationsHelper(digits, curPos + 1, mappings, res, cur);
//             delete the letter in the cur level, find next one
            cur.deleteCharAt(cur.length() - 1);
        }

    }

    public String[] initMapping() {
        String[] mapping = new String[10];
        for (int i = 2; i <= 6; i++) {
            StringBuilder temp = new StringBuilder();
            for (char c = (char) ((int) 'a' + (i - 2) * 3); c <= (int) 'a' + (i - 2) * 3 + 2; c++) {
                temp.append(c);
            }
            mapping[i] = temp.toString();
        }
        mapping[7] = "pqrs";
        mapping[8] = "tuv";
        mapping[9] = "wxyz";

        return mapping;
    }

//    Binary Watch
int []hourChoice=new int[]{1,2,4,8};
    boolean []visitedHour=new boolean[4];
    int []minuteChoice=new int[]{1,2,4,8,16,32};
    boolean []visitedMinute=new boolean[6];
    public List<String> readBinaryWatch(int num) {
        List<String> res=new LinkedList<>();
        if(num==0){
            res.add("0:00");
            return res;
        }
        for(int i=0;i<=num;i++){
//            if choose all numbers in the hours, the hours will exceed 11
//            if choose all numbers in the minutes, the minutes will exceed 59
            if(i>=4||num-i>=6){
                continue;
            }
//            why use set
//            can be redundant when choose 1,2 and 2,1
            Set<Integer> hours=new HashSet<>();
            getHours(i,0,0,hours);
            Set<Integer> minutes=new HashSet<>();
            getMinutes(num-i,0,0,minutes);
//            multiple theory
            for(Integer h:hours){
                for(Integer m:minutes){
                    StringBuilder temp=new StringBuilder(h+":");
                    if(m<10){
                        temp.append("0"+m);
                    }else{
                        temp.append(""+m);
                    }
                    res.add(temp.toString());
                }
            }
        }
        return res;
    }

//    combination of hours
//    in 1,2,4,8 select "numberHour" numbers
    public void getHours(int numHour, int curNum, int curHour, Set<Integer> hourList){
        if(curNum>=numHour){
            if(curHour<=11){
                hourList.add(curHour);
            }
            return;
        }
        for(int i=0;i<hourChoice.length;i++){
            if(!visitedHour[i]){
                curHour+=hourChoice[i];
                visitedHour[i]=true;
                getHours(numHour,curNum+1,curHour,hourList);
                curHour-=hourChoice[i];
                visitedHour[i]=false;
            }
        }
        return;
    }

//    combination of minutes
//    in 1,2,4,8,16,32, select "numMinute" numbers
    public void getMinutes(int numMinute, int curNum, int curMinute, Set<Integer> miniuteList){
        if(curNum>=numMinute){
            if(curMinute<=59){
                miniuteList.add(curMinute);
            }
            return;
        }
        for(int i=0;i<minuteChoice.length;i++){
            if(!visitedMinute[i]){
                curMinute+=minuteChoice[i];
                visitedMinute[i]=true;
                getMinutes(numMinute,curNum+1,curMinute,miniuteList);
                curMinute-=minuteChoice[i];
                visitedMinute[i]=false;
            }
        }
        return;
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        allPathsSourceTargetHelper(graph,0,graph.length-1,path,res);
        return res;
    }

    public void allPathsSourceTargetHelper(int [][] graph, int curPos, int targetPos, List<Integer> curPath, List<List<Integer>> res){
        if(curPos==targetPos){
            res.add(new ArrayList<Integer>(curPath));
            return;
        }
//        i start with 0
//        for every line in graph, we should try every node in this line
        for(int i=0;i<graph[curPos].length;i++){
//             add a node to the path
            curPath.add(graph[curPos][i]);
//             find next node
            allPathsSourceTargetHelper(graph,graph[curPos][i],targetPos,curPath,res);
//             remove cur node try new start
            curPath.remove(curPath.size()-1);
        }
        return;
    }


    char []vowelList=new char[]{'a','e','i','o','u'};
    public int countVowelStrings(int n) {
//        'A' randomly pick a char<'a'
        countVowelStringsHelper(n,0,'A');
        return count;
    }

    public void countVowelStringsHelper(int num, int curNum, char lastChar){
//        find a solution
        if(curNum>=num){
            count++;
            return ;
        }
        for(int i=0;i<vowelList.length;i++){
            if(isValid(lastChar,vowelList[i])){
//                last char is the new one
                lastChar=vowelList[i];
//                count next level
                countVowelStringsHelper(num,curNum+1,lastChar);
//                recover the last char
                if(i-1>=0){
                    lastChar=vowelList[i-1];
                }else{
                    lastChar='A';
                }
            }

        }
        return ;
    }

    public boolean isValid(char lastChar, char c){
//        only care about last char
//        ascending
        if(lastChar=='A'){
            return true;
        }
        if(lastChar>c){
            return false;
        }
        return true;
    }


    

}
