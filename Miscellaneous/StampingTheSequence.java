/*https://leetcode.com/problems/stamping-the-sequence/*/

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] T = target.toCharArray(), S = stamp.toCharArray();
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] visited = new boolean[T.length];
        int i = 0, j = 0, sLen = stamp.length(), tLen = target.length(), stars = 0;
        while (stars < tLen)
        {
            boolean stamped = false;
            for (i = 0; i <= tLen-sLen; ++i)
            {
                if (!visited[i] && canBeStamped(S,T,i))
                {
                    stamped = true;
                    stars += stampProcess(T,sLen,i);
                    visited[i] = true;
                    result.add(i);
                    if (stars == tLen) break;
                }
            }
            if (!stamped) return new int[0];
        }
        int[] arr = new int[result.size()];
        for (i = arr.length-1, j = 0; i >= 0; --i, ++j)
            arr[i] = result.get(j);
        return arr;
    }
    private boolean canBeStamped(char[] S, char[] T, int start)
    {
        int s = S.length;
        for (int i = start; i < start+s; ++i)
            if (T[i] != '*' && T[i] != S[i-start])
                return false;
        return true;
    }
    private int stampProcess(char[] T, int sLen, int start)
    {
        int count = 0;
        for (int i = start; i < start+sLen; ++i)
            if (T[i] != '*')
            {
                T[i] = '*';
                ++count;
            }
        return count;
    }
}