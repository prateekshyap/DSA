/*https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/*/

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int result = 0, key, val;
        boolean flag = true, check;
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);
        for (Map.Entry elem : map.entrySet())
        {
            key = (Integer)elem.getKey();
            val = (Integer)elem.getValue();
            check = true;
            for (int div : numsDivide)
            {
                if (div < key || div%key != 0)
                {
                    check = false;
                    break;
                }
            }
            if (!check) result += val;
            else return result;
        }
        if (!flag) return -1;
        if (result == nums.length) return -1;
        return result;
    }
}

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        
        int gcd = numsDivide[0];
        
        for (int num : numsDivide){
            gcd = gcd(gcd, num);
        }
        
        for (int i = 0; i < nums.length; ++i){
            if (gcd % nums[i] == 0)
                return i;
        }
        
        return -1;
    }
    
    private int gcd(int a , int b){
        if (a % b == 0)
            return b;
        
        return gcd(b, a % b);
    }
}