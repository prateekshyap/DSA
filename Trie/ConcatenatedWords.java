/*https://leetcode.com/problems/concatenated-words/*/

class TrieNode
{
    TrieNode[] hash;
    boolean isEnd;
    TrieNode()
    {
        hash = new TrieNode[26];
        isEnd = false;
    }
}
class Trie
{
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void add(String word)
    {
        TrieNode temp = root;
        for (char ch : word.toCharArray())
        {
            int index = ch-'a';
            if (temp.hash[index] == null)
                temp.hash[index] = new TrieNode();
            temp = temp.hash[index];
        }
        temp.isEnd = true;
    }
    public boolean checkConcatenation(String word)
    {
        return dfs(root,word.toCharArray(), 0, 1);
    }
    private boolean dfs(TrieNode node, char[] arr, int index, int dfsCount)
    {
    	/**
    	 * if all the characters are checked
    	 * return true if the current node is the end of some word and
    	 * the total number of dfs performed is greater than 1
    	 * */
        if (index == arr.length)
            return node.isEnd && dfsCount > 1;
        if (node.isEnd) //if current node is the end of some word
        {
        	/**
        	 * the character at the current index will be searched at the root and
        	 * dfsCount will increase by 1 since we are starting from root i.e. with a new word
        	 * */
            boolean result = dfs(root,arr,index,dfsCount+1);
            /**
             * if the character at the current index is present at the current node itself then
             * the word can be continued with next index and the same dfsCount since no new
             * word is introduced
             * */
            if (node.hash[arr[index]-'a'] != null)
            	result |= dfs(node.hash[arr[index]-'a'],arr,index+1,dfsCount);
            /**
             * result will be the OR of both the cases
             * */
            return result;
        }
        if (node.hash[arr[index]-'a'] == null) return false; //if the current character is not present at the current node, return false
        return dfs(node.hash[arr[index]-'a'],arr,index+1,dfsCount); //default case
    }
}
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<String>();
        Trie trie = new Trie();
        for (String word : words) //add all words to trie
            trie.add(word);
        for (String word : words) //for each word
            if (trie.checkConcatenation(word)) result.add(word); //if it can be broken then add it to result
        return result;
    }
}