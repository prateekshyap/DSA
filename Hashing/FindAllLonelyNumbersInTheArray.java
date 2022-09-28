/*https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/*/

class Solution {
    public List<Integer> findLonely(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);
        List<Integer> result = new ArrayList<Integer>();
        for (Map.Entry entry : map.entrySet())
        {
            int num = (Integer)entry.getKey();
            int freq = (Integer)entry.getValue();
            if (map.containsKey(num+1) || map.containsKey(num-1) || freq > 1) continue;
            result.add(num);
        }
        return result;
    }
}

class Solution {
    public List<Integer> findLonely(int[] nums) {
        int[] map = new int[(int)(1e6+2)];
        for (int num : nums)
            ++map[num];
        List<Integer> result = new ArrayList<Integer>();
        if (map[1] == 0 && map[0] == 1) result.add(0);
        for (int i = 1; i <= 1e6; ++i)
        {
            if (map[i-1] > 0 || map[i+1] > 0 || map[i] > 1) continue;
            if (map[i] != 0) result.add(i);
        }
        return result;
    }
}

class Solution {
    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int j = nums.length - 1;
        if(nums.length == 1){
            list.add(nums[0]);
            return list;
        } 
        if(nums[0] != nums[1] - 1 && nums[0] != nums[1])
            list.add(nums[0]);
        if(nums[j] != nums[j - 1] + 1 && nums[j] != nums[j - 1])
            list.add(nums[j]);
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1] && nums[i] != nums[i-1] +1 && nums[i] != nums[i+1] -1)
                list.add(nums[i]);
        }
        return list;
    }
}