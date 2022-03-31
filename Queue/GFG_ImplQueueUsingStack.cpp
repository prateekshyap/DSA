/* https://leetcode.com/problems/implement-queue-using-stacks/
 * 232. Implement Queue using Stacks
 */
/******************** PUSH Costly *******************/
class MyQueue {
    stack<int> s1;
    stack<int> s2;
    int e;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        while(!s1.empty())
        {
            s2.push(s1.top()); s1.pop();            
        }
        s1.push(x);
        while(!s2.empty())
        {
            s1.push(s2.top()); s2.pop();
        }
    }
    
    int pop() {
        e = s1.top();
        s1.pop();
        return e;
    }
    
    int peek() {
        return s1.top();
    }
    
    bool empty() {
        return (s1.empty());
    }
};


/******************** POP Costly *******************/
// class MyQueue {
//     stack<int> s1; // input stack
//     stack<int> s2; // output stack
//     int x;
// public:
    
//     MyQueue() {
        
//     }
    
//     void push(int x) {
//         s1.push(x);
//     }
    
//     int pop() {
//         if(!s2.empty())
//         {
//           x = s2.top();
//             s2.pop();
//             return x;
//         } 
//         else if(s1.empty())
//         {
//             cout<<"queue empty";
//             exit(1);
//         }
//         else{
//             while(s1.size()!=1)
//             {
//                 x = s1.top(); s1.pop();
//                 s2.push(x);
//             }
//             x=s1.top(); s1.pop();
//             return x;
//         }
//     }
    
//     int peek() {
//         if(!s2.empty())
//         {
//             return s2.top();
//         } 
//         else if(s1.empty())
//         {
//             cout<<"queue empty";
//             exit(1);
//         }
//         else{
//             while(s1.size()!=0)
//             {
//                 s2.push(s1.top());
//                 s1.pop();
//             }
//             return s2.top();
//         }
//     }
    
//     bool empty() {
//         if(s1.empty() && s2.empty())
//             return true;
//         else return false;
//     }
// };
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */