/*
https://leetcode.com/problems/smallest-number-in-infinite-set/
2336. Smallest Number in Infinite Set

*/
class SmallestInfiniteSet {
public:
    set<int> ms;
    SmallestInfiniteSet() {
        for(int i=1; i<=1000; i++)
            ms.insert(i);
     }
    
    int popSmallest() {
        int y = *ms.begin();
        
        ms.erase(y);
        
        
        return y;
    }
    
    void addBack(int num) {
        ms.insert(num);
    }
};

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet* obj = new SmallestInfiniteSet();
 * int param_1 = obj->popSmallest();
 * obj->addBack(num);
 */