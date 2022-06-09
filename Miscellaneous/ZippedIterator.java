/*https://binarysearch.com/problems/Zipped-Iterator*/

import java.util.*;

class ZippedIterator {
    boolean turn;
    int[] a, b;
    int i, j;
    public ZippedIterator(int[] a, int[] b) {
        this.turn = true;
        this.a = a;
        this.b = b;
        i = j = 0;
    }

    public int next() {
        int elem;
        if (turn)
        {
            turn = !turn;
            if (i < a.length) return a[i++];
            else if (j < b.length) return b[j++];
            return -1;
        }
        turn = !turn;
        if (j < b.length) return b[j++];
        else if (i < a.length) return a[i++];
        return -1;
    }

    public boolean hasnext() {
        if (turn && (i < a.length || j < b.length)) return true;
        else if (!turn && (j < b.length || i < a.length)) return true;
        return false;
    }
}