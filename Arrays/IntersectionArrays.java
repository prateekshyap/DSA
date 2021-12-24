/*https://practice.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1*/

//need to return the count
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

/*https://leetcode.com/problems/intersection-of-two-arrays/*/

//need to return the elements
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        Set<Integer> set = new HashSet<Integer>();
        int min = m < n ? m : n;
        int max = m < n ? n : m;
        int[] minArr = null;
        int[] maxArr = null;
        minArr = m < n ? nums1 : nums2;
        maxArr = m < n ? nums2 : nums1;
        for (int i = 0; i < min; ++i)
            map.put(minArr[i],true);
        for (int i = 0; i < max; ++i)
            if (map.containsKey(maxArr[i]) && map.get(maxArr[i]))
            {
                set.add(maxArr[i]);
                map.put(maxArr[i],false);
            }
        int[] arr = new int[set.size()];
        Iterator iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext())
            arr[index++] = (Integer)iterator.next();
        return arr;
    }
}

/*https://leetcode.com/problems/intersection-of-two-arrays-ii/*/

//need to retain the duplicates
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int min = m < n ? m : n;
        int max = m < n ? n : m;
        int[] minArr = null;
        int[] maxArr = null;
        minArr = m < n ? nums1 : nums2;
        maxArr = m < n ? nums2 : nums1;
        
        for (int i = 0; i < min; ++i)
            map.put(minArr[i],(map.containsKey(minArr[i]) ? (Integer)map.get(minArr[i])+1 : 1));
        
        for (int i = 0; i < max; ++i)
            if (map.containsKey(maxArr[i]) && map.get(maxArr[i]) > 0)
            {
                list.add(maxArr[i]);
                map.put(maxArr[i],(Integer)map.get(maxArr[i])-1);
            }
        
        int index = 0;
        int[] arr = new int[list.size()];
        for (Integer i : list)
            arr[index++] = i;
        return arr;
    }
}