/*https://leetcode.com/problems/process-tasks-using-servers/*/

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> avail = new PriorityQueue<int[]>((a,b)->(a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
        for (int i = 0; i < servers.length; ++i)
            avail.add(new int[]{servers[i],i,0});
        PriorityQueue<int[]> occup = new PriorityQueue<int[]>((a,b)->(a[2]-b[2]));
        int[] result = new int[tasks.length];
        Queue<Integer> taskQueue = new LinkedList<Integer>();
        taskQueue.add(0);
        int t = 1;
        for (int time = 0; time < tasks.length; ++time)
        {
            while (!occup.isEmpty() && occup.peek()[2] <= time)
                avail.add(occup.poll());
            if (avail.isEmpty())
            {
                int nextTime = occup.peek()[2];
                while (!occup.isEmpty() && occup.peek()[2] <= nextTime)
                    avail.add(occup.poll());
            }
            int[] server = avail.poll();
            result[time] = server[1];
            server[2] = Math.max(server[2],time)+tasks[time];
            occup.add(server);
        }
        return result;
    }
}