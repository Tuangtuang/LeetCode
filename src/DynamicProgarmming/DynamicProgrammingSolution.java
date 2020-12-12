package DynamicProgarmming;

import java.util.Arrays;
import java.util.Comparator;

public class DynamicProgrammingSolution {
    //     Coin Change
//     base case: f(0)=0
//     f[n]=min{f[n]-coins[i]+1}
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
//         init dp
        for (int i = 0; i < amount + 1; i++) {
//             the largest amount is using "amount" of 1 coin
//             amount+1 is impossible
//             why not use Integer.MAX_VALUE?
//             overflow become negative number then generate wrong answer
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
//                 no solution
                if (i - coins[j] < 0) {
                    continue;
                }
//                 compare current with the former one+1
                dp[i] = Integer.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    //     f(0,j)=j
//     f(i,0)=i
//     f(i,j)=min(f(i-1,j)+1,f(i,j-1)+1,f(i-1,j-1)+1) word1[i]!=word2[j]
//                 delete     insert        replace
//     f(i,j)=f(i-1,j-1) word1[i]==word2[j]
    public int minDistance(String word1, String word2) {
        int row = word1.length();
        int col = word2.length();
        int[][] dp = new int[row + 1][col + 1];
//         init
        for (int i = 0; i < row + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < col + 1; j++) {
            dp[0][j] = j;
        }
//         calculate
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = getMin(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                } else {
//                    chars are the same
//                    no need to do any operations
                    dp[i][j] = dp[i - 1][j - 1];
                }

            }
        }
        return dp[row][col];
    }

    public int getMin(int a, int b, int c) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    //     Longest Increasing Subsequence
// https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%AE%BE%E8%AE%A1%EF%BC%9A%E6%9C%80%E9%95%BF%E9%80%92%E5%A2%9E%E5%AD%90%E5%BA%8F%E5%88%97.md
//     dp[i] the length of longest increasing subsequence end with i
//     dp[0]=1
//     dp[i]=max(dp[i-k]+1), i-k nums smaller than nums[i]
//     res=max{dp[i]}
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int j = i - 1;
//             try to add the nums[i] into a former increasing sequence
//             find the one that make dp[i] largest
            while (j >= 0) {
                if (nums[j] >= nums[i]) {
                    j--;
                } else {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    j--;
                }
            }

        }
        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    //    354. Russian Doll Envelopes
//    https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/1.2-zi-xu-lie-lei-xing-wen-ti/xin-feng-qian-tao-wen-ti
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
//                     descending
                    return a[1] < b[1] ? 1 : -1;
                } else {
//                     ascendeing
                    return a[0] < b[0] ? -1 : 1;
                }
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
                j--;
            }
        }
        return max;
    }

    //    53. Maximum Subarray
//     dp[i] end with i, the max subarray
//     dp[0]=nums[0]
//     dp[i]=max{dp[i],dp[i-1]+dp[i]}
//     状态压缩，只和前一个状态有关
//    https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/1.2-zi-xu-lie-lei-xing-wen-ti/zui-da-zi-shu-zu
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            cur = Integer.max(cur, pre + cur);
            pre = cur;
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

    //     base case: dp[i][0]=0 dp[0][j]=0
//     dp[i][j]=dp[i-1][j-1] if s1[i]==s2[j]
//     dp[i][j]=max{dp[i-1][j],dp[i][j-1]} if s1[i]!=s2[j]
//    1143. Longest Common Subsequence
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null||text2==null){
            return 0;
        }
        int row=text1.length();
        int col=text2.length();
        if(row==0||col==0){
            return 0;
        }
        int [][]dp = new int [row+1][col+1];
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Integer.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[row][col];
    }


    //     base case dp[i][0]=i dp[0][j]=j
//     dp[i][j]=dp[i-1][j-1] if word1[i]==word2[j]
//     dp[i][j]=min{dp[i][j-1],dp[i-1][j]}+1 if word1[i]!=word2[j]
//    Delete Operation for Two Strings
    public int minDistanceDelete(String word1, String word2) {
        if(word1==null||word1.length()==0){
            return word2.length();
        }
        if(word2==null||word2.length()==0){
            return word1.length();
        }
        int row=word1.length();
        int col=word2.length();
        int [][]dp=new int [row+1][col+1];
        for(int i=0;i<=row;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=col;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
//                 no increasing distance
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                } else{
                    dp[i][j]=Integer.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[row][col];
    }

//     712. Minimum ASCII Delete Sum for Two Strings
    public int minimumDeleteSum(String s1, String s2) {
        int row=s1.length();
        int col=s2.length();
        int dp[][]=new int [row+1][col+1];
        for(int i=1;i<=row;i++){
            dp[i][0]=dp[i-1][0]+(int) s1.charAt(i-1);
        }
        for(int j=1;j<=col;j++){
            dp[0][j]=dp[0][j-1]+(int) s2.charAt(j-1);
        }
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Integer.min(dp[i][j-1]+(int)s2.charAt(j-1),dp[i-1][j]+(int)s1.charAt(i-1));
                }
            }
        }
        return dp[row][col];
    }


    //     dp[i][j],对于前i个数字，当前和为j时，能不能恰好组成j
//     dp[0][j]=false;
//     dp[i][0]=true;
//     dp[i][j]=dp[i-1][j] or dp[i-1][j-nums[i-1]] if nums[i-1]+j<=sum/2
    // = dp[i-1][j] nums[i-1]+j>sum/2
    // https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/1.3-bei-bao-lei-xing-wen-ti/bei-bao-zi-ji
//    416. Partition Equal Subset Sum
    public boolean canPartition(int[] nums) {
        if(nums==null){
            return false;
        }
        if(nums.length==1||nums.length==0){
            return false;
        }
//         get sum of the list
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1){
            return false;
        }

//         start dp
        boolean [][]dp=new boolean [nums.length+1][sum/2+1];
        for (int i = 0; i <= nums.length; i++){
            dp[i][0] = true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(nums[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]|dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum/2];
    }


    //     dp(i,j)用前i种coin，凑出j元的方法数
//     dp(0,j)=0
//     dp(i,0)=1
//     dp(i,j)=dp(i-1,j)+dp(i,j-conins[i-1])
//    518. Coin Change 2
    public int change(int amount, int[] coins) {
//         凑0元，只有一种方法，所有的硬币都不选
        if(amount==0){
            return 1;
        }
        if(coins==null||coins.length==0){
            return 0;
        }
        int row=coins.length+1;
        int col=amount+1;
        int [][]dp=new int [row][col];
        for(int i=0;i<dp.length;i++){
//             凑0元，不论用前几种coin，都只有一种方法：全不选
            dp[i][0]=1;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(j-coins[i-1]>=0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[row-1][col-1];
    }

}
