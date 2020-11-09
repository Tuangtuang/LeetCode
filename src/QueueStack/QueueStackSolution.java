package QueueStack;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.util.Pair;

import java.util.*;

/**
 * @program: LeetCode
 * @description: solution of queue and stack
 * @author: tyq
 * @create: 2020-09-23 11:09
 **/
public class QueueStackSolution {
    //    Number of Islands
//    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//    You may assume all four edges of the grid are all surrounded by water.
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    // BFS
                    visited[i][j] = true;
                    BFS(visited, grid, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    public void BFS(boolean[][] visited, char[][] grid, int rowIndex, int colIndex, int rows, int cols) {
        Queue<Integer> queue = new LinkedList<>();
        int pos = rowIndex * cols + colIndex;
        queue.offer(pos);
        while (!queue.isEmpty()) {
            int curPos = queue.poll();
            int i = curPos / cols;
            int j = curPos % cols;
            // up
            if (!outBound(rows, cols, i - 1, j) && !visited[i - 1][j] && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * cols + j);
                visited[i - 1][j] = true;
            }
            // down
            if (!outBound(rows, cols, i + 1, j) && !visited[i + 1][j] && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * cols + j);
                visited[i + 1][j] = true;
            }
            // left
            if (!outBound(rows, cols, i, j - 1) && !visited[i][j - 1] && grid[i][j - 1] == '1') {
                queue.offer(i * cols + j - 1);
                visited[i][j - 1] = true;
            }
            // right
            if (!outBound(rows, cols, i, j + 1) && !visited[i][j + 1] && grid[i][j + 1] == '1') {
                queue.offer(i * cols + j + 1);
                visited[i][j + 1] = true;
            }
        }
    }

    public boolean outBound(int row, int col, int i, int j) {
        if (i >= 0 && i < row && j >= 0 && j < col) {
            return false;
        }
        return true;
    }


    //    Open the Lock
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<String>();
        Collections.addAll(deadSet, deadends);
        Set<String> visited = new HashSet<>();
        if (deadSet.contains(target) || deadSet.contains("0000")) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        String mark = "*";
        q.offer("0000");
        q.offer(mark);
        int depth = 0;
        while (!q.isEmpty()) {
            String curNode = q.poll();
            if (target.equals(curNode)) {
                return depth;
            }
            if (deadSet.contains(curNode) || visited.contains(curNode)) {
                continue;
            }
            if (curNode.equals(mark) && q.isEmpty()) {
                return -1;
            }
            if (curNode.equals(mark)) {
                q.offer(mark);
                depth++;
            } else {
                visited.add(curNode);
                q.addAll(getNextLevel(curNode));
            }
        }

        return depth;

    }

    public LinkedList<String> getNextLevel(String str) {
        LinkedList<String> res = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 : str.charAt(i) - '0' - 1) + str.substring(i + 1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 : str.charAt(i) - '0' + 1) + str.substring(i + 1));
        }
        return res;
    }

//    Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//    public int numSquares(int n) {
//        int minDepth=Integer.MAX_VALUE;
//        int i=1;
//        LinkedList<Integer> numbers = new LinkedList<>();
//        while (i*i<=n){
//            numbers.add(i*i);
//            i++;
//        }
//        Collections.reverse(numbers);
//        for(Integer item:numbers){
//            System.out.println(item+" ");
//            int depth=BFSNumSquares(n,item);
//            if(depth!=-1&&depth<minDepth){
//                minDepth=depth;
//            }
//        }
//        return minDepth;
//    }
//
//    public int BFSNumSquares(int target,int root){
//        Set<Integer> visited = new HashSet<>();
//        Queue<Integer> q = new LinkedList<>();
//        int mark=-1;
//        int depth=1;
//        q.offer(root);
//        q.offer(-1);
//        while (!q.isEmpty()){
//            int curNode=q.poll();
//            if(curNode==target){
//                return depth;
//            }
//            if(curNode==-1&&q.isEmpty()){
//                return -1;
//            }
//            if(curNode==mark){
//                q.offer(mark);
//                depth++;
//            }else{
//                visited.add(curNode);
//                q.addAll(generateNext(curNode,target,visited));
//            }
//        }
//        return depth;
//    }
//
//    public LinkedList<Integer> generateNext(int n,int target,Set<Integer> visited){
//        LinkedList res = new LinkedList();
//        int i=1;
//        int tmp=0;
//        while (tmp<=target){
//            tmp=n+i*i;
//            i++;
//            if(!visited.contains(tmp)){
//                res.add(tmp);
//                visited.add(tmp);
//            }
//        }
//        return res;
//    }

    public int numSquares(int n) {
        Set<Integer> visited = new HashSet<>();
        int mark = -1;
        int depth = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        q.offer(mark);
        while (!q.isEmpty()) {
            int curNode = q.poll();
            if (curNode == 0) {
                return depth;
            }
            if (curNode == mark && q.isEmpty()) {
                return -1;
            }
            if (visited.contains(curNode)) {
                continue;
            }
            if (curNode == mark) {
                q.offer(mark);
                depth++;
            } else {
                visited.add(curNode);
                q.addAll(generateNextSquare(curNode));
            }
        }
        return depth;
    }

    public LinkedList<Integer> generateNextSquare(int n) {
        LinkedList<Integer> nextLevel = new LinkedList<>();
        int i = 1;
        int temp;
        while ((temp = n - i * i) >= 0) {
            nextLevel.add(temp);
            i++;
        }
        return nextLevel;
    }

    // stack

    //    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || !match(stack.peek(), s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean match(char left, char right) {
        if (left == '{' && right == '}' || left == '[' && right == ']' || left == '(' && right == ')') {
            return true;
        } else {
            return false;
        }
    }

    //    Daily Temperatures
