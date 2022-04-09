/*
https://leetcode.com/problems/kth-largest-element-in-a-stream703. 
Kth Largest Element in a Stream
 
*/

class KthLargest {
    priority_queue<int, vector<int>, greater<int>> pq;
    int k;
public:
    KthLargest(int k, vector<int>& nums) {
        this->k = k;
        vector<int>::iterator endptr = nums.begin() + min(k, nums.size());
        pq = priority_queue<int, vector<int>, greater<int>> (nums.begin(), endptr);
        for(int i=k; i<nums.size(); i++)
        {
            pq.push(nums[i]);
            pq.pop();
        }
    }
    
    int add(int val) {
        pq.push(val);
        if(pq.size() > k) pq.pop(); // not needed when size is less than k
        return pq.top();
    }
    
    int min(int a, int b)
    {
        return a<b?a:b;
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */