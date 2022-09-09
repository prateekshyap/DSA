/*https://leetcode.com/problems/append-k-integers-with-minimal-sum/*/

class Solution {
    public long minimalKSum(int[] nums, int k) {
        long result = (long)k*((long)k+1)/2;
        TreeSet<Long> treeSet = new TreeSet<Long>();
        for (int num : nums) treeSet.add((long)num);
        for (long num : treeSet)
        {
            if (k >= num)
            {
                result -= num;
                result += ++k;
            }
            else break;
        }
        return result;
    }
}

class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = -1;
        long sum = 0;
        for (int num : nums) {
            // Taking care of the duplicate numbers.
            if (prev == num) continue;
            // If num > k, we already have found the needed k numbers upto num. 
            if (num > k) break;
            k++;
            sum += num;
            prev = num;
        }
        
        return (long)(k + 1) * k / 2 - sum;
    }
}