//    Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
    public int[] dailyTemperatures(int[] T) {
        if (T == null) {
            return null;
        }
        int[] res = new int[T.length];
        if (T.length == 0) {
            return res;
        }
//        top is least, bottom is maximum
        Stack<Integer> decreasingStack = new Stack<>();
//        push index to the stack
        decreasingStack.push(0);
        for (int i = 1; i < T.length; i++) {
            // if top is less than T[i], we find the latest temperature larger than top
            while (!decreasingStack.isEmpty() && T[i] > T[decreasingStack.peek()]) {
                int index = decreasingStack.pop();
                res[index] = i - index;
            }
            decreasingStack.push(i);
        }
        return res;
    }

    //  Evaluate Reverse Polish Notation
//  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//  Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            Integer tmp = parseNumber(tokens[i]);
            if (tmp != null) {
//                number
                s.push(tmp);
            } else {
//                operator
                int right = s.pop();
                int left = s.pop();
                if (tokens[i].equals("+")) {
                    s.push(left + right);
                } else if (tokens[i].equals("-")) {
                    s.push(left - right);
                } else if (tokens[i].equals("*")) {
                    s.push(left * right);
                } else {
                    s.push(left / right);
                }
            }
        }
        return s.pop();
    }

    public Integer parseNumber(String str) {
        if (str.length() == 0 || str == null) {
            return null;
        }
        if (str.length() != 1) {
//            not operator
            if (str.charAt(0) == '-') {
//                negative number
                int temp = Integer.parseInt(str.substring(1));
                return temp * -1;
            } else {
//                positive number
                return Integer.parseInt(str);
            }
        } else {
//            one digit num
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                return str.charAt(0) - '0';
            } else {
//                operator
                return null;
            }

        }
    }

    //    Number of Islands DFS
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    DFSIsland(grid, visited, i, j, rows, cols);
                    res++;
                }
            }
        }
        return res;
    }

    public void DFSIsland(char[][] grid, boolean[][] visited, int rowIndex, int colIndex, int row, int col) {
        if (rowIndex >= row || colIndex >= col || rowIndex < 0 || colIndex < 0 || grid[rowIndex][colIndex] == '0' || visited[rowIndex][colIndex] == true) {
            return;
        }
        visited[rowIndex][colIndex] = true;
//        right
        DFSIsland(grid, visited, rowIndex + 1, colIndex, row, col);
//        left
        DFSIsland(grid, visited, rowIndex - 1, colIndex, row, col);
//        up
        DFSIsland(grid, visited, rowIndex, colIndex - 1, row, col);
//        down
        DFSIsland(grid, visited, rowIndex, colIndex + 1, row, col);

    }

    //    Given a reference of a node in a connected undirected graph.
//
//    Return a deep copy (clone) of the graph.
//    hash map declaration must outside the function, otherwise it will be always new while recur
    HashMap<GraphNode, GraphNode> map = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }
//        HashMap<GraphNode, GraphNode> map = new HashMap<>();
        GraphNode newNode = new GraphNode();
        newNode.val = node.val;
        map.put(node, newNode);
        for (GraphNode item : node.neighbors) {
            GraphNode tmp = null;
            if (map.containsKey(item)) {
                tmp = map.get(item);
            } else {
                tmp = cloneGraph(item);
            }
            newNode.neighbors.add(tmp);
        }
        return newNode;
    }


    //    Target Sum
//    You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        return DFSfindTargetSum(nums, S, 0, 0);

    }

    public int DFSfindTargetSum(int[] nums, int sum, int depth, int curSum) {
        if (depth == nums.length) {
            if (curSum == sum) {
                count++;
            }
            return count;
        }
        curSum += nums[depth];
        depth++;
        DFSfindTargetSum(nums, sum, depth, curSum);
        depth--;
        curSum -= 2 * nums[depth];
        depth++;
        DFSfindTargetSum(nums, sum, depth, curSum);
        return count;
    }


    //    Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;

    }


    //    Decode String
