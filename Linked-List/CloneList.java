/*https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1*/
/*https://leetcode.com/problems/copy-list-with-random-pointer/*/

//hashmap approach
class Clone {
    Node copyList(Node head) {
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        Node temp = head;

        //create a new list
        Node newHead = new Node(0);
        Node newTemp = newHead;
        temp = head;

        //till we have more nodes
        while (temp != null)
        {
        	//clone the node
            newTemp.next = new Node(temp.data);
            
            //move the pointer in copy list
            newTemp = newTemp.next;
            
            //store the original node to copy node mappings
            map.put(temp,newTemp);

            //move the pointer in original list
            temp = temp.next;
        }
        newHead = newHead.next;
        newTemp = newHead;
        temp = head;

        //till we have more elements
        while (temp != null && newTemp != null)
        {
        	//if the arb pointer of current node is set
            if (temp.arb != null)
            {
            	//get the target node of the original list
                Node tempArb = temp.arb;

                //get the corresponding node from copy list
                Node newArb = map.get(temp.arb);

                //store it in the arb pointer of the current copy node
                newTemp.arb = newArb;
            }

            //move both the pointers simultaneously
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}

//efficient approach
class Clone {
    Node copyList(Node head) {
        Node temp = head;

        //for every node
        while (temp != null)
        {
        	//create a new node with the same value
            Node newNode = new Node(temp.data);

            //insert it after the current node
            newNode.next = temp.next;
            temp.next = newNode;

            //make a double jump since the next node is the newly inserted node which need not be considered
            temp = temp.next.next;
        }
        temp = head;

        //for every node
        while (temp != null)
        {
        	/*if the next node is not empty and the random pointer is not null,
        	store the next of random pointer at random of next pointer i.e.
        	temp.next.arb = temp.arb.next*/
            if (temp.next != null)
                temp.next.arb = (temp.arb == null) ? null : temp.arb.next;

            //make a double jump
            temp = (temp.next == null) ? null : temp.next.next;
        }

        //copy points to the second node
        Node copy = head.next;

        //make the new head
        Node newHead = copy;

        //original points to the first node
        Node original = head;

        //till we have more elements
        while (original != null && copy != null)
        {
        	//skip the copy node for the original list
            original.next = (original.next == null) ? null : original.next.next;

            //move to the next original node
            original = original.next;

            //skip the original node for the copy list
            copy.next = (copy.next == null) ? null : copy.next.next;

            //move to the next copy node
            copy = copy.next;
        }

		/*This way we retain both the head pointers intact and also create the required copy list*/
		//return the new head
        return newHead;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node temp = head, newNode;
        while (temp != null)
        {
            newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null)
        {
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        Node newHead = temp.next;
        Node hold = temp.next.next;
        while (hold != null)
        {
            temp.next.next = hold.next;
            temp.next = hold;
            temp = hold;
            hold = temp.next.next;
        }
        temp.next = null;
        return newHead;
    }
}