/*https://leetcode.com/problems/jump-game-iv/*/

//tle
class Solution {
    HashMap<Integer,TreeSet<Integer>> map;
    boolean[] visited;
    int N;
    final int MAX= (int)1e9;
    public int minJumps(int[] arr) {
        map = new HashMap<Integer,TreeSet<Integer>>();
        N = arr.length;
        for (int i = 0; i < N; ++i)
        {
            if (!map.containsKey(arr[i]))
                map.put(arr[i],new TreeSet<Integer>());
            map.get(arr[i]).add(i);
        }
        visited = new boolean[N];
        return check(arr,N-1);
    }
    private int check(int[] arr, int index)
    {
        if (index == 0) return 0;
        
        if (visited[index]) return MAX;
        
        visited[index] = true;
        
        int result = MAX;
        if (index+1 < N) result = Math.min(result,1+check(arr,index+1));
        if (index-1 >= 0) result = Math.min(result,1+check(arr,index-1));
        for (Integer i : map.get(arr[index])) if (i != index) result = Math.min(result,1+check(arr,i));
        
        visited[index] = false;
        return result;
    }
}

//bfs
class Solution {
    HashMap<Integer,TreeSet<Integer>> map;
    boolean[] visited;
    int N, index, len, step;
    final int MAX= (int)1e9;
    public int minJumps(int[] arr) {
        map = new HashMap<Integer,TreeSet<Integer>>();
        N = arr.length;
        for (int i = 0; i < N; ++i)
        {
            if (!map.containsKey(arr[i]))
                map.put(arr[i],new TreeSet<Integer>());
            map.get(arr[i]).add(i);
        }
        visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        
        while (!queue.isEmpty())
        {
            len = queue.size();
            while (len-- > 0)
            {
                index = queue.poll();
                if (index == N-1) return step;

                if (index+1 < N && !visited[index+1])
                {
                    visited[index+1] = true;
                    queue.add(index+1);
                }
                if (index-1 >= 0 && !visited[index-1])
                {
                    visited[index-1] = true;
                    queue.add(index-1);
                }
                for (Integer i : map.get(arr[index]))
                    if (i != index && !visited[i])
                    {
                        visited[i] = true;
                        queue.add(i);
                    }
                map.get(arr[index]).clear();
            }
            ++step;
        }
        
        return -1;
    }
}

//bidirectional bfs
class Solution {
    HashMap<Integer,TreeSet<Integer>> map;
    boolean[] visited;
    int N, len, step;
    final int MAX= (int)1e9;
    public int minJumps(int[] arr) {
        map = new HashMap<Integer,TreeSet<Integer>>();
        N = arr.length;
        if (N <= 1) return 0;
        step = 0;
        for (int i = 0; i < N; ++i)
        {
            if (!map.containsKey(arr[i]))
                map.put(arr[i],new TreeSet<Integer>());
            map.get(arr[i]).add(i);
        }
        visited = new boolean[N];
        HashSet<Integer> headQueue = new HashSet<Integer>(), tailQueue = new HashSet<Integer>(), tempQueue;
        headQueue.add(0);
        tailQueue.add(N-1);
        visited[0] = visited[N-1] = true;
        
        while (!headQueue.isEmpty())
        {
            if (headQueue.size() > tailQueue.size())
            {
                tempQueue = headQueue;
                headQueue = tailQueue;
                tailQueue = tempQueue;
            }
            tempQueue = new HashSet<Integer>();
            for (Integer index : headQueue)
            {
                for (Integer i : map.get(arr[index]))
                {
                    if (tailQueue.contains(i)) return step+1;
                    if (i != index && !visited[i])
                    {
                        visited[i] = true;
                        tempQueue.add(i);
                    }
                }
                map.get(arr[index]).clear();
                if (index+1 < N)
                {
                    if (tailQueue.contains(index+1)) return step+1;
                    if (!visited[index+1])
                    {
                        visited[index+1] = true;
                        tempQueue.add(index+1);
                    }
                }
                if (index-1 >= 0)
                {
                    if (tailQueue.contains(index-1)) return step+1;
                    if (!visited[index-1])
                    {
                        visited[index-1] = true;
                        tempQueue.add(index-1);
                    }
                }
            }
            ++step;
            headQueue = tempQueue;
        }
        
        return -1;
    }
}