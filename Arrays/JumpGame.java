/*https://practice.geeksforgeeks.org/problems/jump-game/1/#*/

class Solution {
    static int canReach(int[] A, int N) {
        int reach = 0;
        for (int i = 0; i < N; ++i)
        {
            // if you have reached the current index already
            if (reach >= i)

                //try increasing your reach if possible
                reach = Math.max(reach,i+A[i]);

            //if you reach the last index
            if (reach >= N-1)

                //return 1
                return 1;
        }

        //return 0
        return 0;
    }
}

class Solution {
    static int canReach(int[] A, int N) {
        // code here
        int i, reach = 0;
        for (i = 0; i < N; ++i)
            if (i <= reach)
                reach = Math.max(reach,i+A[i]);
        return reach >= N-1 ? 1 : 0;
    }
};