class Solution {
    public int f(int num){
        int count=0;
        String str = Integer.toString(num);
        for(int i=1;i<=str.length()-2;i++){
            if(str.charAt(i-1)>str.charAt(i) && str.charAt(i+1)>str.charAt(i)){
                count ++;
            }
            if(str.charAt(i-1)<str.charAt(i) && str.charAt(i+1)<str.charAt(i)){
                count ++;
            }
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        int count =0;
        for(int i=num1;i<=num2;i++){
            count+=f(i);
        }
        return count;       
    }
}