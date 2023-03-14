/*https://leetcode.com/problems/the-dining-philosophers/*/

class DiningPhilosophers {
    
    Semaphore[] forks;
    Semaphore philosophers;

    public DiningPhilosophers() {
        forks = new Semaphore[5];
        for (int i = 0; i < 5; ++i)
            forks[i] = new Semaphore(1);
        philosophers = new Semaphore(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        philosophers.acquire();
        
        forks[philosopher].acquire();
        forks[(philosopher+1)%5].acquire();
        
        pickLeftFork.run();
        pickRightFork.run();
        
        eat.run();
        
        putLeftFork.run();
        putRightFork.run();
        
        forks[philosopher].release();
        forks[(philosopher+1)%5].release();
        
        philosophers.release();
    }
}