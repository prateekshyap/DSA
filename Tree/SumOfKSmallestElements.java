/*https://practice.geeksforgeeks.org/problems/sum-of-k-smallest-elements-in-bst3029/1*/

class Tree {
    int res, count, ind;
    int sum(Node root, int k) { 
        
        // Code here
        res = 0;
        count = 0;
        traverseInOrder(root,k);
        return res;
    } 
    
    public void traverseInOrder(Node root,int k) {
    	//if root is not null and result is not yet found
        if (root != null && count <= k)
        {
        	//recursion call for left subtree
            traverseInOrder(root.left,k);


            //if count becomes equal to k and result is -1
            if (count < k)
            {
            	//store the result and return
                res += root.data;
                ++count;
                //System.out.println(root.data+" "+count);
            }

            //recursion call for right subtree
            traverseInOrder(root.right,k);
        }

        //if result is found, return
        if (count > k)
            return;
    }
}