/*https://leetcode.com/problems/ones-and-zeroes/*/

class Solution {
    HashMap<String,Integer> dp;
    public int findMaxForm(String[] s, int m, int n) {
        dp = new HashMap<String,Integer>();
        return recur(s, 0, m, n);
    }
    
    int recur(String[] s, int i, int m, int n)
    {
        if((m == 0 && n == 0) || i >= s.length) return 0;
        
        String key = m+"#"+n+"#"+i;
        
        if (dp.containsKey(key)) return dp.get(key);

        int M = m;
        int N = n;
       
        String st = s[i];
        for (char ch: st.toCharArray())
        {
            if (ch == '0') M--;
            else N--;
        }

        if (M < 0 || N < 0)
        {
            dp.put(key,recur(s,i+1,m,n));
            return dp.get(key);
        }
        
        dp.put(key,Math.max(recur(s,i+1,m,n),1+recur(s, i+1, M, N)));
        return dp.get(key);
    }
}

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int ones = 0;
        int zeros = 0;
        for (String s : strs)
        {
            ones = countOnes(s);
            zeros = countZeros(s);
            for (int i = m; i >= zeros; --i)
                for(int j = n; j >= ones; --j)
                   dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones]+1);
            
        }
        return dp[m][n];
    }
    public int countOnes(String s)
    {
        int count = 0;
        for (char ch : s.toCharArray())
            if (ch == '1')
                count += 1;
        return count;
    } 
    public int countZeros(String s)
    {
        int count = 0;
        for (char ch : s.toCharArray())
            if (ch == '0')
                count += 1;
        return count;
    } 
}

class Solution {
    int[] zeros, ones;
    Integer[][][] store;
    public int findMaxForm(String[] strs, int m, int n) {
        zeros = new int[strs.length]; ones = new int[strs.length];
        store = new Integer[m+1][n+1][strs.length+1];
        for (int i = 0; i < strs.length; ++i)
        {
            zeros[i] = countZeros(strs[i]);
            ones[i] = countOnes(strs[i]);
        }
        store[0][0][0] = countElements(strs, m, n, 0, 0, 0);
        return store[0][0][0];
    }
    private int countElements(String[] strs, int m, int n, int zc, int oc, int index)
    {
        if (index == strs.length) return 0;
        if (store[zc][oc][index] != null) return store[zc][oc][index];
        int result = 0;
        if (zc+zeros[index] <= m && oc+ones[index] <= n)
            result = Math.max(countElements(strs, m, n, zc, oc, index+1),countElements(strs, m, n, zc+zeros[index], oc+ones[index], index+1)+1);
        else result = countElements(strs, m, n, zc, oc, index+1);
        store[zc][oc][index] = result;
        return store[zc][oc][index];
    }
    public int countOnes(String s)
    {
        int count = 0;
        for (char ch : s.toCharArray())
            if (ch == '1')
                count += 1;
        return count;
    } 
    public int countZeros(String s)
    {
        int count = 0;
        for (char ch : s.toCharArray())
            if (ch == '0')
                count += 1;
        return count;
    } 
}
