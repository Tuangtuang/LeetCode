package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class GreedySolution {
//    https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/1.4-tan-xin-lei-xing-wen-ti/tan-xin-suan-fa-zhi-qu-jian-tiao-du-wen-ti
    //     greedy algorithm
//    435. Non-overlapping Intervals
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null||intervals.length==0){
            return 0;
        }
//        sort with end time, small to large
        Arrays.sort(intervals, new Comparator<int []>(){
            @Override
            public int compare(int []a, int b[]){
                if(a[1]<b[1]){
                    return -1;
                }else if(a[1]==b[1]){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
//         the interval with earliest end time must be in the set
        int count=1;
        int curEnd=intervals[0][1];
//         loop start with the seond interval
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=curEnd){
//                 the current interval can be put in the set
                curEnd=intervals[i][1];
                count++;
            }
        }
//         total intervals-the number of intervals in the selected
        return intervals.length-count;
    }

//     O(nlogn)
//     452. Minimum Number of Arrows to Burst Balloons
//    https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/1.4-tan-xin-lei-xing-wen-ti/tan-xin-suan-fa-zhi-qu-jian-tiao-du-wen-ti
    public int findMinArrowShots(int[][] points) {
        if(points==null||points.length==0){
            return 0;
        }
        Arrays.sort(points,new Comparator<int []>(){
            @Override
            public int compare(int a[],int b[]){
                if(a[1]==b[1]){
                    return 0;
                }else{
                    return a[1]>b[1]?1:-1;
                }
            }
        });
        int count=1;
        int curEnd=points[0][1];
        for(int i=1;i<points.length;){
//             find the ball can be shot together
            if(points[i][0]>curEnd){
//                 cannot be shot together
//                 set the fisrt one which cannot be shot as the new start
                curEnd=points[i][1];
//                 shot a row
                count++;
            }else{
//                 can be shot together
                i++;
            }
        }
        return count;
    }
}
