/*https://leetcode.com/problems/sort-array-by-increasing-frequency/*/

class Solution {
    public int[] frequencySort(int[] nums) {
        int[] hash = new int[201];
        int offset = 100;
        for (int num : nums)
            ++hash[num+offset];
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b)->(a[1] == b[1] ? b[0]-a[0] : a[1]-b[1]));
        for (int i = 0; i <= 200; ++i)
            if (hash[i] != 0)
                heap.add(new int[]{i-offset,hash[i]});
        int index = 0;
        while (!heap.isEmpty())
        {
            int[] data = heap.poll();
            for (int i = 0; i < data[1]; ++i)
                nums[index++] = data[0];
        }
        return nums;
    }
}