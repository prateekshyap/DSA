/*https://leetcode.com/problems/task-scheduler-ii/*/

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> map = new HashMap<Integer,Long>();
        long days = 0;
        int i = 0;
        
        while (i < tasks.length)
        {
            if (!map.containsKey(tasks[i]) || days-(Long)map.get(tasks[i]) > space)
                map.put(tasks[i++],days);
            else
                days = (Long)map.get(tasks[i])+space;
            ++days;
        }
        
        return days;
    }
}

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long currentDay = 0;
        
        Map<Integer, Long> map = new HashMap<>();
        
        for (int num : tasks){
            currentDay = Math.max(currentDay, map.getOrDefault(num, 0L));
            map.put(num, ++currentDay + space);
        }
        
        return currentDay;
    }
}