/*https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/*/

class Solution {
    public char findKthBit(int n, int k) {
        if (k <= 2) return (char)((k-1)+'0');
        int[] arr = new int[(int)Math.pow(2,n)-1];
        int mid = 1, rev = 0, store = 2, loop = 2;
        arr[1] = 1;
        while (loop <= n)
        {
            arr[store] = 1-arr[rev];
            ++store;
            --rev;
            if (rev == -1)
            {
                if (store >= arr.length) break;
                mid = store;
                arr[mid] = 1;
                rev = mid-1;
                store = mid+1;
                ++loop;
            }
        }
        return (char)(arr[k-1]+'0');
    }
}

class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        // The first thing to note is that each strings
        // is of the length 2^n - 1. Thus the middle char
        // for n, is at 2^(n - 1).
        int m = (int) Math.pow(2, n - 1);

        if (k == m) {
            // And of course "1" is always at the middle
            return '1';
        } else if (k < m) {
            // Then the k is in the prior string because
            // the first half is copied verbatim.
            return findKthBit(n - 1, k);
        } else {
            // k > m, then k is indicated in the prior string's
            // first half, but this time it is reversed and
            // inverted.
            return findKthBit(n - 1, m - (k - m)) == '1' ? '0' : '1';
        }
    }
}