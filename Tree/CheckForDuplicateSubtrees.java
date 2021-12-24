/*https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1/*/

//Tree serialization and mapping the duplicate indices technique
class Solution {
    HashMap<Integer,ArrayList<Integer>> map; //to store the indices of the nodes
    StringBuilder sb; //string representation of binary tree

    int dupSub(Node root) {
        sb = new StringBuilder("");
        map = new HashMap<Integer,ArrayList<Integer>>();
        
        //convert the binary tree to string representation
        convertToString(root);
        String tree = new String(sb);
        
        //iterate over the hashmap
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
        	//get one entry from the hashmap
            Map.Entry nodeInfo = (Map.Entry)iterator.next();

            //get the list of indices where the same node value is present
            ArrayList<Integer> indices = (ArrayList)nodeInfo.getValue();

            //if there are more than one indices, that means the root of those subtrees are matching
            if (indices.size() > 1)
            {
            	//for every index present in the list
                for (int i = 0; i < indices.size(); ++i)
                {
                	//create a stack for parentheses checking
                    Stack<Integer> stack = new Stack<Integer>();

                    //get the index of the root node
                    int k = (Integer)indices.get(i);

                    //set start to its previous index and push an open bracket to the stack
                    int start = k-1;
                    stack.push(1);

                    //til the stack gets empty
                    while (!stack.isEmpty())
                    {
                    	//skip the integers
                        while (tree.charAt(k) != '(' && tree.charAt(k) != ')')
                            ++k;

                        //perform parentheses matching
                        if (tree.charAt(k) == '(')
                            stack.push(1);
                        else if (tree.charAt(k) == ')')
                            stack.pop();

                        //increase the index
                        ++k;
                    }

                    //set end index
                    int end = k-1;

                    //set the subtree length
                    int subtreeLength = end-start+1;

                    /*start and end indicate the indices of the subtree to be matched with other subtrees*/

                    //for all other indices present in the list
                    for (k = i+1; k < indices.size(); ++k)

                    	//if the same length of substrings at both the indices match, we found a duplicate subtree
                        if ((Integer)indices.get(k)+subtreeLength <= tree.length() && tree.substring(start,end+1).equals(tree.substring(((Integer)indices.get(k))-1,((Integer)indices.get(k))+subtreeLength-1)))
                            return 1;
                }
            }
        }

        //if no duplicates found, return 0
        return 0;
    }
    void convertToString(Node root)
    {
    	//append open bracket and root value
        sb.append("(");
        sb.append(root.data);

        //if root is not a leaf
        if (root.left != null || root.right != null)
        {
        	//insert the index of the value to the hashmap
        	//here index means the index at which the value is present in the string representation
            ArrayList<Integer> temp = (map.containsKey(root.data)) ? map.get(root.data) : new ArrayList<Integer>();
            temp.add(sb.length()-1);
            map.put(root.data,temp);
        }

        //standard string conversion technique
        if (root.left == null && root.right == null)
        {}
        else if (root.left == null)
        {
            sb.append("()");
            convertToString(root.right);
        }
        else if (root.right == null)
        {
            convertToString(root.left);
        }
        else 
        {
            convertToString(root.left);
            convertToString(root.right);
        }
        sb.append(")");
    }
}

//Tree serialization and mapping the entire tree technique
class Solution {
    HashSet<String> subtrees;

    int dupSub(Node root) {
        subtrees=new HashSet<String>();

        //serialize and check presence in hashset
        String result = dupSubUtil(root,subtrees);

        return result.length() == 0 ? 1 : 0 ;
    }
    String dupSubUtil(Node root, HashSet<String> subtrees)
    {
        String s = "";

        //base case
        if (root == null)
            return s + "()";
        
        //get the serialized left subtree
        String lStr = dupSubUtil(root.left,subtrees);

        //if the left subtree serialization is also empty string, return empty string
        if (lStr.equals(s))
            return s;

        //get the serialized right subtree
        String rStr = dupSubUtil(root.right,subtrees);
        
        //if the right subtree serialization is also empty string, return empty string
        if (rStr.equals(s))
            return s;

        //attach root, left and right subtrees
        s = s+"("+root.data+"("+lStr+")("+rStr+"))";

        //if this subtree is already present having more than 1 nodes, return empty string
        String[] tokens = s.trim().split("[()]+");
        if (tokens.length > 2 && subtrees.contains(s))
            return "";

        //return serialized string
        subtrees.add(s);
        return s;
    }
}