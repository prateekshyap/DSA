/*https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/*/

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> heap = new PriorityQueue<String>((a,b)->(a.length() == b.length() ? a.compareTo(b) : a.length()-b.length()));
        for (String num : nums)
        {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }
}