/*https://leetcode.com/problems/student-attendance-record-ii/*/

class Solution {
    Integer[][][] table;
    static final int m = (int)1e9+7;
    public int checkRecord(int n) {
        table = new Integer[n+1][3][2];
        table[n][0][0] = count(n, 0, 0);
        return table[n][0][0].intValue();
    }
    private int count(int n, int lateStreak, int absentCount)
    {
        if (n == 0) return table[n][lateStreak][absentCount] = 1;
        
        if (table[n][lateStreak][absentCount] != null) return table[n][lateStreak][absentCount];
        
        table[n][lateStreak][absentCount] = 0;
        if (absentCount < 1) table[n][lateStreak][absentCount] = (table[n][lateStreak][absentCount]+count(n-1, 0, absentCount+1))%m; //absent
        if (lateStreak < 2) table[n][lateStreak][absentCount] = (table[n][lateStreak][absentCount]+count(n-1, lateStreak+1, absentCount))%m; //late
        table[n][lateStreak][absentCount] = (table[n][lateStreak][absentCount]+count(n-1, 0, absentCount))%m; //present
        
        return table[n][lateStreak][absentCount];
    }
}

class Solution {
    public int checkRecord(int n) {
        long mod = 1_000_000_007;
        long a0l0 = 1, a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i <= n; i++) {
            long new_a0l0 = (a0l0 + a0l1 + a0l2) % mod;
            long new_a0l1 = a0l0;
            long new_a0l2 = a0l1;
            long new_a1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % mod;
            long new_a1l1 = a1l0;
            long new_a1l2 = a1l1;
            a0l0 = new_a0l0;
            a0l1 = new_a0l1;
            a0l2 = new_a0l2;
            a1l0 = new_a1l0;
            a1l1 = new_a1l1;
            a1l2 = new_a1l2;
        }
        return (int) a1l0;
    }
}