/*https://practice.geeksforgeeks.org/problems/quick-sort-on-linked-list/1*/

//merge sort is more important
//this approach is not standard, since it involves data swapping instead of pointer swapping
class GfG
{
    GfG(){}
    Node node;
    Node end;
    GfG(Node node, Node end)
    {
        this.node = node;
        this.end = end;
    }
    Node paritionLast(Node start, Node end)
    {
        if (start == end || start == null || end == null)
            return start;
 
        Node prevPivot = start;
        Node curr = start;
        int pivot = end.data;
 
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.data < pivot) {
                // keep tracks of last modified item
                prevPivot = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }
 
        // swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
 
        // return one previous to current
        // because current is now pointing to pivot
        return prevPivot;
    }
 
    void sort(Node start, Node end)
    {
        if(start == null || start == end|| start == end.next )
            return;
 
        // split list and partion recurse
        Node prevPivot = paritionLast(start, end);
        sort(start, prevPivot);
 
        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (prevPivot != null && prevPivot == start)
            sort(prevPivot.next, end);
 
        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have prevPivot, so we move two nodes
        else if (prevPivot != null
                 && prevPivot.next != null)
            sort(prevPivot.next.next, end);
    }
    public static Node quickSort(Node node)
    {
        Node end = node;
        while (end.next != null)
            end =end.next;
        GfG g = new GfG(node,end);
        g.sort(node,end);
        return g.node;
    }
}