/*
https://leetcode.com/problems/next-greater-element-ii/
503. Next Greater Element II

https://binarysearch.com/problems/Circular-Greater-Element-to-the-Right
*/

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        
        vector<int> ans(nums.size());
        stack<int> st;
        // st.push(INT_MIN);
        
        //insert all elements in reverse order
        for(int i=nums.size()-1; i>=0; i--)
            st.push(nums[i]);
        
        for(int i=nums.size()-1; i>=0; i--)
        {
            while(!st.empty() && st.top() <= nums[i])
                st.pop();
            
            ans[i] = st.empty()? -1 : st.top();
            
            st.push(nums[i]);
        } 
        
        return ans;
    }//end
};

vector<int> solve_1(vector<int>& nums) {
    
    stack<int> st;
    vector<int> ans(nums.size());

    st.push(-1);
    for(int i=nums.size()-1; i>=0; i--)
        st.push(nums[i]);
    
    for(int i=nums.size()-1; i>=0; i--)
    {
        while(st.top()!=-1 && st.top()<= nums[i])
            st.pop();
        
        ans[i] = st.top();

        st.push(nums[i]);
    }

    return ans;
}

vector<int> solve_2(vector<int>& nums) {
    
    vector<int> st;
    vector<int> ans(nums.size());

    st.push_back(-1);
    for(int i=nums.size()-1; i>=0; i--)
        st.push_back(nums[i]);
    
    for(int i=nums.size()-1; i>=0; i--)
    {
        while(st.back()!=-1 && st.back()<= nums[i])
            st.pop_back();
        
        ans[i] = st.back();

        st.push_back(nums[i]);
    }

    return ans;
}

vector<int> solve_3(vector<int>& nums) {
    
    int n = nums.size();
    vector<int> ans(n, -1);
    nums.insert(nums.end(), nums.begin(), nums.end());  
    stack<int> st;

    for(int i=0; i<2*n; i++)
    {
        while(!st.empty() && nums[st.top()] < nums[i])
        {
            if(st.top()<n)
                ans[st.top()] = nums[i];
            st.pop();
        }
        st.push(i);
    }


    return ans;
}

vector<int> solve(vector<int>& nums) {
    
    int n = nums.size();
    int i = distance(nums.begin(), max_element(nums.begin(), nums.end()));
    
    stack<int> st;

    for(int j=0; j<n; j++)
    {
        int x = nums[i];
        while(!st.empty() && st.top() <= nums[i])
            st.pop();

        nums[i] = st.empty() ? -1 : st.top();

        st.push(x);
        
        i = (n + ((i - 1) % n)) % n;
    }


    return nums;
}
