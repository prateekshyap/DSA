/*https://leetcode.com/problems/employee-importance/*/

//application of BFS
class Solution {
    HashMap<Integer,Integer> map;
    Queue<Employee> queue;
    boolean[] visited;
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        map = new HashMap<Integer,Integer>();
        queue = new LinkedList<Employee>();
        visited = new boolean[employees.size()];
        
        for (Employee e : employees)
            map.put(e.id,result++);
        result = 0;
        
        Employee e = employees.get((Integer)map.get(id));
        queue.add(e);
        visited[(Integer)map.get(e.id)] = true;
        
        while (!queue.isEmpty())
        {
            e = queue.poll();
            result += e.importance;
            for (Integer subordinateId : e.subordinates)
            {
                Employee subordinate = (Employee)employees.get((Integer)map.get(subordinateId));
                if (!visited[(Integer)map.get(subordinate.id)])
                {
                    visited[(Integer)map.get(subordinate.id)] = true;
                    queue.add(subordinate);
                }
            }
        }
        return result;
    }
}