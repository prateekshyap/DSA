/*https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1/*/

class Node implements Comparable<Node> {
    Node left;
    char ch;
    int freq;
    Node right;
    Node(char ch, int freq) {
        super();
        this.ch = ch;
        this.freq = freq;
    }
    
    @Override
    public String toString() {
        return "";
    }
    
    @Override
    public int compareTo(Node node) {
        if (this.freq < node.freq) return -1;
        return 1;
    }
}

class Solution {
    ArrayList<String> list;
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        list = new ArrayList<String>();
        
        //add all the nodes to priority queue
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (int i = 0; i < N; ++i)
            pq.add(new Node(S.charAt(i),f[i]));
            
        //till the minheap has more than one elements
        while (pq.size() > 1)
        {
        	//poll the children
            Node leftChild = pq.poll();
            Node rightChild = pq.poll();

            //build their parent node and attach them
            Node parentNode = new Node('\0',leftChild.freq+rightChild.freq);
            parentNode.left = leftChild;
            parentNode.right = rightChild;

            //add the parent to the minheap
            pq.add(parentNode);
        }
        
        //traverse preorder and store into the final list
        Node treeRoot = pq.poll();
        traversePreOrder(treeRoot,"");
        return list;
    }
    public void traversePreOrder(Node root, String currCode)
    {
        if (root != null)
        {
            if (root.ch != '\0') list.add(currCode);
            traversePreOrder(root.left,currCode+"0");
            traversePreOrder(root.right,currCode+"1");
        }
    }
}