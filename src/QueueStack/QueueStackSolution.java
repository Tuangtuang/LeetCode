package QueueStack;

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
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int rows=grid.length;
        int cols=grid[0].length;
        int count=0;
        boolean [][]visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(visited[i][j]==false&&grid[i][j]=='1'){
                    // BFS
                    visited[i][j]=true;
                    BFS(visited,grid,i,j,rows,cols);
                    count++;
                }
            }
        }
        return count;
    }

    public void BFS(boolean [][]visited, char [][]grid,int rowIndex,int colIndex,int rows,int cols){
        Queue<Integer> queue = new LinkedList<>();
        int pos=rowIndex*cols+colIndex;
        queue.offer(pos);
        while (!queue.isEmpty()){
            int curPos=queue.poll();
            int i=curPos/cols;
            int j=curPos%cols;
            // up
            if(!outBound(rows,cols,i-1,j)&&!visited[i-1][j]&&grid[i-1][j]=='1'){
                queue.offer((i-1)*cols+j);
                visited[i-1][j]=true;
            }
            // down
            if(!outBound(rows,cols,i+1,j)&&!visited[i+1][j]&&grid[i+1][j]=='1'){
                queue.offer((i+1)*cols+j);
                visited[i+1][j]=true;
            }
            // left
            if(!outBound(rows,cols,i,j-1)&&!visited[i][j-1]&&grid[i][j-1]=='1'){
                queue.offer(i*cols+j-1);
                visited[i][j-1]=true;
            }
            // right
            if(!outBound(rows,cols,i,j+1)&&!visited[i][j+1]&&grid[i][j+1]=='1'){
                queue.offer(i*cols+j+1);
                visited[i][j+1]=true;
            }
        }
    }

    public boolean outBound(int row,int col,int i, int j){
        if(i>=0&&i<row&&j>=0&&j<col){
            return false;
        }
        return true;
    }


//    Open the Lock
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet=new HashSet<String>();
        Collections.addAll(deadSet, deadends);
        Set<String> visited = new HashSet<>();
        if(deadSet.contains(target)||deadSet.contains("0000")){
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        String mark = "*";
        q.offer("0000");
        q.offer(mark);
        int depth=0;
        while (!q.isEmpty()){
            String curNode=q.poll();
            if(target.equals(curNode)){
                return depth;
            }
            if(deadSet.contains(curNode)||visited.contains(curNode)){
                continue;
            }
            if (curNode.equals(mark)&&q.isEmpty()) {
                return -1;
            }
            if(curNode.equals(mark)){
                q.offer(mark);
                depth++;
            }else {
                visited.add(curNode);
                q.addAll(getNextLevel(curNode));
            }
        }

        return depth;

    }

    public LinkedList<String> getNextLevel(String str){
        LinkedList<String> res=new LinkedList<>();
        for(int i=0;i<str.length();i++){
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 :  str.charAt(i) - '0' - 1) + str.substring(i+1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 :  str.charAt(i) - '0' + 1) + str.substring(i+1));
        }
        return res;
    }
}
