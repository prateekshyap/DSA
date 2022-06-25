/*https://practice.geeksforgeeks.org/problems/rotate-matrix-elements-clockwise2336/1*/

class Solution {
    int[][] rotateMatrix(int M, int N, int Mat[][]) {
        // code here
        int rs = 0, re = M-1, cs = 0, ce = N-1, i, j, temp;
        /* target elements to be rotated-->
			$ $ $ $ $
			$ # # # $
			$ # # # $
			$ # # # $
			$ # # # $
			$ $ $ $ $
        */
        while (rs < re && cs < ce)
        {
        	/*  temp
        		|	
				$ # # # #
				# # # # #
				# # # # #
				# # # # #
				# # # # #
				# # # # #
        	*/
            temp = Mat[rs][cs];

            /*
				$ # # # #
				$ # # # #
				$ # # # #
				$ # # # #
				$ # # # #
				# # # # #
            */
            for (i = rs; i < re; ++i)
                Mat[i][cs] = Mat[i+1][cs];

            /*
				# # # # #
				# # # # #
				# # # # #
				# # # # #
				# # # # #
				$ $ $ $ #
            */
            for (j = cs; j < ce; ++j)
                Mat[re][j] = Mat[re][j+1];

            /*
				# # # # #
				# # # # $
				# # # # $
				# # # # $
				# # # # $
				# # # # $
            */
            for (i = re; i > rs; --i)
                Mat[i][ce] = Mat[i-1][ce];

            /*
				# # $ $ $
				# # # # #
				# # # # #
				# # # # #
				# # # # #
				# # # # #
            */
            for (j = ce; j > cs+1; --j)
                Mat[rs][j] = Mat[rs][j-1];

            /*
				# $ # # #
				# # # # #
				# # # # #
				# # # # #
				# # # # #
				# # # # #
            */
            Mat[rs][j] = temp;
            /* target elements to be rotated-->
				# # # # #
				# $ $ $ #
				# $ # $ #
				# $ # $ #
				# $ $ $ #
				# # # # #
        	*/
            ++rs; --re; ++cs; --ce;
        }
        return Mat;
    }
}