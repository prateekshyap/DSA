/*https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1*/

/*Pratik's Solution*/

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        HashSet<Integer> sptSet = new HashSet<Integer>();
        int[] dist = new int[V];
        for(int i=0;i<V;i++)dist[i] = Integer.MAX_VALUE;
        dist[S] = 0;
        while(sptSet.size()<V)
        {
            int u = getMin(sptSet,dist);
            ArrayList<ArrayList<Integer>> adjU = adj.get(u);
            for(int i = 0;i<adjU.size();i++)
            {
                int distU = dist[u];
                int distUI = adjU.get(i).get(1);
                int distI = dist[adjU.get(i).get(0)];
                if(distI>(distU+distUI))
                {
                    dist[adjU.get(i).get(0)] = distU+distUI;
                }
            }
            sptSet.add(u);
        }
        return dist;
    }
    static int getMin(HashSet<Integer> sptSet,int[] dist)
    {
        int minWeight = Integer.MAX_VALUE;
        int u = -1;
        for(int i=0;i<dist.length;i++)
        {
            if(!sptSet.contains(i) && dist[i]<minWeight)
            {
                minWeight = dist[i];
                u = i;
            }
        }
        return u;
    }
}

/*Prateekshya's Solution*/
class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] pathCosts = new int[V];
        boolean[] checkedVertices = new boolean[V];
        
        //initialize all path costs to infinity except the source
        for (int i = 0; i < V; ++i)
            if (i != S)
                pathCosts[i] = Integer.MAX_VALUE;
                
        for (int count = 1; count < V; ++count)
        {
            //extract minimum from the unchecked vertices and mark it checked
            int minVertex = getMinVertex(pathCosts, checkedVertices, V);
            checkedVertices[minVertex] = true;

            //get the adjacent nodes
            ArrayList<ArrayList<Integer>> adjacentNodes = adj.get(minVertex);
            
            //relax all the adjacent edges
            for (ArrayList<Integer> edge : adjacentNodes)
                pathCosts = relaxEdge(pathCosts, minVertex, (Integer)edge.get(0), (Integer)edge.get(1));
        }
        
        return pathCosts;
    }
    
    static int getMinVertex(int[] costs, boolean[] checked, int V)
    {
        int minValue = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < V; ++i)
            if (!checked[i] && costs[i] < minValue)
            {
                minValue = costs[i];
                index = i;
            }
        return index;
    }
    
    static int[] relaxEdge(int[] pathCosts, int source, int destination, int weight)
    {
    	//update the path cost
        if (pathCosts[destination] > pathCosts[source]+weight)
            pathCosts[destination] = pathCosts[source]+weight;
        return pathCosts;
    }
}

/*Using heap from scratch*/

class Node
{
    private int vertex, cost, index;
    Node(int v, int c, int i)
    {
        vertex = v;
        cost = c;
        index = i;
    }
    public void setCost(int c) { cost = c; }
    public int getCost() { return cost; }
    public int getVertex() { return vertex; }
    public void setIndex(int i){ index = i; }
    public int getIndex() { return index; }
}

