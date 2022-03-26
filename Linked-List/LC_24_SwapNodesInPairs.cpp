/* 
 *	https://leetcode.com/problems/swap-nodes-in-pairs/
 *  24. Swap Nodes in Pairs

 */
 /**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        
        // if empty LL or single node
        if(!head || !head->next) return head;
        
        // if atleast 2 nodes exists;
        
        // return swapPairsRecursive(head);
        
        return swapPairsIterative(head);
        
        
        
    }//swapPairs
    
    //Iterative Solution 
    ListNode* swapPairsIterative(ListNode* head)
    {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        ListNode* cnxt = nullptr;
        
        head = head->next; // head would be second element in pair after swap
        
        while(curr && curr->next)
        {
            cnxt = curr->next;
            
            if(prev) prev->next = cnxt;
            
            curr->next = cnxt->next;
            cnxt->next = curr;
            
            prev = curr;
            curr = curr->next;
            
            
        }
        
        return head;
    }//end swapPairsIterative
    
    // recursive solution
    ListNode* swapPairsRecursive(ListNode* ptr1)
    {
        if(!ptr1 || !ptr1->next) return ptr1; // base condition
        
        ListNode* ptr2 = ptr1->next;
        
        ptr1->next = swapPairsRecursive(ptr1->next->next);
        ptr2->next = ptr1; // after call because we need to travel ptr->n->n
        
        return ptr2;
    }//swapPairsRecursive
};