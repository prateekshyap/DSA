/*https://leetcode.com/problems/queue-reconstruction-by-height/*/

class Person implements Comparable<Person>
{
    int height;
    int count;
    Person(int h, int c)
    {
        this.height = h;
        this.count = c;
    }
    @Override
    public int compareTo(Person p)
    {
        if (this.height < p.height) return -1;
        else if (this.height > p.height) return 1;
        else if (this.count < p.count) return -1;
        return 1;
    }
    @Override
    public String toString()
    {
        return "("+this.height+","+this.count+")";
    }
}
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        int index = -1, n = people.length, i;
        Person p;
        Iterator iterator;
        
        //fill result with -1
        for (i = 0; i < n; ++i)
            Arrays.fill(result[i],-1);
            
        //add all empty slots to the tree set
        TreeSet<Integer> emptySlots = new TreeSet<Integer>();
        for (i = 0; i < n; ++i) emptySlots.add(i);
        Stack<Integer> removeStack = new Stack<Integer>();
        
        //create priorityqueue for all the people
        PriorityQueue<Person> heap = new PriorityQueue<Person>();
        for (int[] person : people) heap.add(new Person(person[0],person[1]));
        
        //pick one by one and place at the correct position
        while (!heap.isEmpty())
        {
            p = heap.poll(); //get the shortest person
            iterator = emptySlots.iterator(); //start a new iterator on the empty slots
            //get the empty place by skipping count number of places
            for (i = 0; i <= p.count; ++i)
                if (iterator.hasNext())
                    index = (Integer)iterator.next();
            removeStack.add(index); //add the current index to a stack
            if (!heap.isEmpty() && p.height != heap.peek().height) //only if the next height is different from the current one
            {
                while (!removeStack.isEmpty()) //for all the elements present in the stack
                    emptySlots.remove(removeStack.pop()); //remove them from both stack and empty slots
            }
            //store the result in the desired index
            result[index][0] = p.height;
            result[index][1] = p.count;
        }
        
        return result;
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->(a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]));
        
        List<int[]> cache = new ArrayList<int[]>();
        for(int[] p : people)
            cache.add(p[1], p);
        
        return cache.toArray(new int[people.length][]);
    }
}