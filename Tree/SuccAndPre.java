/*https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1/*/

class GfG
{
    static boolean flag = true;
    static Node dummy = null;
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        flag = true; //indicates whether predecessor is found or not
        dummy = null; //hold the previous node
        inOrder(root,p,s,key);

        //update pre and succ
        if (dummy != null && dummy.data < key)
            p.pre = dummy;
        if (dummy != null && dummy.data > key && s.succ == null)
            s.succ = dummy;
    }
    public static void inOrder(Node root, Res p, Res s, int key)
    {
        if (root != null)
        {
            inOrder(root.left,p,s,key);

            //id predecessor is found and successor is null
            if (flag == false && s.succ == null)
            {
            	//update successor and make dummy null
                s.succ = dummy.data == key ? root : dummy;
                dummy = null;
            }

            //if the current data is greater than or equal to key
            if (root.data >= key)
            {
            	//update predecessor
                if (flag)
                {
                    if (dummy == null || dummy.data != key)
                        p.pre = dummy;
                    dummy = root;
                }

                //make flag false, so that next time predecessor will not be updated
                flag = false;
            }

            //otherwise
            else
            {
            	//update predecessor
                if (dummy == null || dummy.data != key)
                    p.pre = dummy;
                dummy = root;
            }

            inOrder(root.right,p,s,key);
        }
    }
}