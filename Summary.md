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

### 算法框架

```java
int left = 0, right = 0;

while (right < s.size()) {
    // 增大窗口
    window.add(s[right]);
    //right++;

    while (window needs shrink) {
        // 缩小窗口
        window.remove(s[left]);
        left++;
    }
  	right++
}
```

### Longest Repeating Character Replacement

- https://leetcode.com/problems/longest-repeating-character-replacement/

- ```java
  class Solution {
      public int characterReplacement(String s, int k) {
          if(s==null||s.length()==0){
              return 0;
          }
          
          char [] alphabet=new char[26];
          int maxDup=0;
          int res=Integer.MIN_VALUE;
          
         int left=0,right=0;
          // window size=k+maxDup
          while(right<s.length()){
  //             enlarge window
              alphabet[s.charAt(right)-'A']++;
              if(alphabet[s.charAt(right)-'A']>maxDup){
                  maxDup=alphabet[s.charAt(right)-'A'];
              }
  //             shrink window
              while(right-left+1>maxDup+k){
                  alphabet[s.charAt(left)-'A']--;
                  left++;
              }
              res=Integer.max(res,right-left+1);
              right++;
          }
          return res;
      }
  }
  ```



### **Minimum Size Subarray Sum**

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

### 单调栈问题

- 在一个数组中找左右两边第一个大于、小于、等于的数这种问题可以使用单调栈来解决。
- https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/dan-diao-zhan-zuo-you-liang-bian-di-yi-g-ww3n/
- 题目：42，84，daily temperature

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

## Duplicate Calculation in Recursion(Memoriztion)

