/*https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-given-n-ranges/1/*/

class Pair implements Comparable<Pair>
{
    int a, b;
    Pair(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public int compareTo(Pair p)
    {
        return 0;
    }
    
    @Override
    public String toString()
    {
        return "("+this.a+" "+this.b+")";
    }
}

class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        Arrays.sort(range, new Comparator<int[]>(){ //sort according to the starting number of the ranges
            public int compare(int[] a1, int[] a2)
            {
                return a1[0]-a2[0];
            }
        });
        ArrayList<Pair> ranges = new ArrayList<Pair>();
        ranges.add(new Pair(range[0][0],range[0][1])); //add the first range
        int i;
        for (i = 1; i < n; ++i) //for all other ranges
        {
            if (ranges.get(ranges.size()-1).b+1 >= range[i][0]) //if the ranges overlap
                ranges.get(ranges.size()-1).b = Math.max(ranges.get(ranges.size()-1).b,range[i][1]); //update the ending value of the range
            else //otherwise
                ranges.add(new Pair(range[i][0],range[i][1])); //add a new range
        }

        //find the count and prefix sum for the ranges
        int len = ranges.size();
        int[] count = new int[len], preSum = new int[len];
        for (i = 0; i < len; ++i)
            count[i] = ranges.get(i).b-ranges.get(i).a+1;
        preSum[0] = count[0];
        for (i = 1; i < len; ++i)
            preSum[i] = preSum[i-1]+count[i];

        ArrayList<Integer> result = new ArrayList<Integer>();
        int low, high, mid, lowerBound = len;
        for (int query : queries) //for each query
        {
            if (query <= preSum[0]) //if it lies in the first range
                result.add(ranges.get(0).a+query-1); //add the answer
            else if (query > preSum[len-1]) //if it is out of range
                result.add(-1); //add -1
            else //otherwise do a binary search to find out the lower bound for the query in the prefix array
            {
                low = 0; high = len-1; lowerBound = len;
                while (low <= high)
                {
                    mid = low+(high-low)/2;
                    if (preSum[mid] < query)
                    {
                        lowerBound = mid;
                        low = mid+1;
                    }
                    else high = mid-1;
                }
                query -= preSum[lowerBound]; //subtract the lower bound from the query
                result.add(ranges.get(lowerBound+1).a+query-1); //add the answer
            }
        }
        return result;
    }
}