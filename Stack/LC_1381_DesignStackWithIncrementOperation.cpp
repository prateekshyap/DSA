/*
https://leetcode.com/problems/design-a-stack-with-increment-operation/
1381. Design a Stack With Increment Operation

*/

class CustomStack {
public:
    vector<int> st;
    int size;
    CustomStack(int maxSize) {
        size = maxSize;
    }
    
    void push(int x) {
        if(st.size() == size)
            return; //ignore the element
        
        st.push_back(x);
    }
    
    int pop() {
        if(st.size() == 0)
            return -1; // stack empty return -1
        int value = st.back();
        st.pop_back();
        return value;
    }
    
    void increment(int k, int val) {
        if(st.size() == 0)
            return;
        
        int sz = k; // 
        if(st.size() < k)
            sz = st.size();
        for(int i=0; i<sz; i++)
            st[i] += val;
    }
};

/*
class CustomStack {
    
    vector<int> st;
    int top;
    
public:
    
    CustomStack(int maxSize) {
        st.resize(maxSize);
        top = -1;
    }
    
    void push(int x) {
        if(st.size() == top+1)
            return; //ignore the element
        
        st[++top] = x;
    }
    
    int pop() {
        if(top == -1)
            return -1; // stack empty return -1
        
        return st[top--];
    }
    
    void increment(int k, int val) {
        if(top == -1)
            return;
        
        int sz = min(k, top+1); // 
        
        for(int i=0; i<sz; i++)
            st[i] += val;
    }
};

*/
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack* obj = new CustomStack(maxSize);
 * obj->push(x);
 * int param_2 = obj->pop();
 * obj->increment(k,val);
 */