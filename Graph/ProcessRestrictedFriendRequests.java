/*https://leetcode.com/problems/process-restricted-friend-requests/*/

class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int[] parents = IntStream.rangeClosed(0,n-1).toArray();
        Map<Integer,Set<Integer>> sets = new HashMap<Integer,Set<Integer>>();
        for (int i = 0; i < n; ++i)
        {
            sets.put(i,new HashSet<Integer>());
            sets.get(i).add(i);
        }
        int requestsLength = requests.length;
        boolean[] result = new boolean[requestsLength];
        for (int i = 0; i < requestsLength; ++i)
            result[i] = union(parents,sets,restrictions,requests[i][0],requests[i][1]);
        return result;
    }
    private boolean union(int[] parents, Map<Integer,Set<Integer>> sets, int[][] restrictions, int x, int y)
    {
        int parentX = find(parents,x);
        int parentY = find(parents,y);
        if (parentX != parentY)
        {
            Set<Integer> setX = sets.get(parentX);
            Set<Integer> setY = sets.get(parentY);
            for (int[] restriction : restrictions)
            {
                if ((setX.contains(restriction[0]) && setY.contains(restriction[1])) || (setX.contains(restriction[1]) && setY.contains(restriction[0])))
                    return false;
            }
            if (setX.size() > setY.size())
            {
                parents[parentY] = parentX;
                sets.remove(parentY);
                setX.addAll(setY);
            }
            else
            {
                parents[parentX] = parentY;
                sets.remove(parentX);
                setY.addAll(setX);
            }
        }
        return true;
    }
    private int find(int[] parents, int x)
    {
        if (parents[x] == x) return x;
        parents[x] = find(parents,parents[x]);
        return parents[x];
    }
}

class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int[] parents = IntStream.rangeClosed(0,n-1).toArray();
        int[] rank = new int[n];
        int requestsLength = requests.length;
        boolean[] result = new boolean[requestsLength];
        for (int i = 0; i < requestsLength; ++i)
            result[i] = union(parents,rank,restrictions,requests[i][0],requests[i][1]);
        return result;
    }
    private boolean union(int[] parents, int[] rank, int[][] restrictions, int x, int y)
    {
        int parentX = find(parents,x);
        int parentY = find(parents,y);
        if (parentX != parentY)
        {
            for (int[] restriction : restrictions)
            {
                int parentRestrictedX = find(parents,restriction[0]);
                int parentRestrictedY = find(parents,restriction[1]);
                if ((parentX == parentRestrictedX && parentY == parentRestrictedY) || (parentX == parentRestrictedY && parentY == parentRestrictedX))
                    return false;
            }
            if (rank[parentX] > rank[parentY])
                parents[parentY] = parentX;
            else
            {
                parents[parentX] = parentY;
                if (rank[parentX] == rank[parentY])
                    ++rank[parentY];
            }
        }
        return true;
    }
    private int find(int[] parents, int x)
    {
        if (parents[x] == x) return x;
        parents[x] = find(parents,parents[x]);
        return parents[x];
    }
}

class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int[] parents = IntStream.rangeClosed(0,n-1).toArray();
        int[] rank = new int[n];
        int requestsLength = requests.length;
        boolean[] result = new boolean[requestsLength];
        boolean[][] enemies = new boolean[n][n];
        for (int[] restriction : restrictions)
            enemies[restriction[0]][restriction[1]] = enemies[restriction[1]][restriction[0]] = true;
        for (int i = 0; i < requestsLength; ++i)
            result[i] = union(parents,rank,enemies,n,requests[i][0],requests[i][1]);
        return result;
    }
    private boolean union(int[] parents, int[] rank, boolean[][] restrictions, int n, int x, int y)
    {
        int parentX = find(parents,x);
        int parentY = find(parents,y);
        if (parentX != parentY)
        {
            if (restrictions[parentX][parentY])
                return false;
            if (rank[parentX] > rank[parentY])
                parents[parentY] = parentX;
            else
            {
                parents[parentX] = parentY;
                if (rank[parentX] == rank[parentY])
                    ++rank[parentY];
            }
            for (int i = 0; i < n; ++i)
            {
                if (restrictions[parentX][i]) restrictions[parentY][i] = restrictions[i][parentY] = true;
                if (restrictions[parentY][i]) restrictions[parentX][i] = restrictions[i][parentX] = true;
            }
        }
        return true;
    }
    private int find(int[] parents, int x)
    {
        if (parents[x] == x) return x;
        parents[x] = find(parents,parents[x]);
        return parents[x];
    }
}