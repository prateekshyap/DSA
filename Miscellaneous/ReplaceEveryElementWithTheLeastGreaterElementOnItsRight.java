/*https://practice.geeksforgeeks.org/problems/replace-every-element-with-the-least-greater-element-on-its-right/1/*/

class Solution {
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>(), result = new ArrayList<Integer>();
        int i, low, mid, high, leastMax;
        result.add(-1);
        list.add(arr[n-1]);
        for (i = n-2; i >= 0; --i)
        {
            if (arr[i] >= list.get(list.size()-1))
            {
                result.add(0,-1);
                list.add(arr[i]);
            }
            else if (arr[i] < list.get(0))
            {
                result.add(0,list.get(0));
                list.add(0,arr[i]);
            }
            else
            {
                low = 0; high = list.size()-1; leastMax = -1;
                while (low <= high)
                {
                    mid = low+((high-low)/2);
                    if (list.get(mid) > arr[i])
                    {
                        leastMax = mid;
                        high = mid-1;
                    }
                    else low = mid+1;
                }
                result.add(0,list.get(leastMax));
                list.add(leastMax,arr[i]);
            }
        }
        return result;
    }
}

//tree solution
class Solution {
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        // code here
        int i;
        BST tree = new BST();
        tree.insert(arr[n-1]);
        arr[n-1] = -1;
        for (i = n-2; i >= 0; --i)
        {
            tree.insert(arr[i]);
            arr[i] = tree.successor(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int d : arr) list.add(d);
        return list;
    }
}

class BST
{
    class Node
    {
        Node left;
        boolean leftThread;
        int data;
        boolean rightThread;
        Node right;
        Node(int d)
        {
            data = d;
            leftThread = rightThread = false;
        }
    }
    
    Node root;
    
    BST()
    {
        root = null;
    }
    
    public void insert(int val)
    {
        if (root == null) //if root is null then create root
    		root = new Node(val);
    	else //otherwise call recursive insertion
    		insertIntoTree(root,val);
    }
    
    public void insertIntoTree(Node root, int x)
    {
        if (x <= root.data) //if x is less than root
    	{
    		if (root.left == null || root.leftThread == true) //if left is null or left thread is present
    		{
    			Node newNode = new Node(x); //create a new node
    
    			newNode.rightThread = true; //mark its right thread to be true
    			newNode.right = root; //point the right thread to root
    
    			if (root.leftThread) //if root has a left thread
    			{
    				newNode.left = root.left; //update the left child of new node
    				root.left = newNode; //store new node in root's left
    				root.leftThread = false; //mark root's left thread false
    				if (newNode.left != null) newNode.leftThread = true; //if new node's left is not null, mark thread true
    			}
    			else //otherwise
    				root.left = newNode; //store new node in root's left
    		}
    		else insertIntoTree(root.left, x);
    	}
    	if (x > root.data) //if x is greater than root
    	{
    		if (root.right == null || root.rightThread) //if right is null or right thread is present
    		{
    			Node newNode = new Node(x); //create a new node
    
    			newNode.leftThread = true; //mark its left thread to be true
    			newNode.left = root; //point the left thread to root
    
    			if (root.rightThread) //if root has a right thread
    			{
    				newNode.right = root.right; //update the right child of new node
    				root.right = newNode; //store new node in root's right
    				root.rightThread = false; //mark root's right thread false
    				if (newNode.right != null) newNode.rightThread = true; //if new node's right is not null, mark thread true
    			}
    			else //otherwise
    				root.right = newNode; //store new node in root's right
    		}
    		else insertIntoTree(root.right, x);
    	}
    }
    
    public int successor(int x)
    {
        Node xNode = find(x);
    	if (xNode.rightThread == true) //if right thread is present return it
    		return xNode.right.data;
    	else if (xNode.right == null) //if right pointer is null then there is no successor
    		return -1;
    	return leftMost(xNode.right).data; //otherwise get the leftmost node of the right subtree
    }
    
    private Node find(int x)
    {
        Node temp = root;
        while (temp != null && temp.data != x)
        {
            if (x <= temp.data)
                temp = temp.left;
            else temp = temp.right;
        }
        return temp; 
    }
    
    private Node leftMost(Node node)
    {
    	Node temp = node; //start from node
    	while (temp.left != null && temp.leftThread == false) //move left till there is no more left child
    		temp = temp.left;
    	return temp;
    }
}
        
