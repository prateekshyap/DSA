/*https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1*/

class Solution{
    static int minJumps(int[] arr){
        /*if (nums.length == 1) return 0;*/ //leetcode
        int n = arr.length;
        int reach = 0, jumps = 0, steps = 0;
        if (arr[0] == 0) return -1;
        
        //added the first value
        reach = arr[0];
        steps = arr[0];
        
        //hence did one jump
        jumps = 1;
        for (int i = 1; i < n; ++i)
        {
            // return the answer
            if (i == n-1) return jumps;
            
            // update reach
            reach = Math.max(i+arr[i],reach);
            
            //decrement a step
            --steps;
            
            //if all steps exhausted
            if (steps == 0)
            {
                //increment jump
                ++jumps;
                
                //if steps can't be updated return -1
                if (i >= reach)
                    return -1;
                    
                //update step
                steps = reach-i;
            }
        }
        return -1;
    }
}