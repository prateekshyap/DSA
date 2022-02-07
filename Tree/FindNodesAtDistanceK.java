/*https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1*/

class Solution
{
	public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
	{
		ArrayList<Node> path = new ArrayList<>();
		NodetoRoot(root,target,path);
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < path.size(); ++i) 
	    	KDown(path.get(i),k-i,list,i == 0 ? null : path.get(i-1));
	    Collections.sort(list);
	    return list;
	}

	public static void KDown(Node root,int k,ArrayList<Integer> list,Node blocker)
	{
		if(root == null || k < 0 || root == blocker)
			return;

		if(k == 0)
			list.add(root.data);

		KDown(root.left,k-1,list,blocker);
		KDown(root.right,k-1,list,blocker);
	}

	public static boolean NodetoRoot(Node root,int node,ArrayList<Node> path)
	{
		if(root == null)
			return false;

		if(root.data == node)
		{
			path.add(root);
			return true;
		}

		if(NodetoRoot(root.left,node,path) || NodetoRoot(root.right,node,path))
		{
			path.add(root);
			return true;
		}

		return false;
	}
}