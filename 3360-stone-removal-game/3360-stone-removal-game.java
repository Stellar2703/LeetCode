class Solution {
    public boolean canAliceWin(int n) {
        int req = 10,steps=0;
        while(n>=req){
            n-=req;
            steps++;
            req--;
        }
        return steps%2==0 ? false : true;

    }
}