- Recursion is often an intuitive and powerful way to implement an algorithm. However, it might bring some undesired penalty to the performance, *e.g.* duplicate calculations, if we do not use it wisely. 
- [Memoization](https://en.wikipedia.org/wiki/Memoization) is an optimization technique used primarily to **speed up** computer programs by **storing** the results of expensive function calls and returning the cached result when the same inputs occur again. 

## Time Complexity - Recursion

- O(*T*)=*R*∗O(*s*)
- R: **the number of recursion** **invocations** 递归调用的次数
- O(s): **the time complexity of calculation** 子问题的复杂度
- Example:
  - print reverse string
    - the function would be recursively invoked `n` times
    - At the end of each recursion, we simply print the leading character, therefore the time complexity of this particular operation is constant,O(1)
    - O(printReverse)=*n*∗O(1)=O(*n*).
  - Execution tree
    
    - Fib
    
      - ![image-20201116201738247](/Users/tangyuqi/Library/Application Support/typora-user-images/image-20201116201738247.png)
    
      - In a full binary tree with `n` levels, the total number of nodes would be 2^n - 1.
      - As a result, we can estimate that the time complexity for `f(n)` would be O(2^n).
  
  - Memorization
    - With memoization, we save the result of Fibonacci number for each index `n`. 
    - We are assured that the calculation for each Fibonacci number would occur only once. And we know, from the recurrence relation, the Fibonacci number `f(n)` would depend on all `n-1` precedent Fibonacci numbers. As a result, the recursion to calculate `f(n)` would be invoked `n-1` times to calculate all the precedent numbers that it depends on. 
    - Now, we can simply apply the formula we introduced in the beginning of this chapter to calculate the time complexity, which is O(1) * n = O(*n*).

## Space Complexity - Recursion

- There are mainly two parts of the space consumption that one should bear in mind when calculating the space complexity of a recursive algorithm: 
  - `recursion related` 
    - the memory cost that is incurred directly by the recursion i.e. **the stack to keep track of recursive function calls**
      - The returning address of the function call. Once the function call is completed, the program must know where to return to, *i.e.* the line of code after the function call.
      - The parameters that are passed to the function call. 
      - The local variables within the function call.
    - **For a recursive algorithm, if there is no other memory consumption, then this recursion incurred space will be the space upper-bound of the algorithm.**
      - For example, in the exercise of [printReverse](https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1439/), we don't have extra memory usage outside the recursive call, since we simply print a character. For each recursive call, let's assume it can use space up to a constant value. And the recursive calls will chain up to `n` times, where `n` is the size of the input string. So the space complexity of this recursive algorithm is O(*n*).
  - `non-recursion related space.`
    - the memory space that is not directly related to recursion, which typically includes the space (normally in heap) that is allocated for the global variables.
    - **memoization**

## Tail Recursion

- **Tail recursion** is a recursion where the recursive call is the final instruction in the recursion function. And there should be only **one** recursive call in the function.

- ```java
  public class Main {
      
    private static int helper_non_tail_recursion(int start, int [] ls) {
      if (start >= ls.length) {
        return 0;
      }
      // not a tail recursion because it does some computation after the recursive call returned.
      return ls[start] + helper_non_tail_recursion(start+1, ls);
    }
  
    public static int sum_non_tail_recursion(int [] ls) {
      if (ls == null || ls.length == 0) {
        return 0;
      }
      return helper_non_tail_recursion(0, ls);
    }
  
    //---------------------------------------------
  
    private static int helper_tail_recursion(int start, int [] ls, int acc) {
      if (start >= ls.length) {
        return acc;
      }
      // this is a tail recursion because the final instruction is the recursive call.
      return helper_tail_recursion(start+1, ls, acc+ls[start]);
    }
      
    public static int sum_tail_recursion(int [] ls) {
      if (ls == null || ls.length == 0) {
        return 0;
      }
      return helper_tail_recursion(0, ls, 0);
    }
  }
  ```


## Divide and Conquer Intro

- A divide-and-conquer algorithm works by ***recursively*** breaking the problem down into ***two\*** or more subproblems of the same or related type, until these subproblems become simple enough to be solved directly. 

### Differernce between recursive algorithms and D&C

- We break the problem down into **two or more** subproblems in the divide-and-conquer algorithm, rather than a single smaller subproblem. 

- Step

  1. **Divide.** Divide the problem {S}*S* into a set of subproblems: {S1,S2....Sn} where n≥2, *i.e.* there are usually more than one subproblem.

  2. **Conquer.** Solve each subproblem recursively. 

  3. **Combine.** Combine the results of each subproblem.

     ![image-20201120164751395](/Users/tangyuqi/Library/Application Support/typora-user-images/image-20201120164751395.png)

### Example of D&C

-  Merge Sort(Up-Bottom Approach)

  - Divide the given unsorted list into several sublists. (**Divide**)
  - Sort each of the sublists recursively. (**Conquer**)
  - Merge the sorted sublists to produce new sorted list. (**Combine**)
  - ![image-20201120165155118](/Users/tangyuqi/Library/Application Support/typora-user-images/image-20201120165155118.png)

  - The recursion in **step (2)** would reach the base case where the input list is either empty or contains a single element (see the nodes in blue from the above figure).
  - Now, we have reduced the problem down to a merge problem, which is much simpler to solve. Merging two sorted lists can be done in ***linear time*** **complexity** {O(N)}*O*(*N*), where {N}*N* is the total lengths of the two lists to merge.

- Merge Sort(Bottom-Up Solution)
  - In the **bottom up** approach, we divide the list into sublists of a single element at the beginning. Each of the sublists is then sorted already. Then from this point on, we merge the sublists two at a time until a single list remains.

- Complexity
  - The overall **time complexity** of the merge sort algorithm is O*(*N*log*N)
  - We recursively divide the input list into two sublists, until a sublist with single element remains. This dividing step computes the midpoint of each of the sublists, which takes O(1) time. This step is repeated N*N* times until a single element remains, therefore the total time complexity is O*(*N).
    
  - Then, we repetitively merge the sublists, until one single list remains. The recursion tree in ***Fig. 1\*** or ***Fig. 2\*** above is useful for visualizing how the recurrence is iterated. As shown in the recursion tree, there are a total of N*N* elements on each level. Therefore, it takes O*(*N*) time for the merging process to complete on each level. And since there are a total of logN levels, the overall complexity of the merge process is O*(*N*logN)
  - The **space complexity** of the merge sort algorithm is O(N)*O*(*N*)

### D&C template

- ```python
  def divide_and_conquer( S ):
      # (1). Divide the problem into a set of subproblems.
      [S1, S2, ... Sn] = divide(S)
  
      # (2). Solve the subproblem recursively,
      #   obtain the results of subproblems as [R1, R2... Rn].
      rets = [divide_and_conquer(Si) for Si in [S1, S2, ... Sn]]
      [R1, R2,... Rn] = rets
  
      # (3). combine the results from the subproblems.
      #   and return the combined result.
      return combine([R1, R2,... Rn])
  ```


## Master Theorem

- https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2871/

- ```C++
   function dac( n ):
     if n < k:  // k: some constant
       Solve "n" directly without recursion
     else:
       [1]. divide the problem "n" into "b" subproblems of equal size.
         - then the size of each subproblem would be "n/b"
       [2]. call the function "dac()" recursively "a" times on the subproblems
       [3]. combine the results from the subproblems
  ```

- If we define the time complexity of the above recursion algorithm as $T(n)$, then we can express it as follows:

  $T(n)=aT(n/b)+f(n)$

  - 将规模为n的问题分成a个规模为n/b的子问题，将a个子问题合并需要f(n)

  - *f*(*n*) is the time complexity that it takes to divide the problems into subproblems and also to combine the results from the subproblems. We can further represent $f(n)$ as $O(n^d)  d≥0$. 
  
  ![image-20201121205752097](/Users/tangyuqi/Library/Application Support/typora-user-images/image-20201121205752097.png)

## Backtracking

- https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2654/

### N 皇后问题

```java
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
        for(int i=0;i<n;i++){
            solution[i]=-10;
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
```

### Backtracking Template

```python
def backtrack(candidate):
    if find_solution(candidate):
        output(candidate)
        return
    # iterate all possible candidates.
    for next_candidate in list_of_candidates:
        if is_valid(next_candidate):
            # try this partial candidate solution
            place(next_candidate)
            # given the candidate, explore further.
            backtrack(next_candidate)
            # backtrack
            remove(next_candidate)
```

## Recursion to Iteration

To convert a recursion approach to an iteration one, we could perform the following two steps:

1. We **use a stack or queue data structure** within the function, to replace the role of the system call stack. At each occurrence of recursion, we simply push the parameters as a new element into the data structure that we created, instead of invoking a recursion.
2. In addition, we **create a loop** over the data structure that we created before. The chain invocation of recursion would then be replaced with the iteration within the loop.

## Divide-and-Conquer VS Backtracking

### Divide and Conquer

- A divide-and-conquer algorithm works by ***recursively*** breaking the problem down into two or more subproblems of the same or related type, until these subproblems become simple enough to be solved directly 

### Backtracking

- Backtracking is a general algorithm for finding all (or some) solutions to some computational problems (notably constraint satisfaction problems), which incrementally builds candidates to the solution and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot leads to a valid solution.

### Difference

- Often the case, the divide-and-conquer problem has a **sole** solution, while the backtracking problem has **unknown** number of solutions.

- Each step in the divide-and-conquer problem is **indispensable** to build the final solution, while many steps in backtracking problem might not be useful to build the solution, but serve as **atttempts** to search for the potential solutions. 

- When building the solution in the divide-and-conquer algorithm, we have a clear and **predefined** path, though there might be several different manners to build the path. While in the backtracking problems, one does not know in advance the ***exact path*** to the solution. 



# Binary Search

## Binary Search Template I

- ````java
  int binarySearch(int[] nums, int target){
    if(nums == null || nums.length == 0)
      return -1;
  
    int left = 0, right = nums.length - 1;
    while(left <= right){
      // Prevent (left + right) overflow
      int mid = left + (right - left) / 2;
      if(nums[mid] == target){ return mid; }
      else if(nums[mid] < target) { left = mid + 1; }
      else { right = mid - 1; }
    }
  
    // End Condition: left > right
    return -1;
  }
  ````

- Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)

