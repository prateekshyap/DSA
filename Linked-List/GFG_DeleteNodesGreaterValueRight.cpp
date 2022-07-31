/*
https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1#
Delete nodes having greater value on right 
*/

// { Driver Code Starts
#include<bits/stdc++.h>

using namespace std;

struct Node
{
    int data;
    Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
};


void print(Node *root)
{
    Node *temp = root;
    while(temp!=NULL)
    {
        cout<<temp->data<<" ";
        temp=temp->next;
    }
}



 // } Driver Code Ends
/*

The structure of linked list is the following

struct Node
{
    int data;
    Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
};
*/
class Solution
{
    public:
    /*
    Node *compute(Node *head)
    {
        if(!head  || !head->next)
        return head;
        
        Node* nextHead = compute(head->next);
        
        if(head->data < nextHead->data)
            return nextHead; //deleting head;
        else
        {
            head->next = nextHead; // 6 2 3, 6-->3
            return head;
        }
            
    }
    */
    Node* reverse(Node* cur)
    {
        Node* prev = nullptr;
        Node* cnext = nullptr;
        while(cur){
            cnext = cur->next;
            cur -> next = prev;
            prev = cur;
            cur = cnext;
        }
        return prev;
    }
    
    Node *compute(Node *head)
    {
        if(!head  || !head->next)
        return head;
        
        head = reverse(head);
        int maxFromRight = head->data;
        
        Node* cur = head->next;
        Node* pre = head;
        while(cur)
        {
            if(cur->data >= maxFromRight)
            {
                maxFromRight = max(maxFromRight, cur->data);
                pre = pre->next;
                cur = cur->next;
            }
            else
            {
                pre->next = cur->next;
                cur = cur->next;
            }
        }
        
        return reverse(head);
    }
    
};
   


// { Driver Code Starts.

int main()
{
    int T;
	cin>>T;

	while(T--)
	{
		int K;
		cin>>K;
		struct Node *head = NULL;
        struct Node *temp = head;

		for(int i=0;i<K;i++){
		    int data;
		    cin>>data;
			if(head==NULL)
			    head=temp=new Node(data);
			else
			{
				temp->next = new Node(data);
				temp = temp->next;
			}
		}
        Solution ob;
        Node *result = ob.compute(head);
        print(result);
        cout<<endl;
    }
}
  // } Driver Code Ends