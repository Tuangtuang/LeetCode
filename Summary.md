# Array & String

## Insertion

### Insert Element

- Try to insert elements at the end, since under this circumstances, the movements of elements are at minimum.

- Examples:

  - **Duplicate Zeros**

    - Given a fixed length array `arr` of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

    - ```
      Input: [1,0,2,3,0,4,5,0]
      Output: null
      Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
      ```

    - ```Java
      class Solution {
          public void duplicateZeros(int[] arr) {
              if(arr==null||arr.length==0||arr.length==1){
                  return;
              }
              // count possible zeros
              int length=arr.length-1;
              int zeros=0;
              for(int i=0;i+zeros<=length;i++){
                  if(arr[i]==0){
                      if(i==length-zeros){
                          arr[length]=0;
                          length--;
                          break;
                      }
                      zeros++;
                  }
              }
              if(zeros==0){
                  return;
              }
            // curLength is the length of elements we want
            // move the last element we want to the end
            // If it's 0, then duplicate 0
            // zeros is the movement length
              int curLength=length-zeros;
              for(int j=curLength;j>=0;j--){
                  if(arr[j]==0){
                      arr[j+zeros]=0;
                      zeros--;
                      arr[j+zeros]=0;
                  }else {
                      arr[j+zeros]=arr[j];
                  }
              }
              return;
          }
      }
      ```

## Deletion

### Delete Element

- Use Two Point Techique

  - **Remove Element**

    - Given an array *nums* and a value *val*, remove all instances of that value in-place and return the new length.

    - ```
      Given nums = [3,2,2,3], val = 3,
      Your function should return length = 2, with the first two elements of nums being 2.
      It doesn't matter what you leave beyond the returned length.
      ```

    - ```Java
      public int removeElement(int[] nums, int val) {
          int i = 0;
        // slow pointer i, faster pointer j
          for (int j = 0; j < nums.length; j++) {
              if (nums[j] != val) {
                  nums[i] = nums[j];
                  i++;
              }
          }
          return i;
      }
      ```

  - **Remove Duplicates from Sorted Array**

    - Given a sorted array *nums*, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that each element appear only *once* and return the new length.

    - ```
      Given nums = [1,1,2],
      
      Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
      
      It doesn't matter what you leave beyond the returned length.
      ```

    - ```java
      class Solution {
          public int removeDuplicates(int[] nums) {
              if(nums==null||nums.length==0){
                  return 0;
              }
              if(nums.length==1){
                  return 1;
              }
              int i=1,j=1;
              int curNum=nums[0];
              while (j<nums.length){
                  if(nums[j]==curNum){
                      j++;
                  }else {
                      curNum=nums[j];
                      nums[i]=nums[j];
                      i++;
                      j++;
                  }
              }
              return i;
          }
      }
      ```

## Search

### Linear Search

### Binary Search(for sorted array)

## In-place Operation

- Examples

  - **Sort Array By Parity**(like quick sort)

    - Given an array `A` of non-negative integers, return an array consisting of all the even elements of `A`, followed by all the odd elements of `A`.

    - ```
      Input: [3,1,2,4]
      Output: [2,4,3,1]
      The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
      ```

    - ```java
      class Solution {
          public int[] sortArrayByParity(int[] A) {
              if(A==null||A.length==1){
                  return A;
              }
              int low=0,high=A.length-1;
      //        3,1,2,4
              while (low<high){
                  while (high>=0&&A[high]%2==1){
                      high--;
                  }
                  while (low<A.length&&A[low]%2==0){
                      low++;
                  }
                  // swap high and low
                  if(low<high){
                      int temp = A[high];
                      A[high] = A[low];
                      A[low]=temp;
                  }
      
              }
              return A;
          }
      }
      ```

## Two Point Technique

### Same Direction(两指针同向)

- one is still used for the iteration while the second one always points at the position for next addition

- One slow-runner and one fast-runner at the same time.

- Examples:

  - **Remove Element**

    - Given an array *nums* and a value *val*, remove all instances of that value in-place and return the new length.

    - ```
      Given nums = [3,2,2,3], val = 3,
      Your function should return length = 2, with the first two elements of nums being 2.
      It doesn't matter what you leave beyond the returned length.
      ```

    - ```Java
      public int removeElement(int[] nums, int val) {
          int i = 0;
        // slow pointer i, faster pointer j
          for (int j = 0; j < nums.length; j++) {
              if (nums[j] != val) {
                  nums[i] = nums[j];
                  i++;
              }
          }
          return i;
      }
      ```

  - **Max Consecutive Ones**

    - Given a binary array, find the maximum number of consecutive 1s in this array.

    - ```
      Input: [1,1,0,1,1,1]
      Output: 3
      Explanation: The first two digits or the last three digits are consecutive 1s.
      The maximum number of consecutive 1s is 3.
      ```

    - ```java
      class Solution {
          public int findMaxConsecutiveOnes(int[] nums) {
              if(nums==null||nums.length==0){
                  return 0;
              }
              int max=0;
              int count=0;
              for(int i=0;i<nums.length;i++){
                  if(nums[i]==1){
                      count++;
                  }else {
                      if(count>max){
                          max=count;
                      }
                      count=0;
                  }
              }
              return max>count?max:count;
          }
      }
      ```

