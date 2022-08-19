/*https://leetcode.com/problems/split-array-into-consecutive-subsequences/*/

class Solution {
    public boolean isPossible(int[] nums) {
        int num, n = nums.length;
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int val : nums)
            map.put(val,map.getOrDefault(val,0)+1);
        Map<Integer,Integer> need = new HashMap<Integer,Integer>();
        while (n > 0)
        {
            num = map.firstKey();
            if (need.containsKey(num))
            {
                need.put(num,need.getOrDefault(num,0)-1); if (need.get(num) == 0) need.remove(num);
                need.put(num+1,need.getOrDefault(num+1,0)+1);
                map.put(num,map.get(num)-1); if (map.get(num) == 0) map.remove(num); --n;
            }
            else if (map.containsKey(num+1) && map.containsKey(num+2))
            {
                map.put(num,map.get(num)-1); if (map.get(num) == 0) map.remove(num); --n;
                map.put(num+1,map.get(num+1)-1); if (map.get(num+1) == 0) map.remove(num+1); --n;
                map.put(num+2,map.get(num+2)-1); if (map.get(num+2) == 0) map.remove(num+2); --n;
                need.put(num+3,need.getOrDefault(num+3,0)+1);
            }
            else return false;
        }
        return true;
    }
}