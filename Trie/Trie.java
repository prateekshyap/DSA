/*https://practice.geeksforgeeks.org/problems/trie-insert-and-search0651/1*/

//Function to insert string into TRIE.
static void insert(TrieNode root, String key) 
{
    TrieNode temp = root;
    for (int i = 0; i < key.length(); ++i)
    {
        if (temp.children[key.charAt(i)-'a'] == null)
            temp.children[key.charAt(i)-'a'] = new TrieNode();
        temp = temp.children[key.charAt(i)-'a'];
    }
    temp.isEndOfWord = true;
}

//Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key)
{
    TrieNode temp = root;
    for (int i = 0; i < key.length(); ++i)
    {
        if (temp.children[key.charAt(i)-'a'] == null)
            return false;
        temp = temp.children[key.charAt(i)-'a'];
    }
    return temp.isEndOfWord;
}