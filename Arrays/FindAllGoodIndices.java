/*https://leetcode.com/problems/find-all-good-indices/*/

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        TreeSet<Integer> nonIn = new TreeSet<Integer>(), nonDec = new TreeSet<Integer>();
        for (int i = 0; i < n-1; ++i)
            if (nums[i+1] > nums[i])
                nonIn.add(i);
        for (int i = 0; i < n-1; ++i)
            if (nums[i+1] < nums[i])
                nonDec.add(i);
        List<Integer> result = new ArrayList<Integer>();
        for (int i = k; i < n-k; ++i)
        {
            Integer left = nonIn.lower(i);
            if (left != null && left == i-1) left = nonIn.lower(left);
            Integer right = nonDec.higher(i);
            if ((left != null && left >= i-k) || (right != null && right < i+k)) continue;
            else result.add(i);
        }
        return result;
    }
}

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] incScore = new int[nums.length];
        int[] decScore = new int[nums.length];
        
        int score = 0;
        
        for (int i = 1; i < nums.length; ++i){
            if (nums[i] <= nums[i - 1])
                decScore[i] = decScore[i - 1] + 1;
        }
        
        for (int i = nums.length - 2; i >= 0; --i){
            if (nums[i] <= nums[i + 1])
                incScore[i] = incScore[i + 1] + 1;
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i < nums.length - 1; ++i){
            if (incScore[i + 1] >= k - 1 && decScore[i - 1] >= k - 1)
                result.add(i);
        }
        
        return result;
    }
}