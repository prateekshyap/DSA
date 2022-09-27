/*https://leetcode.com/problems/decode-the-slanted-ciphertext/*/

//matrix technique
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.length() == 0) return "";
        int encodedLength = encodedText.length();
        int columns = encodedLength/rows;
        if (encodedLength%rows != 0) ++columns;
        char[][] matrix = new char[rows][columns];
        int index = 0;
        for (int r = 0; r < rows; ++r)
            for (int c = 0; c < columns; ++c)
                matrix[r][c] = encodedText.charAt(index++);
        int row = 0, column = 0, ref = 0, lastTextIndex = -1;
        index = 0;
        StringBuilder decodedText = new StringBuilder("");
        while (row != 0 || column != columns-1)
        {
            if (matrix[row][column] != ' ') lastTextIndex = index++;
            else index++;
            decodedText.append(matrix[row][column]);
            ++row; ++column;
            if (row >= rows || column >= columns)
            {
                row = 0;
                column = ref+1;
                ref = column;
            }
        }
        if (matrix[0][columns-1] != ' ')
        {
            decodedText.append(matrix[0][columns-1]);
            lastTextIndex = index++;
        }
        if (lastTextIndex < decodedText.length()-1)
            decodedText.replace(lastTextIndex+1,decodedText.length(),"");
        return decodedText.toString();
    }
}

//difference = columns+1
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder decodedText = new StringBuilder();
        int encodedLength = encodedText.length();
        int columns = encodedLength/rows;
        if (encodedLength%rows != 0) ++columns;
        int difference = columns+1;
        int lastTextIndex = -1;
        for (int start = 0; start < columns; ++start)
        {
            int move = start;
            while (move < encodedLength)
            {
                char ch = encodedText.charAt(move);
                decodedText.append(ch);
                if (ch != ' ')
                    lastTextIndex = decodedText.length()-1;
                move += difference;
            }
        }
        if (lastTextIndex < decodedText.length()-1)
            decodedText.replace(lastTextIndex+1,decodedText.length(),"");
        return decodedText.toString();
    }
}

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder decodedText = new StringBuilder("a");
        int encodedLength = encodedText.length();
        int columns = encodedLength/rows;
        if (encodedLength%rows != 0) ++columns;
        int difference = columns+1;
        for (int start = 0; start < columns; ++start)
        {
            int move = start;
            while (move < encodedLength)
            {
                decodedText.append(encodedText.charAt(move));
                move += difference;
            }
        }
        return decodedText.toString().trim().substring(1);
    }
}