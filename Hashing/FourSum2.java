/*https://leetcode.com/problems/4sum-ii/*/

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        int i, j;
        for (i = 0; i < nums1.length; ++i)
            for (j = 0; j < nums2.length; ++j)
                map1.put(nums1[i]+nums2[j],map1.getOrDefault(nums1[i]+nums2[j],0)+1);
        for (i = 0; i < nums3.length; ++i)
            for (j = 0; j < nums4.length; ++j)
                map2.put(nums3[i]+nums4[j],map2.getOrDefault(nums3[i]+nums4[j],0)+1);
        int result = 0;
        for (Map.Entry entry1 : map1.entrySet())
        {
            for (Map.Entry entry2 : map2.entrySet())
            {
                if ((Integer)entry1.getKey()+(Integer)entry2.getKey() == 0)
                    result += (Integer)entry1.getValue()*(Integer)entry2.getValue();
            }
        }
        return result;
    }
}

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int a : A)
            for (int b : B)
                m.put(a + b, m.getOrDefault(a + b, 0) + 1);
        for (int c : C)
            for (int d : D)
                cnt += m.getOrDefault(-(c + d), 0);
        return cnt;
    }
}