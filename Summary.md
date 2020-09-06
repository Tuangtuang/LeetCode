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

  