### Different Direction(两指针反向)

- one starts from the first element and another starts from the last element

- Examples:

  - **Reverse String**

    - Write a function that reverses a string. The input string is given as an array of characters `char[]`.

    - ```
      Input: ["h","e","l","l","o"]
      Output: ["o","l","l","e","h"]
      ```

    - ```Java
      class Solution {
          public void reverseString(char[] s) {
              if (s.length == 0) {
                  return;
              }
              int start = 0, end = s.length-1;
              while (start <= end) {
                  // swap start and end elements
                  char temp = s[start];
                  s[start] = s[end];
                  s[end] = temp;
                  start++;
                  end--;
              }
              return;
          }
      }
      ```

  - **Two Sum II - Input array is sorted**

    - Given an array of integers that is already **sorted in ascending order**, find two numbers such that they add up to a specific target number.

      The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

    - ```
      Input: numbers = [2,7,11,15], target = 9
      Output: [1,2]
      Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
      ```

    - ```java
      class Solution {
          public int[] twoSum(int[] numbers, int target) {
              int []result=new int[2];
              int i=0,j=numbers.length-1;
              while (i<j){
                  if(numbers[i]+numbers[j]>target){
                      j--;
                  }else if(numbers[i]+numbers[j]<target){
                      i++;
                  }else {
                      break;
                  }
              }
              result[0]=i+1;
              result[1]=j+1;
              return result;
          }
      }
      ```

## Slide Window(滑动窗口)

- Examples:

  - **Minimum Size Subarray Sum**

    - Given an array of **n** positive integers and a positive integer **s**, find the minimal length of a **contiguous** subarray of which the sum ≥ **s**. If there isn't one, return 0 instead.

    - ```
      Input: s = 7, nums = [2,3,1,2,4,3]
      Output: 2
      Explanation: the subarray [4,3] has the minimal length under the problem constraint.
      ```

    - ```Java
      class Solution {
          public int minSubArrayLen(int s, int[] nums) {
             if(nums==null||nums.length==0){
                  return 0;
              }
              // 滑动窗口
              int low=0,high=0,currSum=0,minLength=Integer.MAX_VALUE;
              while(low<nums.length&&high<nums.length){
                  if(currSum<s){
                      currSum+=nums[high];
                      high++;
                  }else{
                      minLength=Integer.min(high-low,minLength);
                      currSum-=nums[low];
                      low++;
                  }
              }
              // 可能仍有多余项
              while (currSum>=s){
                  minLength=Integer.min(high-low,minLength);
                  currSum-=nums[low];
                  low++;
              }
              return minLength==Integer.MAX_VALUE?0:minLength;
          }
      }
      ```

## Circular Array

......

# Linked List

## Two Pointer Technique

### Dynamic Distance Between 2 Pointers

- Linked List Cycle

  - Given a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

    To represent a cycle in the given linked list, we use an integer `pos` which represents the position (0-indexed) in the linked list where tail connects to. If `pos` is `-1`, then there is no cycle in the linked list.

  - ```
    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.
    ```

  - **设置快慢指针，假如有环，他们最后一定相遇。**

    **两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。**

    https://www.jianshu.com/p/888f574925c3

  - ```java
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
    ```

### Fixed Distance Between 2 Pointers

- Remove Nth Node From End of List

  - Given a linked list, remove the *n*-th node from the end of list and return its head.

  - ```
    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.
    ```

  - 前指针先走N+1步，之后前后指针一起走，等前指针null时，后指针的后一个就是要删除的

  - ```java
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
    ```

  

# Queue & BFS

## BFS  template

```java
/**
 * Return the length of the shortest path between root and target node.
 */
int BFS(Node root, Node target) {
    Queue<Node> queue;  // store all nodes which are waiting to be processed
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    add root to queue;
    // BFS
    while (queue is not empty) {
        step = step + 1;
        // iterate the nodes which are already in the queue
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node cur = the first node in queue;
            return step if cur is target;
            for (Node next : the neighbors of cur) {
                add next to queue;
            }
            remove the first node from queue;
        }
    }
    return -1;          // there is no path from root to target
}
```

