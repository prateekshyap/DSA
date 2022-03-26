/*
https://leetcode.com/problems/implement-stack-using-queues/
225. Implement Stack using Queues
 

*/
class MyStack {
public:
    queue<int> q1;
    queue<int> q2;
    int size, x;
    MyStack() {
        size=0;
    }
    
    void push(int x) {
        
        q1.push(x);
        for(int i=1; i<=q1.size() - 1; i++)
        {
            q1.push(q1.front());
            q1.pop();
        }
        
        
        /****** USING 2nd Queue *******/
//         q2.push(x);
//         size++ ;
        
//         while(!q1.empty())
//         {
//             q2.push(q1.front());
//             q1.pop();
//         }
//         swap(q1,q2);
    }
    
    int pop() {
        if(q1.empty()) return -1;
        
        x = q1.front();
        q1.pop();
        size--;
        
        return x;
    }
    
    int top() {
       if(q1.empty()) return -1;
        
        
        return q1.front();
    }
    
    bool empty() {
        return q1.empty();
    }
};


/***************** POP Costly ***********/
// class MyStack {
// public:
//     queue<int> q1;
//     queue<int> q2;
//     int size, x;
//     MyStack() {
//         size=0;
//     }
    
//     void push(int x) {
//         q1.push(x);
//         size++ ;
//     }
    
//     int pop() {
//         if(q1.empty()) return -1;
        
//         while(q1.size() != 1)
//         {
//             q2.push(q1.front()); q1.pop();
//         }
//         x = q1.front();
//         q1.pop();
//         size--;
        
//         queue<int> q = q1;
//         q1 = q2;
//         q2 = q;
        
//         return x;
//     }
    
//     int top() {
//        if(q1.empty()) return -1;
        
//         while(q1.size() != 1)
//         {
//             q2.push(q1.front()); q1.pop();
//         }
//         x = q1.front();
//         q1.pop();
//         q2.push(x);
        
//         queue<int> q = q1;
//         q1 = q2;
//         q2 = q;
        
//         return x;
//     }
    
//     bool empty() {
//         return q1.empty();
//     }
// };

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */