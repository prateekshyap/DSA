/*https://practice.geeksforgeeks.org/problems/water-connection-problem5822/1*/

class Solution 
{ 
    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,ArrayList<Integer> b ,ArrayList<Integer> d) 
    {
        //build the graph from a, b and d
        //also keep track of the source vertices
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<ArrayList<ArrayList<Integer>>>();
        boolean[] hash = new boolean[n];
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<ArrayList<Integer>>());
        for (int i = 0; i < b.size(); ++i)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(b.get(i)-1);
            list.add(d.get(i));
            hash[b.get(i)-1] = true;
            graph.get(a.get(i)-1).add(list);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        //for every house
        for (int i = 0; i < n; ++i)
        {
            //if the house is a source
            if (!hash[i])
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                
                //get the tap installing house and minimum diameter
                int[] tapDetails = findTapDetails(graph,i);

                //if the minimum diameter is not infinity
                if (tapDetails[1] != Integer.MAX_VALUE)
                {
                    //add it to the result
                    list.add(i+1); //add source
                    list.add(tapDetails[0]+1); //add sink
                    list.add(tapDetails[1]); //add diameter
                    result.add(list);
                }
            }
        }
        return result;
    }
    int[] findTapDetails(ArrayList<ArrayList<ArrayList<Integer>>> graph, int src)
    {
        /*
        0 index stores the sink vertex
        1 index stores the minimum diameter
        */
        int[] result = new int[2];
        result[1] = Integer.MAX_VALUE;

        //get the adjacent vertex of the source
        ArrayList<ArrayList<Integer>> adjVertex = graph.get(src);

        //till we reach the sink
        while (adjVertex.size() > 0)
        {
            //find out the minimum diameter edge out of all outgoing edges
            ArrayList<Integer> edge = null;
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < adjVertex.size(); ++i)
            {
                if (adjVertex.get(i).get(1) < minValue)
                {
                    minValue = adjVertex.get(i).get(1);
                    minIndex = i;
                }
            }
            edge = adjVertex.get(minIndex);

            //update the minimum diameter through the path
            if (edge.get(1) < result[1])
                result[1] = edge.get(1);

            //traverse the next vertex
            adjVertex = graph.get(edge.get(0));
            result[0] = edge.get(0);
        }
        return result;
    }
}