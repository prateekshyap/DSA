/*https://leetcode.com/problems/word-ladder/*/

//unidirectional bfs
class Solution {
    int result;
    HashSet<String> hash;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //add everything to hash
        hash = new HashSet<String>();
        for (String s : wordList)
            hash.add(s);

        //if the end word is not present then there is no sequence
        if (!hash.contains(endWord)) return 0;

        int result = 0;

        //add the first word to the queue
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        //till the queue has more elements
        while (!queue.isEmpty())
        {
            //increment result
            ++result;
            int len = queue.size();

            //for all elements of current level
            for (int i = 0; i < len; ++i)
            {
                String currWord = queue.remove();

                //if the current word is end word, return result
                if (currWord.equals(endWord)) return result;

                //otherwise
                StringBuilder left = new StringBuilder("");
                for (int j = 0; j < beginWord.length(); ++j)
                {
                    for (int k = 0; k < 26; ++k)
                    {
                        //keep replacing a to z at each place
                        left = new StringBuilder("");
                        left.append(currWord.substring(0,j));
                        left.append((char)(k+'a'));
                        left.append(currWord.substring(j+1));

                        //if the word is in hash and is not equal to current word
                        if (hash.contains(new String(left)) && !new String(left).equals(currWord))
                        {
                            //remove from hash and add to queue
                            queue.add(new String(left));
                            hash.remove(new String(left));
                        }
                    }
                }
            }
        }

        //if nothing found, return 0
        return 0;
    }
}

//preprocessing the adjacency list
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();
        StringBuilder temp;
        String newWord;
        for (String word : wordList)
        {
            temp = new StringBuilder(word);
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                temp.replace(i,i+1,"*");
                newWord = temp.toString();
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
                temp.replace(i,i+1,Character.toString(word.charAt(i)));
            }
        }
        // System.out.println(allComboDict);

        // Queue for BFS
        Queue<String> Q = new LinkedList<>();
        Q.add(beginWord);
        int level = 0, size;

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        while (!Q.isEmpty()) {
            size = Q.size();
            ++level;
            while (size-- > 0)
            {
                String word = Q.poll();
                if (word.equals(endWord)) return level;
                temp = new StringBuilder(word);
                for (int i = 0; i < L; i++) {

                    // Intermediate words for current word
                    temp.replace(i,i+1,"*");
                    newWord = temp.toString();

                    // Next states are all the words which share the same intermediate state.
                    for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>()))
                    {
                        if (!visited.containsKey(adjacentWord))
                        {
                            visited.put(adjacentWord, true);
                            Q.add(adjacentWord);
                        }
                    }
                    temp.replace(i,i+1,Character.toString(word.charAt(i)));
                }
            }
        }

        return 0;
    }
}

//bidirectional bfs
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if (!wordSet.contains(endWord)) return 0;
        Set<String> head = new HashSet<>();
        Set<String> tail = new HashSet<>();
        Set<String> temp = new HashSet<>();
        int smallest = 2;
        head.add(beginWord);
        tail.add(endWord);
        StringBuilder build;
        String key;
        int i, len = beginWord.length();
        Map<String,List<String>> graph = new HashMap<String,List<String>>();
        for (String word : wordList)
        {
            build = new StringBuilder(word);
            for (i = 0; i < len; ++i)
            {
                build.replace(i,i+1,"*");
                key = build.toString();
                if (!graph.containsKey(key))
                    graph.put(key, new ArrayList<String>());
                graph.get(key).add(word);
                build.replace(i,i+1,Character.toString(word.charAt(i)));
            }
        }
        visited.add(beginWord);
        while (!head.isEmpty() && !tail.isEmpty()) {
            if (head.size() > tail.size()) {
                temp = head;
                head = tail;
                tail = temp;
            }
            temp = new HashSet<>();
            
            for (String current: head) {
                visited.add(current);
                build = new StringBuilder(current);
                for (i = 0; i < len; ++i)
                {
                    build.replace(i,i+1,"*");
                    key = build.toString();
                    for (String neighbor: graph.getOrDefault(key,new ArrayList<String>())) {
                        if (tail.contains(neighbor)) {
                            return smallest;
                        }
                        if (!visited.contains(neighbor))
                            temp.add(neighbor);
                    }
                    build.replace(i,i+1,Character.toString(current.charAt(i)));
                }
            }
            head = temp;
            smallest++;
        }
        
        return 0;
    }
}

//inspired from word ladder 2
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return 0;
        HashSet<String> wordSet = new HashSet<String>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int i, distance = 1;
        StringBuilder build;
        String key;
        
        Map<String,List<String>> graph = new HashMap<String,List<String>>();
        for (String word : wordList)
        {
            build = new StringBuilder(word);
            for (i = 0; i < word.length(); ++i)
            {
                build.replace(i,i+1,"*");
                key = build.toString();
                if (!graph.containsKey(key)) graph.put(key,new ArrayList<String>());
                graph.get(key).add(word);
                build.replace(i,i+1,Character.toString(word.charAt(i)));
            }
        }
        
        int len;
        String word;
        List<String> adjacents;
        Set<String> explored = new HashSet<String>();
        wordSet.remove(beginWord);
        while (!queue.isEmpty())
        {
            len = queue.size();
            explored = new HashSet<String>();
            while (len-- > 0)
            {
                word = queue.poll();
                if (visited.contains(word)) continue;
                visited.add(word);
                adjacents = getAdjacents(word,graph,wordSet);
                for (String adj : adjacents)
                {
                    if (adj.equals(endWord)) return distance+1;
                    
                    explored.add(adj);
                    queue.add(adj);
                }
            }
            for (String w : explored)
                wordSet.remove(w);
            ++distance;
        }
        
        return 0;
    }
    private List<String> getAdjacents(String word, Map<String,List<String>> graph, Set<String> wordSet)
    {
        String key;
        StringBuilder build = new StringBuilder(word);
        List<String> adjacents = new ArrayList<String>();
        for (int i = 0; i < word.length(); ++i)
        {
            build.replace(i,i+1,"*");
            key = build.toString();
            for (String adj : graph.getOrDefault(key,new ArrayList<String>()))
            {
                if (wordSet.contains(adj))
                    adjacents.add(adj);
            }
            build.replace(i,i+1,Character.toString(word.charAt(i)));
        }
        return adjacents;
    }
}