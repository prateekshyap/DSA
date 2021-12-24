/*https://practice.geeksforgeeks.org/problems/partition-a-linked-list-around-a-given-value/1/*/

class Solution {
    public static Node partition(Node node, int x) {
    	//initialize three lists with dummy nodes
        Node less = new Node(0), lTail = less;
        Node more = new Node(0), mTail = more;
        Node equal = new Node(0), eTail = equal;

        //keep moving the node pointer and attach the nodes to the appropriate lists
        while (node != null)
        {
            if (node.data == x)
            {
                eTail.next = node;
                eTail = eTail.next;
            }
            else if (node.data < x)
            {
                lTail.next = node;
                lTail = lTail.next;
            }
            else
            {
                mTail.next = node;
                mTail = mTail.next;
            }
            node = node.next;
        }

        //mark the end of list as null
        mTail.next = null;

        //if equal list is present
        if (eTail != equal)
        {
        	//attach equal list to less list
            lTail.next = equal.next;
            //attach more list to equal list
            eTail.next = more.next;
            //return less list without the dummy node
            return less.next;
        }

        //attach more list to less list and return less list without dummy node
        lTail.next = more.next;
        return less.next;
    }
}