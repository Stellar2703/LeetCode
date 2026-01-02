class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> mp = new HashSet<>();
        while(n!=1 && !mp.contains(n)){
            mp.add(n);
            int temp = 0;
            while (n>0){
                temp +=((n%10)*(n%10));
                n= n/10;
            }
            n = temp;
        }
        if (n==1) return true;
        return false;
    }
}