- No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found

### Distinguishing Syntax

- Initial Condition:` left = 0, right = length-1`
- Termination: `left > right`
- Searching Left: `right = mid-1`
- Searching Right: `left = mid+1`

## Square Root

- Binary

  ```java
  public int mySqrt(int x) {
          long left=0;
        //   每个数的平方跟不会大于这个数字的一半+1
          long right=x/2+1;
          while(left<right){
            // 右中值
              long mid=(left+right+1)/2;
              long square = mid * mid;
              if(square<=x){
                  left=mid;
              }else{
                  right=mid-1;
              }
          }
          return (int)left;
      }
  ```

## 二分查找找下界

- 对于数组 `[1,2,3,5,5,5,6,7,9]`，令 `target=5`，则满足 `x ≥ target` 的下界的下标应该是 `3`，如下图所示：

  ![image.png](https://pic.leetcode-cn.com/306c71552186f5b178a413074ee1b4417bb541f0e750128cdb4e3a6d06a26007-image.png)

- 区间范围为 [left,right]，left、right 是区间的左右边界的下标
  mid 是 [left,right] 的中间位置
  初始时，left、right 分别指向数组的第一个和最后一个元素
  当 left > right 时，表示区间为空

- 不断右移 left，左移 right，使得所有「小于」target 的元素都在 left 左侧，所有「大于等于」target 的元素都在 right 右侧，那么当区间为空时，left 就是要查找的下界

- 算法步骤：

  - 若 nums[mid] >= target，说明 [mid,right] 区间的所有元素均「大于等于」target，因此 right 左移，有 right = mid-1
    否则，说明 [left,mid] 区间的所有元素均「小于」target，因此 left 右移，有 left = mid+1
    重复上述步骤，直到区间为空，表示找到了下界，返回 left。因此循环条件为 left <= right，表示“区间不为空”
    注意，上述两个赋值语句均跳过了中间元素 mid

  - ```javascript
    func LowerBound(nums []int, target int) int {
        left, right := 0, len(nums)-1
        for left <= right {
            mid := left + (right-left) >> 1
            if nums[mid] >= target { // 这里的比较运算符与题目要求一致
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left // 返回下界的下标
    
    ```

## 找上界

- 定义满足 x ≤ target 的最后一个元素为「上界」。给定一个 target，要求返回升序数组中上界的下标。比如：对于数组 [0,1,2,3,4]，当 target=3 时，返回下标 2；当 target=5 时，返回下标 4。

- 根据上界和下界的定义，我们可以发现：上界和「互补的」下界是相邻的，并且 上界 = 下界 - 1。比如 x ≤ target 的上界和 x > target 的下界相邻。因此，所有找上界的问题，都可以转换为「互补的」找下界的问题。

- Find **Minimum** in Rotated Sorted Array

  - Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:
  - `[4,5,6,7,0,1,2]` if it was rotated `4` times.
  - `[0,1,2,4,5,6,7]` if it was rotated `7` times.

  - ```java
    class Solution {
        public int findMin(int[] nums) {
            if(nums==null||nums.length==0){
                return -1;
            }
            if(nums.length==1){
                return nums[0];
            }
            int left=0,right=nums.length-1;
            int size=nums.length-1;
            // 结尾比开头大，一定没有转过
            if(nums[right]>nums[left]){
                return nums[left];
            }
            while(left<=right){
                int mid=(left+right)/2;
                // 比后一项大，该项一定是peek
                if(nums[mid]>nums[mid+1]){
                    return nums[mid+1];
                }
                // 前一项更大，前一项一定是peek
                if(nums[mid-1]>nums[mid]){
                    return nums[mid];
                }
    //             peek一定在mid之后
                if(nums[mid]>nums[0]){
                    left=mid+1;
                }else{
    //                 nums[mid]比开头小，peek一定在前面
                    right=mid-1;
                }
            }
            return -1;
        }
    }
    ```

    


## Find Minimum in Rotated Sorted Array

```java
class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }
        int left=0,right=nums.length-1;
        int size=nums.length-1;
        // 结尾比开头大，一定没有转过
        if(nums[right]>nums[left]){
            return nums[left];
        }
        while(left<=right){
            int mid=(left+right)/2;
            // 比后一项大，该项一定是peek
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            // 前一项更大，前一项一定是peek
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
//             peek一定在mid之后
            if(nums[mid]>nums[0]){
                left=mid+1;
            }else{
//                 nums[mid]比开头小，peek一定在前面
                right=mid-1;
            }
        }
        
        return -1;
    }
}
```

## Median of Two Sorted Arrays

- https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/

- ```java
  class Solution {
      public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          int n = nums1.length;
          int m = nums2.length;
          if((m+n)%2==1){
              return getKthSmall(nums1,0,n-1,nums2,0,m-1,(m+n)/2+1);
          }else{
              int left=getKthSmall(nums1,0,n-1,nums2,0,m-1,(m+n)/2);
              int right=getKthSmall(nums1,0,n-1,nums2,0,m-1,(m+n)/2+1);
              return (left+right)*0.5;
          }
      
      }
      
      public int getKthSmall(int []nums1,int start1,int end1,
                            int []nums2,int start2,int end2,
                            int k){
          
          if(start1>end1){
              return nums2[start2+k-1];
          }
          if(start2>end2){
              return nums1[start1+k-1];
          }
          if(k==1){
              return Integer.min(nums1[start1],nums2[start2]);
          }
  //         compare k/2 
  //         如果k/2>当前长度，则取最后一位
          int index1=start1+Integer.min(k/2,end1-start1+1)-1;
          int index2=start2+Integer.min(k/2,end2-start2+1)-1;
          if(nums1[index1]<nums2[index2]){
  //             扔掉[0:index]
  //             此时1中小于等于nums1[index]的一共有index个
  //             B中小于等于nums1[index]最多有index-1个
  //             所以此时nums1[index]最多是第k-1小的数
  //             此时只要找第k-（index-start+1）小的数
              return getKthSmall(nums1,index1+1,end1,nums2,start2,end2,k-(index1-start1+1));
                  
          }else{
              return getKthSmall(nums1,start1,end1,nums2,index2+1,end2,k-(1+index2-start2));
          }
          
      }
  }
  ```

  

# 动态规划

## 子序列问题解题模板

### **一个一维的 dp 数组**

- **在子数组`array[0..i]`中，以array[i]结尾的目标子序列（最长递增子序列）的长度是`dp[i]`**。

- Unique Binary Search Trees

  - Given *n*, how many structurally unique **BST's** (binary search trees) that store values 1 ... *n*?

  - ```java
    class Solution {
    //     dp[i]: # of binary trees with i nodes
    //     assume ith node is root
    //     from 0 to i-1 can be left subtree, from i+1 to n-1 can be right subtree
    //     dp[n]=sum(dp[i-1]*dp[n-i]) i from 1 to n
    //     base case:
    //     dp[0]=1
    //     dp[1]=1
        
        public int numTrees(int n) {
            int []memo=new int [n+1];
            return numTreesHelper(n,memo);
        }
        
        public int numTreesHelper(int n, int []memo){
            if(n==0||n==1){
                return 1;
            }
            if(memo[n]!=0){
                return memo[n];
            }
            int curRes=0;
            for(int i=1;i<=n;i++){
                curRes+=numTreesHelper(i-1,memo)*numTreesHelper(n-i,memo);
            }
            if(memo[n]==0){
                memo[n]=curRes;
            }
            return curRes;
        }
    }
    ```

### **一个二维的 dp 数组**

#### **涉及两个字符串/数组时**

- **在子数组`arr1[0..i]`和子数组`arr2[0..j]`中，我们要求的子序列（最长公共子序列）长度为`dp[i][j]`**

#### **只涉及一个字符串/数组时**

- **在子数组`array[i..j]`中，我们要求的子序列（最长回文子序列）的长度为`dp[i][j]`**

## 背包问题

### 0-1背包问题

- 给你一个可装载重量为 `W` 的背包和 `N` 个物品，每个物品有重量和价值两个属性。其中第 `i` 个物品的重量为 `wt[i]`，价值为 `val[i]`，现在让你用这个背包装物品，最多能装的价值是多少？

  - 明确选择和状态
    - 选择：装或者不装第i个物品
    - 状态：背包容量，可选择的物品
  - 定义DP数组
    - **`dp[i][w]`的定义如下：对于前`i`个物品，当前背包的容量为`w`，这种情况下可以装的最大价值是`dp[i][w]`**

  - 完成状态转换
    - $dp[i][0]=0$
    - 对于每一个物品，可以选或者不选
      - $dp[i][j]=Max\{dp[i-1][j-w[i]]+p[i],dp[i-1][j]\}$

- Leetcode 416

### 完全背包问题

- leetcode 518
- 有一个背包，最大容量为 `amount`，有一系列物品 `coins`，每个物品的重量为 `coins[i]`，**每个物品的数量无限**。请问有多少种方法，能够把背包恰好装满？
- 和0-1背包区别，每个物品的数量是无限的
  - 状态和选择
    - 「背包的容量」和「可选择的物品」
    - 用或者不用第i种硬币
  - dp数组
    - 若只使用前 `i` 个物品，当背包容量为 `j` 时，有 `dp[i][j]` 种方法可以装满背包
    - **若只使用** **`coins`** **中的前** **`i`** **个硬币的面值，若想凑出金额** **`j`**，**`dp[i][j]`** **种凑法**。
    - $dp[i][0]=0$
    - $dp[0][j]=0$
    - $dp[i][j]=dp[i-1][j-nums[i]]+dp[i-1][j]$
    - 对于凑j元，可以使用第i种硬币，也可以不使用第i种硬币

## 买卖股票

### 选择

- 每一天有三种选择：买，卖，不操作

### 状态

- 天数i
- 交易次数k
- 手里有没有股票0/1

- Dp(i,k,0)表示第i天，交易k次，手里没有股票时的最大收益

### Base Case:

- dp(i,0,1)=-infinite, 第i天，没有交易，手里有股票是不可能的
- dp(i,0,0)=0, 第i天，没有交易，手机没有股票，收益是0
- dp(0,k,1)=-infinite, 第0天，交易还没开始，手里不可能有股票
- dp(0,k,0)=0, 第0天，没有交易，手里没有股票，收益是0

### 状态转移方程

- $dp(i,k,0)=max\{dp(i-1,k,0), dp(i-1,k,1)+price[i]\}$
- 第i天，交易次数为k，没有股票=max{（第i-1天，交易次数k，没有股票），（第i-1天，交易次数为k，持有股票，但是在第i天卖了）}
- $dp(i,k,1)=max\{dp(i-1,k,1), dp(i-1,k-1,0)-price[i]\}$
- 第i天，交易次数为k，持有股票=max{（第i-1天，交易次数k，持有股票），（第i-1天，交易次数为k-1，没有股票，但是在第i天买入了股票）}

### 第一题，k = 1

- k==1, 所以可以减少一个状态
- Base Case
  - dp(0,0)=0; On the 0th day, the transaction doesn't start.profit=0
  - dp(0,1)=-price[0]; Impossible, when we not start, we have stock

- 状态转移方程

  - $dp(i,1)=max\{dp(i-1,1), dp(i-1,0)-prices[i]\}$

    ​		 $ =max\{dp(i-1,1),-prices[i]\}$

    - dp(i-1,0)恒等于0，因为只允许做一次交易，第i次才开始买，所以之前一定都没买也没卖，收益一定是0

  - $dp(i,0)=max\{dp(i-1,0), dp(i-1,1)+price[i]\}$

- Goal

  - the max # of the matrix

- Code

  - ```java
    //     121. Best Time to Buy and Sell Stock
    //		 dp(i,j) on the ith day, when we have/ don't have stock, the max profit
    //     Base Case
    //     dp(0,0)=0; on the 0th day, the transaction doesn't start.profit=0
    //     dp(0,1)=-1; impossible, when we not start, we have stock
    //     dp(i,1)=max{dp(i-1,1),dp(i-1,0)-prices[i]}=max{dp(i-1,1),-prices[i]}
    //     dp(i,0)=max{dp(i-1,0),dp(i-1,1)+price[i]}
    //     Goal: the max of the matrix
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length==0){
                return 0;
            }
            int [][]dp=new int [prices.length+1][2];
            int maxProfit=0;
            dp[0][0]=0;
            dp[0][1]=-prices[0];
            for(int i=1;i<dp.length;i++){
                dp[i][1]=Integer.max(dp[i-1][1],-prices[i-1]);
                dp[i][0]=Integer.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
                maxProfit=Integer.max(maxProfit,dp[i][0]);
            }
            return maxProfit;
        }
    ```

  - 状态压缩

    - ```java
      public int maxProfit(int[] prices) {
              if(prices==null||prices.length==0){
                  return 0;
              }
              // int [][]dp=new int [prices.length+1][2];
              int maxProfit=0;
              // dp[0][0]=0;
              // dp[0][1]=-prices[0];
              int dp_i0=0;
              int dp_i1=Integer.MIN_VALUE;
              for(int i=1;i<prices.length+1;i++){
                  dp_i1=Integer.max(dp_i1,-prices[i-1]);
                  dp_i0=Integer.max(dp_i0,dp_i1+prices[i-1]);
                  maxProfit=Integer.max(maxProfit,dp_i0);
              }
              return maxProfit;
          }
      ```

    - dp(i,j)只和dp(i-1,0)和dp(i-1,1)有关，状态压缩为两个

### k = +infinity

- 认为k和k-1是一样的

- $dp(i,k,0) = max\{dp(i-1,k,0), dp(i-1,k,1)-prices[i]\}$

- $dp(i,k,1) = max\{dp(i-1,k,1),dp(i-1,k-1,0)-prices[i]\}$

  ​				$= max\{dp(i-1,k,1),dp(i-1,k,0)-prices[i]\}$

- 可以省略一个状态k
  - $dp(i,0) = max\{dp(i-1,0), dp(i-1,1)-prices[i]\}$
  - $dp(i,1) = max\{dp(i-1,1),dp(i-1,0)+prices[i]\}$

- Base Case

  - $dp(0,0)=0$
  - $dp(0,1)=-infinite$

- Code

  - ```java
    public int maxProfit(int[] prices) {
            if(prices==null||prices.length==0){
                return 0;
            }
            int maxProfit=0;
            int dp_i0=0;
            int dp_i1=Integer.MIN_VALUE;
            for(int i=1;i<prices.length+1;i++){
                dp_i1=Integer.max(dp_i1,dp_i0-prices[i-1]);
                dp_i0=Integer.max(dp_i0,dp_i1+prices[i-1]);
                maxProfit=Integer.max(maxProfit,dp_i0);
            }
            return maxProfit;
        }
    ```

### k = +infinity with cooldown

- 每次 sell 之后要等一天才能继续交易
- Base Case
  - $dp(0,0)=0$
  - $dp(0,1)=-infinite$
- $dp(i,0) = max\{dp(i-1,0), dp(i-1,1)+prices[i]\}$
- $dp(i,1) = max\{dp(i-1,1),dp(i-2,0)+prices[i]\}$

- code

  - ```java
    public int maxProfit(int[] prices) {
            if(prices==null||prices.length==0){
                return 0;
            }
            // int maxProfit=0;
            int dp_i0=0;
            int dp_i1=Integer.MIN_VALUE;
            int dp_i0_pre=0;
            for(int i=1;i<prices.length+1;i++){
                int temp=dp_i0;
                dp_i1=Integer.max(dp_i1,dp_i0_pre-prices[i-1]);
                dp_i0=Integer.max(dp_i0,dp_i1+prices[i-1]);
                dp_i0_pre=temp;
                // maxProfit=Integer.max(maxProfit,dp_i0);
            }
            return dp_i0;
        }
    ```

### k = +fee

- Base Case
  - $dp(0,0)=0$
  - $dp(0,1)=-infinite$
- $dp(i,0) = max\{dp(i-1,0), dp(i-1,1)+prices[i]\}$
- $dp(i,1) = max\{dp(i-1,1),dp(i-1,0)-prices[i]-fee\}$

- Code

  - ```java
    public int maxProfit(int[] prices, int fee) {
            if(prices==null||prices.length==0){
                return 0;
            }
            int dpi0=0;
            int dpi1=Integer.MIN_VALUE;
            for(int i=0;i<prices.length;i++){
                dpi0=Integer.max(dpi0,dpi1+prices[i]);
                dpi1=Integer.max(dpi1,dpi0-prices[i]-fee);
            }
            return dpi0;
        }
    ```

    

### k=2

- Base Case
  - $dp(0,k,0)=0$
  - $dp(0,k,1)=-infinite$

- 状态转移方程

  - $dp(i,k,0)=max\{dp(i-1,k,0),dp(i-1,k,1)+price(i)\}$

  - $dp(i,k,1) = max\{dp(i-1,k,1),dp(i-1,k-1,0)-price(i)\}$

- Code

  - 需要穷举所有状态

  - ```java
    public int maxProfit(int[] prices) {
            int [][][]dp=new int [prices.length+1][3][2];
    //         base case
    //         dp(0,k,0)=0
    //         dp(0,k,1)=-infinite
            dp[0][0][1]=Integer.MIN_VALUE;
            dp[0][1][1]=Integer.MIN_VALUE;
            dp[0][2][1]=Integer.MIN_VALUE;
    //         start dp
            for(int i=1;i<=prices.length;i++){
                dp[i][1][0]=Integer.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i-1]);
                dp[i][2][0]=Integer.max(dp[i-1][2][0],dp[i-1][2][1]+prices[i-1]);
                dp[i][1][1]=Integer.max(dp[i-1][1][1],dp[i-1][0][0]-prices[i-1]);
                dp[i][2][1]=Integer.max(dp[i-1][2][1],dp[i-1][1][0]-prices[i-1]);
            }
            return dp[prices.length][2][0];
            
        }
    ```

  - 状态压缩

    - ```java
      public int maxProfit(int[] prices) {
              int dp10=0;
              int dp11=Integer.MIN_VALUE;
              int dp20=0;
              int dp21=Integer.MIN_VALUE;
              for(int i=0;i<prices.length;i++){
                  dp10=Integer.max(dp10,dp11+prices[i]);
                  dp20=Integer.max(dp20,dp21+prices[i]);
               // 	dp00恒等于0 
                  dp11=Integer.max(dp11,-prices[i]);
      				// 		最多交易两次手里有股票：前一次就有；前一次没有股票，最多交易次数是i-1=1时买入了        
                  dp21=Integer.max(dp21,dp10-prices[i]);
              }
              return dp20;
          }
      ```

### k arbitray

```java
public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0){
//             prices是空的或者无，肯定不会产生利润
            return 0;
        }
//         dp[i][k][0]第i天，最大交易次数是k且手里没有股票时的最大收益
        int [][][]dp=new int [prices.length+1][k+1][2];
//         base case
//         dp[0][k][1]=-infinite
//         dp[0][k][0]=0
        for(int i=0;i<k+1;i++){
            dp[0][i][1]=Integer.MIN_VALUE;
        }
//         dp(i,k,0)=max{dp(i-1,k.0),dp(i-1,k,1)+prices(i-1)}
//         dp(i,k,1)=max{dp(i-1,k,1),dp(i-1,k-1,0)-prices(i-1)}
        for(int i=1;i<prices.length+1;i++){
            for(int j=1;j<k+1;j++){
                dp[i][j][0]=Integer.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i-1]);
                dp[i][j][1]=Integer.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i-1]);
            }
        }
        return dp[prices.length][k][0];
        
    }
```

## 正则匹配

- 如果不考虑通配符`*`

  - $s[i]==p[j]||p[j]=='.'$  匹配，i++，j++
  - 否则不匹配
  - 循环结束 $i!=j$ 则不匹配

- 考虑通配符`*`

  - 如果 $p[i+1]$ 是通配符`*`

    - $s[i]==p[j]$
      - $p[j]$ 可以匹配多个 $s[i]$ , 如s="aaa", p="a*"
      - $p[j]$ 可以匹配0个 $s[i]$ , 如s="aa", p="a*aa"

    - $s[i]!=p[j]$
      - $p[j]$ 可以匹配0个 $s[i]$ , 如s="bb", p="a*bb"
      - $p[j]$ 不匹配

- 状态转移方程

  - Base Case

    ```java
    dp[0][0]=true;
    ```

  - Recursion

    ```python
    if p[j]!='*':
    	if s[i]==p[j] or p[j]=='.':
      	dp[i][j]=dp[i-1][j-1]
    	else:
      	dp[i][j]=False
    else:
      if s[i]==p[j-1]:
        # 可以匹配一次或者不匹配
        #			匹配s的末尾字符，将该字符扔掉
        #										不匹配任何字符
        dp[i][j]=dp[i-1][j] or dp[i][j-2]
      else:
        # 只能不匹配仍和字符
        dp[i][j]=dp[i][j-2]
    
    ```

- Code

  ```java
  class Solution {
      public boolean isMatch(String s, String p) {
          int m = s.length();
          int n = p.length();
  
          boolean[][] f = new boolean[m + 1][n + 1];
          f[0][0] = true;
          for (int i = 0; i <= m; ++i) {
              for (int j = 1; j <= n; ++j) {
                  if (p.charAt(j - 1) == '*') {
                      f[i][j] = f[i][j - 2];
                      if (matches(s, p, i, j - 1)) {
                          f[i][j] = f[i][j] || f[i - 1][j];
                      }
                  } else {
                      if (matches(s, p, i, j)) {
                          f[i][j] = f[i - 1][j - 1];
                      }
                  }
              }
          }
          return f[m][n];
      }
  
      public boolean matches(String s, String p, int i, int j) {
          if (i == 0) {
              return false;
          }
          if (p.charAt(j - 1) == '.') {
              return true;
          }
          return s.charAt(i - 1) == p.charAt(j - 1);
      }
  }
  
  
  ```

  

# Hash Table

## 哈希表整合队列

### Top K Frequent Elements

- https://leetcode.com/problems/top-k-frequent-elements/

- ```java
  class Solution {
  //     TC O(n+n+k)
  //     SC o(n+n)
      public int[] topKFrequent(int[] nums, int k) {
  //         corner cases
          if(nums==null||nums.length==0){
              return null;
          }
  //        value-frequecen map
          Map<Integer,Integer> vf=new HashMap<>();
  //        record frequent
          for(int i=0;i<nums.length;i++){
              vf.put(nums[i],vf.getOrDefault(nums[i],0)+1);
          }
  //         large heap according to frequent in vf
          PriorityQueue<Integer> heap=new PriorityQueue(new Comparator<Integer>(){
              @Override
              public int compare(Integer o1, Integer o2) {
                  if(vf.get(o1)>vf.get(o2)){
                      return -1;
                  }else if (vf.get(o1)==vf.get(o2)){
                      return 0;
                  }else{
                      return 1;
                  }
              }
          });
  //         add data to heap
          for(Integer key: vf.keySet()){
              heap.add(key);
          }
  //         get the result
          int []res=new int [k];
          for(int i=0;i<k;i++){
              res[i]=heap.poll();
          }
          return res;
      }
  }
  ```

- 