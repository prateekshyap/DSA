/*https://leetcode.com/problems/keep-multiplying-found-values-by-two/*/

class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums)
            set.add(num);
        if (!set.contains(original)) return original;
        while (set.contains(original))
            original *= 2;
        return original;
    }
}

class Solution {
    public int findFinalValue(int[] nums, int original) {
        while(isFound(nums, original)){
            if(isFound(nums, original)){
                original = 2*original;
            }else{
                break;
            }
        }
        return original;
    }
    
    public static boolean isFound(int[] nums, int original){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == original)
                return true;
        }
        return false;
    }
}