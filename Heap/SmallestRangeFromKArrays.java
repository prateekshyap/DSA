/*https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1*/

class Element implements Comparable<Element>
{
    int array;
    int index;
    int element;
    Element(int a, int i, int e)
    {
        array = a;
        index = i;
        element = e;
    }
    public int compareTo(Element e)
    {
        return this.element - e.element;
    }
}

class smallestRangeFromKLists
{
	static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    int[] result = new int[2];

	    //create a min heap
	    PriorityQueue<Element> minHeap = new PriorityQueue<Element>();
	    int minRange = Integer.MAX_VALUE;
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    
	    //add all the first elements and find the maximum too
	    for (int i = 0; i < arr.length; ++i)
	    {
	        minHeap.add(new Element(i,0,arr[i][0]));
	        max = Math.max(max,arr[i][0]);
	    }

	    //till no array is exhausted
	    while (minHeap.size() == k)
	    {
	    	//set the minimum element
	        Element minElem = minHeap.poll();
	        min = minElem.element;

	        //update the range and result
	        if (minRange > max-min+1)
	        {
	            minRange = max-min+1;
	            result[0] = min;
	            result[1] = max;
	        }

	        //update the heap and max as well
	        if (minElem.index+1 < n)
	        {
	            Element newElem = new Element(minElem.array,minElem.index+1,arr[minElem.array][minElem.index+1]);
	            minHeap.add(newElem);
	            if (newElem.element > max)
	                max = newElem.element;
	        }

	        //when one array is exhausted, break
	        else
	            break;
	    }

	    return result;
	}
}