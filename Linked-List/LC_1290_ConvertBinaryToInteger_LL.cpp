/*
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
1290. Convert Binary Number in a Linked List to Integer

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
    int getDecimalValue(ListNode* head) {
        
        int decimal=0;
        ListNode* ptr = head;
    
        // Left Shifting.
//         while(ptr){
//             decimal*=2;             // left shifting is multiply by 2
//             decimal += ptr->val ;   // at the time of addition it is the LSB.
            
//             ptr = ptr->next;
//         }
//         return decimal;
        
        //Using String
        // string d;
        // while(ptr){
        //     d += to_string(ptr->val) ; 
        //     ptr = ptr->next;
        // }
        // return stoi(d, nullptr, 2);
   
    
        while(ptr){
            decimal =  decimal <<1;
            decimal = decimal | ptr->val;
            ptr = ptr->next;
        }
        return decimal;
        
   } //getDecimalValue
};