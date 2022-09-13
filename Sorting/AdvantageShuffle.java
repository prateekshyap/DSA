/*https://leetcode.com/problems/advantage-shuffle/*/

class Solution {
    public int[] advantageCount(int[] A, int[] B) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = A.length;
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] arr = new int[n];
        int i = 0;
        for (int b : B) {

            Integer key = map.higherKey(b);
            if (key == null) {
                key = map.firstKey();
            }
            Integer val = map.get(key);
            if (val == 1) {
                map.remove(key);
            } else {
                map.put(key, val - 1);
            }
            A[i++] = key;
        }
        return A;
    }
}