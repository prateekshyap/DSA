/*
https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#
Flattening a Linked List 
*/

// { Driver Code Starts
#include <bits/stdc++.h>

struct Node{
	int data;
	struct Node * next;
	struct Node * bottom;
	
	Node(int x){
	    data = x;
	    next = NULL;
	    bottom = NULL;
	}
	
};

using namespace std;

void printList(Node *Node)
{
    while (Node != NULL)
    {
        printf("%d ", Node->data);
        Node = Node->bottom;
    }
}

Node* flatten (Node* root);

int main(void) {

	int t;
	cin>>t;
	while(t--){
    int n,m,flag=1,flag1=1;
    struct Node * temp=NULL;
	struct Node * head=NULL;
	struct Node * pre=NULL;
	struct Node * tempB=NULL;
	struct Node * preB=NULL;
		cin>>n;
        int work[n];
		for(int i=0;i<n;i++)
            cin>>work[i];
		for(int i=0;i<n;i++){
			m=work[i];
			--m;
			int data;
			scanf("%d",&data);
			temp = new Node(data);
			temp->next = NULL;
			temp->bottom = NULL;
			
			if(flag){
				head = temp;
				pre = temp;
				flag = 0;
				flag1 = 1;
			}
			else{
				pre->next = temp;
				pre = temp;
				flag1 = 1;
			}
			for(int j=0;j<m;j++){
				
				int temp_data;
				scanf("%d",&temp_data);
				tempB = new Node(temp_data);

				if(flag1){
					temp->bottom=tempB;
					preB=tempB;
					flag1=0;
				}
				else{
					preB->bottom=tempB;
					preB=tempB;
				}
			}
		}
		   Node *fun = head;
		   Node *fun2=head;

            Node* root = flatten(head);
            printList(root);
            cout<<endl;

	}
	return 0;
}
// } Driver Code Ends


/* Node structure  used in the program

struct Node{
	int data;
	struct Node * next;
	struct Node * bottom;
	
	Node(int x){
	    data = x;
	    next = NULL;
	    bottom = NULL;
	}
	
};
*/

Node* merge(Node* l1, Node* l2)
{
    // if(!l1)
    //     return l2;
    // if(!l2)
    //     return l1;
    
    Node* head = new Node(0);
    Node* ptr = head;
    
    while(l1 && l2)
    {
        if(l1->data < l2->data)
        {
            ptr->bottom = l1;
            l1 = l1->bottom;
        }
        else
        {
            ptr->bottom = l2;
            l2 = l2->bottom;
        }
        ptr = ptr->bottom;
    }
    
    if(l1)
        ptr->bottom = l1;
    else
        ptr->bottom = l2;
    return head->bottom;
}

/*  Function which returns the  root of 
    the flattened linked list. */
Node *flatten(Node *root)
{
   Node* ptr = root;
   
   while(ptr->next)
   {
       root = merge(root, ptr->next); // merge this two sorted list
       ptr = ptr->next; //we are not changing the next pointer so we can traverse the next list 
   }
   return root;
}

