/*https://binarysearch.com/problems/Distinct-Substrings*/
/*https://practice.geeksforgeeks.org/problems/count-of-distinct-substrings/1*/

import java.util.*;

class TrieNode
{
    boolean endOfWord;
    TrieNode[] hash = new TrieNode[26];
}

class Trie
{
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void addWord(String s)
    {
        int i = 0;
        TrieNode temp = root;
        for (; i < s.length(); ++i)
        {
            if (temp.hash[s.charAt(i)-'a'] == null)
                temp.hash[s.charAt(i)-'a'] = new TrieNode();
            temp = temp.hash[s.charAt(i)-'a'];
            temp.endOfWord = true;
        }
    }

    public int check(String s, int index)
    {
        int i, result = 0;
        TrieNode temp = root;
        boolean flag = false;
        for (i = index; i < s.length(); ++i)
        {
            if (temp.hash[s.charAt(i)-'a'] == null)
            {
                temp.hash[s.charAt(i)-'a'] = new TrieNode();
                flag = true;
            }
            temp = temp.hash[s.charAt(i)-'a'];
            if (flag) ++result;
        }
        return result;
    }
}

class Solution {
    Set<String> set;
    public int solve(String s) {
        set = new HashSet<String>();
        int n = s.length(), i, j, result = s.length();
        Trie trie = new Trie();
        trie.addWord(s);
        for (i = 1; i < n; ++i)
            result += trie.check(s,i);
        return result;
    }
}

