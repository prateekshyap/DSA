/*
Trie | (Delete) 
https://practice.geeksforgeeks.org/problems/trie-delete/1#
*/

class Solution{
  public:
  void deleteKey(trie_node_t *root, char key[])
  {
    // int k=0;
    
    // for(int i=0; key[i]!='\0'; i++)
    // {
    //     k = key[i]-'a';
    //     root = root->children[k];
    // }
    // root->value = 0;
    deleteFunction(root, key, 0);
  }//
  
    bool isEmptyNode(trie_node_t * ptr)
    {
        for(int i=0; i<26; i++)
        {
            if(ptr->children[i]!=nullptr) return false;
        }
        return true;
    }
    
    trie_node_t * deleteFunction(trie_node_t *root, char key[], int level)
    {
        if(root == nullptr) return root;
        if(strlen(key) == level)
        {
            root->value = 0;
            if(isEmptyNode(root))
            {
                delete(root);
                root = nullptr;
            }
            return root;
        }
        int k = key[level] - 'a';
        root->children[k] = deleteFunction(root->children[k], key, level+1);
        if(isEmptyNode(root) && root->value==0)
        {
            delete(root);
            root = nullptr;
        }
        return root;
    }
};
