/*
https://practice.geeksforgeeks.org/problems/deletion-and-reverse-in-linked-list/1#
Deletion and Reverse in Linked List 
*/

// { Driver Code Starts
// C program to delete a given key from
// linked list.
#include<bits/stdc++.h>
using namespace std;

/* structure for a node */
struct Node
{
	int data;
	struct Node *next;
	
	Node(int x){
	    data = x;
	    next = NULL;
	}
};

Node *pre=NULL;

/* Function to delete a given node from the list */
//void deleteNode(struct Node *head, int key);
void deleteNode(Node **head,int data);
void reverse(Node **head);

/* Function to reverse the linked list */
//static void reverse(struct Node** head_ref);

/* Function to insert a node at the beginning of
a Circular linked list */

void push(struct Node **head_ref, int data)
{
	// Create a new node and make head as next
	// of it.

        struct Node *curr = new Node(data);

        curr->next=curr;
    
    	if(*head_ref==NULL)
        {
            *head_ref=curr;
            curr->next=*head_ref;
            pre=*head_ref;
    
        }
        else
        {
            curr->next=*head_ref;
            pre->next=curr;
            pre=pre->next;
    
    
        }
}

/* Function to print nodes in a given
circular linked list */
void printList(struct Node *head)
{
	struct Node *temp = head;
	if (head != NULL)
	{
		do
		{
			printf("%d ", temp->data);
			temp = temp->next;
		}
		while (temp != head);
	}
    else
    cout<<"empty"<<endl;

	printf("\n");
}
/* Driver program to test above functions */
int main()
{

	/* Initialize lists as empty */
	int t,a,delnode;
	cin>>t;
	while(t--)
	{
        pre=NULL;
	   Node *head=NULL;
      
        int n;
	    cin>>n;
	    while(n--)
	    {
	        cin>>a;
	        push(&head,a);
	    }    
	/* Created linked list will be 2->5->7->8->10 */
	cin>>delnode;

	deleteNode(&head, delnode);
	
	reverse(&head);

	printList(head);
}
	return 0;
}
// } Driver Code Ends


/* structure for a node 
struct Node
{
	int data;
	struct Node *next;
};
*/

/* Function to delete a given node from the list */
void deleteNode(struct Node **head, int key)
{

    // struct Node *ptr = (*head)->next, *prev=*head;
    // while(ptr->data != key && ptr->next != *head)
    // {
    //     prev = ptr;
    //     ptr = ptr->next;
    // }
    // if(ptr->data == key)
    //     {
    //         prev->next = ptr->next;
    //     }
    
    struct Node *ptr = (*head);
    while(ptr->next != *head)
    {
        if(ptr->next->data == key)
            ptr->next = ptr->next->next;
        ptr = ptr->next;
    }

}

/* Function to reverse the linked list */
 void reverse(struct Node** head_ref)
{
    struct Node* prev = nullptr, *cnxt = nullptr;
    struct Node* ptr = *head_ref;
    
    while(ptr->next != *head_ref)
    {
        cnxt =  ptr->next;
        ptr->next = prev;
        prev = ptr;
        ptr = cnxt;
    }
    ptr->next = prev;
    (*head_ref)->next = ptr;
    (*head_ref) = ptr;

}