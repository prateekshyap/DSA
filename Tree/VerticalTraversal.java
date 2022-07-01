/*https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1*/
/*https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/*/

class Data implements Comparable<Data>
{
    int index;
    int level;
    int data;
    Data(int i, int l, int d)
    {
        index = i;
        level = l;
        data = d;
    }
    @Override
    public int compareTo(Data d)
    {
        if (this.level < d.level) return -1;
        if (this.level > d.level) return 1;
        return this.index - d.index;
    }
}

class Solution
{
    static int minAlignment, maxAlignment;
    static HashMap<Integer,ArrayList<Data>> map;
    static ArrayList<Integer> verticalOrder(Node root)
    {
        map = new HashMap<Integer,ArrayList<Data>>();
        minAlignment = Integer.MAX_VALUE;
        maxAlignment = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<Integer>();

        //recursion call
        traverseAndStore(root,0,0);

        //add the elements in the order of the alignments
        for (int i = minAlignment; i <= maxAlignment; ++i)
        {
            //get the list and sort it (compareTo method is already written)
            ArrayList<Data> list = (ArrayList)map.get(i);
            Collections.sort(list);

            //keep adding the values to the final list
            for (Data d : list)
                result.add(d.data);
        }

        return result;
    }
    static void traverseAndStore(Node root, int verticalAlignment, int level)
    {
        if (root != null)
        {
            //if the alignment is new then create an entry in map and add an empty list
            if (!map.containsKey(verticalAlignment))
            {
                ArrayList<Data> temp = new ArrayList<Data>();
                map.put(verticalAlignment,temp);
            }

            //put the value along with its level and index in the list
            map.get(verticalAlignment).add(new Data(map.get(verticalAlignment).size(),level,root.data));

            //update the minimum and maximum alignment
            minAlignment = Math.min(minAlignment,verticalAlignment);
            maxAlignment = Math.max(maxAlignment,verticalAlignment);
            
            /*recursion*/
            traverseAndStore(root.left,verticalAlignment-1,level+1);
            traverseAndStore(root.right,verticalAlignment+1,level+1);
        }
    }
}