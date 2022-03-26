/*
https://practice.geeksforgeeks.org/problems/partition-a-linked-list-around-a-given-value/1/#
Partition a Linked List around a given value 

*/

// { Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

/* Link list node */
struct Node* partition(struct Node* head, int x);

struct Node {
    int data;
    struct Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

/* Function to print linked list */
void printList(struct Node* node) {
    while (node != NULL) {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
}

/* Drier program to test above function*/
int main(void) {
    int t;
    cin >> t;

    while (t--) {
        struct Node* head = NULL;
        struct Node* temp = NULL;
        int n;
        cin >> n;

        for (int i = 0; i < n; i++) {
            int value;
            cin >> value;
            if (i == 0) {
                head = new Node(value);
                temp = head;
            } else {
                temp->next = new Node(value);
                temp = temp->next;
            }
        }

        int k;
        cin >> k;

        // Solution ob;

        head = partition(head, k);
        printList(head);
    }

    return (0);
}
// } Driver Code Ends


// User function Template for C++

/*struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};*/

/***** *******/
struct Node* partition(struct Node* head, int x) {
    // code here
    if(!head || !head->next) return head;
    
    Node* smhead = new Node(-1), *smp = smhead;
    Node* eqhead = new Node(x),  *eqp = eqhead;
    Node* gthead = new Node(1),  *gtp = gthead;
    
    while(head)
    {
        if(head->data < x)
        {
            smp->next = head; smp = smp->next;
        }
        else if(head->data == x)
        {
            eqp->next = head; eqp = eqp->next;
        }
        else
        {
            gtp->next = head; gtp = gtp->next;
        }
        
        head = head->next;
    }
    
    gtp->next = nullptr; // make end of list as nullptr
    
    if(eqp != eqhead) // if equal list exist
    {
        smp->next = eqhead->next; // merge small with equal
        
        eqp->next = gthead->next; // merge equal with greater
        
        return smhead->next;
    }
    
    smp->next = gthead->next;
    
    return smhead->next;
}

/***** WITH QUEUE *******/
// struct Node* partition(struct Node* head, int x) {
//     // code here
//     if(!head || !head->next) return head;
    
//     queue<int> small, greater;
//     int equal = 0;
//     Node* ptr = head;
    
//     while(ptr)
//     {
//         if(ptr->data < x)
//             small.push(ptr->data);
//         else if(ptr->data > x)
//             greater.push(ptr->data);
//         else
//             equal++;
        
//         ptr = ptr->next;
//     }
    
//     ptr = head;
    
//     while(!small.empty())
//     {
//         ptr->data = small.front(); small.pop();
//         ptr = ptr->next;
//     }
    
//     while(equal--)
//     {
//         ptr->data = x; 
//         ptr = ptr->next;
//     }
    
//     while(!greater.empty())
//     {
//         ptr->data = greater.front(); greater.pop();
//         ptr = ptr->next;
//     }
    
    
//     return head;
// }