import ArrayString.ArrayStringTest;
import BinaryTree.BinaryTreeSolution;
import BinaryTree.BinaryTreeTest;
import LinkedList.LinkedListTest;
import QueueStack.QueueStackTest;
import QueueStack.MinStackTest;
import Recursion.RecursionTest;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Main {

    //LeetCode English, login in Github account TuangTuang
    public static void main(String[] args) {
        // write your code here
        ArrayStringTest arrayStringTest = new ArrayStringTest();
        arrayStringTest.testPivotIndex();
        arrayStringTest.testDominantIndex();
        arrayStringTest.testPlusOne();
        arrayStringTest.testFindDiagonalOrder();
        arrayStringTest.testSpiralOrder();
        arrayStringTest.testGenerate();
        arrayStringTest.testAddBinary();
        arrayStringTest.testStrStr();
        arrayStringTest.testLongestCommonPrefix();
        arrayStringTest.testReverseString();
        arrayStringTest.testArrayPairSum();
        arrayStringTest.testTwoSum();
        arrayStringTest.testRemoveElement();
        arrayStringTest.testFindMaxConsecutiveOnes();
        arrayStringTest.testMinSubArrayLen();
        arrayStringTest.testRotate();
        arrayStringTest.testGetRow();
        arrayStringTest.testReverseWords();
        arrayStringTest.testReverseWords2();
        arrayStringTest.testRemoveDuplicates();
        arrayStringTest.testMoveZeroes();
        arrayStringTest.testFindNumbers();
        arrayStringTest.testSortedSquares();
        arrayStringTest.testDuplicateZeros();
        arrayStringTest.testMerge();
        arrayStringTest.testValidMountainArray();
        arrayStringTest.testCheckIfExist();
        arrayStringTest.testReplaceElements();
        arrayStringTest.testSortArrayByParity();
        arrayStringTest.testHeightChecker();
        arrayStringTest.testThirdMax();
        arrayStringTest.testFindDisappearedNumbers();

//        Linked list
        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.testHasCycle();
        linkedListTest.testDetectCycle();
        linkedListTest.testRemoveNthFromEnd();
        linkedListTest.testReverseList();
        linkedListTest.testRemoveElements();
        linkedListTest.testOddEvenList();
        linkedListTest.testIsPalindrome();
        linkedListTest.testMergeTwoLists();
        linkedListTest.testAddTwoNumbers();
        linkedListTest.testRotateRight();

//        queue stack
        QueueStackTest queueStackTest = new QueueStackTest();
        queueStackTest.testNumIslands();
        queueStackTest.testOpenLock();
        queueStackTest.testNumSquares();
        queueStackTest.testBracketValid();
        queueStackTest.testDailyTemperatures();
        queueStackTest.testEvalRPN();
        queueStackTest.testNumIslandsDFS();
        queueStackTest.testFindTargetSumWays();
        queueStackTest.testDecodeString();
        queueStackTest.testFloodFill();
        queueStackTest.testUpdateMatrix();
        queueStackTest.testCanVisitAllRooms();

        MinStackTest minStackTest = new MinStackTest();
        minStackTest.testMinStack();

//        Binary Tree
        BinaryTreeTest binaryTreeTest = new BinaryTreeTest();
        binaryTreeTest.preorderTraversalTest();
        binaryTreeTest.postorderTraversalTest();
        binaryTreeTest.testLevelOrder();
        binaryTreeTest.testHasPathSum();
        binaryTreeTest.testBuildTree();
        binaryTreeTest.testConnect();
        binaryTreeTest.testConnect2();
        binaryTreeTest.testLowestCommonAncestor();

//        recursion
        RecursionTest recursionTest = new RecursionTest();
        recursionTest.testSwapPairs();
        recursionTest.testReverseList();
        recursionTest.testFib();
        recursionTest.testMyPow();
        recursionTest.testGenerateTrees();
        recursionTest.testIsValidBST();
        recursionTest.testSearchMatrix();
        recursionTest.testQueen2();
        recursionTest.testSolveSudoku();
        recursionTest.testCombine();
        recursionTest.testgenerateParentheses();
        recursionTest.testPermutation();
        recursionTest.testBinaryWatch();


    }
}
