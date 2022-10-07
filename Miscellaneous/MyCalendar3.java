/*https://leetcode.com/problems/my-calendar-iii/*/

class MyCalendarThree {
    Map<Integer,Integer> diff;
    public MyCalendarThree() {
        diff = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        diff.put(start,diff.getOrDefault(start,0)+1);
        diff.put(end,diff.getOrDefault(end,0)-1);
        int result = 0, curr = 0;
        for (int delta : diff.values())
        {
            curr += delta;
            result = Math.max(result,curr);
        }
        return result;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

class MyCalendarThree {
    SegmentTree root;
    int max;
    public MyCalendarThree() {
        max = 0;        
    }
    
    public int book(int start, int end) {
        root = insert(root, start, end , 1);      
        return max;
    }
    
    
    public SegmentTree insert(SegmentTree node, int s , int e, int count){
        if(e <= s) return node;
        
        if(node == null)
        {
            node = new SegmentTree(s, e, count);
            max = Math.max(count, max);
            return node;
        }
        if(e <= node.start)
            node.left = insert(node.left, s, e, count);
        else if(node.end <= s)
            node.right = insert(node.right, s, e, count);
        else
        {
            int a = Math.min(node.start, s);
            int b = Math.max(node.start, s);
            int c = Math.min(node.end, e);
            int d = Math.max(node.end, e);
            
            node.left = insert(node.left, a,b, a==node.start? node.booking : count);
            node.right = insert(node.right, c, d, d == node.end ? node.booking: count);
            node.start = b;
            node.end = c;
            node.booking += count;
            max = Math.max(node.booking, max);
        }
        
        return node;
    }
}

class SegmentTree
{
    public int start;
    public int end;
    public int booking;
    public SegmentTree left;
    public SegmentTree right;
    
    public SegmentTree(int start, int end, int count)
    {
        this.start = start;
        this.end = end;
        this.booking = count;
    }
}


/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

