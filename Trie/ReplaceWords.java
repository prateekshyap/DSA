/*https://leetcode.com/problems/replace-words/*/

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
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = new TrieNode();
        for (String word : dictionary)
        {
            TrieNode temp = trie;
            for (char ch : word.toCharArray())
            {
                int index = ch-'a';
                if (temp.hash[index] == null)
                    temp.hash[index] = new TrieNode();
                temp = temp.hash[index];
            }
            temp.isEnd = true;
        }
        StringBuilder build = new StringBuilder(), finalString = new StringBuilder();
        int index = 0, n = sentence.length();
        String[] sentenceWords = sentence.split(" +");
        for (int i = 0; i < sentenceWords.length; ++i)
        {
            if (i != 0) finalString.append(" ");
            String word = sentenceWords[i];
            StringBuilder root = new StringBuilder();
            TrieNode temp = trie;
            for (char ch : word.toCharArray())
            {
                if (temp.hash[ch-'a'] == null || temp.isEnd) break;
                temp = temp.hash[ch-'a'];
                root.append(ch);
            }
            if (temp.isEnd) finalString.append(root);
            else finalString.append(word);
        }
        return finalString.toString();
    }
}

class Solution {
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        for(String s : dictionary) {
            insert(s);
        }
        
        StringBuilder res = new StringBuilder();
        
        String[] all = sentence.split(" ");
        
        for(int k = 0; k < all.length; k++) {
            String word = all[k];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            
            if(k != 0) res.append(" ");
            
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd) {
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            
            if(curr.isEnd) {
                res.append(replacement);
            } else {
                res.append(word);
            }
        }
        return res.toString();
    }
}