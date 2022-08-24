/*https://leetcode.com/problems/jump-game-v/*/

class Solution {
    int N;
    Integer[] store;
    public int maxJumps(int[] arr, int d) {
        int result = 0, i;
        N = arr.length;
        store = new Integer[N];
        for (i = 0; i < N; ++i)
            result = Math.max(result,count(arr,d,i)+1);
        return result;
    }
    private int count(int[] arr, int d, int index)
    {
        if (store[index] != null) return store[index];
        
        int result = 0;
        
        for (int i = index-1; i >= Math.max(index-d,0); --i)
        {
            if (arr[i] < arr[index])
                result = Math.max(count(arr,d,i)+1,result);
            else break;
        }
        for (int i = index+1; i <= Math.min(index+d,N-1); ++i)
        {
            if (arr[i] < arr[index])
                result = Math.max(count(arr,d,i)+1,result);
            else break;
        }
        
        return store[index] = result;
    }
}