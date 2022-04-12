/*
https://leetcode.com/problems/merge-k-sorted-lists/
23. Merge k Sorted Lists
 
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
    struct Comp{
      bool operator()(ListNode* X, ListNode* Y)
      {  return X->val > Y->val;
      }
    };
    
    ListNode* mergeKListsWithComparator(vector<ListNode*>& lists) {
        
        auto cmp = [&](ListNode* X, ListNode* Y) { return X->val > Y->val; };
        
        ListNode head;
        ListNode* ptr = &head;
        
        // priority_queue<ListNode*, vector<ListNode*>, Comp)> pq;
        priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> pq(cmp);
        
        for(ListNode* list: lists)
        {   
            if(list)
                pq.push(list);
        }
        
        while(!pq.empty())
        {
            ListNode* lst = pq.top(); pq.pop();
            
            ptr->next = lst;
            ptr = ptr->next;
            
            if(ptr->next) // if not last column
            {
                pq.push(ptr->next);
               
            }
            
        }
        return head.next;
    }
    
    ListNode* mergeKListsWithOutComparator(vector<ListNode*>& lists) {
        
        ListNode head;
        ListNode* ptr = &head;
        
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
        
        for(int i=0; i<lists.size(); i++)
        {   
            if(lists[i])
                 pq.push({lists[i]->val, i}); // lists value and its row number
        }
        
        while(!pq.empty())
        {
            int j = pq.top().second; pq.pop();
            ptr->next = lists[j];
            ptr = ptr->next;
            
            lists[j] = lists[j]->next;
            if(lists[j]) // if not last column
            {
                pq.push({lists[j]->val,j});
               
            }
            
        }
        return head.next;
    }
    
    ListNode* merge2Lists(ListNode* l1, ListNode* l2)
    {
        if(!l1) return l2;
        if(!l2) return l1;
        ListNode head;
        ListNode* ptr = &head;
        
        while(l1 && l2)
        {
            if(l1->val <= l2->val)
            {
                ptr->next = l1;
                l1 = l1->next;
            }
            else
            {
                ptr->next = l2;
                l2 = l2->next;
            }
            ptr = ptr->next;
        }
        
        if(l1) ptr->next = l1;
        if(l2) ptr->next = l2;
        
        return head.next;
    }
    
    ListNode* mergeKLists(vector<ListNode*>& lists)
    {
        if(lists.empty()) return nullptr;
        
        // return mergeKListsWithComparator(lists);
        // return mergeKListsWithOutComparator(lists);
        
        while(lists.size()>1) // size from 1 to k
        {
            
            lists.push_back(merge2Lists(lists[0], lists[1]));
            lists.erase(lists.begin());
            lists.erase(lists.begin());
        }
        
        return lists[0];
        
    }
};