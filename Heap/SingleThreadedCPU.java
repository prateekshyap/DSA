/*https://leetcode.com/problems/single-threaded-cpu/*/

class Solution {
  	public int[] getOrder(int[][] tasks) {
    	int[][] arr = new int[tasks.length][3];
    	for (int i = 0; i < tasks.length; i++)
    	arr[i] = new int[] {tasks[i][0], tasks[i][1], i};

    	Arrays.sort(
        arr,
        (o1, o2) -> {
          if (o1[0] == o2[0]) {
            return Integer.compare(o1[1], o2[1]);
          }
          return Integer.compare(o1[0], o2[0]);
        });
    	PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
              if (o1[1] == o2[1]) {
                return Integer.compare(o1[2], o2[2]);
              }
              return Integer.compare(o1[1], o2[1]);
            });
	    pq.add(arr[0]);
	    int idx = 1;
	    List<Integer> ans = new ArrayList<>();
	    int endTime = 0;
    	while (!pq.isEmpty())
    	{
      		int[] curr = pq.poll();
      		if (curr[0] <= endTime) endTime += curr[1];
        	else endTime = (curr[0] + curr[1]);

			ans.add(curr[2]);
			boolean added = false;
      		while (idx < arr.length && arr[idx][0] <= endTime)
      		{
		        pq.add(arr[idx]);
		        idx++;
		        added = true;
      		}
      		if (!added && idx < arr.length && pq.isEmpty())
      		{
        		pq.add(arr[idx]);
        		idx++;
      		}
    	}
    	return ans.stream().mapToInt(i -> i).toArray();
	}
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        if(tasks == null || tasks.length == 0) {
            return new int[]{};
        }
        Task[] arr = new Task[tasks.length];
        for(int i=0;i<tasks.length;i++) {
            Task task = new Task(i,tasks[i][0], tasks[i][1]);
            arr[i] = task;
        }
        Arrays.sort(arr, (t1,t2) -> t1.enqueTime-t2.enqueTime);
        
        PriorityQueue<Task> pq = new PriorityQueue<Task>((task1, task2) -> {
            if (task1.processingTime == task2.processingTime) {
                return task1.idx - task2.idx;
            }
            return task1.processingTime - task2.processingTime;
        });
        
        int[] res = new int[tasks.length];
        int len = arr.length;
        int orderIdx =0;
        int nextTaskIdx=0;
        int currTime=0;
        while(orderIdx < len) {
            while(nextTaskIdx<arr.length && arr[nextTaskIdx].enqueTime <= currTime) {
                pq.add(arr[nextTaskIdx]);
                nextTaskIdx++;
            }
            
            if(pq.isEmpty()) {
                currTime = arr[nextTaskIdx].enqueTime;
                continue;
            }
            Task minTask = pq.poll();
            res[orderIdx++] = minTask.idx;
            currTime += minTask.processingTime;
        }
        
        return res;
    }
}

class Task {
    int idx;
    int enqueTime;
    int processingTime;
    
    public Task(int idx, int enqueTime, int processingTime) {
        this.idx = idx;
        this.enqueTime = enqueTime;
        this.processingTime = processingTime;
    }
}