class Heap
{
    private Node[] pointers;
    private Node[] pathCosts;
    private int heapSize;
    Heap(int V, int S)
    {
        pointers = new Node[V];
        pathCosts = new Node[V];
        heapSize = V;
        for (int i = 0; i < V; ++i)
        {
            if (i != S)
            {
                pathCosts[i] = new Node(i, Integer.MAX_VALUE, i);
                pointers[i] = pathCosts[i];
            }
            else
            {
                pathCosts[i] = new Node(i, 0, i);
                pointers[i] = pathCosts[i];
            }
        }
        buildHeap();
    }
    private int left(int root) { return (2*root)+1; }
    private int right(int root) { return (2*root)+2; }
    private int parent(int root) { return (root-1)/2; }
    private void buildHeap()
    {
        for (int i = (heapSize/2)-1; i >= 0; --i)
            minHeapify(i);
    }
    private void minHeapify(int root)
    {
        int min = root;
        if (left(root) < heapSize && pathCosts[left(root)].getCost() < pathCosts[min].getCost())
            min = left(root);
        if (right(root) < heapSize && pathCosts[right(root)].getCost() < pathCosts[min].getCost())
            min = right(root);
        if (min != root)
        {
            Node temp = pathCosts[min];
            pathCosts[min] = pathCosts[root];
            pathCosts[root] = temp;
            pointers[pathCosts[min].getVertex()] = pathCosts[min];
            pointers[pathCosts[root].getVertex()] = pathCosts[root];
            pathCosts[min].setIndex(min);
            pathCosts[root].setIndex(root);
            minHeapify(min);
        }
    }
    public Node extractRoot()
    {
        Node temp = pathCosts[0];
        pathCosts[0] = pathCosts[heapSize-1];
        pointers[temp.getVertex()] = null;
        pathCosts[0].setIndex(0);
        pointers[pathCosts[0].getVertex()] = pathCosts[0];
        --heapSize;
        minHeapify(0);
        return temp;
    }
    public void decreaseKey(int i, int newCost)
    {
        Node destination = pointers[i];
        destination.setCost(newCost);
        int index = destination.getIndex();
        int parent = parent(index);
        while (index != 0)
        {
            if (pathCosts[index].getCost() < pathCosts[parent].getCost())
            {
                Node temp = pathCosts[index];
                pathCosts[index] = pathCosts[parent];
                pathCosts[parent] = temp;
                pointers[pathCosts[index].getVertex()] = pathCosts[index];
                pointers[pathCosts[parent].getVertex()] = pathCosts[parent];
                pathCosts[index].setIndex(index);
                pathCosts[parent].setIndex(parent);
                index = parent;
                parent = parent(parent);
            }
            else break;
        }
    }
}

class Solution
{
    static int[] costs;
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        costs = new int[V];
        Heap heap = new Heap(V,S);
        
        //initialize all path costs to infinity except the source
        for (int i = 0; i < V; ++i)
            if (i != S)
                costs[i] = Integer.MAX_VALUE;
                
        for (int count = 1; count < V; ++count)
        {
            //extract minimum from the unchecked vertices and mark it checked
            Node minVertex = heap.extractRoot();
            //costs[minVertex.getVertex()] = minVertex.getCost();

            //get the adjacent nodes
            ArrayList<ArrayList<Integer>> adjacentNodes = adj.get(minVertex.getVertex());
            
            //relax all the adjacent edges
            for (ArrayList<Integer> edge : adjacentNodes)
                costs = relaxEdge(heap, minVertex.getVertex(), (Integer)edge.get(0), (Integer)edge.get(1));
        }
        
        return costs;
    }
    
    static int[] relaxEdge(Heap heap, int source, int destination, int weight)
    {
        //update the path cost
        if (costs[destination] > costs[source]+weight)
        {
            costs[destination] = costs[source]+weight;
            heap.decreaseKey(destination, costs[destination]);
        }
        return costs;
    }
}

class Pair implements Comparable<Pair>
{
    int j;
    int wt;
    Pair(int j, int wt)
    {
        this.j = j;
        this.wt = wt;
    }
    @Override
    public int compareTo(Pair p)
    {
        return this.wt-p.wt;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int V;
    static int[] costs;
    static boolean[] visited;
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        V = v;
        costs = new int[V];
        int[] parents = new int[V];
        visited = new boolean[V];
        Arrays.fill(costs,5000000);
        costs[S] = 0;
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
        heap.add(new Pair(S,0));
        Pair p;
        while (heap.size() > 0)
        {
            p = heap.poll();
            if (visited[p.j]) continue;
            visited[p.j] = true;
            costs[p.j] = p.wt;
            for (ArrayList<Integer> adjNode : adj.get(p.j))
            {
                if (!visited[adjNode.get(0)])
                {
                    heap.add(new Pair(adjNode.get(0),adjNode.get(1)+p.wt));
                }
            }
        }
        
        return costs;
    }
}