- never visit a node twice

  ```java
  int BFS(Node root, Node target) {
      Queue<Node> queue;  // store all nodes which are waiting to be processed
      Set<Node> visited;  // store all the nodes that we've visited
      int step = 0;       // number of steps neeeded from root to current node
      // initialize
      add root to queue;
      add root to visited;
      // BFS
      while (queue is not empty) {
          step = step + 1;
          // iterate the nodes which are already in the queue
          int size = queue.size();
          for (int i = 0; i < size; ++i) {
              Node cur = the first node in queue;
              return step if cur is target;
              for (Node next : the neighbors of cur) {
                  if (next is not in used) {
                      add next to queue;
                      add next to visited;
                  }
              }
              remove the first node from queue;
          }
      }
      return -1;          // there is no path from root to target
  }
  ```

## Perfect Square

- Given a positive integer *n*, find the least number of perfect square numbers (for example, `1, 4, 9, 16, ...`) which sum to *n*.

  ```java
   public int numSquares(int n) {
          Set<Integer> visited=new HashSet<>();
          int mark=-1;
          int depth=0;
          Queue<Integer> q = new LinkedList<>();
          q.offer(n);
          q.offer(mark);
          while (!q.isEmpty()){
              int curNode = q.poll();
              if(curNode==0){
                  return depth;
              }
              if(curNode==mark&&q.isEmpty()){
                  return -1;
              }
              if(visited.contains(curNode)){
                  continue;
              }
              if(curNode==mark){
                  q.offer(mark);
                  depth++;
              }else{
                  visited.add(curNode);
                  q.addAll(generateNextSquare(curNode));
              }
          }
          return depth;
      }
  
      public LinkedList<Integer> generateNextSquare(int n){
          LinkedList<Integer> nextLevel = new LinkedList<>();
          int i=1;
          int temp;
          while ((temp=n-i*i)>=0){
              nextLevel.add(temp);
              i++;
          }
          return nextLevel;
      }
  ```



## Number of Island

- ```java
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
  ```

- 

# Stack and DFS

## Stack

### Mining stack

- Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

  - push(x) -- Push element x onto stack.
  - pop() -- Removes the element on top of the stack.
  - top() -- Get the top element.
  - getMin() -- Retrieve the minimum element in the stack.

  ```java
  class MinStack {
  
      /** initialize your data structure here. */
      int min;
      Stack<Integer> minStack;
      public MinStack() {
          minStack = new Stack<>();
          min=Integer.MAX_VALUE;
      }
  
      public void push(int x) {
          minStack.add(x);
          if(x<=min){
              // update minIndex
              min=x;
          }
  
      }
  
      public void pop() {
          if(minStack.isEmpty()){
              return;
          }
          if(minStack.peek()!=min){
              minStack.pop();
          }else{
              minStack.pop();
              min = Integer.MAX_VALUE;
              for(Integer item:minStack){
                  if(item<=min){
                      min=item;
                  }
              }
          }
      }
  
      public int top() {
          return minStack.peek();
      }
  
      public int getMin() {
          return min;
      }
  }
  
  /**
   * Your MinStack object will be instantiated and called as such:
   * MinStack obj = new MinStack();
   * obj.push(x);
   * obj.pop();
   * int param_3 = obj.top();
   * int param_4 = obj.getMin();
   */
  ```

### Descresing Stack(Temperature problem)

- Daily Temperatures

  - Given a list of daily temperatures `T`, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put `0` instead.

  - For example, given the list of temperatures `T = [73, 74, 75, 71, 69, 72, 76, 73]`, your output should be `[1, 1, 4, 2, 1, 1, 0, 0]`.

    ```java
    public int[] dailyTemperatures(int[] T) {
            if(T==null){
                return null;
            }
            int []res=new int[T.length];
            if(T.length==0){
                return res;
            }
    //        top is least, bottom is maximum
            Stack<Integer> decreasingStack=new Stack<>();
    //        push index to the stack
            decreasingStack.push(0);
            for(int i=1;i<T.length;i++){
                // if top is less than T[i], we find the latest temperature larger than top
                while (!decreasingStack.isEmpty()&&T[i]>T[decreasingStack.peek()]){
                    int index=decreasingStack.pop();
                    res[index]=i-index;
                }
                decreasingStack.push(i);
            }
            return res;
        }
    ```

## DFS

### Template 1

```java
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(Node cur, Node target, Set<Node> visited) {
    return true if cur is target;
    for (next : each neighbor of cur) {
        if (next is not in visited) {
            add next to visted;
            return true if DFS(next, target, visited) == true;
        }
    }
    return false;
}
```



### Templete2

