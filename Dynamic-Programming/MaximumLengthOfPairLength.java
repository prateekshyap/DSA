/*https://leetcode.com/problems/maximum-length-of-pair-chain/*/

class Pair implements Comparable<Pair>
{
    int a, b;
    Pair(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(Pair other)
    {
    return 0;
    }
    
    @Override
    public String toString()
    {
    return "("+a+","+b+")";
    }
}
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->(a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]));
        ArrayList<Pair> list = new ArrayList<Pair>();
        int result = 0, i = 0, low, high, mid, pos = -1;
        list.add(new Pair(pairs[i][0],pairs[i][1]));
        for (i = 1; i < pairs.length; ++i)
        {
            if (pairs[i][0] > list.get(list.size()-1).b) list.add(new Pair(pairs[i][0],pairs[i][1]));
            else
            {
                pos = -1;
                low = 0;
                high = list.size()-1;
                while (low <= high)
                {
                    mid = low+(high-low)/2;
                    if (list.get(mid).b < pairs[i][1])
                        low = mid+1;
                    else
                    {
                        pos = mid;
                        high = mid-1;
                    }
                }
                if (pos == -1) continue;
                list.set(pos,new Pair(pairs[i][0],pairs[i][1]));
            }
        }
        return list.size();
    }
}

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs)
            if (cur < pair[0])
            {
                cur = pair[1];
                ++ans;
            }
        return ans;
    }
}