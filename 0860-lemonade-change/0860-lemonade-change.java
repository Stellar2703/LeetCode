class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] arr= new int[2];
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                arr[0]++;
            }
            else if(bills[i]==10){
                if(arr[0]>0){
                    arr[0]--;
                    arr[1]++;
                }
                else{
                    return false;
                }
            }
            else{
                if(arr[0]>0 && arr[1]>0){
                    arr[0]--;
                    arr[1]--;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}