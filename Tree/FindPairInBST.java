/*https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1*/

//hashing technique - O(n) extra space
class Solution
{
    HashMap<Integer, Integer> map;
    int retVal = 0;
    public int isPairPresent(Node root, int target)
    {
        map = new HashMap<Integer, Integer>();

        //recursion call
        inOrder(root, target);

        return retVal;
    }
    public void inOrder(Node root, int sum)
    {
        if (root != null)
        {
        	/*recursion*/
            inOrder(root.left, sum);

            //if the hashmap contains the other value
            if (map.containsKey(sum-root.data))
            {
            	//mark it and return
                retVal = 1;
                return;
            }

            //put the current value in hashmap
            map.put(root.data,1);

            /*recursion*/
            inOrder(root.right, sum);
        }
    }
}

//two pointer approach after converting into a sorted DLL - O(h) extra space
class Solution
{
    public Node head, tail;
    void addNodeToRight(int num)
    {
    	//create a new node after tail
        tail.right = new Node(num);

        //set the previous pointer of the new node
        tail.right.left = tail;

        //move tail
        tail = tail.right;
    }
    void inOrder(Node root)
    {
    	//if root is not null
        if (root != null)
        {
        	/*recursion*/
            inOrder(root.left);

            //add the current node to the end of the linked list
            addNodeToRight(root.data);

            /*recursion*/
            inOrder(root.right);
        }
    }
    public int isPairPresent(Node root, int target)
    {
    	//initialize a dummy node and make both the pointers point to it
        head = new Node(0);
        tail = head;

        //recursion call
	    inOrder(root);

	    //delete the dummy node
	    head = head.right;
	    head.left = null;
	    
	    //two pointer approach to get the pair
	    Node left = head;
	    Node right = tail;
	    
	    //till the pointers collide
	    while (left != right)
	    {
	    	//if sum is equal to target return 1
	        if (left.data+right.data == target) return 1;

	        //if sum is less, move left pointer
	        else if (left.data+right.data < target) left = left.right;

	        //else move right pointer
	        else right = right.left;
	    }

	    return 0;
    }
}