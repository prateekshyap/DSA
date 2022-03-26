/* 
 *	https://leetcode.com/problems/reverse-nodes-in-k-group/
 *  25. Reverse Nodes in k-Group
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
    ListNode* reverseKGroup(ListNode* head, int k) {
        
        if(!head || !head->next) return head;
        
        // return reverseKGroupRecursive(head,k);
        return reverseKGroupIterative(head,k);
        
    }//end reverseKGroup
    
     ListNode* reverseKGroupIterative(ListNode* head, int k) {
        
        if(!head || !head->next) return head;
        
        ListNode* dummyHead = new ListNode(0);
            dummyHead->next = head;
        
        ListNode* prevGpHead = dummyHead; //previous Group Head
        ListNode* nxtGpHead = head; // Next Group Head

        while(nxtGpHead)
        {
            ListNode* prev = prevGpHead;
            ListNode* curr = nxtGpHead; // currently it is head of current list
            ListNode* cnext = nullptr;
            
            ListNode* currGpOldHead = nxtGpHead;
  
            // first we need to check whether group of k exists or not
           int ck = k;
           while(nxtGpHead && ck)
           {
               ck--;
               nxtGpHead = nxtGpHead->next; 
           } //now it is head of next group
            
           if(ck==0) // if group of k nodes exists
           {
               int countk=1;
                while(curr && countk<=k)
                {
                    cnext = curr->next;
                    curr->next = prev;
                    prev = curr;
                    curr = cnext;
                    countk++;
                }
                // prev is now current Group New Head
                prevGpHead->next = prev;  // previous group head now points to newHead of current list
                prevGpHead = currGpOldHead; // update previous Gp Head to current list
                currGpOldHead->next = nxtGpHead; // update current group old head to next group un updated head
               //it is required in case if next group is not of k size then we still have valid pointers
           }
            
        }// outer while loop nxtGpHead
         head = dummyHead->next;
         delete (dummyHead);
         return head;
        
    }//end reverseKGroupIterative
    
    
    
     ListNode* reverseKGroupRecursive(ListNode* head, int k) {
        
         
        // if empty LL or single node, BASE CASE
        if(!head || !head->next) return head;
        
         // first we need to check whether group of k exists or not
        ListNode *ptr = head;
        for(int i=1; i<=k ; i++)
        {
            if(!ptr) return head; // return LL as it is without reversing
            ptr = ptr->next; // then update the pointer to next otherwise Test case of k==count(LL) will not pass
        }
         
        // if group of k nodes exists, reverse the group of nodes
        ListNode* prev = nullptr;
        ListNode* curr = head;
        ListNode* cnext = nullptr;
        int countk=1; 
        while(curr && countk<=k)
        {
            cnext = curr->next;
            curr->next = prev;
            prev = curr;
            curr = cnext;
            countk++;
        }
        
       // if(cnext)
         head->next = reverseKGroupRecursive(cnext, k);
         
         return prev;
    }//end reverseKGroupRecursive
    
};
};