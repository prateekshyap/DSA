/*
https://binarysearch.com/problems/Virtually-Cloneable-Stacks
Virtually Cloneable Stacks

*/

int sz[100001];
class VirtuallyCloneableStacks {
    public:
    int top=0;

    VirtuallyCloneableStacks() {
        top= sz[0] = 0;
    }

    void copyPush(int i) {
        // ++top;
        sz[++top] = sz[i] + 1;
    }

    void copyPop(int i) {
        // ++top;
        sz[++top] = sz[i] - 1;
    }

    int size(int i) {
        return sz[i];
    }
};

// class VirtuallyCloneableStacks {
//     public:
//     vector<int> stk;

//     VirtuallyCloneableStacks() {
//         stk.push_back(0);
//     }

//     void copyPush(int i) {
//         int sz = stk[i];
//         stk.push_back(sz+1);
//     }

//     void copyPop(int i) {
//         int sz = stk[i];
//         stk.push_back(sz-1);
//     }

//     int size(int i) {
//         return stk[i];
//     }
// };