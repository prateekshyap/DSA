/*https://leetcode.com/problems/word-search-ii/*/

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
    boolean stopDFS = false;
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void add(String s)
    {
        TrieNode temp = root;
        for (int i = 0; i < s.length(); ++i)
        {
            if (temp.hash[s.charAt(i)-'a'] == null)
                temp.hash[s.charAt(i)-'a'] = new TrieNode();
            temp = temp.hash[s.charAt(i)-'a'];
        }
        temp.isEndOfWord = true;
    }
    public boolean checkPresence(TrieNode pointer, char ch)
    {
        if (pointer.hash[ch-'a'] != null)
            return true;
        return false;
    }
}

class Solution {
    boolean visited[][];
    Set<String> resultSet;
    public List<String> findWords(char[][] board, String[] words) {
    	//add all words to a trie
        Trie trie = new Trie();
        for (String word : words)
            trie.add(word);

        resultSet = new HashSet<String>();
        List<String> resultList = new ArrayList<String>();
        boolean result = false; //store false in result
        visited = new boolean[board.length][board[0].length];
        StringBuffer currentWord = new StringBuffer("");
        
        for (int r = 0; r < board.length; ++r)
        {
            for (int c = 0; c < board[r].length; ++c)
            {
                TrieNode pointer = trie.root;
                if (trie.checkPresence(pointer,board[r][c])) //if current cell contains any of the first characters
                {
                    visited[r][c] = true; //mark the cell as visited
                    currentWord.append(board[r][c]); //append the character to current word
                    runDFS(trie, board, r, c, 1, currentWord, pointer); //recursion call to DFS
                    visited[r][c] = false; // BACKTRACK
                    currentWord.setLength(currentWord.length()-1); // BACKTRACK
                }
            }
        }

        //add words from set to list
        for (String str : resultSet)
            resultList.add(str);
        return resultList; //this definitely returns false
    }
    public void runDFS(Trie trie, char[][] board, int r, int c, int index, StringBuffer currentWord, TrieNode pointer)
    {
        TrieNode ref = pointer; //store the current trie pointer in a reference
        pointer = pointer.hash[currentWord.charAt(currentWord.length()-1)-'a']; //move the pointer to the next node

    	//base case
        if (pointer.isEndOfWord) //if the current point is the end of a word
        {
            resultSet.add(currentWord.toString()); //add it to set

            //check if further paths are available
            boolean isTrieAvailable = false;
            for (int i = 0; i < 26; ++i)
                if (pointer.hash[i] != null)
                    isTrieAvailable = true;

            //if the current node is a dead end, return
            if (!isTrieAvailable)
                return;
        }

        if (c+1 < board[0].length && trie.checkPresence(pointer,board[r][c+1]) && !visited[r][c+1]) //for right cell
        {
            visited[r][c+1] = true; //mark as visited
            currentWord.append(board[r][c+1]); //append the character to current word
            runDFS(trie, board, r, c+1, index+1, currentWord, pointer); //recursion call to DFS
            visited[r][c+1] = false; // BACKTRACK
            currentWord.setLength(currentWord.length()-1); // BACKTRACK
        }
        if (c-1 >= 0 && trie.checkPresence(pointer,board[r][c-1]) && !visited[r][c-1]) //for left cell
        {
            visited[r][c-1] = true; //mark as visited
            currentWord.append(board[r][c-1]); //append the character to current word
            runDFS(trie, board, r, c-1, index+1, currentWord, pointer); //recursion call to DFS
            visited[r][c-1] = false; // BACKTRACK
            currentWord.setLength(currentWord.length()-1); // BACKTRACK
        }
        if (r+1 < board.length && trie.checkPresence(pointer,board[r+1][c]) && !visited[r+1][c]) //for down cell
        {
            visited[r+1][c] = true; //mark as visited
            currentWord.append(board[r+1][c]); //append the character to current word
            runDFS(trie, board, r+1, c, index+1, currentWord, pointer); //recursion call to DFS
            visited[r+1][c] = false; // BACKTRACK
            currentWord.setLength(currentWord.length()-1); // BACKTRACK
        }
        if (r-1 >= 0 && trie.checkPresence(pointer,board[r-1][c]) && !visited[r-1][c]) //for up cell
        {
            visited[r-1][c] = true; //mark as visited
            currentWord.append(board[r-1][c]); //append the character to current word
            runDFS(trie, board, r-1, c, index+1, currentWord, pointer); //recursion call to DFS
            visited[r-1][c] = false; // BACKTRACK
            currentWord.setLength(currentWord.length()-1); // BACKTRACK
        }
        
        pointer = ref; // BACKTRACK
    }
}