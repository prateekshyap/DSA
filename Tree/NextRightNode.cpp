/*https://practice.geeksforgeeks.org/problems/next-right-node/1*/

class Solution
{
public:
    Node *nextRight(Node *root, int key)
    {
        //code here
        queue<Node *> queue;
        queue.push(root);
        Node * t = new Node(-1);
        while (!queue.empty())
        {
            int size = queue.size();
            for (int i = 0; i < size; ++i)
            {
                Node * temp = queue.front();
                queue.pop();
                if (temp->left) queue.push(temp->left);
                if (temp->right) queue.push(temp->right);
                if (temp->data == key && i < size-1)
                    t = queue.front();
            }
        }
        return t;
    }
};