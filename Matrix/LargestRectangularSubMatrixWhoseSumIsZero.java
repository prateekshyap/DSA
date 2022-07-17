/*https://practice.geeksforgeeks.org/problems/largest-rectangular-sub-matrix-whose-sum-is-0/1/*/

class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] M) {
        // code here
        int R = M.length, C = M[0].length;
        int[][] preSum = new int[R+1][C];
        int c, i, j, rs, re, col, maxSum = Integer.MIN_VALUE, sum, ansRS = -1, ansRE = -1, ansCS = -1, ansCE = -1, prevSize = -1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (i = 1; i <= R; ++i)
            for (j = 0; j < C; ++j)
                preSum[i][j] = preSum[i-1][j]+M[i-1][j];
        
        for (rs = 0; rs < R; ++rs)
        {
            for (re = rs+1; re <= R; ++re)
            {
                map = new HashMap<Integer,Integer>();
                map.put(0,-1);
                sum = 0;
                for (col = 0; col < C; ++col)
                {
                    sum += preSum[re][col]-preSum[rs][col];
                    if (map.containsKey(sum))
                    {
                        c = (Integer)map.get(sum);
                        if ((re-rs)*(col-c) > prevSize)
                        {
                            ansRS = rs;
                            ansRE = re-1;
                            ansCS = c+1;
                            ansCE = col;
                            prevSize = (re-rs)*(col-c);
                        }
                        else if ((re-rs)*(col-c) == prevSize && col-c > ansCE-ansCS+1)
                        {
                            ansRS = rs;
                            ansRE = re-1;
                            ansCS = c+1;
                            ansCE = col;
                        }
                    }
                    else map.put(sum,col);
                }
            }
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (ansRS == -1)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(-1);
            list.add(temp);
            return list;
        }
        for (i = ansRS; i <= ansRE; ++i)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (j = ansCS; j <= ansCE; ++j)
                temp.add(M[i][j]);
            list.add(temp);
        }
        return list;
    }
}
        
