/*https://leetcode.com/problems/print-zero-even-odd/*/

class ZeroEvenOdd {
    private int n;
    
    Semaphore zeroRun, evenBlock, oddBlock;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroRun = new Semaphore(1); //binary semaphore
        this.evenBlock = new Semaphore(0); //blocking semaphore
        this.oddBlock = new Semaphore(0); //blocking semaphore
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean toggle = true;
        for (int i = 0; i < n; ++i)
        {
            zeroRun.acquire(); //acquire semaphore for zero
            printNumber.accept(0); //print 0
            if (toggle) oddBlock.release(); //if toggle is true, release odd
            else evenBlock.release(); //else release even
            toggle = !toggle; //toggle
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int m = n/2; //get the half
        int even = 2; //initialize
        for (int i = 0; i < m; ++i)
        {
            evenBlock.acquire(); //acquire even block
            printNumber.accept(even); //this line runs only when even block is released
            even += 2; //increment even
            zeroRun.release(); //release zero semaphore
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int m = n/2; //get the half
        if (n%2 == 1) ++m; //if n is odd, increment the half
        int odd = 1; //initialize
        for (int i = 0; i < m; ++i)
        {
            oddBlock.acquire(); //acquire odd block
            printNumber.accept(odd); //this line runs only when odd block is released
            odd += 2; //increment odd
            zeroRun.release(); //release zero semaphore
        }
    }
}