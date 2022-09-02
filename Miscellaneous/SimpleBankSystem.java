/*https://leetcode.com/problems/simple-bank-system/*/

class Bank {
    long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        int a1 = account1-1, a2 = account2-1;
        if (a1 >= balance.length || a2 >= balance.length || balance[a1] < money) return false;
        balance[a1] -= money;
        balance[a2] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        int a = account-1;
        if (a >= balance.length) return false;
        balance[a] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        int a = account-1;
        if (a >= balance.length || balance[a] < money) return false;
        balance[a] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */