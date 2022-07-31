/*
https://practice.geeksforgeeks.org/problems/trie-insert-and-search0651/1#
Trie | (Insert and Search) 
*/


//Function to insert string into TRIE.
void insert(struct TrieNode *root, string key)
{
    int k=0;
    for(int i=0; i<key.size(); i++)
    {
        k = key[i]-'a';
        if(!root->children[k])// {    
            root->children[k] = getNode();
        //     root=root->children[key[i]-'a'];
        // }  
        // else
        // {
            root=root->children[k];
        // }
    }
    root->isLeaf = true;
}

//Function to use TRIE data structure and search the given string.
bool search(struct TrieNode *root, string key) 
{
    TrieNode *ptr = root;
    int k=0;
    
    for(int i=0; i<key.length(); i++)
    {
         k = key[i]-'a';
        if(ptr->children[k] == nullptr)
            return false;
        ptr = ptr->children[k];
    }
    return (ptr->isLeaf);
}// end search