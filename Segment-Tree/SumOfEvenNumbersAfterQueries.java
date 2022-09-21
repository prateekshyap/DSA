/*https://leetcode.com/problems/sum-of-even-numbers-after-queries/*/

class Solution {
    int[] segmentTree;
    int sLen;
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length, sLen = n*4, i = 0;
        segmentTree = new int[sLen];
        buildSegmentTree(nums,0,n-1,0);
        int[] result = new int[queries.length];
        for (int[] query : queries)
        {
            update(0, n-1, 0, query[1], query[0]);
            result[i++] = segmentTree[0]%2 == 0 ? segmentTree[0] : 0;
        }
        return result;
    }
    private boolean buildSegmentTree(int[] nums, int low, int high, int treeIndex)
    {
        if (low == high)
        {
            segmentTree[treeIndex] = nums[low];
            return nums[low]%2 == 0 ? true : false;
        }
        int mid = low+(high-low)/2;
        boolean left = buildSegmentTree(nums, low, mid, treeIndex*2+1);
        boolean right = buildSegmentTree(nums, mid+1, high, treeIndex*2+2);
        segmentTree[treeIndex] = (left ? segmentTree[treeIndex*2+1] : 0)+(right ? segmentTree[treeIndex*2+2] : 0);
        return true;
    }
    private boolean update(int low, int high, int treeIndex, int index, int value)
    {
        if (low == high)
        {
            segmentTree[treeIndex] += value;
            return Math.abs(segmentTree[treeIndex])%2 == 0 ? true : false;
        }
        int mid = low+(high-low)/2;
        boolean result = true;
        if (index <= mid)
        {
            int oldVal = segmentTree[treeIndex*2+1];
            oldVal = oldVal%2 == 0 ? oldVal : 0;
            result = update(low, mid, treeIndex*2+1, index, value);
            if (result) segmentTree[treeIndex] = segmentTree[treeIndex]-oldVal+segmentTree[treeIndex*2+1];
            else segmentTree[treeIndex] = segmentTree[treeIndex]-oldVal;
        }
        else
        {
            int oldVal = segmentTree[treeIndex*2+2];
            oldVal = oldVal%2 == 0 ? oldVal : 0;
            result = update(mid+1, high, treeIndex*2+2, index, value);
            if (result) segmentTree[treeIndex] = segmentTree[treeIndex]-oldVal+segmentTree[treeIndex*2+2];
            else segmentTree[treeIndex] = segmentTree[treeIndex]-oldVal;
        }
        return true;
    }
}

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length, i = 0, sum = 0;
        for (int num : nums)
            sum += num%2 == 0 ? num : 0;
        int[] result = new int[queries.length];
        for (int[] query : queries)
        {
            int index = query[1];
            int value = query[0];
            int oldValue = nums[index];
            oldValue = oldValue%2 == 0 ? oldValue : 0;
            nums[index] += value;
            sum = nums[index]%2 == 0 ? sum-oldValue+nums[index] : sum-oldValue;
            result[i++] = sum;
        }
        return result;
    }
}

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length, i = 0, sum = 0;
        for (int num : nums)
            if ((num&1) == 0)
                sum += num;
        int[] result = new int[queries.length];
        for (int[] query : queries)
        {
            int index = query[1];
            int value = query[0];
            int oldValue = nums[index];
            if ((oldValue&1) != 0) oldValue = 0;
            sum -= oldValue;
            nums[index] += value;
            if ((nums[index]&1) == 0) sum += nums[index];
            result[i++] = sum;
        }
        return result;
    }
}