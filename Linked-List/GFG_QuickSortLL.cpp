/*
https://practice.geeksforgeeks.org/problems/quick-sort-on-linked-list/1#
Quick Sort on Linked List 
*/

// { Driver Code Starts
#include <iostream>
#include <cstdio>
using namespace std;
 
/* a node of the singly linked list */
struct node
{
    int data;
    struct node *next;
    
    node(int x){
        data = x;
        next = NULL;
    }
};

/* A utility function to insert a node at the beginning of linked list */
void push(struct node** head_ref, int new_data)
{
    /* allocate node */
    struct node* new_node = new node(new_data);
 
    /* link the old list off the new node */
    new_node->next = (*head_ref);
 
    /* move the head to point to the new node */
    (*head_ref)    = new_node;
}
 
/* A utility function to print linked list */
void printList(struct node *node)
{
    while (node != NULL)
    {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
}
void quickSort(struct node **headRef);
int main()
{
	int t,n,x;
	cin>>t;
	while(t--){
		
        
        cin>>n;n=n-1;
		cin>>x;
        node *temp,*head = new node(x);
        temp=head;
        while(n--)
        {
			cin>>x;
          temp->next=new node(x);
          temp=temp->next;
			}
    
    quickSort(&head);
 
    printList(head);
 while(head!= NULL){
     temp=head;
     head=head->next;
     free(temp);
     
 }
	}
    return 0;
}// } Driver Code Ends


 
/* a node of the singly linked list 
struct node
{
    int data;
    struct node *next;
    
    node(int x){
        data = x;
        next = NULL;
    }
}; */
///////////////////////////////////////////////////////////////////////
node* Partition(node* start, node* end)
{
    int pivotVal = start->data;
    node* i = start;
    node* j = start->next;
    
    while(j!=end)
    {
        if(j->data < pivotVal)
        {
            i = i->next;
            swap(i->data, j->data);
        }
        j = j->next;
    }
    swap(start->data, i->data);
    return i;
}

void QuickS(node* start, node* end)
{
    if(start == end) 
        return;
    
    node* pivot = Partition(start, end);
    QuickS(start, pivot);
    QuickS(pivot->next, end);
}

//you have to complete this function
void quickSort_(struct node **headRef) {
    QuickS(*headRef, nullptr);
}
//////////////////////////////////////////////////////////////////////////
// without swapping values
node* QS(node *head)
{
    if(!head || !head->next) //zero or single element return 
        return head;
    
    // Partition
    node* pivot = head; // first node as pivot
    
    node* smallHead = new node(-1);
    node* largeHead = new node(-1);
    node* small = smallHead;
    node* large = largeHead;
    node* cur = head->next;
    
    while(cur)
    {
        if(cur->data < pivot->data)
        {
            small->next = cur;
            small = cur;
        }
        else
        {
            large->next = cur;
            large = cur;
        }
        cur = cur->next;
    }
    small->next = nullptr;
    large->next = nullptr;
    // Recursion
    // now we have small - pivot - large
    small = QS(smallHead->next);
    large = QS(largeHead->next);
    
    cur = small;
    while(cur && cur->next)
        cur = cur->next;
    
    if(cur)
        cur->next = pivot;
    else
        small = pivot;
    pivot->next = large;
    
    return small;
    
}

void quickSort(struct node **headRef) {
    *headRef = QS(*headRef);
}
    
    