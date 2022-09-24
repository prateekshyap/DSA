/*https://leetcode.com/problems/prefix-and-suffix-search/*/

//hashing
class WordFilter
{
    HashMap<String, TreeSet<Integer>> prefMap = new HashMap<>();
    HashMap<String, TreeSet<Integer>> suffMap = new HashMap<>();
    
    public WordFilter(String[] words)
    {
        for (int i = 0; i < words.length; i++)
        {
            for (int j = 0; j < words[i].length(); j++)
            {
                String s1 = words[i].substring(0, j+1);
                String s2 = words[i].substring(j, words[i].length());
                if (!prefMap.containsKey(s1))
                    prefMap.put(s1, new TreeSet<>(Collections.reverseOrder()));
                if (!suffMap.containsKey(s2))
                    suffMap.put(s2, new TreeSet<>(Collections.reverseOrder()));
                prefMap.get(s1).add(i);
                suffMap.get(s2).add(i);
            }
        }
    }
    
    public int f(String pref, String suff)
    {
        if (prefMap.containsKey(pref) == false || suffMap.containsKey(suff) == false)
            return -1;
        TreeSet<Integer> p = prefMap.get(pref);
        TreeSet<Integer> s = suffMap.get(suff);
        for (Integer val : p)
            if (s.contains(val))
                return val;
        return -1;
    }
}

//trie
class WordFilter {
    TrieNode root;
    String[] words;

    public WordFilter(String[] words) {
        root = new TrieNode();
        TrieNode node = root;
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (root.child[ch - 'a'] == null) {
                    root.child[ch - 'a'] = new TrieNode();
                }

                root.child[ch - 'a'].indexList.add(i);
                root = root.child[ch - 'a'];
            }
            root = node;
        }

        this.words = words;
    }

    public int f(String prefix, String suffix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.child[ch - 'a'];
            if (node == null) {
                return -1;
            }
        }

        List<Integer> list = node.indexList;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (words[list.get(i)].endsWith(suffix)) {
                return list.get(i);
            }
        }
        return -1;
    }

    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        List<Integer> indexList = new ArrayList<>();
    }
}