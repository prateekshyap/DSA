
/*
https://leetcode.com/problems/design-hashmap/
706. Design HashMap

*/
/*********** USING Array and SET (Direct Addressing) ******************/
// class MyHashMap {
// public:
    
//     const int n=1000001;
//     int *mp;
    
//     unordered_set<int> seen;
//     MyHashMap() {
//        mp = new int[n];
//        //  for(int i=0; i<n; i++)
//        // {
//        //     mp[i]=-1;
//        // }
        
//     }
    
//     void put(int key, int value) {
//         seen.insert(key);
//         mp[key]=value;
//     }
    
//     int get(int key) {
//         if(seen.find(key) == seen.end()) return -1;
//         return mp[key];
//     }
    
//     void remove(int key) {
//         seen.erase(key);
//         mp[key]=-1;
//     }
// };

/*********** using vector (Chaining) **********/
// class MyHashMap {
// public:
    
//     vector<list<pair<int,int>>> mp; // array of linkedlist
//     const int size = 769; // large prime number 9973;
    
//     MyHashMap() {
//         mp.resize(size, NULL);
//     }
    
//     void put(int key, int value) 
//     {
//         list<pair<int,int>> :: iterator it = search(key);
//         if(it != mp[getIndex(key)].end()) it->second = value;
//         else mp[getIndex(key)].push_back({key,value});
            
//     }
    
 
//     int get(int key) 
//     {
//        list<pair<int,int>> :: iterator it = search(key);
//         if(it != mp[getIndex(key)].end() && it->first == key) return it->second ;
        
//         return -1;
//     }
    
//     void remove(int key)
//     {
        
//          list<pair<int,int>> :: iterator it = search(key);
//         if(it != mp[getIndex(key)].end()) 
//         {
//             mp[getIndex(key)].erase(it);
//             return  ;
//         }
//     }
    
//     int getIndex(int key)
//     {
//         return key%size;
//     }
    
//      list<pair<int,int>> :: iterator search(int key){
//         // search
//         int i = getIndex(key);
        
//         list<pair<int,int>> :: iterator it;
        
//         for(it= mp[i].begin(); it!=mp[i].end(); it++)
//             if(it->first == key) return it;
//         return it;
//     }
// };


// /*********** using vector + list (Chaining) **********/
// class MyHashMap {
// public:
    
//     vector<list<pair<int,int>>> mp; // array of linkedlist
//     const int size = 769; // large prime number 9973;
    
//     MyHashMap() {
//         mp.resize(size, NULL);
//     }
    
//     void put(int key, int value) {
        
//         auto& list = mp[getIndex(key)];
//         //if key already exist
//         for(auto &it : list)
//         {
//             if(it.first == key)
//             {
//                 it.second =value;
//                 return;
//             }
//         }
//         // if key doesn't exist
//         list.push_back({key,value});
//     }
    
   
//     int get(int key) {
//        auto &list = mp[getIndex(key)];
//         for(auto it: list)
//             if(it.first == key)
//                 return it.second;
//         return -1;
//     }
    
//     void remove(int key) {
//        auto &list = mp[getIndex(key)];
//         for(auto &it:list)
//             if(it.first == key)
//             {
//                 list.remove(it);
//                 return;
//             }

//     }
    
//     int getIndex(int key)
//     {
//         return key%size;
//     }

// };

// /*********** using vector + vector (Chaining) **********/
// class MyHashMap {
// public:
    
//     vector< vector< pair<int,int> > *> mp; // array of linkedlist
//     const int size = 769; // large prime number 9973;
    
//     MyHashMap() {
//         mp.resize(size, NULL);
//     }
    
//     void put(int key, int value) {
        
//         auto& list = mp[getIndex(key)];
        
//         if(!list)
//         {
//             list = new vector<pair<int,int>>;
//         }
        
//        for(int j=0; j< list->size(); j++)
//        {
//            if(list->operator[](j).first == key)
//            {
//                list->operator[](j).second = value;
//                return;
//            }
//        }
//         // if key doesn't exist
//         list->push_back({key,value});
//     }
    
   
//     int get(int key) {
//        auto &list = mp[getIndex(key)];
//         if(list)
//         {
//              for(int j=0; j< list->size(); j++)
//                    if(list->operator[](j).first == key)
//                        return list->operator[](j).second;
//         }
//         return -1;
//     }
    
//     void remove(int key) {
//        auto &list = mp[getIndex(key)];
//        if(list)
//        {
//            for(int j=0; j< list->size(); j++)
//                    if(list->operator[](j).first == key)
//                         list->erase(list->begin() + j);
//        }

//     }
    
//     int getIndex(int key)
//     {
//         return key%size;
//     }

// };


/*********** using user defined **********/
struct Node{
  int key, val;
    Node* next;
    Node(int k, int v, Node* n)
    {
        key = k;
        val = v;
        next = n;
    }
};
class MyHashMap {
public:
    
    const static int size = 19997; // large prime number 9973;
    const static int mult = 12582917;
    Node* data[size]; // array of linkedlist

    int hash(int key)
    {
        return (int)((long)key*mult %size);
    }
    
    // MyHashMap() {
    // }
    
    void put(int key, int value) {
        
        remove(key);
        int h = hash(key);
        Node *node = new Node(key, value, data[h]);
        data[h] = node;
    }
    
   
    int get(int key) {
        int h = hash(key);
        Node *node = data[h];
        while(node!=nullptr)
        {
            if(node->key == key)
                return node->val;
            node = node->next;
        }
        return -1;
    }
    
    void remove(int key) {
       int h = hash(key);
        
        // cout<<key<<" "<<h<<" "<<endl;
       Node *node = data[h];
       if(node == nullptr) return;
       if(node->key == key) 
           data[h] = node->next;
       else {
           while(node->next !=nullptr)
           {
               if(node->next->key == key)
               {
                   node->next = node->next->next;
                   return;
               }
               node = node->next;
           }
       }
    }
    
    
    

};


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */