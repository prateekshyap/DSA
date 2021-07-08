/*https://practice.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1*/

class Solution{
    public static int NumberofElementsInIntersection(int a[],int b[],int n,int m)
    {
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        int min = m < n ? m : n;
        int max = m < n ? n : m;
        int[] minArr = m < n ? b : a;
        int[] maxArr = m < n ? a : b;
        for (int i = 0; i < min; ++i)
            map.put(minArr[i],true);
        int count = 0;
        for (int i = 0; i < max; ++i)
            if (map.containsKey(maxArr[i]) && map.get(maxArr[i]))
            {
                ++count;
                map.put(maxArr[i],false);
            }
        return count;
    }
}