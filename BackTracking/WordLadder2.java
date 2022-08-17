/*https://leetcode.com/problems/word-ladder-ii/*/

//TLE
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

//TLE
class Solution {
    List<List<String>> result;
    int maxDepth;
    String target;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        result = new ArrayList<List<String>>();
        HashSet<String> wordSet = new HashSet<String>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) return new ArrayList<List<String>>();
        target = endWord;
        int distance = 2;
        maxDepth = -1;
        
        Map<String,Integer> headDepths = new HashMap<String,Integer>();
        Map<String,Integer> tailDepths = new HashMap<String,Integer>();
        Map<String,Integer> tempDepths;
        headDepths.put(beginWord,0);
        tailDepths.put(endWord,0);
        HashSet<String> head = new HashSet<String>();
        HashSet<String> tail = new HashSet<String>();
        HashSet<String> temp;
        head.add(beginWord);
        tail.add(endWord);
        Map<String,List<String>> graph = new HashMap<String,List<String>>();
        Map<String,List<String>> tailGraph = new HashMap<String,List<String>>();
        Map<String,List<String>> tempGraph;
        Map<String,List<String>> pre = new HashMap<String,List<String>>();
        Set<String> visited = new HashSet<String>();
        
        //preprocessing
        int i;
        String key;
        StringBuilder build;
        for (String word : wordList)
        {
            build = new StringBuilder(word);
            for (i = 0; i < word.length(); ++i)
            {
                build.replace(i,i+1,"*");
                key = build.toString();
                if (!pre.containsKey(key)) pre.put(key,new ArrayList<String>());
                pre.get(key).add(word);
                build.replace(i,i+1,Character.toString(word.charAt(i)));
            }
        }
        
        //bfs and adjacency list building
        int len, d, initial = 0;
        String curr;
        boolean found = false;
        while (!head.isEmpty() && !tail.isEmpty())
        {
            if (head.size() > tail.size())
            {
                temp = head;
                head = tail;
                tail = temp;
                
                tempDepths = headDepths;
                headDepths = tailDepths;
                tailDepths = tempDepths;
                
                tempGraph = graph;
                graph = tailGraph;
                tailGraph = tempGraph;
                
                initial = 1-initial;
            }
            temp = new HashSet<String>();
            
            for (String word : head)
            {
                d = headDepths.get(word);
                visited.add(word);
                build = new StringBuilder(word);
                for (i = 0; i < word.length(); ++i)
                {
                    build.replace(i,i+1,"*");
                    key = build.toString();
                    for (String adjWord : pre.getOrDefault(key,new ArrayList<String>()))
                    {
                        if (tail.contains(adjWord))
                        {
                            if (maxDepth == -1) maxDepth = distance;
                            found = true;
                        }
                        if (!visited.contains(adjWord))
                        {
                            temp.add(adjWord);
                            headDepths.put(adjWord,d+1);
                            if (!graph.containsKey(word)) graph.put(word,new ArrayList<String>());
                            graph.get(word).add(adjWord);
                        }
                        else if (headDepths.get(adjWord) == d+1)
                        {
                            if (!graph.containsKey(word)) graph.put(word,new ArrayList<String>());
                            graph.get(word).add(adjWord);
                        }
                    }
                    build.replace(i,i+1,Character.toString(word.charAt(i)));
                }
            }
            
            head = temp;
            ++distance;
            if (found) break;
        }
        if (initial == 1)
        {
            temp = head;
            head = tail;
            tail = temp;

            tempDepths = headDepths;
            headDepths = tailDepths;
            tailDepths = tempDepths;

            tempGraph = graph;
            graph = tailGraph;
            tailGraph = tempGraph;

            initial = 1-initial;
        }
        List<String> value;
        for (Map.Entry entry : tailGraph.entrySet())
        {
            key = (String)entry.getKey();
            value = (ArrayList)entry.getValue();
            for (String adjWord : value)
            {
                if (!graph.containsKey(adjWord)) graph.put(adjWord, new ArrayList<String>());
                graph.get(adjWord).add(key);
            }
        }
        List<String> currList = new ArrayList<String>();
        currList.add(beginWord);
        dfs(graph,beginWord,1,currList);
        return result;
    }
    private void dfs(Map<String,List<String>> graph, String word, int depth, List<String> curr)
    {
        if (depth == maxDepth)
        {
            if (word.equals(target)) result.add(new ArrayList<String>(curr));
            return;
        }
        
        for (String adjWord : graph.getOrDefault(word,new ArrayList<String>()))
        {
            curr.add(adjWord);
            dfs(graph, adjWord, depth+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}

//no TLE
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet(wordList);
        if(!dict.contains(endWord))
            return new ArrayList();
        
        // adjacent words for each word
        Map<String,List<String>> adjacency = new HashMap();
        Queue<String> queue = new LinkedList();
        // does path exist?
        boolean found = false;
        
        // BFS for shortest path, keep removing visited words
        queue.offer(beginWord);
        dict.remove(beginWord);
                
        while(!found && !queue.isEmpty())
        {
            // System.out.println("===");
            // System.out.println(queue);
            int size = queue.size();
            
            // adjacent words in current level
            HashSet<String> explored = new HashSet();

            while(size-- > 0)
            {
                String word = queue.poll();
                
                if(adjacency.containsKey(word)) //if word is already present in the graph as a source node, continue
                    continue;
                
                // remove current word from dict, and search for adjacent words
                dict.remove(word);
                List<String> adjacents = getAdjacents(word, dict);
                // System.out.println(adjacents);
                adjacency.put(word, adjacents);

                for(String adj : adjacents)
                {
                    if(!found && adj.equals(endWord)) 
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
        if(found) 
            return dfs(beginWord, endWord, adjacency, new HashMap());
        else
            return new ArrayList();
    }
    
    private List<String> getAdjacents(String word, Set<String> dict)
    {
        List<String> adjs = new ArrayList();
        char[] wordChars = word.toCharArray();
        
        for(int i=0; i<wordChars.length; i++) 
            for(char c='a'; c<='z'; c++)
            {
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
                                   Map<String,List<List<String>>> memo)
    {
        if( memo.containsKey(src) )
            return memo.get(src);
        
        List<List<String>> paths = new ArrayList();
        
        // reached dest? return list with dest word
        if(src.equals( dest ))
        {
            paths.add( new ArrayList(){{ add(dest); }} );
            return paths;
        }

        // no adjacent for curr word? return empty list
        List<String> adjacents = adjacency.get(src);
        if(adjacents == null || adjacents.isEmpty())
            return paths;

        for(String adj : adjacents)
        {
            List<List<String>> adjPaths = dfs(adj, dest, adjacency, memo);
            
            for(List<String> path : adjPaths) 
            {
                if(path.isEmpty()) continue;
                
                List<String> newPath = new ArrayList(){{ add(src); }};
                newPath.addAll(path);
                
                paths.add(newPath);
            }
        } 
        memo.put(src, paths);
        return paths;
    }
}