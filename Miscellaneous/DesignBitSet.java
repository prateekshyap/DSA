/*https://leetcode.com/problems/design-bitset/*/

//TLE
class Bitset {
    int[] bits;
    int oneCount, size;
    public Bitset(int size) {
        oneCount = 0;
        bits = new int[size];
        this.size = size;
    }
    
    public void fix(int idx) {
        oneCount += 1-bits[idx];
        bits[idx] = 1;
    }
    
    public void unfix(int idx) {
        oneCount -= bits[idx];
        bits[idx] = 0;
    }
    
    public void flip() {
        for (int i = 0; i < size; ++i)
            bits[i] = 1-bits[i];
        oneCount = size-oneCount;
    }
    
    public boolean all() {
        return oneCount == size;
    }
    
    public boolean one() {
        return oneCount > 0;
    }
    
    public int count() {
        return oneCount;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder("");
        for (int bit : bits)
            result.append(bit);
        return result.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */

class Bitset {
    int[] bits;
    int oneCount, zeroCount, size;
    boolean flipStatus;
    public Bitset(int size) {
        oneCount = 0;
        zeroCount = size;
        bits = new int[size];
        this.size = size;
        flipStatus = false;
    }
    
    public void fix(int idx) {
        if (flipStatus) changeOneToZero(idx); else changeZeroToOne(idx);
    }
    
    public void unfix(int idx) {
        if (flipStatus) changeZeroToOne(idx); else changeOneToZero(idx);
    }
    
    public void flip() {
        flipStatus = !flipStatus;
    }
    
    public boolean all() {
        return flipStatus ? (zeroCount == size) : (oneCount == size);
    }
    
    public boolean one() {
        return flipStatus ? (zeroCount > 0) : (oneCount > 0);
    }
    
    public int count() {
        return flipStatus ? zeroCount : oneCount;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder("");
        for (int bit : bits)
            result.append(flipStatus ? 1-bit : bit);
        return result.toString();
    }
    
    private void changeZeroToOne(int idx)
    {
        if (bits[idx] == 0)
        {
            ++oneCount;
            --zeroCount;
        }
        bits[idx] = 1;
    }
    
    private void changeOneToZero(int idx)
    {
        if (bits[idx] == 1)
        {
            --oneCount;
            ++zeroCount;
        }
        bits[idx] = 0;
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */