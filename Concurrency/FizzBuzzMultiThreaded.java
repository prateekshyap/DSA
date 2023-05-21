/*https://leetcode.com/problems/fizz-buzz-multithreaded/*/

class FizzBuzz {
    private int n;
    Semaphore fizzBlock, buzzBlock, fizzBuzzBlock, numberRun, numberBlock;

    public FizzBuzz(int n) {
        this.n = n;
        fizzBlock = new Semaphore(0); //blocking semaphore
        buzzBlock = new Semaphore(0); //blocking semaphore
        fizzBuzzBlock = new Semaphore(0); //blocking semaphore
        numberRun = new Semaphore(1); //binary semaphore
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int loop = (n/3)-(n/15);
        for (int i = 0; i < loop; ++i)
        {
            fizzBlock.acquire(); //block
            printFizz.run(); //this line runs only when the above blocking semaphore is released
            numberRun.release(); //release the binary semaphore for next iteration
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int loop = (n/5)-(n/15);
        for (int i = 0; i < loop; ++i)
        {
            buzzBlock.acquire(); //block
            printBuzz.run(); //this line runs only when the above blocking semaphore is released
            numberRun.release(); //release the binary semaphore for next iteration
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int loop = n/15;
        for (int i = 0; i < loop; ++i)
        {
            fizzBuzzBlock.acquire(); //block
            printFizzBuzz.run(); //this line runs only when the above blocking semaphore is released
            numberRun.release(); //release the binary semaphore for next iteration
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; ++i)
        {
            numberRun.acquire(); //acquire binary semaphore
            if (i%15 == 0) //for 15
            {
                fizzBuzzBlock.release(); //release fizz buzz
            }
            else if (i%3 == 0) //for 3
            {
                fizzBlock.release(); //release fizz
            }
            else if (i%5 == 0) //for 5
            {
                buzzBlock.release(); //release buzz
            }
            else //otherwise
            {
                printNumber.accept(i); //print the number
                numberRun.release(); //release the binary semaphore
            }
        }
    }
}