/*https://practice.geeksforgeeks.org/problems/minimum-swaps/1*/
/*Prateekshya's Solution*/
class Solution
{
    public int minSwaps(int nums[])
    {
        int swapCount = 0;

        //add the element to index mappings to hashtable
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; ++i)
            map.put(nums[i],i);

        //sort the array
        Arrays.sort(nums);

        //create a graph where edges are directed from old indices to new indices for each element
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < nums.length; ++i)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; ++i)
            if (i != (Integer)map.get(nums[i])) //avoid adding self loops
                graph.get((Integer)map.get(nums[i])).add(i);

        //create a visited array
        boolean[] visited = new boolean[nums.length];

        //for each element
        for (int i = 0; i < nums.length; ++i)
        {
        	//mark as visited if it is already at its correct index
            if (graph.get(i).size() == 0) visited[i] = true;

            //otherwise if it is not already visited
            else if (!visited[i])
            {
            	//find the cycle size
                int cycleSize = 0;
                visited[i] = true;
                int src = (Integer)graph.get(i).get(0);
                ++cycleSize;
                visited[src] = true;
                int temp = (Integer)graph.get(src).get(0);
                ++cycleSize;
                while ((Integer)graph.get(temp).get(0) != src)
                {
                    ++cycleSize;
                    visited[temp] = true;
                    temp = (Integer)graph.get(temp).get(0);
                }

                //add to the swap count
                swapCount += (cycleSize-1);
            }
        }
        
        return swapCount;
    }
}

/*Pratik's Solution*/
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int graph[][] = new int[nums.length][2];
        for(int i=0;i<nums.length;i++)
        {
            graph[i][0] = nums[i];
            graph[i][1] = i;
        }
        Arrays.sort(graph,(a,b)->a[0]-b[0]);
        boolean visited[] = new boolean[nums.length];
        int len = 1;
        int index = graph[0][1];
        int rem = nums.length-1;
        int count = 0;
        visited[index] = true;
        while(rem>0)
        {
            index = graph[index][1];
            if(visited[index]==true)
            {
                count+=(len-1);
                len = 1;
                while(visited[index]!=false)
                {
                    index = (index+1)%nums.length;
                }
                visited[index] = true;
            }
            else
            {
                len++;
                visited[index] = true;
            }
            rem--;
        }
        count+=(len-1);
        return count;
    }
}

class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        HashMap<Integer,Integer> graph = new HashMap<Integer,Integer>();
        int[] copy = nums.clone();
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length; ++i)
            graph.put(nums[i],i);
        boolean[] visited = new boolean[nums.length];
        int result = 0, start, curr, cycle = 0, ind;
        for (i = 0; i < nums.length; ++i)
        {
            if (!visited[i])
            {
                ind = i;
                start = nums[ind];
                visited[ind] = true;
                cycle = 1;
                while (copy[ind] != start)
                {
                    ind = graph.get(copy[ind]);
                    visited[ind] = true;
                    ++cycle;
                }
                result += cycle-1;
            }
        }
        return result;
    }
}