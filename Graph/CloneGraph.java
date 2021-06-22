/*https://leetcode.com/problems/clone-graph/*/

//a solution using BFS and hashmap
class Solution {
    public Node cloneGraph(Node node) {
    	//if graph is null return null
        if (node == null) return null;

        //clone the head node with the value
        Node newNode = new Node();
        newNode.val = node.val;

        //add the old head node to the queue
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        //add the new head node to hash map
        HashMap<Integer,Node> map = new HashMap<Integer,Node>();
        map.put(newNode.val,newNode);

        //till the queue has more nodes
        while (!queue.isEmpty())
        {
        	//remove from queue
            Node oldCurrNode = queue.remove();

            //new neighbors list
            List<Node> adjNodes = new ArrayList<Node>();

            //get the neighbors of the node from old graph 
            List<Node> oldAdjNodes = oldCurrNode.neighbors;

            //get the node with same value from the new graph
            Node currNode = map.get(oldCurrNode.val);

            //for every neighbor
            for (Node adjNode : oldAdjNodes)
            {
            	//get the new adjacent node
                Node newAdjNode = null;

                //if the copy of the node is not present
                if (!map.containsKey(adjNode.val))
                {
                	//create and add it to hashmap as well as queue
                    newAdjNode = new Node(adjNode.val);
                    map.put(adjNode.val,newAdjNode);
                    queue.add(adjNode);
                }
                //otherwise get the node from hashmap
                else
                    newAdjNode = map.get(adjNode.val);

                //add it to the new list
                adjNodes.add(newAdjNode);
            }

            //set the new neighbors
            currNode.neighbors = adjNodes;
        }

        //return the new head
        return newNode;
    }
}