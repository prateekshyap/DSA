/*https://leetcode.com/problems/jump-game-iii/*/

class Solution {
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        return check(arr,start);
    }
    private boolean check(int[] arr, int index)
    {
        if (arr[index] == 0) return true;
        if (visited[index]) return false;
        
        visited[index] = true;
        boolean result = false;
        
        if (index+arr[index] < arr.length) result |= check(arr,index+arr[index]);
        if (index-arr[index] >= 0) result |= check(arr,index-arr[index]);
        
        visited[index] = false;
        return result;
    }
}

class Solution {
    int[] arr;
    int start;
    boolean[] dp;
    public boolean canReach(int[] arr, int start) {
        this.arr=arr;
        this.start=start;
        dp=new boolean[arr.length];
        return dfs(start);
    }
    
    public boolean dfs(int index){
        if(index<0 || index>=arr.length){
            return false;
        }
        else if(dp[index]){
            return false;
        }
        if(arr[index]==0){
            return true;
        }
        dp[index]=true;
        return dfs(index+arr[index]) || dfs(index-arr[index]);
    }
}