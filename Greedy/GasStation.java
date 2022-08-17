/*https://leetcode.com/problems/gas-station/*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, n = gas.length, index, status = 0;
        boolean[] visited = new boolean[n];
        while (i < n) //till all elements are exhausted
        {
            if (visited[i]) //if some index is already visited
            {
                ++i; //increment i
                continue; //continue with while loop
            }
            visited[i] = true; //mark i as visited
            if (gas[i] < cost[i]) //if available gas is less than the cost, it is impossible to move from that position
            {
                ++i; //so increment i
                continue; //continue with the while loop
            }
            status = gas[i]; //store current gas amount as the starting gas
            index = (i+1)%n; //increment index
            while (index != i) //till we make a round trip and hit i
            {
            	visited[index] = true; //mark index as visited
                status -= cost[((index-1)+n)%n]; //subtract the cost required to move from previous index to current index
                if (status < 0) //if amount becomes negative, it is again impossible to move from that position
                {
                    i = ((index-1)+n)%n; //set i as the previous index of it
                    visited[(i+1)%n] = false; //mark next index as unvisited
                    break; //break from the loop
                }
                status += gas[index]; //add the current amount of gas
                index = (index+1)%n; //increment index
            }
            if (index == i && status >= cost[((index-1)+n)%n]) return i; //if we hit i and amount of gas is not negative, we can start from i
            ++i; //increment i
        }
        return -1; //return -1 at the end
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int deficit = 0;
        int start = 0;
        int capacity = 0;        
        int diff;
        
        for( int i = 0 ; i < gas.length; i++) //for each index
        {
            capacity += gas[i] - cost[i]; //add the difference to capacity
            if(capacity < 0) //if capacity becomes negative
            {
                deficit += capacity; //add it into deficiency
                start = i+1; //mark start index as the index next to it
                capacity = 0; //reset capacity
            }
        }
        
        if(capacity+deficit >= 0) //if current capacity can cover the deficiency caused
            return start; //start index can be the required index
        else return -1; //otherwise no answer
        
    }
}