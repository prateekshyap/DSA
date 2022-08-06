/*https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1*/
/*https://binarysearch.com/problems/Longest-Increasing-Subsequence*/

class Solution 
{
    static int longestSubsequence(int size, int a[])
    {
        int[] result = new int[size];
        for (int i = 0; i < size; ++i)
            result[i] = 1;
        for (int i = 1; i < size; ++i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (a[i] > a[j] && result[i] < result[j]+1)
                    result[i] = result[j]+1;
            }
        }
        int max = result[0];
        for (int i = 1; i < size; ++i)
            max = Math.max(max, result[i]);
        return max;
    }
} 

class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        int result = 0, i = 0, low, high, mid, pos = -1;
        list.add(a[i]);
        for (i = 1; i < size; ++i)
        {
            if (a[i] > list.get(list.size()-1)) list.add(a[i]);
            else
            {
                pos = -1;
                low = 0;
                high = list.size()-1;
                while (low <= high)
                {
                    mid = low+(high-low)/2;
                    if (list.get(mid) >= a[i])
                    {
                        pos = mid;
                        high = mid-1;
                    }
                    else low = mid+1;
                }
                list.set(pos,a[i]);
            }
        }
        return list.size();
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