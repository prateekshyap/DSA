/*
https://leetcode.com/problems/text-justification/
68. Text Justification

*/
class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth)     {
        vector<string> sentences; string line;
        int num_w = words.size();
        int startWdInd=0, endWdInd=0, charsTillNow=0;
        int testSpaceBwWords=0; //zero space for first word
        int cntDefaultSpaceLoc=0, cntActualSpace=0, minSpaceBwWords, extraSpaceFirst;
        
        int wordCnt, spaceCnt;
        
        while(endWdInd < num_w) // iterate through all the words
        {
            int nextWdCharCnt = words[endWdInd].size(); //end index word size i.e characters count
            
            if(charsTillNow + testSpaceBwWords + nextWdCharCnt <= maxWidth) // already char count  + space + curr char count<= maxWidth of sentence
            {
                charsTillNow += nextWdCharCnt + testSpaceBwWords; // include word in line
                endWdInd++; //take next word
                testSpaceBwWords = 1; // space for old word and next word
                continue;
            }//if
            
            
        
            wordCnt = endWdInd - startWdInd; // 0(start),1,2(end) == 2-0 = 2 words (0th and 1)
            cntDefaultSpaceLoc = wordCnt - 1; // this many spaces would be present between words no matter what.
            cntActualSpace = maxWidth - (charsTillNow - cntDefaultSpaceLoc); // subtracting actual char count from max width excluding the all spaces;
            minSpaceBwWords = cntActualSpace; //if one word is there 
            extraSpaceFirst = 0;
            if(wordCnt > 1) //more than 1 words in line, otherwise /0 error
            {
                minSpaceBwWords = cntActualSpace / cntDefaultSpaceLoc; // total space in sentence / num of space count
                extraSpaceFirst = cntActualSpace%cntDefaultSpaceLoc; // in case we can't divide the space evenly between words
            }
            
            
            // now we will process the current line as we have required words and space between them
            while(startWdInd < endWdInd)
            {
                line.append(words[startWdInd]);
                // add space between words now, also extra space if any present it will be added one by one
                if(startWdInd != endWdInd-1) // not the last word
                    line += string(minSpaceBwWords + int(extraSpaceFirst >0), ' ');
                else if(wordCnt==1)
                    line+= string(minSpaceBwWords, ' '); // actual space in this case
                startWdInd++; // next word processing
                extraSpaceFirst--; // we will add space only when >0 in above condition
            }
            
            sentences.push_back(line);
            //reset
            line.clear();
            testSpaceBwWords=0; //for new line, zero space for first word
            charsTillNow=0;
        }//while endWdInd < num_w

        //For Last Line, above while loop will break as endwdInd > num_w
        wordCnt = endWdInd - startWdInd; 
        cntDefaultSpaceLoc = wordCnt - 1; 
        cntActualSpace = maxWidth - (charsTillNow - cntDefaultSpaceLoc); 
        while(startWdInd < endWdInd)
        {
            line.append(words[startWdInd]);
            if(startWdInd != endWdInd-1) // not the last word
                line += ' ';
            startWdInd++; // next word processing
        }
        line+= string(cntActualSpace-cntDefaultSpaceLoc, ' '); // actual space in this case
        sentences.push_back(line);
        
        return sentences;
    }
};