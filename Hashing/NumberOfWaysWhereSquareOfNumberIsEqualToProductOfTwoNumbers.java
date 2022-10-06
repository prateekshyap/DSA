/*https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/*/

class Solution {
    public int numTriplets(int[] n1, int[] n2) {
        long res = 0;
        for (long n : n1)
            res += twoProduct(n * n, n2);
        for (long n : n2)
            res += twoProduct(n * n, n1);
        return (int)res;
    }
    long twoProduct(long i, int[] n) {
        Map<Long, Long> m = new HashMap<>();
        long cnt = 0;
        for (long v : n) {
            if (i % v == 0)
                cnt += m.getOrDefault(i / v, 0l);
            m.put(v, m.getOrDefault(v, 0l) + 1);
        }
        return cnt;
    }
}