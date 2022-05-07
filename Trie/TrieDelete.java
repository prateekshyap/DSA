/*https://practice.geeksforgeeks.org/problems/trie-delete/1*/

class Solution
{
    public static void deleteKey(TrieNode root,char[] key)
    {
        TrieNode temp = root;
        int i = 0;
        for (i = 0; i < key.length; ++i)
        {
            temp = temp.subNode(key[i]);
            if (temp == null) return;
        }
        temp.isEnd = false;
    }
}