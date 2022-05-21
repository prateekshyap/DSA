/*https://leetcode.com/problems/perfect-squares/*/

class Solution {
    /*int[] sArr;
    int count;
    LinkedHashSet<Integer> squares;
    public int numSquares(int n) {
        squares = new LinkedHashSet<Integer>();
        int odd = 3, square = 1;
        
        
        while (square <= n)
        {
            squares.add(square);
            square += odd;
            odd += 2;
        }
        
        sArr = new int[squares.size()];
        int i = 0;
        Iterator it = squares.iterator();
        while (it.hasNext())
            sArr[i++] = (Integer)it.next();
        
        count = Integer.MAX_VALUE;
        recur(n,sArr.length-1,0);
        
        return count;
    }
    public void recur(int n, int index, int c)
    {
        if (n == 0 || squares.contains(n))
        {
            if (c < count) count = n == 0 ? c : c+1;
            return;
        }
        else if (n < 0) return;
        
        int newC;
        for (int i = index; i >= 0; --i)
            recur(n-sArr[i],index,c+1);
    }*/
    
    
    public int numSquares(int n) {
    int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++){
            dp[i]=n;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                int sq = j*j;
                if(sq>i)
                    break;
                if(dp[i] > (1+dp[i-sq])){
                     dp[i] = 1+dp[i-sq];
                }
            }
        }
        return dp[n];
    }
}