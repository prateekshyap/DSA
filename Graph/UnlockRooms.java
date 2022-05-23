/*Unlock Rooms

Medium

You are given a two-dimensional list of integers rooms. Each index i in rooms represents a room and rooms[i] represents different keys to unlock other rooms.

You are currently in an unlocked room 0 and every other room is locked. Given you can move freely between unlocked rooms, return whether you can unlock every room.

Constraints

    n, m ≤ 250 where n and m are the number of rows and columns in rooms.

Example 1
Input

rooms = [
    [1, 3],
    [2],
    [0],
    []
]

Output

true

Explanation

We start off at room 0 and can go to room 1 with its key. From room 1 we can go to room 2. Then, we can go back to room 0 and go to room 3.

https://binarysearch.com/problems/Unlock-Rooms
*/

//BFS
import java.util.*;

class Solution {
    public boolean solve(int[][] rooms) {
        boolean[] visited = new boolean[rooms.length];
        int visitCount = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int room : rooms[0])
            queue.add(room);
        visited[0] = true; //mark source as true
        visitCount = 1; //increment count
        int currNode;

        while (!queue.isEmpty()) //till queue is not empty
        {
            currNode = queue.poll(); //poll a node
            if (!visited[currNode]) //if not visited yet
            {
                visited[currNode] = true; //mark as visited
                ++visitCount; //increment count
                for (int room : rooms[currNode]) //for each adjacent room
                    queue.add(room); //add to queue
            }
        }

        return visitCount == rooms.length; //return equality
    }
}

//DFS
import java.util.*;

class Solution {
    int visitCount;
    boolean[] visited;
    public boolean solve(int[][] rooms) {
        visited = new boolean[rooms.length];
        visitCount = 0;
        recur(rooms, 0); //recursion call
        return visitCount == rooms.length;
    }
    public void recur(int[][] rooms, int node)
    {
        if (visited[node]) return; //if room already visited, return
        visited[node] = true; //mark as visited
        ++visitCount; //increment count
        for (int room : rooms[node]) //for each adjacent room
            recur(rooms, room); //call recursion
    }
}