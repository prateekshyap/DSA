/*https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/*/

class Point
{
    int x;
    int y;
    int distance;
    int index;
    Point(int x, int y, int i, int origX, int origY)
    {
        this.x = x;
        this.y = y;
        this.index = i;
        if (x == origX || y == origY)
            this.distance = Math.abs(x-origX)+Math.abs(y-origY);
        else
            this.distance = Integer.MAX_VALUE;
    }
}

class Heap
{
    Point[] points;
    int size;
    int x, y;
    Heap(int[][] p, int x, int y)
    {
        points = new Point[p.length];
        size = p.length;
        this.x = x;
        this.y = y;
        for (int i = 0; i < p.length; ++i)
            points[i] = new Point(p[i][0],p[i][1],i,x,y);
        buildHeap();
    }
    private int left(int root) { return (2*root)+1; }
    private int right(int root) { return (2*root)+2; }
    private int parent(int root) { return (root-1)/2; }
    private void buildHeap()
    {
        for (int i = (size/2)-1; i >= 0; --i)
            minHeapify(i);
    }
    private void minHeapify(int root)
    {
        int min = root;
        if (left(root) < size && points[left(root)].distance < points[min].distance)
            min = left(root);
        if (right(root) < size && points[right(root)].distance < points[min].distance)
            min = right(root);
        if (min != root)
        {
            Point temp = points[min];
            points[min] = points[root];
            points[root] = temp;
            minHeapify(min);
        }
    }
    public Point extractRoot()
    {
        if (size == 1)
        {
            size = 0;
            return points[0];
        }
        Point temp = points[0];
        points[0] = points[size-1];
        --size;
        minHeapify(0);
        return temp;
    }
    public boolean isEmpty()
    {
        return size == 0 ? true : false;
    }
}

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        Heap heap = new Heap(points,x,y);
        Point point = heap.extractRoot();
        if (point.distance == Integer.MAX_VALUE) return -1;
        int minDist = point.distance;
        int result = point.index;
        if (heap.isEmpty()) return result;
        point = heap.extractRoot();
        while (!heap.isEmpty() && point.distance == minDist)
        {
            result = Math.min(result,point.index);
            point = heap.extractRoot();
        }
        if (point.distance == minDist)
            result = Math.min(result,point.index);
        return result;
    }
}