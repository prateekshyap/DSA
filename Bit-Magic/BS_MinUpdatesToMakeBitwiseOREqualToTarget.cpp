/*
https://binarysearch.com/problems/Minimum-Updates-to-Make-Bitwise-OR-Equal-to-Target
Minimum Updates to Make Bitwise OR Equal to Target

*/
int solve_1(int a, int b, int target) {
    int cnt=0;
    int a1, b1, t1;
    while(target)
    {
        a1 = a&1;
        b1 = b&1;
        t1 = target&1;

        if(t1==1)
            cnt += (a1==0 && b1==0);
        else
            cnt+= (a1==1) + (b1==1);

        b>>=1;
        a>>=1;
        target>>=1;
    }
    while(a)
    {
        cnt+=(a&1);
        a>>=1;
    }
    while(b)
    {
        cnt+=(b&1);
        b>>=1;
    }

    return cnt;
}

int solve(int a, int b, int target) {
    int cnt=0;
    int mask;
    for(int i=0; i<32; i++)
    {
        mask = 1<<i;
        if(target & mask)
        {
            if(a & mask || b & mask) continue;
            cnt++;
        }
        else
        {
            if(a & mask) cnt++;
            if(b & mask) cnt++;
        }
    }

    return cnt;
}