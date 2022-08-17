/*
https://leetcode.com/problems/largest-rectangle-in-histogram/
84. Largest Rectangle in Histogram
https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
*/

class Solution {
public:
    int largestRectangleArea_1(vector<int>& heights) {
        int n = heights.size();
        vector<int> leftSmaller(n, -1), rightSmaller(n, n);
        stack<int> st;
        int ans=0, area=0;
        
        for(int i=0; i<n; i++)
        {
            while(!st.empty() && heights[i] <= heights[st.top()])
                st.pop();
            
            if(!st.empty())
                leftSmaller[i] = st.top();
            
            st.push(i);
        }
        
//         for(int x: leftSmaller)
//             cout<<x<<" ";
        
        while(!st.empty())
            st.pop();
        
        for(int i=n-1; i>=0; i--)
        {
            while(!st.empty() && heights[i] <= heights[st.top()])
                st.pop();
            
            if(!st.empty())
                rightSmaller[i] = st.top();
            
            st.push(i);
        }
        // cout<<endl;
        // for(int x: rightSmaller)
        //     cout<<x<<" ";
        // cout<<endl;
        for(int i=0; i<n; i++)
        {
            area = (rightSmaller[i] - leftSmaller[i]-1)*heights[i];
            // cout<<area<<" ";
            if(area> ans)
                ans = area;
        }
        
        return ans;
    }//end
    
     int largestRectangleArea_2(vector<int>& heights) {
        int n = heights.size();
        vector<int> leftSmaller(n, -1), rightSmaller(n, n);
        // stack<int> st;
        int ans=0, area=0, pre=0;
        
        for(int i=1; i<n; i++)
        {
            pre=i-1;
            while(pre>=0 && heights[pre] >= heights[i])
                pre = leftSmaller[pre];
                
            leftSmaller[i] = pre;
        }
        
        // for(int x: leftSmaller)
        //     cout<<x<<" ";
        
        
        for(int i=n-2; i>=0; i--)
        {
            pre = i+1;
            
           while(pre<n && heights[i] <= heights[pre])
                pre = rightSmaller[pre];
                
            rightSmaller[i] = pre;
        }
        // cout<<endl;
        // for(int x: rightSmaller)
        //     cout<<x<<" ";
        // cout<<endl;
        for(int i=0; i<n; i++)
        {
            area = (rightSmaller[i] - leftSmaller[i]-1)*heights[i];
            // cout<<area<<" ";
            if(area> ans)
                ans = area;
        }
        
        return ans;
    }//end
    
    int largestRectangleArea(vector<int>& heights) {
        
        int n = heights.size();
        stack<int> st;
        int ans=0, h;
        
        for(int i=0; i<n; i++)
        {
            while(!st.empty() && heights[st.top()] > heights[i])
            {
                h = heights[st.top()]; st.pop();
                
                if(st.empty())
                    ans = max(ans, i*h);
                else
                    ans = max(ans, h*(i-st.top()-1));
                // cout<<i<<" "<<h<<" "<<ans<<endl;
            }
            st.push(i);
        }
        while(!st.empty() && heights[st.top()] > 0)
        {
            h = heights[st.top()]; st.pop();
            if(st.empty())
                ans = max(ans, n*h);
            else
                ans = max(ans, h*(n-st.top()-1));
            // cout<<n<<" "<<h<<" "<<ans<<endl;
        }
        
        return ans;
        
    }//end
};
