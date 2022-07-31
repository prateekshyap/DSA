/*
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
430. Flatten a Multilevel Doubly Linked List

*/

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

class Solution {
public:
    Node* flatten(Node* head) {
        // return flattenRecursive(head);
        
        Node* cur = head, *cnext = nullptr, *ch = nullptr;
        
        while(cur)
        {
            if(cur->child == nullptr)
            {
                cur = cur->next;
                continue;
            }
            cnext = cur->next;
            ch = cur->child;
            
            cur->next = ch;
            ch->prev = cur;
            
            while(ch->next) //iterate new list
                ch = ch->next;
            ch->next = cnext;
            if(cnext) cnext->prev = ch; 
            
            cur->child = nullptr;
            
        }
        return head;
    }
    Node* flattenRecursive(Node* head) {
        Node* cur = head, *cnext = nullptr, *ch = nullptr;
        
        while(cur)
        {
            if(cur->child)
            {
                cnext = cur->next; //store cur next
                ch = flattenRecursive(cur->child); // call next level
                cur->child = nullptr; //imp
                cur->next = ch;
                ch->prev = cur;
                while(ch->next) //iterate new list
                    ch = ch->next;
                ch->next = cnext;
                if(cnext) cnext->prev = ch; //imp
            }
            
            cur = cur->next;
        }
        
        return head;
    }//end
};