/*https://leetcode.com/problems/count-special-integers/*/

class Solution {
    public int countSpecialNumbers(int n) 
    {
        String s = n + "";
        
        int result = 0;
        
        for (int i = 1; i < s.length(); ++i)
            result += countUniqueWithNDigits(i);
        
        int [] arr = new int [s.length()];
        
        for (int i = 0; i < arr.length; ++i)
            arr[i] = s.charAt(i) - '0';
        
        result += evaluate(arr , 0, new boolean [10], true);
        
        return result;
    }
    
    private int evaluate(int [] arr, int idx, boolean [] visited, boolean isEqual)
    {
        if (idx == arr.length)
            return 1;
        else if (!isEqual)
        {
            int length = arr.length - idx;
            return countWays(length, 10 - idx);
        }
        
        int result = 0;
        int start = idx == 0 ? 1 : 0;
        
        for (int i = start; i <= arr[idx]; ++i)
        {
            if (visited[i]) continue;
            
            visited[i] = true;
            
            result += evaluate(arr, idx + 1, visited, i == arr[idx]);
            
            visited[i] = false;
        }
        
        return result;
    }
    
    private int countUniqueWithNDigits(int n)
    {
        return 9 * countWays(n - 1, 9);
    }
    
    private int countWays(int n, int max)
    {
        int result = 1;
        
        for (int i = 1, j = max; i <= n; ++i, --j)
            result *= j;
        
        return result;
    }
}