/*https://practice.geeksforgeeks.org/problems/special-keyboard3018/1*/

class Solution{
    static int optimalKeys(int N){
        // code here
        int result = 0, curr = 0, i;
        for (i = 1; i <= 4; ++i)
        {
            curr = recur(N, i, 0, 0, false);
            if (curr > result) result = curr;
        }
        return result;
    }
    static int recur(int n, int key, int screen, int buffer, boolean isSelected)
    {
        if (n == 0)
        {
            return screen;
        }
        if (key == 1)
        {
            isSelected = false;
            ++screen;
        }
        else if (key == 2) isSelected = true;
        else if (key == 3)
        {
            if (isSelected) buffer = screen;
            isSelected = false;
        }
        else if (key == 4)
        {
            screen += buffer;
            isSelected = false;
        }
        int curr = 0, ret = 0;
        for (int i = 1; i <= 4; ++i)
        {
            curr = recur(n-1, i, screen, buffer, isSelected);
            if (curr > ret) ret = curr;
        }
        return ret;
    }
}

class Solution{
    //Integer[] dp;
    static int optimalKeys(int N){
        // code here
        if (N <= 6)
            return N;
 
        // An array to store result
        // of subproblems
        int screen[] = new int[N];
 
        int b; // To pick a breakpoint
 
        // Initializing the optimal lengths
        // array for until 6 input strokes
        int n;
        for (n = 1; n <= 6; n++)
            screen[n - 1] = n;
 
        // Solve all subproblems in bottom manner
        for (n = 7; n <= N; n++) {
            // Initialize length of optimal
            // string for n keystrokes
            screen[n - 1] = 0;
 
            // For any keystroke n, we need
            // to loop from n-3 keystrokes
            // back to 1 keystroke to find
            // a breakpoint 'b' after which we
            // will have ctrl-a, ctrl-c and
            // then only ctrl-v all the way.
            for (b = n - 3; b >= 1; b--) {
                // if the breakpoint is
                // at b'th keystroke then
                // the optimal string would
                // have length
                // (n-b-1)*screen[b-1];
                int curr = (n - b - 1) * screen[b - 1];
                if (curr > screen[n - 1])
                    screen[n - 1] = curr;
            }
        }
 
        return screen[N - 1];
    }
}