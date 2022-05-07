/*
Decimal Equivalent of Binary Linked List 
https://practice.geeksforgeeks.org/problems/decimal-equivalent-of-binary-linked-list/1/
*/
// { Driver Code Starts
// Program to check if linked list is empty or not
#include<iostream>
using namespace std;
const long long unsigned int MOD = 1000000007;

/* Link list Node */
struct Node
{
    bool data;
    struct Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
    
};

long long unsigned int decimalValue(struct Node *head);

void append(struct Node** head_ref, struct Node **tail_ref, bool new_data)
{

    struct Node* new_node = new Node(new_data);
    
    if (*head_ref == NULL)
       *head_ref = new_node;
    else
       (*tail_ref)->next = new_node;
    *tail_ref = new_node;
}


bool isEmpty(struct Node *head);

/* Driver program to test above function*/
int main()
{
    bool l;
    int i, n, T;

    cin>>T;

    while(T--){
    struct Node *head = NULL,  *tail = NULL;

        cin>>n;
        for(i=1;i<=n;i++)
        {
            cin>>l;
            append(&head, &tail, l);
        }

        cout << decimalValue(head) << endl;
    }
    return 0;
}// } Driver Code Ends


/* Below global variable is declared in code for modulo arithmetic
const long long unsigned int MOD = 1000000007; */

/* Link list Node/
struct Node
{
    bool data;   // NOTE data is bool
    Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
    
}; */

// Should return decimal equivalent modulo 1000000007 of binary linked list 
long long unsigned int decimalValue1(Node *head)
{
   Node* ptr = head;
   long long unsigned int dec = 0;
   
   while(ptr!=nullptr)
   {
       dec = (dec*2)%MOD + ptr->data;
       ptr = ptr->next;
   }
   
   return dec%MOD;
}

long long unsigned int decimalValue(Node *head)
{
   Node* ptr = head;
   long long unsigned int dec = 0;
   long long unsigned int fac = 1;
   
   int n=0; // number of nodes in LL
   while(ptr!=nullptr)
   {
       n++;
       ptr = ptr->next;
   }
   
   n = n-1; //zero indexing so subtract one
//   while(n--)
//   {
       fac = (fac << 1)%MOD;
//   }
  
//   fac = 2**n;
    
   ptr = head;
   while(ptr!=nullptr)
   {
       if(ptr->data)
            dec += (fac);
    //   n--;
       fac = fac>>1;
       ptr = ptr->next;
   }
   return dec%MOD;
}