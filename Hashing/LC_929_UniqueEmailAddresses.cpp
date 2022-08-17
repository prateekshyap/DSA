/*
https://leetcode.com/problems/unique-email-addresses/
929. Unique Email Addresses

*/

class Solution {
public:
    int numUniqueEmails_1(vector<string>& emails) {
        
        set<string> ue;
        string buff="";
        
        for(string email: emails)
        {
            buff="";
            for(char c: email)
            {
                if(c=='.') continue;
                if(c=='+' || c=='@')break;
                buff+=c;
            }
            buff = buff + email.substr(email.find('@'));
            ue.insert(buff);
            
        }
        
        return ue.size();
    }//end
    
     int numUniqueEmails(vector<string>& emails) {
        
        set<string> ue;
        string buff="";
        int j=0;
        
        for(string em: emails)
        {
            buff="";
            j=0;
            while(em[j] != '@' && em[j]!='+')
            {
                if(em[j] == '.') 
                {    
                    j++; continue;
                }
                buff += em[j];
                j++;
            }
            if(em[j] == '+')
                while(em[j]!='@')
                    j++;
            if(em[j] == '@')
                buff = buff + em.substr(j);
            
            // cout<<buff<<endl;
            ue.insert(buff);
            
        }
        
        return ue.size();
    }//end
};