- The advantage of the recursion solution is that it is easier to implement. However, there is a huge disadvantage: if the depth of recursion is too high, you will suffer from `stack overflow`. In that case, you might want to use BFS instead or implement DFS using an explicit stack.

  ```java
  /*
   * Return true if there is a path from cur to target.
   */
  boolean DFS(int root, int target) {
      Set<Node> visited;
      Stack<Node> stack;
      add root to stack;
      while (s is not empty) {
          Node cur = the top element in stack;
          remove the cur from the stack;
          return true if cur is target;
          for (Node next : the neighbors of cur) {
              if (next is not in visited) {
                  add next to visited;
                  add next to stack;
              }
          }
      }
      return false;
  }
  ```

### DFS Number of Island

- ```java
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
  ```

  

# Binary Tree

## PreOrder/InOrder/PostOrder

- recurrsion

- iteration

  - PostOrder

    - 注意区分，有孩子和parent，通过preVisit区分

    - ```java
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
      ```

      

## Level Order

- Use q

- tagNode

- Null

- ```java
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
  ```

## Solve Tree Problems Recursively

### "Top-down" Solution

- We will visit the node **first to come up with some values, and pass these values to its children** when calling the function recursively.

- ```
  1. return specific value for null node
  2. update the answer if needed                      // answer <-- params
  3. left_ans = top_down(root.left, left_params)      // left_params <-- root.val, params
  4. right_ans = top_down(root.right, right_params)   // right_params <-- root.val, params 
  5. return the answer if needed                      // answer <-- left_ans, right_ans
  ```

- Example:

  - We know that the depth of the root node is `1`. For each node, **if we know its depth, we will know the depth of its children**. Therefore, if we pass the depth of the node as a parameter when calling the function recursively, all the nodes will know their depth. And for leaf nodes, we can use the depth to update the final answer. Here is the pseudocode for the recursive function `maximum_depth(root, depth)`:

  - ```
    1. return if root is null
    2. if root is a leaf node:
    3.      answer = max(answer, depth)         // update the answer if needed
    4. maximum_depth(root.left, depth + 1)      // call the function recursively for left child
    5. maximum_depth(root.right, depth + 1)     // call the function recursively for right child
    ```

  - 

### "Bottom-up" Solution

- In each recursive call, we will firstly call the function **recursively for all the children nodes and then come up with the answer according to the returned values and the value of the current node itself**. 

- ```
  1. return specific value for null node
  2. left_ans = bottom_up(root.left)          // call function recursively for left child
  3. right_ans = bottom_up(root.right)        // call function recursively for right child
  4. return answers                           // answer <-- left_ans, right_ans, root.val
  ```

- Example:

  - For a single node of the tree, what will be the maximum depth `x` of the subtree rooted at itself?
  - If we know the maximum depth `l` of the subtree rooted at its **left** child and the maximum depth `r` of the subtree rooted at its **right** child, can we answer the previous question? Of course yes, **we can choose the maximum between them and add 1 to get the maximum depth of the subtree rooted at the current node**. That is `x = max(l, r) + 1`.

  - ```
    1. return 0 if root is null                 // return 0 for null node
    2. left_depth = maximum_depth(root.left)
    3. right_depth = maximum_depth(root.right)
    4. return max(left_depth, right_depth) + 1  // return depth of the subtree rooted
    ```

# Recursion

## Recursion Principal

### Reverse String

- ```java
  class Solution {
      public void reverseString(char[] s) {
          helper(s,0,s.length-1);
      }
      
      public void helper(char[]s, int start, int end){
          if(start>end){
              return;
          }
          // swap 
          char tmp=s[start];
          s[start]=s[end];
          s[end]=tmp;
          helper(s,start+1,end-1);
          return;
      }
  }
  ```

## Recursion Function

- We define the problem as the function *F*(*X*) to implement, where {X}*X* is the input of the function which also defines the scope of the problem.

- Then, in the function *F*(*X*), we will:

  ![image-20201113194912946](/Users/tangyuqi/Library/Application Support/typora-user-images/image-20201113194912946.png)

###  Swap Pair

- Given a linked list, swap every two adjacent nodes and return its head.

- ```java
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
          if(head==null||head.next==null){
              return head;
          }
          ListNode firstNode=head;
          ListNode secondNode=head.next;
          firstNode.next = swapPairs(secondNode.next);
          secondNode.next=firstNode;
  //        new head is second node
          return secondNode;
      }
  ```

## Recursion Relation

- `recurrence relation`: the relationship between the result of a problem and the result of its subproblems.
- `base case`: the case where one can compute the answer directly without any further recursion calls. Sometimes, the base cases are also called *bottom cases*, since they are often the cases where the problem has been reduced to the minimal scale, *i.e.* the bottom, if we consider that dividing the problem into subproblems is in a top-down manner.

