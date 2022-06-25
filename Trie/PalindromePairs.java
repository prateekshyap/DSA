/*https://practice.geeksforgeeks.org/problems/palindrome-pairs/1*/

class TrieNode
{
    TrieNode[] hash;
    boolean isEndOfWord;
    TrieNode()
    {
        hash = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie
{
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void addWord(String word)
    {
        TrieNode temp = root; //start from root
        int len = word.length(), i;
        char ch;
        for (i = 0; i < len; ++i) //for each character in forward direction
        {
            ch = word.charAt(i);
            if (temp.hash[ch-'a'] == null) //if not available in trie
                temp.hash[ch-'a'] = new TrieNode(); //add it
            temp = temp.hash[ch-'a']; //move pointer
        }
        temp.isEndOfWord = true; //mark as end of word
    }
    public boolean searchForPalindromicSuffix(String word)
    {
        TrieNode temp = root; //start from root
        char ch;
        int i, len = word.length();
        for (i = len-1; i >= 0; --i) //for each character is reverse dirction
        {
            ch = word.charAt(i);
            if (temp.hash[ch-'a'] == null) break; //if not available in trie, break from loop
            temp = temp.hash[ch-'a']; //move pointer
        }

        /*
        Now multiple cases may arise
        case 1 : if temp didn't at all move from root, we didn't find any suffix
        		but if we ignore this case, it is possible that the current word is itself a
        		palindrome and we'll get the result as true which should not be the case
        		according to the question description

		After this case if checked, we move further only if we got a suffix

        case 2 : our current word is smaller than the one we got in the trie
        		in this case, the remaining part of the word in the trie should be a palindrome
        		for which we need to run dfs to check this
        		here i will be -1 since we completely traversed the current word in the previous loop

        case 3 : our current word is smaller than the one we got in the trie
        		in this case, the remaining part of the current word should be a palindrome and the
        		word that we found in trie till now should be a complete word i.e. the node we are currently
        		in should be the end of a word for which we can reverse the rest of the word and check
        */

        if (temp == root) return false; //case 1

        //case 2
        StringBuffer buffer = new StringBuffer("");
        if (i == -1) return dfs(temp,buffer);

        //case 3
        for (; i >= 0; --i) buffer.append(word.charAt(i));
        StringBuffer tempBuffer = new StringBuffer(buffer);
        tempBuffer.reverse();
        if (temp.isEndOfWord && buffer.toString().equals(tempBuffer.toString())) return true;
        return false;
    }
    public boolean dfs(TrieNode temp, StringBuffer buffer)
    {
        boolean isLeaf = true, result = false;
        int i;
        for (i = 0; i < 26; ++i) //for each character
        {
            if (temp.hash[i] != null) //if it is not null
            {
                isLeaf = false; //mark as non leaf node
                buffer.append((char)(i+'a')); //append the current character to the buffer
                result |= dfs(temp.hash[i],buffer); //run a dfs and or it with the result
                buffer.delete(buffer.length()-1,buffer.length()); //delete the last added character from the buffer
            }
        }
        if (temp.isEndOfWord || isLeaf) //if end of the word or leaf node, check for palindrome
        {
            StringBuffer tempBuffer = new StringBuffer(buffer);
            tempBuffer.reverse();
            if (buffer.toString().equals(tempBuffer.toString())) return true;
        }
        return result;
    }
}

class Solution {
    static int palindromepair(int N, String arr[]) {
        // code here
        int i;

        //in forward direction
        Trie trie = new Trie();
        for (i = 0; i < N; ++i)
        {
            if (trie.searchForPalindromicSuffix(arr[i])) return 1; //if palindromic suffix of current word is available in trie
            trie.addWord(arr[i]); //add current word to trie
        }

        //in reverse direction
        trie = new Trie();
        for (i = N-1; i >= 0; --i)
        {
            if (trie.searchForPalindromicSuffix(arr[i])) return 1; //if palindromic suffix of current word is available in trie
            trie.addWord(arr[i]); //add current word to trie
        }

        return 0;
    }
}