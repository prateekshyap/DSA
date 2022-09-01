/*https://leetcode.com/problems/design-an-atm-machine/*/

class ATM {
    private static final int DENOMINATIONS[] = new int[] {20,50,100,200,500};
    public long notesAvl[];
    public ATM() {
        this.notesAvl = new long[] {0,0,0,0,0};
    }
    
    public void deposit(int[] banknotesCount) {
        this.notesAvl[0] += banknotesCount[0];
        this.notesAvl[1] += banknotesCount[1];
        this.notesAvl[2] += banknotesCount[2];
        this.notesAvl[3] += banknotesCount[3];
        this.notesAvl[4] += banknotesCount[4];
    }
    
    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        if(amount%10!=0)
            return new int[] {-1};
        for(int i=4;i>=0;i--){
            int reqNotes = amount/DENOMINATIONS[i];
            if(this.notesAvl[i]<reqNotes){
                reqNotes = (int)this.notesAvl[i];
            }
            ans[i] += reqNotes;
            this.notesAvl[i] -= reqNotes;
            amount -= reqNotes*DENOMINATIONS[i];
        }
        if(amount>0){
            for(int i=0;i<5;i++){
                this.notesAvl[i] += ans[i];
            }
            return new int[] {-1};
        }
        return ans;
    }
}



class ATM {
	long[] notes = new long[5];                                                // Note: use long[] instead of int[] to avoid getting error in large testcases
	int[] denoms;
	public ATM() {
		denoms = new int[]{ 20,50,100,200,500 };                               // create an array to represent money value.
	}

	public void deposit(int[] banknotesCount) {
		for(int i = 0; i < banknotesCount.length; i++){
			notes[i] += banknotesCount[i];                                       // add new deposit money to existing
		}
	}

	public int[] withdraw(int amount) {                 
		int[] result = new int[5];                                              // create result array to store quantity of each notes we will be using to withdraw "amount"
		for(int i = 4; i >= 0; i--){
			if(amount >= denoms[i] ){                                              
				int quantity = (int) Math.min(notes[i], amount / denoms[i]);     // pick the minimum quanity. because if say, amount/denoms[i] gives 3 but you only have 1 note. so you have to use 1 only instead of 3 
				amount -= denoms[i] * quantity;                                 // amount left = 100
				result[i] = quantity;
			}
		}
		if(amount != 0){ return new int[]{-1}; }
		for(int i = 0; i < 5; i++){  notes[i] -= result[i];  }                   // deduct the quantity we have used.
		return result;
	}
}
/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */



class ATM {
    long[] money = new long[5];

    public ATM() {
        
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < money.length; i++) {
            money[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int rest = amount;
        int[] res = new int[5];
        int count;
        long[] tempMoney = Arrays.copyOf(money, 5);
        if (money[4] > 0) {
            count = rest / 500;
            if (count < money[4]) {
                res[4] = count;
                rest -= count * 500;
                money[4] -= count;
            } else {
                res[4] = (int) money[4];
                rest -= (int) money[4] * 500;
                money[4] = 0;
            }
        }
        if (money[3] > 0) {
            count = rest / 200;
            if (count < money[3]) {
                res[3] = count;
                rest -= count * 200;
                money[3] -= count;
            } else {
                res[3] = (int) money[3];
                rest -= (int) money[3] * 200;
                money[3] = 0;
            }
        }
        if (money[2] > 0) {
            count = rest / 100;
            if (count < money[2]) {
                res[2] = count;
                rest -= count * 100;
                money[2] -= count;
            } else {
                res[2] = (int) money[2];
                rest -= (int) money[2] * 100;
                money[2] = 0;
            }
        }
        if (money[1] > 0) {
            count = rest / 50;
            if (count < money[1]) {
                res[1] = count;
                rest -= count * 50;
                money[1] -= count;
            } else {
                res[1] = (int) money[1];
                rest -= (int) money[1] * 50;
                money[1] = 0;
            }
        }
        if (money[0] > 0) {
            count = rest / 20;
            if (count < money[0]) {
                res[0] = count;
                rest -= count * 20;
                money[0] -= count;
            } else {
                res[0] = (int) money[0];
                rest -= (int) money[0] * 20;
                money[0] = 0;
            }
        }
        if (rest == 0) {
            return res;
        }
        money = tempMoney;
        return new int[]{-1};
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */

