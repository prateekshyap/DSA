/*https://leetcode.com/problems/all-oone-data-structure/*/

class AllOne {
    
    Map<String, Integer> map;
    TreeMap<Integer, Set<String>> maxMap;

    public AllOne() {
        map = new HashMap<>();
        maxMap = new TreeMap<>();
    }
    
    public void inc(String key) {
        int val = map.getOrDefault(key, 0);
        Set<String> s = maxMap.getOrDefault(val, new HashSet<>());
        s.remove(key);
        if (s.isEmpty()) {
            maxMap.remove(val);
        } else {
            maxMap.put(val, s);
        }
        val++;
        Set<String> s1 = maxMap.getOrDefault(val, new HashSet<>());
        s1.add(key);
        maxMap.put(val, s1);
        map.put(key, val);
    }
    
    public void dec(String key) {
        int val = map.getOrDefault(key, 0);
        Set<String> s = maxMap.getOrDefault(val, new HashSet<>());
        s.remove(key);
        if (s.isEmpty()) {
            maxMap.remove(val);
        } else {
            maxMap.put(val, s);
        }
        val--;
        if (val < 1) {
            map.remove(key);
        } else {
            map.put(key, val);
            Set<String> s1 = maxMap.getOrDefault(val, new HashSet<>());
            s1.add(key);
            maxMap.put(val, s1);
        }
    }
    
    public String getMaxKey() {
        if (maxMap.isEmpty()) return "";
        return maxMap.get(maxMap.lastKey()).iterator().next();
    }
    
    public String getMinKey() {
        if (maxMap.isEmpty()) return "";
        return maxMap.get(maxMap.firstKey()).iterator().next();
    }
}