/*https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1*/

class Element
{
    Integer array, index, value;
    public Element(int a, int i, int v)
    {
        this.array = a;
        this.index = i;
        this.value = v;
    }
}

class ValuePolling implements Comparator<Element> {
    public int compare(Element e1, Element e2) {
        return e1.value-e2.value;
    }
}

class Solution
{
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new ValuePolling());
        ArrayList<Integer> list = new ArrayList<Integer>();

        //add the first element from all the arrays to minheap
        for (int i = 0; i < arr.length; ++i)
            pq.add(new Element(i,0,arr[i][0]));

        //till exhausted
        while (!pq.isEmpty())
        {
        	//remove the root
            Element e = pq.poll();

            //add it to the result
            list.add(e.value);

            //add the next element of the same array to the minheap
            if (e.index+1 < K)
                pq.add(new Element(e.array,e.index+1,arr[e.array][e.index+1]));
        }
        
        return list;
    }
}