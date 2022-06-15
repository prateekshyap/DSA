/*
705. Design HashSet
https://leetcode.com/problems/design-hashset/
*/


/*********** Using Array **********/

// class MyHashSet {
// public:
//     vector<bool> ans;

//     MyHashSet() {
//         // ans.resize(pow(10,6)+1, false);
//         // ans.resize(1e7+1, false);
//         ans.resize(1000001, false);

//     }
    
//     void add(int key) {
//        ans[key] = true;
//     }
    
//     void remove(int key) {
//        ans[key] = false;
//     }
    
//     bool contains(int key) {
//         return ans[key];
//     }
// };
static const int _ = [](){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 0;
}();
/*********** Using User Defined **********/
struct Node{
  int key;
    Node* next;
    Node(int k, Node* n)
    {
        key = k;
        next = n;
    }
};

class MyHashSet {
public:
    
    // const static int size1 = 19997; // large prime number 9973;
    const static int size = 9973; // large prime number 9973;
    // const static int mult1 = 12582917;
    Node* data[size]; // array of linkedlist

    // int hash1(int key){
    //     return (int)((long)key*mult1 %size1);
    // }
    int hash(int key){
        return (int)((long)key%size);
    }
    
//     MyHashSet() {
        
//     }
    
    void add(int key) {
        if(contains(key)) return;
        int h = hash(key);
        Node *node = new Node(key, data[h]);
        data[h] = node;
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
    
    bool contains(int key) {
        int h = hash(key);
        Node *node = data[h];
        while(node!=nullptr)
        {
            if(node->key == key)
                return true;
            node = node->next;
        }
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */