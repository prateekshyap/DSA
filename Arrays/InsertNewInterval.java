/*https://leetcode.com/problems/insert-interval/*/

class Element implements Comparable<Element>
{
    int start;
    int end;
    Element(int s, int e)
    {
        super();
        this.start = s;
        this.end = e;
    }
    
    @Override
    public String toString()
    {
        return "";
    }
    
    @Override
    public int compareTo(Element e)
    {
        return this.start - e.start;
    }
}

class Solution
{
    public int[][] insert(int[][] intervals, int[] newInterval)
    {        
        //add the elements to a priority queue / min heap
        PriorityQueue<Element> pq = new PriorityQueue<Element>();
        for (int i = 0; i < intervals.length; ++i)
            pq.add(new Element(intervals[i][0],intervals[i][1]));
        
        //add the new interval also
        pq.add(new Element(newInterval[0],newInterval[1]));
        
        //stores the results
        List<Element> list = new ArrayList<Element>();
        
        //till priorityqueue has elements
        while (!pq.isEmpty()) 
        {
            boolean flag = true;
            
            //extract root
            Element polled = pq.poll();

            //for all elements added to the result list
            for (int j = 0; j < list.size(); ++j)
            {
                Element old = list.get(j);

                //if the ranges overlap
                if (!(old.start <= old.end && old.end < polled.start && polled.start <= polled.end) && !(polled.start <= polled.end && polled.end < old.start && old.start <= old.end))
                {
                    //set the new range and store
                    old.start = (polled.start <= old.start) ? polled.start : old.start;
                    old.end = (polled.end >= old.end) ? polled.end : old.end;
                    list.set(j,old);
                    flag = false;
                    break;
                }
            }
            
            //if it couldn't be merged then add separately
            if (flag)
                list.add(new Element(polled.start,polled.end));
        }
        
        //convert arraylist to array and return
        int[][] res = new int[list.size()][2];
        int i = 0;
        for (Element e : list)
        {
            res[i][0] = e.start;
            res[i][1] = e.end;
            ++i;
        }
        return res;
    }
}