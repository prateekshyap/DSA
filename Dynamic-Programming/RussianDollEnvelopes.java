/*https://leetcode.com/problems/russian-doll-envelopes/*/

//recursion+memo TLE
class Solution {
    Integer[] table;
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->(a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
        table = new Integer[envelopes.length+1];
        int result = 1;
        for (int i = envelopes.length-1; i > 0; --i)
            result = Math.max(result,1+putInside(envelopes,i));
        return result;
    }
    private int putInside(int[][] envelopes, int lastAdded)
    {
        if (lastAdded == 0) return 0;
        if (table[lastAdded] != null) return table[lastAdded];
        table[lastAdded] = 0;
        for (int i = lastAdded-1; i >= 0; --i)
        {
            if (envelopes[lastAdded][0] > envelopes[i][0] && envelopes[lastAdded][1] > envelopes[i][1])
            {
                if (table[i] == null || table[i]+1 > table[lastAdded])
                    table[lastAdded] = Math.max(table[lastAdded],1+putInside(envelopes,i));
            }
        }
        return table[lastAdded];
    }
}

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
    Integer[] table;
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->(a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]));
        ArrayList<Pair> list = new ArrayList<Pair>();
        int result = 0, i = 0, low, high, mid, pos = -1;
        list.add(new Pair(envelopes[i][0],envelopes[i][1]));
        for (i = 1; i < envelopes.length; ++i)
        {
            if (envelopes[i][1] > list.get(list.size()-1).b) list.add(new Pair(envelopes[i][0],envelopes[i][1]));
            else
            {
                pos = -1;
                low = 0;
                high = list.size()-1;
                while (low <= high)
                {
                    mid = low+(high-low)/2;
                    if (list.get(mid).b < envelopes[i][1])
                        low = mid+1;
                    else
                    {
                        pos = mid;
                        high = mid-1;
                    }
                }
                list.set(pos,new Pair(envelopes[i][0],envelopes[i][1]));
            }
        }
        return list.size();
    }
}