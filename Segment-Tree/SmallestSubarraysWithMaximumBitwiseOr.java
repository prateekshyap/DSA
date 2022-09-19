/*https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/*/

class Solution {
    int[] segmentTree;
    int n, len;
    public int[] smallestSubarrays(int[] nums) {
        n = nums.length;
        if (n == 1)
            return new int[]{1};
        len = 4*n;
        segmentTree = new int[len];
        buildTree(nums, 0, n-1, 0); //build a segment tree with OR operation
        
        int[] result = new int[n];
        int curr = 0, start = n-1, end = n-1, maxOr = 0;
        while (start >= 0) //till start exceeds the limit
        {
            maxOr |= nums[start]; //or with maxor
            while (end > start) //till end reaches start
            {
                int reduce = findOrInRange(0,n-1,start,end-1,0); //if reducing the window does not reduce the ORed value
                if (reduce == maxOr)
                    --end; //reduce the window
                else break; //otherwise break
            }
            result[start] = end-start+1; //store the window size at the start of the window
            --start; //reduce start / extend the window
        }
        return result;
    }
    
    public void buildTree(int[] nums, int low, int high, int treeIndex)
    {
        if (low == high) //if low and high are colliding
        {
            segmentTree[treeIndex] = nums[low]; //store the value
            return; //return
        }
        int mid = low+((high-low)/2); //get the mid
        buildTree(nums,low,mid,2*treeIndex+1); //call for left subtree
        buildTree(nums,mid+1,high,2*treeIndex+2); //call for right subtree
        segmentTree[treeIndex] = segmentTree[2*treeIndex+1]|segmentTree[2*treeIndex+2]; //OR and store
    }
    
    public int findOrInRange(int low, int high, int left, int right, int treeIndex)
    {
        if (left > right) return 0; //if range is not correct, return
        if (low == left && high == right) return segmentTree[treeIndex]; //if indices are matching, return the value in the tree
        int mid = low+((high-low)/2); //get the mid
        //return the or of both the subtrees
        return findOrInRange(low,mid,left,Math.min(right,mid),2*treeIndex+1)|findOrInRange(mid+1,high,Math.max(mid+1,left),right,2*treeIndex+2);
    }
}

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] digits = new int[31];
        int[] res = new int[n];
        for (int i = n-1; i >= 0; i--)
        {
            int j = 0;
            int num = nums[i];
            while (num > 0)
            {
                if ((num & 1) > 0) digits[j] = i; //stores the indices where we visited 1 at the closest
                num >>= 1;
                j++;
            }
            int idx = i;
            for (j = 0; j < 31; j++)
                idx = Math.max(idx, digits[j]); //get the maximum distance
            res[i] = idx - i + 1; //store the window length
        }
        return res;
    }
}