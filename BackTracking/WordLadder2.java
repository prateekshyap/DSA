/*https://leetcode.com/problems/word-ladder-ii/*/

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord == null || endWord == null || wordList == null) {
            return res;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> graph = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        boolean flag = false;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            Set<String> vis = new HashSet<>();
            while (size > 0)
            {
                String cur = queue.poll();
                char[] ch = cur.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char temp = ch[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (temp == j) {
                            continue;
                        }
                        ch[i] = j;
                        String str = new String(ch);
                        if (wordSet.contains(str)) {
                            if (str.equals(endWord)) {
                                flag = true;
                            }
                            if (!vis.contains(str)) {
                                List<String> list = new ArrayList<>();
                                list.add(cur);
                                graph.put(str, list);
                                queue.add(str);
                                vis.add(str);
                            } else {
                                List<String> list = graph.get(str);
                                list.add(cur);
                                graph.put(str, list);
                            }
                        }
                    }
                    ch[i] = temp;
                }
                size--;
            }
            for (String s : vis) {
                wordSet.remove(s);
            }

            if (flag) {
                LinkedList<String> path = new LinkedList<>();
                path.add(endWord);
                dfs(res, path, endWord, beginWord, graph);
                return res;
            }
        }
        return res;
    }

    public void dfs(List<List<String>> res, LinkedList<String> path, String cur, String endWord, Map<String, List<String>> graph) {
        if (cur.equals(endWord)) {
            List<String> copy = new LinkedList<>(path);
            res.add(copy);
            return;
        }
        List<String> nexts = graph.get(cur);
        for (String next : nexts) {
            path.addFirst(next);
            dfs(res, path, next, endWord, graph);
            path.removeFirst();
        }
    }
}

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet(wordList);
        if( !dict.contains(endWord) )
            return new ArrayList();
        
        // adjacent words for each word
        Map<String,List<String>> adjacency = new HashMap();
        Queue<String> queue = new LinkedList();
        // does path exist?
        boolean found = false;
        
        // BFS for shortest path, keep removing visited words
        queue.offer(beginWord);
        dict.remove(beginWord);
                
        while( !found && !queue.isEmpty() ) {
            int size = queue.size();
            // adjacent words in current level
            HashSet<String> explored = new HashSet();

            while( size-- > 0 ) {
                String word = queue.poll();
                
                if( adjacency.containsKey(word) )
                    continue;
                
                // remove current word from dict, and search for adjacent words
                dict.remove(word);
                List<String> adjacents = getAdjacents(word, dict);
                adjacency.put(word, adjacents);

                for(String adj : adjacents) {
                    if( !found && adj.equals(endWord) ) 
                        found = true;
                    
                    explored.add(adj);
                    queue.offer(adj);
                }
            }
            // remove words explored in current level from dict
            for(String word : explored)
                dict.remove(word);
        }

        // if a path exist, dfs to find all the paths
        if( found ) 
            return dfs(beginWord, endWord, adjacency, new HashMap());
        else
            return new ArrayList();
    }
    
    private List<String> getAdjacents(String word, Set<String> dict) {
        List<String> adjs = new ArrayList();
        char[] wordChars = word.toCharArray();
        
        for(int i=0; i<wordChars.length; i++) 
            for(char c='a'; c<='z'; c++) {
                char temp = wordChars[i];
                wordChars[i] = c;
                
                String newAdj = new String(wordChars);
                if( dict.contains(newAdj) )
                    adjs.add(newAdj);
                
                wordChars[i] = temp;
            }
        return adjs;
    }
    
    private List<List<String>> dfs(String src, String dest, 
                                   Map<String,List<String>> adjacency, 
                                   Map<String,List<List<String>>> memo) {
        if( memo.containsKey(src) )
            return memo.get(src);
        
        List<List<String>> paths = new ArrayList();
        
        // reached dest? return list with dest word
        if( src.equals( dest ) ) {
            paths.add( new ArrayList(){{ add(dest); }} );
            return paths;
        }

        // no adjacent for curr word? return empty list
        List<String> adjacents = adjacency.get(src);
        if( adjacents == null || adjacents.isEmpty() )
            return paths;

        for(String adj : adjacents) {
            List<List<String>> adjPaths = dfs(adj, dest, adjacency, memo);
            
            for(List<String> path : adjPaths) {
                if( path.isEmpty() ) continue;
                
                List<String> newPath = new ArrayList(){{ add(src); }};
                newPath.addAll(path);
                
                paths.add(newPath);
            }
        } 
        memo.put(src, paths);
        return paths;
    }
}