//    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//    O(n)
    public String decodeString(String s) {
        char[] sArray = s.toCharArray();
        Deque<Character> reslist = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] != ']') {
                reslist.add(sArray[i]);
            } else {
                StringBuffer repeatedString = new StringBuffer();
                while (reslist.getLast() != '[') {
                    repeatedString.append(reslist.removeLast());
                }
//                pop [
                reslist.removeLast();
                int repeatedTimes = 0;
                int count = 0;
                while (!reslist.isEmpty() && Character.isDigit(reslist.getLast())) {
                    repeatedTimes += (reslist.removeLast() - '0') * Math.pow(10, count);
                    count++;
                }
                for (int k = 0; k < repeatedTimes; k++) {
                    for (int p = repeatedString.length() - 1; p >= 0; p--) {
                        reslist.add(repeatedString.charAt(p));
                    }
                }
            }
        }
        StringBuffer res = new StringBuffer();
        for (Character c : reslist) {
            res.append(c);
        }
        return res.toString();
    }

    //    An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
//
//    Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
//    O(n*m)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return null;
        }
        if (image[0] == null || image[0].length == 0) {
            return null;
        }
        int originalColor = image[sr][sc];
        int row = image.length;
        int col = image[0].length;
        boolean[][] visited = new boolean[row][col];
        DFSFloodFill(image, visited, row, col, sr, sc, originalColor, newColor);
        return image;
    }

    public void DFSFloodFill(int[][] image, boolean[][] visited, int row, int col, int rowIndex, int colIndex, int originalColor, int newColor) {
        if (array2DOutBound(rowIndex, colIndex, image) || image[rowIndex][colIndex] != originalColor || visited[rowIndex][colIndex]) {
            return;
        }
        if (image[rowIndex][colIndex] == originalColor) {
            image[rowIndex][colIndex] = newColor;
            visited[rowIndex][colIndex] = true;
        }
        DFSFloodFill(image, visited, row, col, rowIndex - 1, colIndex, originalColor, newColor);
        DFSFloodFill(image, visited, row, col, rowIndex + 1, colIndex, originalColor, newColor);
        DFSFloodFill(image, visited, row, col, rowIndex, colIndex - 1, originalColor, newColor);
        DFSFloodFill(image, visited, row, col, rowIndex, colIndex + 1, originalColor, newColor);
    }

    public boolean array2DOutBound(int rowIndex, int colIndex, int[][] arr) {
        if (rowIndex >= arr.length || rowIndex < 0 || colIndex >= arr[0].length || colIndex < 0) {
            return true;
        } else {
            return false;
        }
    }


    //    Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
//
//    The distance between two adjacent cells is 1.
//    01 Matrix
//    BFS, O(m*n),O(m*n)
//    易错点：1) q.poll().getKey,q.poll().getValue会出队列两次 2）初始化设置成MAX, 否则影响BFS，初始化的1并不代表距离 3）先判断是否越界
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new Pair<>(i, j));
                } else{
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while (!q.isEmpty()) {
            int rowIndex = q.peek().getKey();
            int colIndex = q.peek().getValue();
            q.poll();
//            up cell
            if (!array2DOutBound(rowIndex - 1, colIndex, matrix) && matrix[rowIndex - 1][colIndex] > matrix[rowIndex][colIndex] + 1) {
                matrix[rowIndex - 1][colIndex] = matrix[rowIndex][colIndex] + 1;
                q.add(new Pair<>(rowIndex - 1, colIndex));
            }
//            down cell
            if (!array2DOutBound(rowIndex + 1, colIndex, matrix) && matrix[rowIndex + 1][colIndex] > matrix[rowIndex][colIndex] + 1) {
                matrix[rowIndex + 1][colIndex] = matrix[rowIndex][colIndex] + 1;
                q.add(new Pair<>(rowIndex + 1, colIndex));
            }
//            left cell
            if (!array2DOutBound(rowIndex, colIndex - 1, matrix) && matrix[rowIndex][colIndex - 1] > matrix[rowIndex][colIndex] + 1) {
                matrix[rowIndex][colIndex - 1] = matrix[rowIndex][colIndex] + 1;
                q.add(new Pair<>(rowIndex, colIndex - 1));
            }
//            right cell
            if (!array2DOutBound(rowIndex, colIndex + 1, matrix) && matrix[rowIndex][colIndex + 1] > matrix[rowIndex][colIndex] + 1) {
                matrix[rowIndex][colIndex + 1] = matrix[rowIndex][colIndex] + 1;
                q.add(new Pair<>(rowIndex, colIndex + 1));
            }

        }
        return matrix;
    }


}
