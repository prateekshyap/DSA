/*https://leetcode.com/problems/open-the-lock/*/

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>(Collections.singletonList("0000"));
        for (int steps = 0; !q.isEmpty(); ++steps) {
            System.out.println(q);
            for (int i = q.size(); i > 0; --i) {
                String curr = q.poll();
                if (curr.equals(target)) return steps;
                for (String nei : neighbors(curr)) {
                    if (deadSet.contains(nei)) continue;
                    deadSet.add(nei); // Marked as visited
                    q.offer(nei);
                }
            }
        }
        return -1;
    }
    List<String> neighbors(String code) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int x = code.charAt(i) - '0';
            for (int diff = -1; diff <= 1; diff += 2) {
                int y = (x + diff + 10) % 10;
                result.add(code.substring(0, i) + ("" + y) + code.substring(i + 1));
            }
        }
        return result;
    }
}