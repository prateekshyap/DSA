/*https://leetcode.com/problems/range-sum-query-mutable/*/

/*simple solution*/
class NumArray {
    int[] a;
    int s = 0;
    public NumArray(int[] nums) {
       a = nums;
       for (int i = 0; i < nums.length; ++i)
            s += nums[i];        
    }
    
    public void update(int index, int val) {
        s -= a[index];
        s += val;
        a[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int s1 = s;
        if (left == right) s1 = a[left];
        else
        {
        	if (left > 0) for(int i = 0; i < left; i++) s1 -= a[i];
        	if (a.length > 2 && right <= a.length-2) for(int i = right+1; i < a.length; ++i) s1 -= a[i];
        }
        return s1;
    }
}

/*segment tree solution*/
class NumArray {
    int[] arr;
    int[] segmentTree;
    int n, len;
    public NumArray(int[] nums) {
        this.arr = nums;
        this.len = nums.length;
        this.n = 4*len;
        this.segmentTree = new int[n];
        buildTree(nums, 0, len-1, 0);
    }
    
    public void buildTree(int[] nums, int low, int high, int treeIndex)
    {
        if (low == high)
        {
            segmentTree[treeIndex] = nums[low];
            return;
        }
        int mid = low+((high-low)/2);
        buildTree(nums,low,mid,2*treeIndex+1);
        buildTree(nums,mid+1,high,2*treeIndex+2);
        segmentTree[treeIndex] = segmentTree[2*treeIndex+1]+segmentTree[2*treeIndex+2];
    }
    
    public int findSumInRange(int low, int high, int left, int right, int treeIndex)
    {
        if (left > right) return 0;
        if (low == left && high == right) return segmentTree[treeIndex];
        int mid = low+((high-low)/2);
        return findSumInRange(low,mid,left,Math.min(right,mid),2*treeIndex+1)+findSumInRange(mid+1,high,Math.max(mid+1,left),right,2*treeIndex+2);
    }
    
    public void updateValueInTree(int low, int high, int index, int value, int treeIndex)
    {
        if (low == high)
        {
            segmentTree[treeIndex] = value;
            return;
        }
        int mid = low+((high-low)/2);
        if (index <= mid) updateValueInTree(low,mid,index,value,2*treeIndex+1);
        else updateValueInTree(mid+1,high,index,value,2*treeIndex+2);
        segmentTree[treeIndex] = segmentTree[2*treeIndex+1]+segmentTree[2*treeIndex+2];
    }
    
    public void update(int index, int val) {
        updateValueInTree(0,len-1,index,val,0);
    }
    
    public int sumRange(int left, int right) {
        return findSumInRange(0,len-1,left,right,0);
    }
}