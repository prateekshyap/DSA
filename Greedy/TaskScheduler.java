/*https://leetcode.com/problems/task-scheduler/*/

/*Prateekshya*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] map = new int[26];
        int result = 0, maxLength = 0;
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < tasks.length; ++i)
        {
            ++map[tasks[i]-'A'];
            if (map[tasks[i]-'A'] > maxLength)
            {
                maxLength = map[tasks[i]-'A'];
                list = new ArrayList<Character>();
                list.add(tasks[i]);
            }
            else if (map[tasks[i]-'A'] == maxLength)
                list.add(tasks[i]);
        }

        //add the maximum length tasks
        result += (maxLength+((maxLength-1)*n));

        //add the rest
        result += (list.size()-1);

        //return the longer length
        return result < tasks.length ? tasks.length : result;
    }
}