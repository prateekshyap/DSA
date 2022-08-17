/*https://leetcode.com/problems/minimum-genetic-mutation/*/

//same as word ladder 2
class Solution {
    char[] ch = new char[]{'A','C','G','T'};
    public int minMutation(String start, String end, String[] bank) {
        Set<String> geneBank = new HashSet<String>();
        for (String gene : bank) geneBank.add(gene);
        if (!geneBank.contains(end)) return -1;
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        Set<String> visited = new HashSet<String>();
        
        int len, depth = 1;
        String word;
        Set<String> explored = new HashSet<String>();
        while (!queue.isEmpty())
        {
            len = queue.size();
            explored = new HashSet<String>();
            while (len-- > 0)
            {
                word = queue.poll();
                if (visited.contains(word)) continue;
                visited.add(word);
                geneBank.remove(word);
                List<String> adjacents = getAdjacents(word,geneBank);
                for (String adj : adjacents)
                {
                    if (adj.equals(end)) return depth;
                    explored.add(adj);
                    queue.add(adj);
                }
            }
            for (String gene : explored)
                geneBank.remove(gene);
            ++depth;
        }
        return -1;
    }
    private List<String> getAdjacents(String word, Set<String> geneBank)
    {
        List<String> adjacents = new ArrayList<String>();
        char[] gene = word.toCharArray();
        int j;
        String adjWord;
        for (int i = 0; i < gene.length; ++i)
        {
            for (j = 0; j < ch.length; ++j)
            {
                if (gene[i] == ch[j]) continue;
                gene[i] = ch[j];
                adjWord = new String(gene);
                if (geneBank.contains(adjWord))
                    adjacents.add(adjWord);
                gene[i] = word.charAt(i);
            }
        }
        return adjacents;
    }
}