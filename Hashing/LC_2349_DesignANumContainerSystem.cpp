/*
https://leetcode.com/problems/design-a-number-container-system/
2349. Design a Number Container System

*/

class NumberContainers {
public:
    unordered_map<int, int> idxnum;
    unordered_map<int, set<int>> numidx;
    NumberContainers() {
        
    }
    
    void change(int index, int number) {
        if(idxnum.find(index) != idxnum.end())
        {
             numidx[idxnum[index]].erase(index);
        }
        idxnum[index] = number;
        numidx[number].emplace(index);
    }
    
    int find(int number) {
        if(numidx[number].size()==0)
            return -1;
        return *(numidx[number].begin());
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */