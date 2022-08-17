/*
https://leetcode.com/problems/lru-cache/
146. LRU Cache
https://practice.geeksforgeeks.org/problems/lru-cache/1
*/

class DLinkedNode{
    public:
        int key, val;
        DLinkedNode *prev, *next;
        DLinkedNode() : key(0), val(0), prev(nullptr), next(nullptr){}
        DLinkedNode(int k, int v) : key(k), val(v), prev(nullptr), next(nullptr){}
};

class LRUCache {
public:
    unordered_map<int, DLinkedNode*> cache;
    DLinkedNode* head, *tail;// dummy node to handle edges cases
    int cap, size=0;
    
    LRUCache(int capacity): cap(capacity){
        // cap = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        if(cache.find(key) == cache.end())
            return -1;
        DLinkedNode* node = cache[key];
        moveToFront(node);
        return node->val;
    }
    
    void put(int key, int value) {
        if(cache.find(key) != cache.end())
        {
            DLinkedNode* node = cache[key];
            node->val = value;
            moveToFront(node);
            return;
        }
        
        if(size == cap)
        {
            DLinkedNode* deleteNode = tail->prev;
            removeNode(deleteNode); // change pointers
            cache.erase(deleteNode->key);
            delete deleteNode;
        }
        else
            size++;
        
        DLinkedNode* newnode = new DLinkedNode(key, value);
        cache[key] = newnode;
        addToHead(newnode);
        // cout<<newnode->key<<" "<<newnode->val<<endl;
    }//
    
    void addToHead (DLinkedNode* node)
    {
        node->prev = head;
        node->next = head->next;
        head->next->prev = node;
        head->next = node;
    }
    
    void moveToFront(DLinkedNode* node)
    {
        removeNode(node);
        addToHead(node);
    }
    
    void removeNode(DLinkedNode* node)
    {
        node->prev->next = node->next;
        node->next->prev = node->prev;
    }
};


/*

class LRUCache {
public:
    
    list<pair<int,int>> cache;
    unordered_map<int, list<pair<int,int>>::iterator> cacheMap;
    int capacity_;
    
    LRUCache(int capacity) : capacity_(capacity){
        // capacity_ = capacity;        
    }
    
    // void moveToFront(list<pair<int,int>>::iterator it)
    // {
    //     cache.push_front({it->first, it->second});
    //     cache.erase(it);
    // }//
    
    int get(int key) 
    {
        if(cacheMap.find(key) == cacheMap.end())
            return -1;
        
        cache.splice(cache.begin(), cache, cacheMap[key]); // transfer to front
        return cacheMap[key]->second; // return its value
        
        // moveToFront(cacheMap[key]); // move to front
        // cacheMap[key] = cache.begin(); // update its address
        // return cacheMap[key]->second; // return its value

       
    }//
    
    void put(int key, int value)
    {
        
        if(cacheMap.find(key) != cacheMap.end())
        {
            cache.splice(cache.begin(), cache, cacheMap[key]);
            cacheMap[key]->second = value;
            return;
        }
        if(cache.size() ==  capacity_)
        {
            cacheMap.erase(cache.back().first);
            cache.pop_back();
        }
        cache.push_front({key, value});
        cacheMap[key] = cache.begin();
//         if(cacheMap.count(key)) // key doesn't exist
//         {
//             if(cache.size()<capacity_)
//             {
//                 cache.push_front({key,value});
                
//                 cacheMap[key] = cache.begin();
//             }
//             else
//             {
//                 cacheMap.erase(cache.back().first);
//                 cache.pop_back();
                
//                 cache.push_front({key, value});
//                 cacheMap[key] = cache.begin();
//             }
//         }
//         else //key exist and move to front
//         {
//             cache.begin()->second = value;
//         }
    }//
};

*/


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */