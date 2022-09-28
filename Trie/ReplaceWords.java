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
        for (char sh : sentence.toCharArray())
        {
            if (sh == ' ')
            {
                String word = build.toString();
                build = new StringBuilder();
                StringBuilder root = new StringBuilder();
                boolean isRootFound = false;
                TrieNode temp = trie;
                for (char ch : word.toCharArray())
                {
                    if (temp.hash[ch-'a'] != null) temp = temp.hash[ch-'a'];
                    else break;
                    root.append(ch);
                    if (temp.isEnd)
                    {
                        isRootFound = true;
                        break;
                    }
                }
                if (isRootFound) finalString.append(root);
                else finalString.append(word);
                finalString.append(' ');
            }
            else build.append(sh);
        }
        String word = build.toString();
        StringBuilder root = new StringBuilder();
        boolean isRootFound = false;
        TrieNode temp = trie;
        for (char ch : word.toCharArray())
        {
            if (temp.hash[ch-'a'] != null) temp = temp.hash[ch-'a'];
            else break;
            root.append(ch);
            if (temp.isEnd)
            {
                isRootFound = true;
                break;
            }
        }
        if (isRootFound) finalString.append(root);
        else finalString.append(word);
        return finalString.toString();
    }
}