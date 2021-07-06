/*https://practice.geeksforgeeks.org/problems/bbt-counter4914/1*/

/*
For height h, there are three combinations possible
1 - tree of height h-1 as left subtree and tree of height h-2 as right subtree
2 - tree of height h-2 as left subtree and tree of height h-1 as right subtree
3 - tree of height h-1 as both left and right subtree
All other combinations violate the condition of balanced binary trees
So - table[i-1]*table[i-2]*2+table[i-1]*table[i-1]
*/

class Solution {
    static final long m = 1000000007;
    static long countBT(int h){
        if (h == 1) return 1;
        long[] table = new long[h+1];
        table[1] = 1;
        table[2] = 3;
        for (int i = 3; i <= h; ++i)
            table[i] = ((((((table[i-1]%m)*(table[i-2]%m))%m)*2)%m)+(((table[i-1]%m)*(table[i-1]%m))%m))%m;
        return table[h];
    }
}