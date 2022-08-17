/*
https://practice.geeksforgeeks.org/problems/special-stack/1

https://leetcode.com/problems/min-stack/
155. Min Stack

*/

class MinStack {
public:
    stack<long int> st;
    long int mini ;
    
    MinStack() {
        
    }
    
    void push(int val) {
        if(st.empty())
            mini = val;
        else if(val < mini)
        {
            st.push((long int)2*val - mini);
            mini = val;
            return;
        }
        st.push(val);
    }
    
    void pop() {
        if(st.top() < mini)
            mini = 2*mini  - st.top();
        st.pop();
    }
    
    int top() {
        if(st.top() < mini)
            return mini;
        
        return st.top();
    }
    
    int getMin() {
         return mini;
    }
    
    /*
    stack<pair<int,int>> st;
    int mini = INT_MAX;
    MinStack() {
        
    }
    
    void push(int val) {
        if(st.empty())
            mini = val;
        else
            mini = min(st.top().second, val); // cur val ya old min val
        st.push({val, mini});
    }
    
    void pop() {
        st.pop();
    }
    
    int top() {
        return st.top().first;
    }
    
    int getMin() {
         return st.top().second;
    }
    */
};

/*
class MinStack {
public:
    stack<int> st;
    stack<int> minst;
    int minval = 0;
    
    MinStack() {
        
    }
    
    void push(int val) {
        st.push(val);
        if(minst.empty() || val <= minst.top())
            minst.push(val);
    }
    
    void pop() {
        if(minst.top()==st.top())
            minst.pop();
        st.pop();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return minst.top();
    }
};

*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */

