/*
https://leetcode.com/problems/decode-the-message/
2325. Decode the Message

*/

class Solution {
public:
    string decodeMessage(string key, string message) {
        vector<int> mapping(26, 0);
        
        char alpha='a';
        for(int i=0; i<key.size(); i++)
        {
            if(key[i] == ' ') continue;
            
            int ind = key[i]-'a';
            if(mapping[ind] == 0)
                mapping[ind] = alpha++;
            
            if(alpha > 'z')
                break;
        }
        
        for(int i=0; i<message.size(); i++)
        {
            if(message[i] == ' ')
                continue;
            int ind = message[i]-'a';
            message[i] = (char)mapping[ind];
        }
        return message;
    }
};