/*https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1*/

//contains the node values and their levels
class Data implements Comparable<Data>
{
    int level;
    int data;
    Data(int l, int d)
    {
        level = l;
        data = d;
    }
    @Override
    public int compareTo(Data d)
    {
        return this.data - d.data;
    }
}

class Solution
{
    static HashMap<Integer,Data> map;
    static int minAlignment, maxAlignment;
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        /*vertical alignments will be the keys, since 
        we need one and only one element per alignment*/
        map = new HashMap<Integer,Data>();
        minAlignment = Integer.MAX_VALUE;
        maxAlignment = Integer.MIN_VALUE;

        //recursion call
        traverseAndStore(root,0,0);

        //add the data to the list in the order of their alignments
        for (int i = minAlignment; i <= maxAlignment; ++i)
            list.add(map.get(i).data);
        return list;
    }
    static void traverseAndStore(Node root, int verticalAlignment, int level)
    {
    	//if root is not null
        if (root != null)
        {
        	/*for top view we need the data at the lowest level*/
        	//if the current alignment is not present in hashtable or a higher level data is stored
            if (!map.containsKey(verticalAlignment) || map.get(verticalAlignment).level > level)
            {
            	//add the current element along with its level and alignment to the hashtable
                map.put(verticalAlignment,new Data(level,root.data));

                //update the minimum and maximum alignment
                minAlignment = Math.min(minAlignment,verticalAlignment);
                maxAlignment = Math.max(maxAlignment,verticalAlignment);
            }

            /*recursion*/
            traverseAndStore(root.left,verticalAlignment-1,level+1);
            traverseAndStore(root.right,verticalAlignment+1,level+1);
        }
    }
}